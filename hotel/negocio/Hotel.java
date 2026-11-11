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
     * Busca a estadia ativa de um apartamento.
     *
     * @param andar andar do apartamento 
     * @param numero número do apartamento 
     * @return a estadia ativa, ou null se não houver
     */
    private Estadia buscarEstadiaAtiva(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        for (Estadia e : estadias) {
            if (e.estaAtiva() && e.getAndar() == andar && e.getNumero() == numero) {
                return e;
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
        apto.reservar();
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
        apto.checkin();
        if (reserva != null) {
            reserva.marcarUtilizada();
        }
        estadias.add(nova);
        return true;
    }

    /**
     * Realiza o check-out de um apartamento ocupado na data atual.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @return true se o check-out foi realizado, ou false se o apartamento
     *         não estiver ocupado
     * @throws IllegalArgumentException se andar/número forem inválidos, ou se
     *         dataFim for nula ou anterior ao início da estadia
     * @throws IllegalStateException se o apartamento estiver ocupado sem estadia ativa
     *
     * @pre hotel inicializado
     * @post se bem-sucedido, o apartamento fica LIVRE e a estadia fica encerrada em dataFim
     */
    public boolean realizarCheckout(int andar, int numero) {
        Apartamento apto = getApartamento(andar, numero);
        if (!apto.estaOcupado()) {
            return false;
        }
        Estadia estadia = buscarEstadiaAtiva(andar, numero);
        if (estadia == null) {
            throw new IllegalStateException("Apartamento ocupado sem estadia ativa");
        }
        estadia.encerrar();
        apto.checkout();
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
     * @post se a operação for bem-sucedida, o estado do apartamento passa de RESERVADO para LIVRE e a reserva é removida; caso contrário, o estado é mantido
     */
    public boolean cancelarReserva(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Apartamento ap = matriz[andar][numero];
        if (!ap.estaReservado()) {
            return false;
        }
        Reserva reserva = buscarReservaAtiva(andar, numero);
        if (reserva == null) {
            throw new IllegalStateException("Apartamento reservado sem reserva ativa");
        }
        reserva.cancelar();
        ap.cancelarReserva();
        return true;
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

    /**
     * Exibe no terminal a situação de um apartamento e, se estiver reservado
     * ou ocupado, os dados do hóspede.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @throws IllegalArgumentException se andar ou número forem inválidos
     *
     * @pre hotel inicializado
     * @post a situação do apartamento é impressa na tela; estado inalterado
     */
    public void consultarApartamento(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Apartamento apto = matriz[andar][numero];
        System.out.println("Apartamento " + andar + "/" + numero
                + " - Status: " + apto.getStatus()
                + " - Diaria: R$ " + apto.getPrecoDiaria());
        if (apto.estaReservado()) {
            Reserva r = buscarReservaAtiva(andar, numero);
            if (r != null) {
                System.out.println("Reservado para: " + r.getHospede());
            }
        } else if (apto.estaOcupado()) {
            Estadia e = buscarEstadiaAtiva(andar, numero);
            if (e != null) {
                System.out.println("Hospede: " + e.getHospede());
            }
        }
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

    /**
     * Cadastra um serviço no cardápio do hotel.
     *
     * @param nome nome do serviço
     * @param preco preço unitário do serviço
     * @throws IllegalArgumentException se os dados forem inválidos (validação do Servico)
     *
     * @pre nome não vazio e preço não negativo
     * @post o serviço é adicionado ao final do cardápio
     */
    public void cadastrarServico(String nome, float preco) {
        this.servicos.add(new Servico(nome, preco));
    }

    /**
     * Registra o consumo de um serviço na estadia ativa de um apartamento.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @param indiceServico posição do serviço no cardápio
     * @param quantidade quantidade consumida (maior que zero)
     * @return true se o consumo foi registrado, ou false se o apartamento
     *         não estiver ocupado
     * @throws IllegalArgumentException se andar/número forem inválidos, se o
     *         índice do serviço não existir ou se a quantidade for inválida
     *
     * @pre hotel inicializado
     * @post se bem-sucedido, a estadia ativa tem um consumo a mais
     */
    public boolean registrarConsumo(int andar, int numero, int indiceServico, int quantidade) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        if (indiceServico < 0 || indiceServico >= servicos.size()) {
            throw new IllegalArgumentException("Indice de servico invalido");
        }
        Estadia estadia = buscarEstadiaAtiva(andar, numero);
        if (estadia == null) {
            return false;
        }
        estadia.registrarConsumo(new Consumo(servicos.get(indiceServico), quantidade));
        return true;
    }
    
    /**
     * Retorna os consumos da estadia ativa de um apartamento.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @return lista não modificável de consumos (vazia se não houver estadia ativa)
     * @throws IllegalArgumentException se andar ou número forem inválidos
     *
     * @pre hotel inicializado
     * @post estado do hotel inalterado
     */
    public List<Consumo> getConsumosDoApartamento(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Estadia estadia = buscarEstadiaAtiva(andar, numero);
        if (estadia == null) {
            return Collections.emptyList();
        }
        return estadia.getConsumos();
    }

    /**
     * Emite a fatura da estadia ativa de um apartamento, sem alterar o estado
     * do hotel. Os dias vêm da própria estadia (até a data atual, mínimo 1) e
     * os consumos são os já registrados; o check-out é uma operação separada.
     *
     * @param andar número do andar, de 0 a 19
     * @param numero número do apartamento no andar, de 0 a 13
     * @return a fatura com diárias e consumos da estadia ativa
     * @throws IllegalArgumentException se andar ou número forem inválidos
     * @throws IllegalStateException se o apartamento não tiver estadia ativa
     *
     * @pre apartamento ocupado
     * @post estado do hotel inalterado
     */
    public Fatura emitirFatura(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        Estadia estadia = buscarEstadiaAtiva(andar, numero);
        if (estadia == null) {
            throw new IllegalStateException("Apartamento sem estadia ativa");
        }
        return new Fatura(matriz[andar][numero], estadia.getDias(), estadia.getConsumos());
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
