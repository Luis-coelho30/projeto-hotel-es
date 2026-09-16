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

    /**
     * cancela a reserva do apartamento, mudando seu status de RESERVADO para LIVRE
     *
     * @throws IllegalStateException se o apartamento não estiver RESERVADO
     *
     * @pre o apartamento deve existir
     * @post o status muda para LIVRE e o hóspede é removido
     */
    public void cancelarReserva() {
        if (this.status != Status.RESERVADO) {
            throw new IllegalStateException("apartamento não está reservado");
        }
        this.status = Status.LIVRE;
        this.hospede = null;
    }

    /**
     * verifica se o apartamento está com status LIVRE
     *
     * @return true se o status for LIVRE, false caso contrário
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public boolean estaLivre() {
        return status == Status.LIVRE;
    }

    /**
     * verifica se o apartamento está com status RESERVADO
     *
     * @return true se o status for RESERVADO, false caso contrário
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public boolean estaReservado() {
        return status == Status.RESERVADO;
    }

    /**
     * verifica se o apartamento está com status OCUPADO
     *
     * @return true se o status for OCUPADO, false caso contrário
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public boolean estaOcupado() {
        return status == Status.OCUPADO;
    }

    /**
     * retorna o preço da diária do apartamento. retorna 0 na classe base,
     * já que o preço é definido pelas subclasses ApartamentoSimples e ApartamentoPremium
     *
     * @return 0f, valor padrão para a classe base
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getPrecoDiaria() {
        return 0f;
    }

    /**
     * retorna o símbolo correspondente ao status atual do apartamento,
     * usado na exibição do mapa de ocupação do hotel
     *
     * @return '.' se LIVRE, 'R' se RESERVADO, 'O' se OCUPADO, '?' em caso de status desconhecido
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public char getSymbol() {
        switch (status) {
            case LIVRE: return '.';
            case RESERVADO: return 'R';
            case OCUPADO: return 'O';
            default: return '?';
        }
    }
}
