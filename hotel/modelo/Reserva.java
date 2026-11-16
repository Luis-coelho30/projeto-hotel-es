package hotel.modelo;

public class Reserva {
    private final int andar;
    private final int numero;
    private final Titular titular;
    private StatusReserva status;

    /**
     * Cria uma nova reserva ativa.
     *
     * @param andar Andar do apartamento
     * @param numero Número do apartamento
     * @param titular Titular que fez a reserva
     * @throws IllegalArgumentException se titular for nulo
     *
     * @pre Titular não nulo; coordenadas já validadas pelo Hotel
     * @post Reserva criada com status ATIVA
     */
    public Reserva(int andar, int numero, Titular titular) {
        if (titular == null) {
            throw new IllegalArgumentException("Titular nao pode ser nulo");
        }
        this.andar = andar;
        this.numero = numero;
        this.titular = titular;
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
     * Retorna o titular que fez a reserva.
     *
     * @return Titular da reserva
     *
     * @pre Reserva criada
     * @post Estado da reserva inalterado
     */
    public Titular getTitular() {
        return this.titular;
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

    /**
     * Marca a reserva como utilizada (check-in realizado).
     *
     * @throws IllegalStateException se a reserva não estiver ativa
     *
     * @pre Reserva ativa
     * @post Status igual a UTILIZADA
     */
    public void marcarUtilizada() {
        if (!estaAtiva()) {
            throw new IllegalStateException("Reserva nao esta ativa (" + this.status + ")");
        }
        this.status = StatusReserva.UTILIZADA;
    }

    /**
     * Cancela a reserva.
     *
     * @throws IllegalStateException se a reserva não estiver ativa
     *
     * @pre Reserva ativa
     * @post Status igual a CANCELADA
     */
    public void cancelar() {
        if (!estaAtiva()) {
            throw new IllegalStateException("Reserva nao esta ativa (" + this.status + ")");
        }
        this.status = StatusReserva.CANCELADA;
    }
}