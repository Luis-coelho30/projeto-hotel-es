package hotel.servico;

import hotel.modelo.*;
import hotel.negocio.Hotel;
import java.util.*;

public class RelatorioSvc {
    private Hotel hotel;
    
    /**
     * Cria uma instância do serviço de relatórios.
     *
     * @pre Hotel criado com lista de estadias, reservas e servicos
     * @post Serviço de relatórios do hotel
     */
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

    /**
     * imprime o ranking dos serviços mais consumidos, em ordem decrescente de
     * quantidade, somando os consumos de todas as estadias (ativas e encerradas).
     *
     * @pre hotel não nulo
     * @post o ranking é impresso na tela; estado do hotel inalterado
     */
    public void gerarRankingServicos() {
        List<Servico> servicos = hotel.getServicos();
        List<Estadia> estadias = hotel.getEstadias();
        int n = servicos.size();
        int[] quantidades = new int[n];

        // soma as quantidades consumidas de cada serviço do cardápio
        for (int i = 0; i < estadias.size(); i++) {
            List<Consumo> consumos = estadias.get(i).getConsumos();
            for (int j = 0; j < consumos.size(); j++) {
                Consumo c = consumos.get(j);
                for (int k = 0; k < n; k++) {
                    if (servicos.get(k) == c.getServico()) {
                        quantidades[k] += c.getQuantidade();
                    }
                }
            }
        }

        // ordena os índices dos serviços por quantidade, do maior para o menor
        int[] ordem = new int[n];
        for (int i = 0; i < n; i++) {
            ordem[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            int maior = i;
            for (int j = i + 1; j < n; j++) {
                if (quantidades[ordem[j]] > quantidades[ordem[maior]]) {
                    maior = j;
                }
            }
            int aux = ordem[i];
            ordem[i] = ordem[maior];
            ordem[maior] = aux;
        }

        System.out.println("\n--- RANKING DE SERVICOS ---");
        int posicao = 0;
        for (int i = 0; i < n; i++) {
            int qtd = quantidades[ordem[i]];
            if (qtd > 0) {
                posicao++;
                System.out.println(posicao + ". " + servicos.get(ordem[i]).getNome() + ": "
                        + qtd + (qtd == 1 ? " unidade" : " unidades"));
            }
        }
        if (posicao == 0) {
            System.out.println("Nenhum consumo registrado");
        }
    }

    /**
     * Imprime o resumo financeiro: o faturamento das estadias encerradas (fatura
     * final), o das estadias ativas (fatura parcial até hoje) e o total estimado.
     *
     * @pre hotel não nulo
     * @post o resumo é impresso na tela; estado do hotel inalterado
     */
    public void gerarResumoFinanceiro() {
        List<Estadia> estadias = hotel.getEstadias();
        float encerradas = 0f;
        float ativas = 0f;

        for (int i = 0; i < estadias.size(); i++) {
            Estadia e = estadias.get(i);
            if (e.estaAtiva()) {
                ativas += e.gerarFatura().getTotalGeral();
            }
            else {
                encerradas += e.getFaturaFinal().getTotalGeral();
            }
        }

        System.out.println("\n--- RESUMO FINANCEIRO ---");
        System.out.println("Estadias encerradas: R$ " + encerradas);
        System.out.println("Estadias ativas (parcial): R$ " + ativas);
        System.out.println("Faturamento total estimado: R$ " + (encerradas + ativas));
    }
}
