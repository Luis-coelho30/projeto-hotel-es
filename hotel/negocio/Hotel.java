package hotel.negocio;

import hotel.modelo.*;
import java.util.ArrayList;

public class Hotel {
    public static final int NUM_ANDARES = 20;
    public static final int APTOS_POR_ANDAR = 14;

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
                matriz[a][n] = new Apartamento();
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

    public boolean realizarCheckout(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar realizarCheckout");
    }

    public boolean cancelarReserva(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar cancelarReserva");
    }

    public void mostrarMapa() {
        throw new UnsupportedOperationException("Implementar mostrarMapa");
    }

    public void consultarApartamento(int andar, int numero) {
        if (!aptoValido(andar, numero)) {
            throw new IllegalArgumentException("Andar ou numero invalido");
        }
        throw new UnsupportedOperationException("Implementar consultarApartamento");
    }

    public float calcularTaxaOcupacao() {
        throw new UnsupportedOperationException("Implementar calcularTaxaOcupacao");
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

    public Apartamento getApartamento(int andar, int numero) {
        return matriz[andar][numero];
    }

    public ArrayList<Servico> getServicos() { return servicos; }
    public ArrayList<Consumo> getConsumos() { return consumos; }
}
