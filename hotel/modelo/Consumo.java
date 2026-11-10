package hotel.modelo;

public class Consumo {
    private Servico servico;
    private int quantidade;

    /**
     * Cria um consumo de um serviço do cardápio
     *
     * @param servico serviço consumido, não pode ser nulo
     * @param quantidade quantidade consumida, deve ser pelo menos 1
     * @throws IllegalArgumentException se o serviço for nulo ou a quantidade for menor que 1
     *
     * @pre (nenhuma)
     * @post instância de Consumo criada com o serviço e a quantidade informados
     */
    public Consumo(Servico servico, int quantidade) {
        if (servico == null) {
            throw new IllegalArgumentException("serviço do consumo não pode ser nulo");
        }
        if (quantidade < 1) {
            throw new IllegalArgumentException("quantidade do consumo deve ser pelo menos 1");
        }
        this.servico = servico;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o serviço consumido
     *
     * @return o serviço consumido
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public Servico getServico() { return servico; }

    /**
     * Retorna a quantidade consumida
     *
     * @return a quantidade consumida, sempre maior ou igual a 1
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public int getQuantidade() { return quantidade; }

    /**
     * Calcula o valor total do consumo
     *
     * @return preço do serviço multiplicado pela quantidade
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getTotal() {
        return servico.getPreco() * quantidade;
    }

    /**
     * Retorna a descrição do consumo para exibição
     *
     * @return texto formatado
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    @Override
    public String toString() {
        return servico.getNome() + " x" + quantidade + " = R$ " + getTotal();
    }
}
