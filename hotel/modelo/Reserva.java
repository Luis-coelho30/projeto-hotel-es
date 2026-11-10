package hotel.modelo;

public class Reserva {
    private final int andar;
    private final int numero;
    private final Hospede hospede;
    private StatusReserva status;

    /**
     * Cria uma nova reserva ativa.
     *
     * @param andar Andar do apartamento
     * @param numero Número do apartamento
     * @param hospede Hóspede que fez a reserva
     * @throws IllegalArgumentException se hospede for nulo
     *
     * @pre Hóspede não nulo; coordenadas já validadas pelo Hotel
     * @post Reserva criada com status ATIVA
     */
    public Reserva(int andar, int numero, Hospede hospede) {
        if (hospede == null) {
            throw new IllegalArgumentException("Hospede nao pode ser nulo");
        }
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.status = StatusReserva.ATIVA;
    }

    /**
     * Retorna o andar do apartamento reservado.
     *
     * @return Andar do apartamento
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public int getAndar() {
        return this.andar;
    }

    /**
     * Retorna o número do apartamento reservado.
     *
     * @return Número do apartamento no andar
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Retorna o hóspede que fez a reserva.
     *
     * @return Hóspede da reserva 
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public Hospede getHospede() {
        return this.hospede;
    }

    /**
     * Retorna a situação atual da reserva.
     *
     * @return Status da reserva
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public StatusReserva getStatus() {
        return this.status;
    }

    /**
     * Indica se a reserva ainda aguarda check-in.
     *
     * @return true se o status for ATIVA, false caso contrário
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public boolean estaAtiva() {
        return this.status == StatusReserva.ATIVA;
    }

    public void marcarUtilizada() {
        throw new UnsupportedOperationException("Implementar encerrar");
    }

    public void cancelar() {
        throw new UnsupportedOperationException("Implementar encerrar");
    }
}