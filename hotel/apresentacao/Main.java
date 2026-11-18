package hotel.apresentacao;

import hotel.modelo.*;
import hotel.negocio.Hotel;
import hotel.repositorio.HotelRepo;
import hotel.servico.RelatorioSvc;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Hotel hotel = new Hotel();
    private static Scanner scanner = new Scanner(System.in);

    private static String lerLinha() {
        return scanner.nextLine().trim();
    }

    private static Titular lerTitular() {
        System.out.print("CPF: ");
        String cpf = lerLinha();
        System.out.print("Nome: ");
        String nome = lerLinha();
        System.out.print("Endereço: ");
        String endereco = lerLinha();
        System.out.print("Celular: ");
        String celular = lerLinha();
        System.out.print("Email: ");
        String email = lerLinha();
        return new Titular(cpf, nome, endereco, celular, email);
    }

    private static void mostrarCardapio() {
        System.out.println("--- CARDÁPIO DE SERVIÇOS ---");
        for (int i = 0; i < hotel.getServicos().size(); i++) {
            System.out.println(i + " - " + hotel.getServicos().get(i));
        }
    }

    private static int lerAndar() {
        System.out.print("Andar (0-" + (Hotel.NUM_ANDARES - 1) + "): ");
        return Integer.parseInt(lerLinha());
    }

    private static int lerNumero() {
        System.out.print("Número (0-" + (Hotel.APTOS_POR_ANDAR - 1) + "): ");
        return Integer.parseInt(lerLinha());
    }

    /**
    * Exibe o menu e trata os erros das operações.
    *
    * @param args argumentos de linha de comando (não utilizados)
    *
    * @pre nenhuma
    * @post o programa encerra quando o usuário escolhe sair
    * 
    */
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE GESTÃO DE HOTEL ===");
            System.out.println("1  - Reservar apartamento");
            System.out.println("2  - Realizar Check-in");
            System.out.println("3  - Realizar Check-out");
            System.out.println("4  - Cancelar reserva");
            System.out.println("5  - Mostrar mapa de ocupação");
            System.out.println("6  - Consultar apartamento");
            System.out.println("7  - Mostrar taxas de ocupação e reservas");
            System.out.println("8  - Cadastrar serviço no cardápio");
            System.out.println("9  - Registrar consumo de serviço");
            System.out.println("10 - Emitir fatura de apartamento");
            System.out.println("11 - Relatório de ocupação");
            System.out.println("12 - Ranking de serviços");
            System.out.println("13 - Salvar dados em arquivo");
            System.out.println("14 - Carregar dados de arquivo");
            System.out.println("0  - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(lerLinha());
            } catch (NumberFormatException e) {
                        System.out.println("Opção inválida.");
                opcao = -1;
                continue;
            }

            try {
                switch (opcao) {
                    case 1:
                        int andar = lerAndar();
                        int numero = lerNumero();
                        Titular t = lerTitular();
                        if (hotel.reservarApartamento(andar, numero, t)) {
                            System.out.println("Reserva realizada com sucesso.");
                        } else {
                            System.out.println("Não foi possível reservar.");
                        }
                        break;
                    case 2:
                        andar = lerAndar();
                        numero = lerNumero();
                        t = lerTitular();
                        if (hotel.realizarCheckin(andar, numero, t)) {
                            System.out.println("Check-in realizado com sucesso.");
                        } else {
                            System.out.println("Não foi possível realizar check-in.");
                        }
                        break;
                    case 3:
                        andar = lerAndar();
                        numero = lerNumero();
                        if (hotel.realizarCheckout(andar, numero)) {
                            System.out.println("Check-out realizado com sucesso.");
                        } else {
                            System.out.println("Não foi possível realizar check-out.");
                        }
                        break;
                    case 4:
                        andar = lerAndar();
                        numero = lerNumero();
                        if (hotel.cancelarReserva(andar, numero)) {
                            System.out.println("Reserva cancelada com sucesso.");
                        } else {
                            System.out.println("Não foi possível cancelar reserva.");
                        }
                        break;
                    case 5:
                        hotel.mostrarMapa();
                        break;
                    case 6:
                        andar = lerAndar();
                        numero = lerNumero();
                        hotel.consultarApartamento(andar, numero);
                        break;
                    case 7:
                        System.out.printf("Taxa de ocupação: %.1f%%\n", hotel.calcularTaxaOcupacao() * 100);
                        System.out.printf("Taxa de reservas: %.1f%%\n", hotel.calcularTaxaReservas() * 100);
                        break;
                    case 8:
                        System.out.print("Nome do serviço: ");
                        String nome = lerLinha();
                        System.out.print("Preço: ");
                        float preco = Float.parseFloat(lerLinha());
                        hotel.cadastrarServico(nome, preco);
                        System.out.println("Serviço cadastrado.");
                        break;
                    case 9:
                        if (hotel.getServicos().isEmpty()) {
                            System.out.println("Nenhum serviço cadastrado. Use a opção 8 primeiro.");
                            break;
                        }
                        mostrarCardapio();
                        andar = lerAndar();
                        numero = lerNumero();
                        System.out.print("Índice do serviço (0 a " + (hotel.getServicos().size() - 1) + "): ");
                        int idx = Integer.parseInt(lerLinha());
                        System.out.print("Quantidade: ");
                        int qtd = Integer.parseInt(lerLinha());
                        if (hotel.registrarConsumo(andar, numero, idx, qtd)) {
                            System.out.println("Consumo registrado.");
                        } else {
                            System.out.println("Não foi possível registrar consumo.");
                        }
                        break;
                    case 10:
                        andar = lerAndar();
                        numero = lerNumero();
                        Fatura fatura = hotel.emitirFatura(andar, numero);
                        System.out.println(fatura);
                        break;
                    case 11:
                        new RelatorioSvc(hotel).gerarRelatorioOcupacao();
                        break;
                    case 12:
                        new RelatorioSvc(hotel).gerarRankingServicos();
                        break;
                    case 13:
                        HotelRepo.salvar(hotel);
                        System.out.println("Dados salvos.");
                        break;
                    case 14:
                        hotel = HotelRepo.carregar();
                        System.out.println("Dados carregados.");
                        break;
                    case 0:
                        System.out.println("Encerrando.");
                        break;
                    default:
                System.out.println("Opção inválida.");
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("Funcionalidade não implementada: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite um número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Operação inválida: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro de arquivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Arquivo de dados incompatível: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }
}
