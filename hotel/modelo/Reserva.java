package hotel.modelo;

public class Reserva {
    private final int andar;
    private final int numero;
    private final Hospede hospede;
    private StatusReserva status;

    public Reserva(int andar, int numero, Hospede hospede) {
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
        throw new UnsupportedOperationException("Implementar encerrar");
    }

    public void marcarUtilizada() {
        throw new UnsupportedOperationException("Implementar encerrar");
    }

    public void cancelar() {
        throw new UnsupportedOperationException("Implementar encerrar");
    }
}