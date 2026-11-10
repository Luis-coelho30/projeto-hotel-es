package hotel.modelo;

import java.util.List;

public class Fatura {
    private Apartamento apartamento;
    private int dias;
    private List<Consumo> consumos;

    public Fatura(Apartamento apto, int dias, List<Consumo> consumos) {
        this.apartamento = apto;
        this.dias = dias;
        this.consumos = consumos;
    }

    public float getTotalGeral() {
        throw new UnsupportedOperationException("Implementar calculo da fatura");
    }

    public Apartamento getApartamento() { return apartamento; }
    public int getDias() { return dias; }
    public List<Consumo> getConsumos() { return consumos; }

    /**
     * Calcula o total das diárias da hospedagem
     *
     * @return número de dias multiplicado pelo preço da diária do apartamento
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getTotalDiarias() {
        return dias * apartamento.getPrecoDiaria();
    }

    public float getTotalConsumos() {
        throw new UnsupportedOperationException("Implementar calculo total de consumos");
    }

    @Override
    public String toString() {
        return "Fatura: R$ " + getTotalGeral();
    }
}
