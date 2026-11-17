package hotel.servico;

import hotel.modelo.*;
import hotel.negocio.Hotel;
import java.util.*;

public class RelatorioSvc {
    private Hotel hotel;

    public RelatorioSvc(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * imprime o histórico de ocupação: quantos dias cada apartamento ficou
     * ocupado, somando todas as estadias (ativas e encerradas).
     *
     * @pre hotel não nulo
     * @post o relatório é impresso na tela; estado do hotel inalterado
     */
    public void gerarRelatorioOcupacao() {
        List<Estadia> estadias = hotel.getEstadias();
        int[] diasPorApto = new int[Hotel.NUM_ANDARES * Hotel.APTOS_POR_ANDAR];

        for (int i = 0; i < estadias.size(); i++) {
            Estadia e = estadias.get(i);
            diasPorApto[e.getAndar() * Hotel.APTOS_POR_ANDAR + e.getNumero()] += e.getDias();
        }

        System.out.println("\n--- RELATORIO DE OCUPACAO ---");
        boolean imprimiu = false;
        for (int i = 0; i < diasPorApto.length; i++) {
            int dias = diasPorApto[i];
            if (dias > 0) {
                int andar = i / Hotel.APTOS_POR_ANDAR;
                int numero = i % Hotel.APTOS_POR_ANDAR;
                System.out.println("Apartamento " + andar + "/" + numero + ": "
                        + dias + (dias == 1 ? " dia" : " dias"));
                imprimiu = true;
            }
        }
        if (!imprimiu) {
            System.out.println("Nenhuma estadia registrada");
        }
    }

    public void gerarRankingServicos() {
        throw new UnsupportedOperationException("Implementar ranking de servicos");
    }

    public void gerarResumoFinanceiro() {
        throw new UnsupportedOperationException("Implementar resumo financeiro");
    }
}
