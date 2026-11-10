package hotel.apartamento.modelo;

public class Apartamento {
    private Status status;

    /**
     * cria um novo apartamento, no estado inicial com status LIVRE e sem hóspede associado
     *
     * @pre (nenhuma)
     * @post instância de Apartamento criada com status LIVRE
     */
    public Apartamento() {
        this.status = Status.LIVRE;
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
     * reserva o apartamento, mudando seu status de LIVRE para RESERVADO
     *
     * @throws IllegalArgumentException se h for nulo
     * @throws IllegalStateException se o apartamento não estiver com status LIVRE
     *
     * @pre o apartamento deve existir (construtor já garante isso)
     * @post se bem-sucedido, o status muda para RESERVADO
     */
    public void reservar() {
        validarStatus(Status.LIVRE, "apartamento não está livre para reserva");
        this.status = Status.RESERVADO;
    }

    /**
     * realiza o check-in no apartamento, mudando seu status para OCUPADO
     * pode ser chamado para apartamentos de status LIVRE ou RESERVADO
     *
     * @throws IllegalArgumentException se h for nulo
     * @throws IllegalStateException se o apartamento já estiver com status OCUPADO
     *
     * @pre o apartamento deve existir
     * @post se bem-sucedido, o status do apartamento muda para OCUPADO
     */
    public void checkin() {
        if (this.status == Status.OCUPADO) {
            throw new IllegalStateException("apartamento já ocupado");
        }
        this.status = Status.OCUPADO;
    }

    /**
     * realiza o check-out do apartamento, liberando-o e mudando seu status para LIVRE
     *
     * @throws IllegalStateException se o apartamento não estiver OCUPADO
     *
     * @pre o apartamento deve existir
     * @post o status do apartamento muda para LIVRE
     */
    public void checkout() {
        validarStatus(Status.OCUPADO, "apartamento não está ocupado");
        this.status = Status.LIVRE;
    }

    /**
     * cancela a reserva do apartamento, mudando seu status de RESERVADO para LIVRE
     *
     * @throws IllegalStateException se o apartamento não estiver RESERVADO
     *
     * @pre o apartamento deve existir
     * @post o status muda para LIVRE
     */
    public void cancelarReserva() {
        validarStatus(Status.RESERVADO, "apartamento não está reservado");
        this.status = Status.LIVRE;
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

    private void validarStatus(Status esperado, String mensagemErro) {
        if (this.status != esperado) {
            throw new IllegalStateException(mensagemErro);
        }
    }
}
