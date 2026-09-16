package hotel.modelo;

public class Apartamento {
    private Status status;
    private Hospede hospede;

    /**
     * cria um novo apartamento, no estado inicial com status LIVRE e sem hóspede associado
     *
     * @pre (nenhuma)
     * @post instância de Apartamento criada com status LIVRE e hóspede nulo
     */
    public Apartamento() {
        this.status = Status.LIVRE;
        this.hospede = null;
    }

    /**
     * retorna o status atual do apartamento
     * @return o status atual (LIVRE, RESERVADO ou OCUPADO)
     *
     * @pre (nenhuma)
     * @post retorna o status atual
     */
    public Status getStatus() {
        return status;
    }

    /**
     * retorna o hóspede atualmente associado ao apartamento, se houver
     * @return o hóspede associado, ou null se o apartamento tiver status LIVRE
     *
     * @pre (nenhuma)
     * @post retorna a referência do hóspede atualmente associado
     */
    public Hospede getHospede() {
        return hospede;
    }

    /**
     * reserva o apartamento, mudando seu status de LIVRE para RESERVADO
     *
     * @param h hóspede que faz a reserva
     * @throws IllegalArgumentException se h for nulo
     * @throws IllegalStateException se o apartamento não estiver com status LIVRE
     *
     * @pre o apartamento deve existir (construtor já garante isso)
     * @post se bem-sucedido, o status muda para RESERVADO e o hóspede é armazenado
     */
    public void reservar(Hospede h) {
        if (h == null) {
            throw new IllegalArgumentException("hóspede não pode ser nulo ao reservar um apartamento");
        }
        if (this.status != Status.LIVRE) {
            throw new IllegalStateException("apartamento não está livre para reserva");
        }
        this.status = Status.RESERVADO;
        this.hospede = h;
    }

    /**
     * realiza o check-in no apartamento, mudando seu status para OCUPADO
     * pode ser chamado para apartamentos de status LIVRE ou RESERVADO
     *
     * @param h hóspede que faz o check-in
     * @throws IllegalArgumentException se h for nulo
     * @throws IllegalStateException se o apartamento já estiver com status OCUPADO
     *
     * @pre o apartamento deve existir
     * @pos se bem-sucedido, o status do apartamento muda para OCUPADO e o hóspede é armazenado
     */
    public void checkin(Hospede h) {
        if (h == null) {
            throw new IllegalArgumentException("hóspede não pode ser nulo ao fazer check-in");
        }
        if (this.status == Status.OCUPADO) {
            throw new IllegalStateException("apartamento já ocupado");
        }
        this.status = Status.OCUPADO;
        this.hospede = h;
    }

    /**
     * realiza o check-out do apartamento, liberando-o e mudando seu status para LIVRE
     *
     * @throws IllegalStateException se o apartamento não estiver OCUPADO
     *
     * @pre o apartamento deve existir
     * @post o status do apartamento muda para LIVRE e o hóspede é removido (ficando nulo)
     */
    public void checkout() {
        if (this.status != Status.OCUPADO) {
            throw new IllegalStateException("apartamento não está ocupado");
        }
        this.status = Status.LIVRE;
        this.hospede = null;
    }

    public void cancelarReserva() {
        throw new UnsupportedOperationException("Implementar: RESERVADO -> LIVRE");
    } // TDD

    public boolean estaLivre() {
        return status == Status.LIVRE;
    }
    public boolean estaReservado() {
        return status == Status.RESERVADO;
    }
    public boolean estaOcupado() {
        return status == Status.OCUPADO;
    }

    public float getPrecoDiaria() {
        return 0f;
    }

    public char getSymbol() {
        switch (status) {
            case LIVRE: return '.';
            case RESERVADO: return 'R';
            case OCUPADO: return 'O';
            default: return '?';
        }
    }
}
