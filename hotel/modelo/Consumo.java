package hotel.modelo;

public class Consumo {
    private Servico servico;
    private int quantidade;

    public Consumo(Servico servico, int quantidade) {
        this.servico = servico;
        this.quantidade = quantidade;
    }

    public Servico getServico() { return servico; }
    public int getQuantidade() { return quantidade; }

    public float getTotal() {
        return servico.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return servico.getNome() + " x" + quantidade + " = R$ " + getTotal();
    }
}
