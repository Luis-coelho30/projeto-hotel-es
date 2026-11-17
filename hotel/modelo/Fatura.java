package hotel.modelo;

import java.util.List;
import java.util.ArrayList;

public class Fatura implements java.io.Serializable {
    private float valorDiaria;
    private int dias;
    private List<Consumo> consumos;

    /**
     * Cria a fatura parcial de uma estadia ativa.
     *
     * @param estadia estadia a ser faturada, não pode ser nula
     * @throws IllegalArgumentException se a estadia for nula
     * @throws IllegalStateException se a estadia já estiver encerrada
     *
     * @pre estadia ativa
     * @post fatura criada com os dias, a diária e os consumos da estadia
     */
    public Fatura(Estadia estadia) {
        this(estadia, true);
    }

    /**
     * Cria a fatura final de uma estadia. Usada apenas pela própria Estadia, logo depois de definir a data de encerramento.
     *
     * @param estadia estadia encerrada, não pode ser nula
     * @return fatura final da estadia
     * @throws IllegalArgumentException se a estadia for nula
     *
     * @pre dataFim da estadia já definida
     * @post fatura criada com os dias, a diária e os consumos da estadia
     */
    static Fatura finalDe(Estadia estadia) {
        return new Fatura(estadia, false);
    }

    /**
     * Cria uma fatura a partir de valores já conhecidos, sem depender de Estadia.
     *
     * @param dias quantidade de dias, deve ser pelo menos 1
     * @param valorDiaria valor da diária, não pode ser negativo
     * @param consumos consumos faturados, não pode ser nulo
     * @throws IllegalArgumentException se dias for menor que 1, se valorDiaria for negativo ou se consumos for nulo
     *
     * @pre (nenhuma)
     * @post fatura criada com uma cópia da lista de consumos
     */
    public Fatura(int dias, float valorDiaria, List<Consumo> consumos) {
        throw new UnsupportedOperationException("não implementado");
    }

    private Fatura(Estadia estadia, boolean parcial) {
        if (estadia == null) {
            throw new IllegalArgumentException("estadia da fatura não pode ser nula");
        }
        if (parcial && !estadia.estaAtiva()) {
            throw new IllegalStateException("estadia encerrada não pode ser faturada");
        }
        this.dias = estadia.getDias();
        this.valorDiaria = estadia.getValorDiaria();
        this.consumos = new ArrayList<>(estadia.getConsumos());
    }

    /**
     * Calcula o valor total da fatura
     *
     * @return total das diárias somado ao total dos consumos
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getTotalGeral() {
        return getTotalDiarias() + getTotalConsumos();
    }

    /**
     * Retorna a quantidade de dias da fatura
     *
     * @return a quantidade de dias da fatura, sempre maior ou igual a 1
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public int getDias() { return dias; }

    /**
     * Retorna a lista de consumos
     *
     * @return a lista de consumos da fatura
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
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
        return dias * valorDiaria;
    }

    /**
     * Calcula o total dos consumos
     *
     * @return soma do valor de cada consumo, ou 0 se não houver consumos
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    public float getTotalConsumos() {
        float total = 0;
        for (int i = 0; i < consumos.size(); i++) {
            total += consumos.get(i).getTotal();
        }
        return total;
    }

    /**
     * Retorna a fatura formatada para exibição
     *
     * @return texto formatado
     *
     * @pre (nenhuma)
     * @post nenhuma alteração de estado
     */
    @Override
    public String toString() {
        return "Fatura: R$ " + getTotalGeral();
    }
}
