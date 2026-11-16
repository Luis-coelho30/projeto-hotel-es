package hotel.modelo;

import java.util.List;
import java.util.ArrayList;

public class Fatura {
    private float valorDiaria;
    private int dias;
    private List<Consumo> consumos;

    /**
     * Cria uma fatura de hospedagem
     *
     * @param apto apartamento faturado, não pode ser nulo
     * @param dias número de diárias, deve ser pelo menos 1
     * @param consumos consumos a cobrar, não pode ser nulo (pode ser vazio)
     * @throws IllegalArgumentException se o apartamento ou a lista forem nulos, ou se os dias forem menores que 1
     *
     * @pre (nenhuma)
     * @post instância de Fatura criada com o apartamento, os dias e os consumos informados
     */
    public Fatura(Apartamento apto, int dias, List<Consumo> consumos) {
        if (apto == null) {
            throw new IllegalArgumentException("apartamento da fatura não pode ser nulo");
        }
        if (dias < 1) {
            throw new IllegalArgumentException("dias da fatura deve ser pelo menos 1");
        }
        if (consumos == null) {
            throw new IllegalArgumentException("lista de consumos da fatura não pode ser nula");
        }
        this.valorDiaria = apto.getPrecoDiaria();
        this.dias = dias;
        this.consumos = new ArrayList<>(consumos);
    }

    /**
     * Cria a fatura de uma estadia ativa
     *
     * @param estadia estadia a ser faturada, não pode ser nula
     * @throws IllegalArgumentException se a estadia for nula
     * @throws IllegalStateException se a estadia já estiver encerrada
     *
     * @pre estadia ativa
     * @post fatura criada com os dias, a diária e os consumos da estadia
     */
    public Fatura(Estadia estadia) {
        if (estadia == null) {
            throw new IllegalArgumentException("estadia da fatura não pode ser nula");
        }
        if (!estadia.estaAtiva()) {
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
