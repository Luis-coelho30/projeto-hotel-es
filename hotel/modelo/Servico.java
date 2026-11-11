package hotel.modelo;

public class Servico {
    private String nome;
    private float preco;

    /**
     * Cria um serviço do cardápio do hotel
     *
     * @param nome nome do serviço, não pode ser nulo nem vazio
     * @param preco preço do serviço, não pode ser negativo
     * @throws IllegalArgumentException se o nome for nulo ou vazio, ou se o preço for negativo
     *
     * @pre (nenhuma)
     * @post instância de Servico criada com o nome e o preço informados
     */
    public Servico(String nome, float preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("nome do serviço não pode ser vazio!");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("preço do serviço não pode ser negativo!");
        }
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Retorna o nome do serviço
     *
     * @return o nome do serviço
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public String getNome() { return nome; }

    /**
     * Retorna o preço do serviço
     *
     * @return o preço do serviço, sempre maior ou igual a zero
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getPreco() { return preco; }

    @Override
    public String toString() {
        return nome + " (R$ " + preco + ")";
    }
}
