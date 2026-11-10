package hotel.negocio;

import hotel.modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hotel {
    public static final int NUM_ANDARES = 20;
    public static final int APTOS_POR_ANDAR = 14;
    public static final int SIMPLES_POR_ANDAR = 8;

    private Apartamento[][] matriz;
    private List<Servico> servicos;
    private List<Estadia> estadias;
    private List<Reserva> reservas;

    public Hotel() {
        this.matriz = new Apartamento[NUM_ANDARES][APTOS_POR_ANDAR];
        this.servicos = new ArrayList<>();
        this.estadias = new ArrayList<>();
        this.reservas = new ArrayList<>();
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
     * Busca a reserva ativa de um apartamento.
     *
     * @param andar andar do apartamento
     * @param numero número do apartamento
     * @return a reserva ativa, ou null se não houver
     */
    private Reserva buscarReservaAtiva(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        for (Reserva r : reservas) {
            if (r.estaAtiva() && r.getAndar() == andar && r.getNumero() == numero) {
                return r;
            }
        }
        return null;
    }

    /**
     * Reserva um apartamento, mudando seu status de LIVRE para RESERVADO.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @param hospede hóspede que fará a reserva
     * @return true se a reserva foi realizada com sucesso, ou false se o 
     *         apartamento não estiver livre (o hóspede só é validado se estiver livre)
     * @throws IllegalArgumentException se andar ou número forem inválidos, 
     *         ou se hospede for nulo e o apartamento estiver livre
     *
     * @pre hotel inicializado
     * @post se bem-sucedido, o apartamento fica RESERVADO e o hóspede é guardado
     */
    public boolean reservarApartamento(int andar, int numero, Hospede hospede) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Apartamento apto = matriz[andar][numero];
        if (!apto.estaLivre()) {
            return false;
        }
        // cria a reserva antes de mudar o estado, impede inconsistencia se falhar por hospede nulo 
        Reserva nova = new Reserva(andar, numero, hospede);
        apto.reservar(hospede);
        reservas.add(nova);
        return true;
    }

    /**
     * Realiza o check-in de um hóspede em um apartamento livre ou reservado.
     * Cria uma nova Estadia ativa. Se havia reserva, ela é consumida e o hóspede
     * informado prevalece.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @param hospede hóspede da estadia
     * @return true se o check-in foi realizado, ou false se o apartamento já
     *         estiver ocupado
     * @throws IllegalArgumentException se andar ou número forem inválidos,
     *         ou se hospede for nulo
     *
     * @pre hotel inicializado
     * @post se bem-sucedido, o apartamento fica OCUPADO e existe uma estadia ativa
     */
    public boolean realizarCheckin(int andar, int numero, Hospede hospede) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Apartamento apto = matriz[andar][numero];
        if (apto.estaOcupado()) {
            return false;
        }
        // cria a estadia antes de mudar o estado: hospede nulo falha sem deixar o hotel inconsistente
        Estadia nova = new Estadia(andar, numero, hospede);
        Reserva reserva = buscarReservaAtiva(andar, numero);
        apto.checkin(hospede);
        if (reserva != null) {
            reserva.marcarUtilizada();
        }
        estadias.add(nova);
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

     /**
     * Calcula a taxa de ocupação atual do hotel (quartos com check-in realizado)
     * 
     * @return O percentual decimal de quartos ocupados (ex: 0.25 para 25% de ocupação)
     * @pre a matriz de apartamentos deve estar instanciada
     * @post retorna a proporção de quartos no estado OCUPADO em relação à capacidade total, sem alterar o estado do hotel
     */
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

    /**
     * Calcula a taxa de reservas atuais do hotel (quartos reservados, aguardando check-in)
     * 
     * @return O percentual decimal de quartos reservados (ex: 0.10 para 10% de reservas)
     * @pre a matriz de apartamentos deve estar instanciada
     * @post retorna a proporção de quartos no estado RESERVADO em relação à capacidade total, sem alterar o estado do hotel
     */
    public float calcularTaxaReservas() {
        Apartamento ap;
        int reservados = 0;
        int totalQuartos = NUM_ANDARES * APTOS_POR_ANDAR;
        float taxa;

        for(int a = 0; a < NUM_ANDARES; a++){
            for(int n = 0; n < APTOS_POR_ANDAR; n++){
                ap = getApartamento(a, n);
                if(ap.estaReservado()){
                    reservados++;
                }
            }
        }

        taxa = (float) reservados/totalQuartos;
        return taxa;
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

    public List<Servico> getServicos() { return servicos; }
    
    public List<Estadia> getEstadias() {
        return Collections.unmodifiableList(estadias);
    }
 
    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }
}
