package hotel.modelo;

public class Reserva {
    private final int andar;
    private final int numero;
    private final Hospede hospede;
    private StatusReserva status;

    public Reserva(int andar, int numero, Hospede hospede) {
        if (hospede == null) {
            throw new IllegalArgumentException("Hospede nao pode ser nulo");
        }
        this.andar = andar;
        this.numero = numero;
        this.hospede = hospede;
        this.status = StatusReserva.ATIVA;
    }

    public int getAndar() {
        return this.andar;
    }

    public int getNumero() {
        return this.numero;
    }

    public Hospede getHospede() {
        return this.hospede;
    }

    public StatusReserva getStatus() {
        return this.status;
    }

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