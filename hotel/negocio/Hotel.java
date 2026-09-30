package hotel.negocio;

import hotel.modelo.*;
import java.util.ArrayList;

public class Hotel {
    public static final int NUM_ANDARES = 20;
    public static final int APTOS_POR_ANDAR = 14;
    public static final int SIMPLES_POR_ANDAR = 8;

    private Apartamento[][] matriz;
    private ArrayList<Servico> servicos;
    private ArrayList<Consumo> consumos;

    public Hotel() {
        this.matriz = new Apartamento[NUM_ANDARES][APTOS_POR_ANDAR];
        this.servicos = new ArrayList<>();
        this.consumos = new ArrayList<>();
        inicializar();
    }

    private void inicializar() {
        for (int a = 0; a < NUM_ANDARES; a++) {
            for (int n = 0; n < APTOS_POR_ANDAR; n++) {
                if(n < SIMPLES_POR_ANDAR){// 8 simples e 6 premium por andar
                    matriz[a][n] = new ApartamentoSimples();
                } else {
                    matriz[a][n] = new ApartamentoPremium();
                }
            }
        }
    }
        

    private boolean aptoValido(int andar, int numero) {
        return andar >= 0 && andar < NUM_ANDARES && numero >= 0 && numero < APTOS_POR_ANDAR;
    }

    /**
     * Reserva um apartamento, mudando seu status de LIVRE para RESERVADO.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @param hospede hóspede que fará a reserva
     * @return true se a reserva foi realizada com sucesso, ou false se o
     *         apartamento não estiver livre
     * @throws IllegalArgumentException se andar ou número forem inválidos,
     *         ou se hospede for nulo
     *
     * @pre hotel inicializado
     * @post o apartamento fica RESERVADO com o hóspede armazenado
     */
    public boolean reservarApartamento(int andar, int numero, Hospede hospede) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        if (!matriz[andar][numero].estaLivre()) {
            return false;
        }

        matriz[andar][numero].reservar(hospede);
        return true;
    }

    /**
     * Realiza o check-in de um hóspede em um apartamento livre ou reservado.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @param hospede hóspede que fará o check-in
     * @return true se o check-in foi realizado com sucesso
     * @throws IllegalArgumentException se andar ou número forem inválidos,
     *         ou se hospede for nulo
     * @throws IllegalStateException se o apartamento já estiver ocupado
     *
     * @pre hotel inicializado
     * @post o apartamento fica OCUPADO com o hóspede armazenado
     */
    public boolean realizarCheckin(int andar, int numero, Hospede hospede) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        matriz[andar][numero].checkin(hospede);
        return true;
    }

    /**
     * Realiza o check-out de um apartamento ocupado, liberando-o.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @return true se o check-out foi realizado com sucesso
     * @throws IllegalArgumentException se andar ou número forem inválidos
     * @throws IllegalStateException se o apartamento não estiver ocupado
     *
     * @pre hotel inicializado
     * @post o apartamento fica LIVRE e sem hóspede associado
     */
    public boolean realizarCheckout(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        
        matriz[andar][numero].checkout();
        return true;
    }

     /**
     * Cancela a reserva de um apartamento específico, alterando o seu estado
     * 
     * @param andar O andar onde o apartamento está localizado
     * @param numero O número do apartamento no andar especificado
     * @return true se o cancelamento foi bem-sucedido, ou false se o quarto não estava reservado (ex: estava livre ou ocupado)
     * @throws IllegalArgumentException Se as coordenadas do andar ou número estiverem fora dos limites do hotel
     * @pre as coordenadas informadas devem ser válidas e pertencer à matriz do hotel
     * @post se a operação for bem-sucedida, o estado do apartamento passa de RESERVADO para LIVRE; caso contrário, o estado é mantido
     */
    public boolean cancelarReserva(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        boolean ok = false;
        Apartamento ap = getApartamento(andar, numero);
        if(ap.estaReservado()){
            ap.cancelarReserva();
            ok = true;
        }
        return ok;
    }

    /**
     * Exibe no terminal o mapa visual de ocupação do hotel
     * Utiliza '.' para livre, 'R' para reservado e 'O' para ocupado
     * 
     * @param N/A Não recebe parâmetros
     * @return (void)
     * @throws (nenhuma)
     * @pre a matriz do hotel deve estar inicializada
     * @post o mapa é impresso na tela
     */
    public void mostrarMapa() {
        System.out.println("\n=== MAPA DE OCUPAÇÃO ===");
  
        for(int a = NUM_ANDARES -1; a >= 0; a--){
            System.out.printf("Andar %02d", a);
            for(int n = 0; n < APTOS_POR_ANDAR; n++){
                char simbolo = matriz[a][n].getSymbol();
                System.out.print("[" + simbolo + "] ");
            }
            System.out.println();
        }

        System.out.println("\nLegenda: [.] Livre\t [R] Reservado\t [O] Ocupado");
    }

    public void consultarApartamento(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar consultarApartamento");
    }

    public float calcularTaxaOcupacao() {
        Apartamento ap;
        int ocupados = 0;
        int totalQuartos = NUM_ANDARES * APTOS_POR_ANDAR;
        float taxa;

        for(int a = 0; a < NUM_ANDARES; a++){
            for(int n = 0; n < APTOS_POR_ANDAR; n++){
                ap = getApartamento(a, n);
                if(ap.estaOcupado()){
                    ocupados++;
                }
            }
        }

        taxa = (float) ocupados/totalQuartos;
        return taxa;
        
    }

    public float calcularTaxaReservas() {
        throw new UnsupportedOperationException("Implementar calcularTaxaReservas");
    }

    public void cadastrarServico(String nome, float preco) {
        throw new UnsupportedOperationException("Implementar cadastrarServico");
    }

    public boolean registrarConsumo(int andar, int numero, int indiceServico, int quantidade) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar registrarConsumo");
    }

    public ArrayList<Consumo> getConsumosDoApartamento(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar getConsumosDoApartamento");
    }

    public Fatura emitirFatura(int andar, int numero, int dias) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar emitirFatura");
    }

    /**
     * Recupera um apartamento específico da matriz do hotel, validando as coordenadas
     * 
     * @param andar O andar desejado (0 a 19)
     * @param numero O número do apartamento no andar (0 a 13)
     * @return A instância do Apartamento correspondente àquela posição.
     * @throws IllegalArgumentException Se as coordenadas do andar ou número estiverem fora dos limites físicos do hotel
     * @pre as coordenadas informadas devem ser maiores ou iguais a zero e menores que a capacidade máxima do prédio
     * @post retorna o objeto Apartamento sem alterar o seu estado atual
     */
    public Apartamento getApartamento(int andar, int numero) {
        if(!aptoValido(andar, numero)){
            throw new IllegalArgumentException("Andar ou número de apartamento inválido.");
        }
        return matriz[andar][numero];
    }

    public ArrayList<Servico> getServicos() { return servicos; }
    public ArrayList<Consumo> getConsumos() { return consumos; }
}
