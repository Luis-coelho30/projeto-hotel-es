package hotel.apresentacao;

import hotel.modelo.*;
import hotel.negocio.Hotel;
import java.util.ArrayList;
import java.time.LocalDate;

public class HotelTest {
    private static int passou = 0;
    private static int total = 0;

    public static void main(String[] args) {
        // Exemplo:
        // testarReservarAptoLivre();
        // testarReservarAptoOcupadoFalha();
        // ...
        testarCadastroHospedeValido();
        testarCadastroHospedeCpfNull();
        testarCadastroHospedeNomeNull();
        testarCadastroHospedeEnderecoNull();
        testarCadastroHospedeCelularNull();
        testarCadastroHospedeEmailNull();
        testarEqualsHospedeValido();
        testarEqualsHospedeDistinto();
        testarEqualsHospedeNull();
        testarHashcodeHospedeValido();
        testarHashcodeHospedeDistinto();

        testarReservaAptoLivreCriaReservaAtiva();
        testarReservaAptoJaReservadoNaoCriaNova();
        testarReservaAptoOcupadoNaoCriaReserva();
        testarReservarHospedeNuloFalha();
        testarReservaAptoNaoLivreComHospedeNuloRetornaFalse();

        testarCheckinLivreCriaEstadiaAtiva();
        testarCheckinDeReservaMarcaUtilizada();
        testarCheckinAptoOcupadoNaoCriaEstadia();
        testarCheckinHospedeNuloNaoCriaEstadia();
        testarCheckinAposCancelarMantemReservaCancelada();

        testarCheckoutAptoOcupado();
        testarCheckoutAptoLivreFalha();
        testarCheckoutAptoReservadoFalha();

        testarCancelarReservaAptoReservado();
        testarCancelarReservaAptoLivreFalha();
        testarCancelarReservaAptoOcupadoFalha();

        testarReservarApartamentoValido();
        testarReservarApartamentoNaoLivreFalha();
        testarCheckoutEncerraEstadiaELibera();
        testarCheckoutAptoNaoOcupadoRetornaFalse();
        testarCheckinAposCheckoutCriaNovaEstadia();
        testarInvarianteReservaAtivaEAptoReservado();

        testarPrecoDiariaFeliz();
        testarAptoHotelFeliz();
        testarAptoHotelTristeTipoIncorreto();

        testarAptoInvalidoTristeNumero();
        testarAptoInvalidoTristeAndar();
        testarAptoValidoFeliz();

        testarCancelarReservaMarcaCancelada();
        testarCancelarAptoNaoReservadoRetornaFalse();
        testarCancelarReservaDuasVezes();
        testarReservarDepoisDeCancelarCriaNovaReserva();

        testarMostrarMapa();

        testarTaxaOcupacaoComCheckin();
        testarTaxaOcupacaoHotelVazio();
        testarTaxaOcupacaoComReserva();

        testarTaxaReservasHotelVazio();
        testarTaxaReservasIgnoraOcupados();
        testarTaxaReservasComSucesso();

        testarCriarServicoValido();
        testarCriarServicoNomeVazioFalha();
        testarCriarServicoPrecoNegativoFalha();

        testarCriarConsumoValido();
        testarCriarConsumoServicoNuloFalha();
        testarCriarConsumoQuantidadeZeroFalha();

        testarFaturaTotalDiarias();
        testarFaturaApartamentoNuloFalha();
        testarFaturaDiasZeroFalha();
        testarFaturaConsumosNuloFalha();
        testarFaturaTotalConsumos();
        testarFaturaTotalConsumosVazio();
        testarFaturaTotalGeral();

        testarCriarReservaValida();
        testarCriarReservaHospedeNuloFalha();
        testarMarcarReservaUtilizada();
        testarMarcarUtilizadaDuasVezesFalha();
        testarCancelarReservaAtiva();
        testarCancelarReservaDuasVezesFalha();
        testarMarcarUtilizadaDepoisDeCancelarFalha();
        testarCancelarDepoisDeUtilizadaFalha();

        testarCriarEstadiaValida();
        testarCriarEstadiaSemDataUsaHoje();
        testarCriarEstadiaHospedeNuloFalha();
        testarCriarEstadiaSemDataHospedeNuloFalha();
        testarCriarEstadiaDataInicioNulaFalha();
        testarEncerrarComData();
        testarEncerrarSemDataUsaHoje();
        testarEncerrarNoMesmoDiaDoInicio();
        testarEncerrarDuasVezesFalha();
        testarEncerrarDataAnteriorAoInicioFalha();
        testarEncerrarDataNulaFalha();
        testarRegistrarConsumo();
        testarRegistrarConsumoNuloFalha();
        testarRegistrarConsumoEstadiaEncerradaFalha();
        testarGetDiasVariosDias();
        testarGetDiasMesmoDia();
        testarGetDiasAtivaRecemCriada();
        testarGetDiasAtivaComInicioNoPassado();
        testarGetTotalConsumos();
        testarGetTotalConsumosVazio();

        testarGetReservasNaoModificavelFalha();
        testarGetEstadiasNaoModificavelFalha();

        testarConsultarAptoLivre();
        testarConsultarAptoReservadoMostraHospede();
        testarConsultarAptoOcupadoMostraHospede();

        testarCadastrarServicoNoCardapio();
        testarCadastrarServicosMantemOrdem();
        testarCadastrarServicoNomeVazioFalha();
        testarCadastrarServicoPrecoNegativoFalha();

        testarRegistrarConsumoAptoOcupado();
        testarRegistrarConsumoAptoNaoOcupadoRetornaFalse();
        testarRegistrarConsumoAposCheckoutRetornaFalse();
        testarRegistrarConsumoIndiceNegativoFalha();
        testarRegistrarConsumoIndiceForaDoCardapioFalha();
        testarRegistrarConsumoQuantidadeZeroFalha();
        testarRegistrarConsumoQuantidadeNegativaFalha();
        testarConsumosSemEstadiaVazio();
        testarConsumosNaoVazamEntreHospedes();
        testarConsumosIndependentesPorApartamento();
        testarConsumosNaoModificavelFalha();

        testarEmitirFaturaSimplesSemConsumo();
        testarEmitirFaturaPremiumComConsumo();
        testarEmitirFaturaNaoAlteraEstado();
        testarEmitirFaturaEhRetratoFixo();
        testarEmitirFaturaIgnoraEstadiaAnterior();
        testarEmitirFaturaAptoLivreFalha();
        testarEmitirFaturaAptoReservadoFalha();
        testarEmitirFaturaAposCheckoutFalha();

        System.out.println(passou + "/" + total + " testes passaram");
    }

    static void testarCadastroHospedeValido() {
        total++;
        String cpf = "123";
        String nome = "Joao";
        String endereco = "Rua X";
        String celular = "9999";
        String email = "joao@x";
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);

            if(!cpf.equals(hospede.getCpf())) {
                System.out.println("FALHOU: testarCadastroHospedeValido - CPF incorreto");
            }
            else if(!nome.equals(hospede.getNome())) {
                System.out.println("FALHOU: testarCadastroHospedeValido - Nome incorreto");
            }
            else if(!endereco.equals(hospede.getEndereco())) {
                System.out.println("FALHOU: testarCadastroHospedeValido - Endereco incorreto");
            }
            else if(!celular.equals(hospede.getCelular())) {
                System.out.println("FALHOU: testarCadastroHospedeValido - Celular incorreto");
            }
            else if(!email.equals(hospede.getEmail())) {
                System.out.println("FALHOU: testarCadastroHospedeValido - Email incorreto");
            }
            else {
                passou++;
            }
        } catch(Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeValido - Excecao inesperada: " + e.getMessage());
        }        
    }

    static void testarCadastroHospedeCpfNull() {
        total++;
        String cpf = null;
        String nome = "Joao";
        String endereco = "Rua X";
        String celular = "9999";
        String email = "joao@x";
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);
            System.out.println("FALHOU: testarCadastroHospedeCpfNull - CPF nao pode ser null");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeCpfNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarCadastroHospedeNomeNull() {
        total++;
        String cpf = "123";
        String nome = null;
        String endereco = "Rua X";
        String celular = "9999";
        String email = "joao@x";
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);
            System.out.println("FALHOU: testarCadastroHospedeNomeNull - Nome nao pode ser null");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeNomeNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarCadastroHospedeEnderecoNull() {
        total++;
        String cpf = "123";
        String nome = "Joao";
        String endereco = null;
        String celular = "9999";
        String email = "joao@x";
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);
            System.out.println("FALHOU: testarCadastroHospedeEnderecoNull - Endereco nao pode ser null");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeEnderecoNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarCadastroHospedeCelularNull() {
        total++;
        String cpf = "123";
        String nome = "Joao";
        String endereco = "Rua X";
        String celular = null;
        String email = "joao@x";
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);
            System.out.println("FALHOU: testarCadastroHospedeCelularNull - Celular nao pode ser null");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeCelularNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarCadastroHospedeEmailNull() {
        total++;
        String cpf = "123";
        String nome = "Joao";
        String endereco = "Rua X";
        String celular = "9999";
        String email = null;
        try {
            Hospede hospede = new Hospede(cpf, nome, endereco, celular, email);
            System.out.println("FALHOU: testarCadastroHospedeEmailNull - Email nao pode ser null");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastroHospedeEmailNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarEqualsHospedeValido() {
        total++;

        try {
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

            if(h1.equals(h2)) {
                passou++;
            } 
            else {
                System.out.println("FALHOU: testarEqualsHospedeValido - Mesmo CPF deve ser igual");
            } 
        } catch (Exception e) {
            System.out.println("FALHOU: testarEqualsHospedeValido - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarEqualsHospedeDistinto() {
        total++;

        try {
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("234", "Joao", "Rua X", "9999", "joao@x");

            if(!h1.equals(h2)) {
                passou++;
            } 
            else {
                System.out.println("FALHOU: testarEqualsHospedeDistinto - CPFs diferentes devem ser distintos");
            } 
        } catch (Exception e) {
            System.out.println("FALHOU: testarEqualsHospedeDistinto - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarEqualsHospedeNull() {
        total++;

        try {
            Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

            if(!hospede.equals(null)) {
                passou++;
            } 
            else {
                System.out.println("FALHOU: testarEqualsHospedeNull - Equals com null deve retornar false");
            } 
        } catch (Exception e) {
            System.out.println("FALHOU: testarEqualsHospedeNull - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarHashcodeHospedeValido() {
        total++;

        try {
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

            if(h1.hashCode() == h2.hashCode()) {
                passou++;
            } 
            else {
                System.out.println("FALHOU: testarHashcodeHospedeValido - Mesmo CPF deve ter mesmo hashCode");
            } 
        } catch (Exception e) {
            System.out.println("FALHOU: testarHashcodeHospedeValido - Excecao inesperada " + e.getMessage());
        }
    }

    static void testarHashcodeHospedeDistinto() {
        total++;

        try {
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("234", "Joao", "Rua X", "9999", "joao@x");

            if(h1.hashCode() != h2.hashCode()) {
                passou++;
            } 
            else {
                System.out.println("FALHOU: testarHashcodeHospedeDistinto - CPFs diferentes devem ter hashCodes diferentes");
            } 
        } catch (Exception e) {
            System.out.println("FALHOU: testarHashcodeHospedeDistinto - Excecao inesperada " + e.getMessage());
        }
    }


    // testes de Apartamento

    // reservarApartamento - caso feliz
    static void testarReservaAptoLivreCriaReservaAtiva() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            boolean ok = hotel.reservarApartamento(0, 0, h);
            if (!ok) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Reserva em apartamento livre devia retornar true");
            }
            else if (!hotel.getApartamento(0, 0).estaReservado()) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Apartamento devia estar RESERVADO");
            }
            else if (hotel.getReservas().size() != 1) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Devia existir exatamente 1 reserva");
            }
            else if (!hotel.getReservas().get(0).estaAtiva()) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Reserva devia estar ativa");
            }
            else if (hotel.getReservas().get(0).getHospede() != h) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Hospede da reserva incorreto");
            }
            else if (!(hotel.getReservas().get(0).getAndar() == 0 && hotel.getReservas().get(0).getNumero() == 0)) {
                System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - Coordenadas da reserva incorretas");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservaAptoLivreCriaReservaAtiva - excecao inesperada");
        }
    }
 
    // reservarApartamento - caso triste (ja reservado)
    static void testarReservaAptoJaReservadoNaoCriaNova() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
            hotel.reservarApartamento(0, 0, h1);
            boolean ok = hotel.reservarApartamento(0, 0, h2);
            if (ok) {
                System.out.println("FALHOU: testarReservaAptoJaReservadoNaoCriaNova - Reserva em apartamento reservado devia retornar false");
            }
            else if (hotel.getReservas().size() != 1) {
                System.out.println("FALHOU: testarReservaAptoJaReservadoNaoCriaNova - Nao devia criar uma segunda reserva");
            }
            else if (hotel.getReservas().get(0).getHospede() != h1) {
                System.out.println("FALHOU: testarReservaAptoJaReservadoNaoCriaNova - A reserva original devia ser mantida");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservaAptoJaReservadoNaoCriaNova - excecao inesperada");
        }
    }
 
    // reservarApartamento - caso triste (ocupado)
    static void testarReservaAptoOcupadoNaoCriaReserva() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean ok = hotel.reservarApartamento(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            if (ok) {
                System.out.println("FALHOU: testarReservaAptoOcupadoNaoCriaReserva - Reserva em apartamento ocupado devia retornar false");
            }
            else if (!hotel.getApartamento(0, 0).estaOcupado()) {
                System.out.println("FALHOU: testarReservaAptoOcupadoNaoCriaReserva - Apartamento devia continuar OCUPADO");
            }
            else if (!hotel.getReservas().isEmpty()) {
                System.out.println("FALHOU: testarReservaAptoOcupadoNaoCriaReserva - Nenhuma reserva devia ter sido criada");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservaAptoOcupadoNaoCriaReserva - excecao inesperada");
        }
    }
 
    // reserva - caso triste
    static void testarReservarHospedeNuloFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            try {
                hotel.reservarApartamento(0, 0, null);
                System.out.println("FALHOU: testarReservaHospedeNuloFalha - Hospede nulo devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getApartamento(0, 0).estaLivre()) {
                    System.out.println("FALHOU: testarReservaHospedeNuloFalha - Apartamento devia continuar LIVRE");
                }
                else if (!hotel.getReservas().isEmpty()) {
                    System.out.println("FALHOU: testarReservaHospedeNuloFalha - Nenhuma reserva devia ter sido criada");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservarHospedeNuloFalha - exceção inesperada");
        }
    }

    // reservarApartamento - apto nao livre: o estado e checado antes do hospede
    static void testarReservaAptoNaoLivreComHospedeNuloRetornaFalse() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            hotel.reservarApartamento(0, 0, h);
            boolean ok = hotel.reservarApartamento(0, 0, null);
            if (ok) {
                System.out.println("FALHOU: testarReservaAptoNaoLivreComHospedeNuloRetornaFalse - Apartamento nao livre devia retornar false, mesmo com hospede nulo");
            }
            else if (hotel.getReservas().size() != 1) {
                System.out.println("FALHOU: testarReservaAptoNaoLivreComHospedeNuloRetornaFalse - Nao devia criar uma segunda reserva");
            }
            else if (hotel.getReservas().get(0).getHospede() != h) {
                System.out.println("FALHOU: testarReservaAptoNaoLivreComHospedeNuloRetornaFalse - A reserva original devia ser mantida");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservaAptoNaoLivreComHospedeNuloRetornaFalse - excecao inesperada");
        }
    }

    // checkin - caso feliz
    static void testarCheckinAptoLivre() {
        total++;
        Apartamento apto = new Apartamento();
        apto.checkin();
        if (apto.estaOcupado()) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarCheckinAptoLivre");
        }
    }

    // checkin - caso feliz
    static void testarCheckinAptoReservado() {
        total++;
        Apartamento apto = new Apartamento();
        apto.reservar();
        apto.checkin();
        if (apto.estaOcupado()) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarCheckinAptoReservado");
        }
    }

    // checkin - caso triste
    static void testarCheckinAptoOcupado() {
        total++;
        Apartamento apto = new Apartamento();
        apto.checkin();
        try {
            apto.checkin();
            System.out.println("FALHOU: testarCheckinAptoOcupado");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckinAptoOcupado - exceção inesperada");
        }
    }

    // checkout - caso feliz
    static void testarCheckoutAptoOcupado() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.checkin();
            apto.checkout();;
            if (apto.estaLivre()) {
                passou++;
            }
            else {
                System.out.println("FALHOU: testarCheckoutAptoOcupado");
            }
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckoutAptoOcupado - exceção inesperada");
        }
    }

    // checkout - caso triste
    static void testarCheckoutAptoLivreFalha() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.checkout();
            System.out.println("FALHOU: testarCheckoutAptoLivreFalha");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckoutAptoLivreFalha - exceção inesperada");
        }
    }

    // checkout - caso triste
    static void testarCheckoutAptoReservadoFalha() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.reservar();
            apto.checkout();
            System.out.println("FALHOU: testarCheckoutAptoReservadoFalha");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckoutAptoReservadoFalha - exceção inesperada");
        }
    }

    // cancelarReserva - caso feliz
    static void testarCancelarReservaAptoReservado() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.reservar();
            apto.cancelarReserva();
            if (apto.estaLivre()) {
                passou++;
            } else {
                System.out.println("FALHOU: testarCancelarReservaAptoReservado");
            }
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaAptoReservado - exceção inesperada");
        }
    }

    // cancelarReserva - caso triste
    static void testarCancelarReservaAptoLivreFalha() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.cancelarReserva();
            System.out.println("FALHOU: testarCancelarReservaAptoLivreFalha");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaAptoLivreFalha - exceção inesperada");
        }
    }

    // cancelarReserva - caso triste
    static void testarCancelarReservaAptoOcupadoFalha() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.checkin();
            apto.cancelarReserva();
            System.out.println("FALHOU: testarCancelarReservaAptoOcupadoFalha");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaAptoOcupadoFalha - exceção inesperada");
        }
    }

    // Testes Hotel.java

    // Reservar - caso feliz
    static void testarReservarApartamentoValido() {
        total++;
        Hotel hotel = new Hotel();
        Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        try {
            boolean resultado = hotel.reservarApartamento(0, 0, hospede);

            if (resultado && hotel.getApartamento(0, 0).estaReservado()) {
                passou++;
            } else {
                System.out.println("FALHOU: testarReservarApartamentoValido");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservarApartamentoValido - excecao inesperada");
        }
    }

    // Reservar - caso triste
    static void testarReservarApartamentoNaoLivreFalha() {
        total++;
        Hotel hotel = new Hotel();
        Hospede primeiroHospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        Hospede segundoHospede = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");

        try {
            boolean primeiraReserva = hotel.reservarApartamento(0, 0, primeiroHospede);
            boolean segundaReserva = hotel.reservarApartamento(0, 0, segundoHospede);

            if (primeiraReserva && !segundaReserva) {
                passou++;
            } else {
                System.out.println("FALHOU: testarReservarApartamentoNaoLivreFalha");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservarApartamentoNaoLivreFalha - excecao inesperada");
        }
    }

    // realizarCheckin - caso feliz (apto livre)
    static void testarCheckinLivreCriaEstadiaAtiva() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            boolean ok = hotel.realizarCheckin(3, 5, h);
            if (!ok) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Check-in em apartamento livre devia retornar true");
            }
            else if (!hotel.getApartamento(3, 5).estaOcupado()) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Apartamento devia estar OCUPADO");
            }
            else if (hotel.getEstadias().size() != 1) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Devia existir exatamente 1 estadia");
            }
            else if (!hotel.getEstadias().get(0).estaAtiva()) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Estadia devia estar ativa");
            }
            else if (hotel.getEstadias().get(0).getHospede() != h) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Hospede da estadia incorreto");
            }
            else if (hotel.getEstadias().get(0).getAndar() != 3) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Coordenadas da estadia incorretas");
            }
            else if (hotel.getEstadias().get(0).getNumero() != 5) {
                System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - Coordenadas da estadia incorretas");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinLivreCriaEstadiaAtiva - excecao inesperada");
        }
    }

    // realizarCheckin - caso feliz (apto reservado)
    static void testarCheckinDeReservaMarcaUtilizada() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            hotel.reservarApartamento(0, 0, h);
            boolean ok = hotel.realizarCheckin(0, 0, h);
            if (!ok) {
                System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - Check-in em apartamento reservado devia retornar true");
            }
            else if (!hotel.getApartamento(0, 0).estaOcupado()) {
                System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - Apartamento devia estar OCUPADO");
            }
            else if (hotel.getReservas().get(0).getStatus() != StatusReserva.UTILIZADA) {
                System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - Reserva devia ficar UTILIZADA");
            }
            else if (hotel.getEstadias().size() != 1) {
                System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - Devia existir exatamente 1 estadia");
            }
            else if (!invarianteReservas(hotel)) {
                System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - Invariante reserva ativa x apartamento RESERVADO violada");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinDeReservaMarcaUtilizada - excecao inesperada");
        }
    }

    // realizarCheckin - caso triste (ja ocupado)
    static void testarCheckinAptoOcupadoNaoCriaEstadia() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
            hotel.realizarCheckin(0, 0, h1);
            boolean ok = hotel.realizarCheckin(0, 0, h2);
            if (ok) {
                System.out.println("FALHOU: testarCheckinAptoOcupadoNaoCriaEstadia - Check-in em apartamento ocupado devia retornar false");
            }
            else if (hotel.getEstadias().size() != 1) {
                System.out.println("FALHOU: testarCheckinAptoOcupadoNaoCriaEstadia - Nao devia criar uma segunda estadia");
            }
            else if (hotel.getEstadias().get(0).getHospede() != h1) {
                System.out.println("FALHOU: testarCheckinAptoOcupadoNaoCriaEstadia - A estadia original devia ser mantida");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinAptoOcupadoNaoCriaEstadia - excecao inesperada");
        }
    }

    // realizarCheckin - caso triste (hospede nulo)
    static void testarCheckinHospedeNuloNaoCriaEstadia() {
        total++;
        try {
            Hotel hotel = new Hotel();
            try {
                hotel.realizarCheckin(0, 0, null);
                System.out.println("FALHOU: testarCheckinHospedeNuloNaoCriaEstadia - Hospede nulo devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getApartamento(0, 0).estaLivre()) {
                    System.out.println("FALHOU: testarCheckinHospedeNuloNaoCriaEstadia - Apartamento devia continuar LIVRE");
                }
                else if (!hotel.getEstadias().isEmpty()) {
                    System.out.println("FALHOU: testarCheckinHospedeNuloNaoCriaEstadia - Nenhuma estadia devia ter sido criada");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinHospedeNuloNaoCriaEstadia - excecao inesperada");
        }
    }

    // realizarCheckin - reserva cancelada nao e reutilizada
    static void testarCheckinAposCancelarMantemReservaCancelada() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.cancelarReserva(0, 0);
            boolean ok = hotel.realizarCheckin(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            if (!ok) {
                System.out.println("FALHOU: testarCheckinAposCancelarMantemReservaCancelada - Check-in em apartamento livre devia retornar true");
            }
            else if (hotel.getReservas().get(0).getStatus() != StatusReserva.CANCELADA) {
                System.out.println("FALHOU: testarCheckinAposCancelarMantemReservaCancelada - Reserva cancelada devia continuar CANCELADA");
            }
            else if (hotel.getEstadias().size() != 1) {
                System.out.println("FALHOU: testarCheckinAposCancelarMantemReservaCancelada - Devia existir exatamente 1 estadia");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinAposCancelarMantemReservaCancelada - excecao inesperada");
        }
    }

    // realizarCheckout - caso feliz
    static void testarCheckoutEncerraEstadiaELibera() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean ok = hotel.realizarCheckout(0, 0);
            if (!ok) {
                System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - Check-out em apartamento ocupado devia retornar true");
            }
            else if (!hotel.getApartamento(0, 0).estaLivre()) {
                System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - Apartamento devia estar LIVRE");
            }
            else if (hotel.getEstadias().size() != 1) {
                System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - A estadia devia permanecer no historico");
            }
            else if (hotel.getEstadias().get(0).estaAtiva()) {
                System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - Estadia devia estar encerrada");
            }
            else if (!hotel.getEstadias().get(0).getDataFim().equals(LocalDate.now())) {
                System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - Data de fim devia ser a data atual");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckoutEncerraEstadiaELibera - excecao inesperada");
        }
    }

    // realizarCheckout - caso triste (livre e reservado)
    static void testarCheckoutAptoNaoOcupadoRetornaFalse() {
        total++;
        try {
            Hotel hotel = new Hotel();
            boolean livre = hotel.realizarCheckout(0, 0);
            hotel.reservarApartamento(0, 1, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean reservado = hotel.realizarCheckout(0, 1);
            if (livre) {
                System.out.println("FALHOU: testarCheckoutAptoNaoOcupadoRetornaFalse - Check-out em apartamento livre devia retornar false");
            }
            else if (reservado) {
                System.out.println("FALHOU: testarCheckoutAptoNaoOcupadoRetornaFalse - Check-out em apartamento reservado devia retornar false");
            }
            else if (!hotel.getApartamento(0, 1).estaReservado()) {
                System.out.println("FALHOU: testarCheckoutAptoNaoOcupadoRetornaFalse - Apartamento reservado devia continuar RESERVADO");
            }
            else if (!hotel.getEstadias().isEmpty()) {
                System.out.println("FALHOU: testarCheckoutAptoNaoOcupadoRetornaFalse - Nenhuma estadia devia existir");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckoutAptoNaoOcupadoRetornaFalse - excecao inesperada");
        }
    }

    // realizarCheckin - apos check-out
    static void testarCheckinAposCheckoutCriaNovaEstadia() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Hospede h2 = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
            hotel.realizarCheckin(0, 0, h1);
            hotel.realizarCheckout(0, 0);
            boolean ok = hotel.realizarCheckin(0, 0, h2);
            if (!ok) {
                System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - Novo check-in devia retornar true");
            }
            else if (hotel.getEstadias().size() != 2) {
                System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - Devia existir 2 estadias (historico + atual)");
            }
            else if (hotel.getEstadias().get(0).estaAtiva()) {
                System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - A primeira estadia devia estar encerrada");
            }
            else if (!hotel.getEstadias().get(1).estaAtiva()) {
                System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - A segunda estadia devia estar ativa");
            }
            else if (hotel.getEstadias().get(1).getHospede() != h2) {
                System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - Hospede da segunda estadia incorreto");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCheckinAposCheckoutCriaNovaEstadia - excecao inesperada");
        }
    }

    // invariante: reserva ativa se e somente se apartamento RESERVADO
    static void testarInvarianteReservaAtivaEAptoReservado() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            hotel.reservarApartamento(0, 0, h);
            hotel.reservarApartamento(0, 1, h);
            hotel.reservarApartamento(0, 2, h);
            hotel.cancelarReserva(0, 1);
            hotel.realizarCheckin(0, 0, h);
            hotel.reservarApartamento(0, 1, h);
            hotel.realizarCheckout(0, 0);
            if (!invarianteReservas(hotel)) {
                System.out.println("FALHOU: testarInvarianteReservaAtivaEAptoReservado - Reservas ativas e apartamentos RESERVADOS ficaram inconsistentes");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarInvarianteReservaAtivaEAptoReservado - excecao inesperada");
        }
    }

    //teste do preco simples e premium - caso feliz
    static void testarPrecoDiariaFeliz(){
        total++;

        Apartamento apSimples = new ApartamentoSimples();
        Apartamento apPremium = new ApartamentoPremium();

        if(apSimples.getPrecoDiaria() == 150.0f && apPremium.getPrecoDiaria() == 350.0f){
            passou++;
        } else {
            System.out.println("FALHOU: testarPrecoDiariaFeliz");
        }
    }

    // testar se os quartos simples e premium estão corretos - caso feliz
    static void testarAptoHotelFeliz(){
        total++;
        Hotel hotel = new Hotel();
        
        // quartos 0 a 7 devem ser Simples, quartos 8 a 13 Premium (regra da mistura 8/6)
        boolean isSimples = hotel.getApartamento(0, 7) instanceof ApartamentoSimples;
        boolean isPremium = hotel.getApartamento(0, 8) instanceof ApartamentoPremium;
        
        if (isSimples && isPremium) {
            passou++;
        } else {
            System.out.println("FALHOU: testarIntegracaoHotelFeliz - A mistura 8/6 não foi respeitada.");
        }
    }

    // testar se os tipos de quarto não se misturam no lugar errado - caso triste
    static void testarAptoHotelTristeTipoIncorreto(){
        total++;
        Hotel hotel = new Hotel();
        
        // perguntar se um quarto Premium (8) é simples, deve ser falso
        boolean isSimples = hotel.getApartamento(0, 8) instanceof ApartamentoSimples;
        
        if (!isSimples) {
            passou++;
        } else {
            System.out.println("FALHOU: testarAptoHotelTristeTipoIncorreto");
        }
    }


    // tenta entrar em um quarto fora dos limites (número) - caso triste
    static void testarAptoInvalidoTristeNumero() {
        total++;
        Hotel hotel = new Hotel();
        
        try {
            hotel.getApartamento(0, 14); // tenta ver o apto inexistente (valido: 0 <= numero <= 13)
            System.out.println("FALHOU: testarAptoInvalidoTristeNumero - Devia ter lançado exceção.");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e){
            System.out.println("FALHOU: testarAptoInvalidoTristeNumero - exceção inesperada " + e.toString());
        }
    }

    // tenta entrar em um quarto fora dos limites (andar) - caso triste
    static void testarAptoInvalidoTristeAndar() {
        total++;
        Hotel hotel = new Hotel();
        
        try {
            hotel.getApartamento(20, 0); // tenta ver o andar inexistente (valido: 0 <= numero <= 19)
            System.out.println("FALHOU: testarAptoInvalidoTristeAndar - Devia ter lançado exceção.");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e){
            System.out.println("FALHOU: testarAptoInvalidoTristeAndar - exceção inesperada " + e.toString());
        }
    }

    // testa quarto dentro dos limites - caso feliz
    static void testarAptoValidoFeliz() {
        total++;
        Hotel hotel = new Hotel();
        
        try {
            Apartamento ap = hotel.getApartamento(10, 5);
            if (ap != null) {
                passou++;
            } else {
                System.out.println("FALHOU: testarAptoValidoFeliz - O sistema retornou nulo para um quarto válido.");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarAptoValidoFeliz - exceção inesperada " + e.toString());
        }
    }

    // cancelarReserva - caso feliz
    static void testarCancelarReservaMarcaCancelada() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean ok = hotel.cancelarReserva(0, 0);
            if (!ok) {
                System.out.println("FALHOU: testarCancelarReservaMarcaCancelada - Cancelamento de reserva ativa devia retornar true");
            }
            else if (!hotel.getApartamento(0, 0).estaLivre()) {
                System.out.println("FALHOU: testarCancelarReservaMarcaCancelada - Apartamento devia estar LIVRE");
            }
            else if (hotel.getReservas().size() != 1) {
                System.out.println("FALHOU: testarCancelarReservaMarcaCancelada - A reserva devia permanecer no historico");
            }
            else if (hotel.getReservas().get(0).getStatus() != StatusReserva.CANCELADA) {
                System.out.println("FALHOU: testarCancelarReservaMarcaCancelada - Reserva devia ficar CANCELADA");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaMarcaCancelada - excecao inesperada");
        }
    }

    // cancelarReserva - caso triste (livre e ocupado)
    static void testarCancelarAptoNaoReservadoRetornaFalse() {
        total++;
        try {
            Hotel hotel = new Hotel();
            boolean livre = hotel.cancelarReserva(0, 0);
            hotel.realizarCheckin(0, 1, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean ocupado = hotel.cancelarReserva(0, 1);
            if (livre) {
                System.out.println("FALHOU: testarCancelarAptoNaoReservadoRetornaFalse - Cancelar apartamento livre devia retornar false");
            }
            else if (ocupado) {
                System.out.println("FALHOU: testarCancelarAptoNaoReservadoRetornaFalse - Cancelar apartamento ocupado devia retornar false");
            }
            else if (!hotel.getApartamento(0, 1).estaOcupado()) {
                System.out.println("FALHOU: testarCancelarAptoNaoReservadoRetornaFalse - Apartamento ocupado devia continuar OCUPADO");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarAptoNaoReservadoRetornaFalse - excecao inesperada");
        }
    }

    // cancelarReserva - caso triste (segunda tentativa)
    static void testarCancelarReservaDuasVezes() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.cancelarReserva(0, 0);
            boolean segunda = hotel.cancelarReserva(0, 0);
            if (segunda) {
                System.out.println("FALHOU: testarCancelarReservaDuasVezes - Segundo cancelamento devia retornar false");
            }
            else if (hotel.getReservas().get(0).getStatus() != StatusReserva.CANCELADA) {
                System.out.println("FALHOU: testarCancelarReservaDuasVezes - Reserva devia continuar CANCELADA");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaDuasVezes - excecao inesperada");
        }
    }

    // reservarApartamento - apos cancelamento
    static void testarReservarDepoisDeCancelarCriaNovaReserva() {
        total++;
        try {
            Hotel hotel = new Hotel();
            Hospede h2 = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.cancelarReserva(0, 0);
            boolean ok = hotel.reservarApartamento(0, 0, h2);
            if (!ok) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - Nova reserva devia retornar true");
            }
            else if (hotel.getReservas().size() != 2) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - Devia existir 2 reservas (cancelada + nova)");
            }
            else if (hotel.getReservas().get(0).getStatus() != StatusReserva.CANCELADA) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - A primeira devia continuar CANCELADA");
            }
            else if (!hotel.getReservas().get(1).estaAtiva()) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - A segunda devia estar ativa");
            }
            else if (hotel.getReservas().get(1).getHospede() != h2) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - Hospede da segunda reserva incorreto");
            }
            else if (!invarianteReservas(hotel)) {
                System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - Invariante reserva ativa x apartamento RESERVADO violada");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservarDepoisDeCancelarCriaNovaReserva - excecao inesperada");
        }
    }

    //hotel mostrar mapa com diferentes status
    static void testarMostrarMapa(){
        total++;

        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        
        hotel.reservarApartamento(0, 0, h);
        hotel.realizarCheckin(0, 1, h);

        try {
            hotel.mostrarMapa();
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarMostrarMapaFeliz - exceção inesperada: " + e.toString());
        }
    }

    //teste de taxa de ocupação - caso feliz
    static void testarTaxaOcupacaoComCheckin() {
        total++;
        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        
        float taxaAntes = hotel.calcularTaxaOcupacao();

        hotel.realizarCheckin(0, 0, h);
        hotel.realizarCheckin(1, 1, h);
        
        float taxaDepois = hotel.calcularTaxaOcupacao(); //2 quartos ocupados num total de 280: (2 / 280) * 100 = 0.714285
        
        if (taxaAntes == 0.0f && taxaDepois > 0.0f && taxaDepois <= 1.0f) {//valor entre 0 e 1
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaOcupacaoComCheckin - O cálculo retornou " + taxaDepois + "mesmo com hóspedes no hotel.");
        }
    }

    //teste de limite de hotel vazio (zero)
    static void testarTaxaOcupacaoHotelVazio() {
        total++;
        Hotel hotel = new Hotel();

        float taxa = hotel.calcularTaxaOcupacao();
    
        if (taxa == 0.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaOcupacaoHotelVazio - Esperado 0.0, recebido " + taxa);
        }
    }

    //testa se ignora os apartamentos reservados
    static void testarTaxaOcupacaoComReserva() {
        total++;
        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        
        hotel.reservarApartamento(0, 0, h);
        float taxa = hotel.calcularTaxaOcupacao();
        
        if (taxa == 0.0f && hotel.getApartamento(0, 0).estaReservado()) {
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaOcupacaoComReserva - O sistema contabilizou quartos 'Reservados' como 'Ocupados'!");
        }
    }

    // teste com hotel vazio
    static void testarTaxaReservasHotelVazio() {
        total++;
        Hotel hotel = new Hotel();
        
        float taxa = hotel.calcularTaxaReservas();
        
        if (taxa == 0.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaReservasHotelVazio - Esperado 0.0, recebido " + taxa);
        }
    }

    //teste se ignora ocupados
    static void testarTaxaReservasIgnoraOcupados() {
        total++;
        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        hotel.realizarCheckin(0, 0, h);

        float taxa = hotel.calcularTaxaReservas();
        
        if (taxa == 0.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaReservasIgnoraOcupados - Sistema contabiliza Quartos Ocupados como Reservas!");
        }
    }

    //testar calculo de taxa de reservas
    static void testarTaxaReservasComSucesso() {
        total++;
        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        
        float taxaAntes = hotel.calcularTaxaReservas();
        
        hotel.reservarApartamento(0, 0, h);
        hotel.reservarApartamento(1, 1, h);
        
        float taxaDepois = hotel.calcularTaxaReservas();
        
        if (taxaAntes == 0.0f && taxaDepois > 0.0f && taxaDepois <= 1.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarTaxaReservasComSucesso - Taxa fora do limite (0 a 1): " + taxaDepois);
        }
    }

    // testes Servico

    // Servico - caso feliz
    static void testarCriarServicoValido() {
        total++;
        Servico s = new Servico("Agua", 5.0f);
        if (s.getNome().equals("Agua") && s.getPreco() == 5.0f) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarCriarServicoValido");
        }
    }

    // Servico - caso triste (nome vazio)
    static void testarCriarServicoNomeVazioFalha() {
        total++;
        try {
            new Servico("", 5.0f);
            System.out.println("FALHOU: testarCriarServicoNomeVazioFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarServicoNomeVazioFalha - excecao inesperada");
        }
    }

    // Servico - caso triste (preco negativo)
    static void testarCriarServicoPrecoNegativoFalha() {
        total++;
        try {
            new Servico("Agua", -1.0f);
            System.out.println("FALHOU: testarCriarServicoPrecoNegativoFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarServicoPrecoNegativoFalha - excecao inesperada");
        }
    }

    // testes Consumo

    // Consumo - caso feliz
    static void testarCriarConsumoValido() {
        total++;
        Servico servico = new Servico("Agua", 5.0f);
        Consumo c = new Consumo(servico, 2);
        if (c.getServico() == servico && c.getQuantidade() == 2 && c.getTotal() == 10.0f) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarCriarConsumoValido");
        }
    }

    // Consumo - caso triste (servico nulo)
    static void testarCriarConsumoServicoNuloFalha() {
        total++;
        try {
            new Consumo(null, 2);
            System.out.println("FALHOU: testarCriarConsumoServicoNuloFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarConsumoServicoNuloFalha - excecao inesperada");
        }
    }

    // Consumo - caso triste (quantidade zero)
    static void testarCriarConsumoQuantidadeZeroFalha() {
        total++;
        Servico servico = new Servico("Agua", 5.0f);
        try {
            new Consumo(servico, 0);
            System.out.println("FALHOU: testarCriarConsumoQuantidadeZeroFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarConsumoQuantidadeZeroFalha - excecao inesperada");
        }
    }

    // teste Fatura

    // testarFaturaTotalDiarias - caso feliz
    static void testarFaturaTotalDiarias() {
        total++;
        Fatura fatura = new Fatura(new ApartamentoSimples(), 3, new ArrayList<Consumo>());
        if (fatura.getTotalDiarias() == 450.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarFaturaTotalDiarias");
        }
    }

    // Fatura - caso triste (apartamento nulo)
    static void testarFaturaApartamentoNuloFalha() {
        total++;
        try {
            new Fatura(null, 3, new ArrayList<Consumo>());
            System.out.println("FALHOU: testarFaturaApartamentoNuloFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarFaturaApartamentoNuloFalha - excecao inesperada");
        }
    }

    // Fatura - caso triste (dias zero)
    static void testarFaturaDiasZeroFalha() {
        total++;
        try {
            new Fatura(new ApartamentoSimples(), 0, new ArrayList<Consumo>());
            System.out.println("FALHOU: testarFaturaDiasZeroFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarFaturaDiasZeroFalha - excecao inesperada");
        }
    }

    // Fatura - caso triste (lista de consumos nula)
    static void testarFaturaConsumosNuloFalha() {
        total++;
        try {
            new Fatura(new ApartamentoSimples(), 3, null);
            System.out.println("FALHOU: testarFaturaConsumosNuloFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarFaturaConsumosNuloFalha - excecao inesperada");
        }
    }

    // getTotalConsumos - caso feliz
    static void testarFaturaTotalConsumos() {
        total++;
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        consumos.add(new Consumo(new Servico("Agua", 5.0f), 2));     // 10
        consumos.add(new Consumo(new Servico("Jantar", 80.0f), 1));  // 80
        Fatura fatura = new Fatura(new ApartamentoSimples(), 3, consumos);
        if (fatura.getTotalConsumos() == 90.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarFaturaTotalConsumos");
        }
    }

    // getTotalConsumos - lista vazia
    static void testarFaturaTotalConsumosVazio() {
        total++;
        Fatura fatura = new Fatura(new ApartamentoSimples(), 3, new ArrayList<Consumo>());
        if (fatura.getTotalConsumos() == 0.0f) {
            passou++;
        } else {
            System.out.println("FALHOU: testarFaturaTotalConsumosVazio");
        }
    }

    // getTotalGeral - caso feliz
    static void testarFaturaTotalGeral() {
        total++;
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        consumos.add(new Consumo(new Servico("Agua", 5.0f), 2));
        consumos.add(new Consumo(new Servico("Jantar", 80.0f), 1));
        Fatura fatura = new Fatura(new ApartamentoSimples(), 3, consumos);
        if (fatura.getTotalGeral() == 540.0f) {   // 450 + 90
            passou++;
        } else {
            System.out.println("FALHOU: testarFaturaTotalGeral");
        }
    }

    // construtor - caso feliz
    static void testarCriarReservaValida() {
        total++;
        try {
            Hospede h = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
            Reserva reserva = new Reserva(4, 9, h);
            if (reserva.getAndar() != 4) {
                System.out.println("FALHOU: testarCriarReservaValida - Andar incorreto");
            }
            else if (reserva.getNumero() != 9) {
                System.out.println("FALHOU: testarCriarReservaValida - Numero incorreto");
            }
            else if (reserva.getHospede() != h) {
                System.out.println("FALHOU: testarCriarReservaValida - Hospede incorreto");
            }
            else if (reserva.getStatus() != StatusReserva.ATIVA) {
                System.out.println("FALHOU: testarCriarReservaValida - Status inicial deve ser ATIVA");
            }
            else if (!reserva.estaAtiva()) {
                System.out.println("FALHOU: testarCriarReservaValida - Reserva recem criada deve estar ativa");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarReservaValida - excecao inesperada");
        }
    }
 
    // construtor - caso triste (hospede nulo)
    static void testarCriarReservaHospedeNuloFalha() {
        total++;
        try {
            new Reserva(0, 0, null);
            System.out.println("FALHOU: testarCriarReservaHospedeNuloFalha - Hospede nulo devia lancar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarReservaHospedeNuloFalha - excecao inesperada");
        }
    }

    // marcarUtilizada - caso feliz
    static void testarMarcarReservaUtilizada() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.marcarUtilizada();
            if (reserva.getStatus() != StatusReserva.UTILIZADA) {
                System.out.println("FALHOU: testarMarcarReservaUtilizada - Status devia ser UTILIZADA");
            }
            else if (reserva.estaAtiva()) {
                System.out.println("FALHOU: testarMarcarReservaUtilizada - Reserva utilizada nao pode estar ativa");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarMarcarReservaUtilizada - excecao inesperada");
        }
    }

    // marcarUtilizada - caso triste (ja utilizada)
    static void testarMarcarUtilizadaDuasVezesFalha() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.marcarUtilizada();
            try {
                reserva.marcarUtilizada();
                System.out.println("FALHOU: testarMarcarUtilizadaDuasVezesFalha - Utilizar duas vezes devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarMarcarUtilizadaDuasVezesFalha - excecao inesperada");
        }
    }

    // cancelar - caso feliz
    static void testarCancelarReservaAtiva() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.cancelar();
            if (reserva.getStatus() != StatusReserva.CANCELADA) {
                System.out.println("FALHOU: testarCancelarReservaAtiva - Status devia ser CANCELADA");
            }
            else if (reserva.estaAtiva()) {
                System.out.println("FALHOU: testarCancelarReservaAtiva - Reserva cancelada nao pode estar ativa");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaAtiva - Excecao inesperada");
        }
    }
 
    // cancelar - caso triste (ja cancelada)
    static void testarCancelarReservaDuasVezesFalha() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.cancelar();
            try {
                reserva.cancelar();
                System.out.println("FALHOU: testarCancelarReservaDuasVezesFalha - Cancelar duas vezes devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                if (reserva.getStatus() != StatusReserva.CANCELADA) {
                    System.out.println("FALHOU: testarCancelarReservaDuasVezesFalha - Status devia continuar CANCELADA");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarReservaDuasVezesFalha - excecao inesperada");
        }
    }
 
    // marcarUtilizada - caso triste (reserva cancelada)
    static void testarMarcarUtilizadaDepoisDeCancelarFalha() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.cancelar();
            try {
                reserva.marcarUtilizada();
                System.out.println("FALHOU: testarMarcarUtilizadaDepoisDeCancelarFalha - Utilizar reserva cancelada devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                if (reserva.getStatus() != StatusReserva.CANCELADA) {
                    System.out.println("FALHOU: testarMarcarUtilizadaDepoisDeCancelarFalha - Status devia continuar CANCELADA");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarMarcarUtilizadaDepoisDeCancelarFalha - excecao inesperada");
        }
    }

    // cancelar - caso triste (reserva utilizada)
    static void testarCancelarDepoisDeUtilizadaFalha() {
        total++;
        try {
            Reserva reserva = new Reserva(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            reserva.marcarUtilizada();
            try {
                reserva.cancelar();
                System.out.println("FALHOU: testarCancelarDepoisDeUtilizadaFalha - Cancelar reserva utilizada devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                if (reserva.getStatus() != StatusReserva.UTILIZADA) {
                    System.out.println("FALHOU: testarCancelarDepoisDeUtilizadaFalha - Status devia continuar UTILIZADA");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCancelarDepoisDeUtilizadaFalha - excecao inesperada");
        }
    }

    // construtor completo - caso feliz
    static void testarCriarEstadiaValida() {
        total++;
        try {
            LocalDate inicio = LocalDate.of(2026, 11, 1);
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Estadia estadia = new Estadia(2, 5, h, inicio);
            if (estadia.getAndar() != 2) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Andar incorreto");
            }
            else if (estadia.getNumero() != 5) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Numero incorreto");
            }
            else if (estadia.getHospede() != h) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Hospede incorreto");
            }
            else if (!estadia.getDataInicio().equals(inicio)) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Data de inicio incorreta");
            }
            else if (estadia.getDataFim() != null) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Data de fim deve comecar nula");
            }
            else if (!estadia.estaAtiva()) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Estadia recem criada deve estar ativa");
            }
            else if (!estadia.getConsumos().isEmpty()) {
                System.out.println("FALHOU: testarCriarEstadiaValida - Lista de consumos deve comecar vazia");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarEstadiaValida - Excecao inesperada");
        }
    }
 
    // construtor sem data - caso feliz
    static void testarCriarEstadiaSemDataUsaHoje() {
        total++;
        try {
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            Estadia estadia = new Estadia(0, 0, h);
            if (!estadia.getDataInicio().equals(LocalDate.now())) {
                System.out.println("FALHOU: testarCriarEstadiaSemDataUsaHoje - Data de inicio deve ser a data atual");
            }
            else if (!estadia.estaAtiva()) {
                System.out.println("FALHOU: testarCriarEstadiaSemDataUsaHoje - Estadia recem criada deve estar ativa");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarEstadiaSemDataUsaHoje - excecao inesperada");
        }
    }
 
    // construtor completo - caso triste (hospede nulo)
    static void testarCriarEstadiaHospedeNuloFalha() {
        total++;
        try {
            new Estadia(0, 0, null, LocalDate.now());
            System.out.println("FALHOU: testarCriarEstadiaHospedeNuloFalha - Hospede nulo devia lancar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarEstadiaHospedeNuloFalha - excecao inesperada");
        }
    }
 
    // construtor sem data - caso triste (hospede nulo)
    static void testarCriarEstadiaSemDataHospedeNuloFalha() {
        total++;
        try {
            new Estadia(0, 0, null);
            System.out.println("FALHOU: testarCriarEstadiaSemDataHospedeNuloFalha - Hospede nulo devia lancar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarEstadiaSemDataHospedeNuloFalha - excecao inesperada");
        }
    }
 
    // construtor completo - caso triste (data de inicio nula)
    static void testarCriarEstadiaDataInicioNulaFalha() {
        total++;
        try {
            Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
            try {
                new Estadia(0, 0, h, null);
                System.out.println("FALHOU: testarCriarEstadiaDataInicioNulaFalha - Data de inicio nula devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCriarEstadiaDataInicioNulaFalha - excecao inesperada");
        }
    }

    // encerrar(LocalDate) - caso feliz
    static void testarEncerrarComData() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.of(2026, 11, 1));
            LocalDate fim = LocalDate.of(2026, 11, 4);
            estadia.encerrar(fim);
            if (estadia.estaAtiva()) {
                System.out.println("FALHOU: testarEncerrarComData - Estadia devia estar encerrada");
            }
            else if (!estadia.getDataFim().equals(fim)) {
                System.out.println("FALHOU: testarEncerrarComData - Data de fim incorreta");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarComData - excecao inesperada");
        }
    }
 
    // encerrar() - caso feliz
    static void testarEncerrarSemDataUsaHoje() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            estadia.encerrar();
            if (estadia.estaAtiva()) {
                System.out.println("FALHOU: testarEncerrarSemDataUsaHoje - Estadia devia estar encerrada");
            }
            else if (!estadia.getDataFim().equals(LocalDate.now())) {
                System.out.println("FALHOU: testarEncerrarSemDataUsaHoje - Data de fim deve ser a data atual");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarSemDataUsaHoje - excecao inesperada");
        }
    }
 
    // encerrar(LocalDate) - caso limite (fim igual ao inicio)
    static void testarEncerrarNoMesmoDiaDoInicio() {
        total++;
        try {
            LocalDate dia = LocalDate.of(2026, 11, 1);
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), dia);
            estadia.encerrar(dia);
            if (estadia.estaAtiva()) {
                System.out.println("FALHOU: testarEncerrarNoMesmoDiaDoInicio - Encerrar no mesmo dia do inicio deve ser permitido");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarNoMesmoDiaDoInicio - excecao inesperada");
        }
    }
 
    // encerrar - caso triste (ja encerrada)
    static void testarEncerrarDuasVezesFalha() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.of(2026, 11, 1));
            estadia.encerrar(LocalDate.of(2026, 11, 2));
            try {
                estadia.encerrar(LocalDate.of(2026, 11, 3));
                System.out.println("FALHOU: testarEncerrarDuasVezesFalha - Encerrar duas vezes devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                if (!estadia.getDataFim().equals(LocalDate.of(2026, 11, 2))) {
                    System.out.println("FALHOU: testarEncerrarDuasVezesFalha - Data de fim nao deve mudar na segunda tentativa");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarDuasVezesFalha - excecao inesperada");
        }
    }
 
    // encerrar - caso triste (fim antes do inicio)
    static void testarEncerrarDataAnteriorAoInicioFalha() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.of(2026, 11, 10));
            try {
                estadia.encerrar(LocalDate.of(2026, 11, 9));
                System.out.println("FALHOU: testarEncerrarDataAnteriorAoInicioFalha - Data de fim anterior ao inicio devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!estadia.estaAtiva()) {
                    System.out.println("FALHOU: testarEncerrarDataAnteriorAoInicioFalha - Estadia deve continuar ativa apos a tentativa invalida");
                }
                else if (estadia.getDataFim() != null) {
                    System.out.println("FALHOU: testarEncerrarDataAnteriorAoInicioFalha - Data de fim deve continuar nula");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarDataAnteriorAoInicioFalha - excecao inesperada");
        }
    }
 
    // encerrar - caso triste (data nula)
    static void testarEncerrarDataNulaFalha() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                estadia.encerrar(null);
                System.out.println("FALHOU: testarEncerrarDataNulaFalha - Data de fim nula devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!estadia.estaAtiva()) {
                    System.out.println("FALHOU: testarEncerrarDataNulaFalha - Estadia deve continuar ativa apos a tentativa invalida");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEncerrarDataNulaFalha - excecao inesperada");
        }
    }

    // registrarConsumo - caso feliz
    static void testarRegistrarConsumo() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            Consumo consumo = new Consumo(new Servico("Agua", 10.0f), 2);
            estadia.registrarConsumo(consumo);
            if (estadia.getConsumos().size() != 1) {
                System.out.println("FALHOU: testarRegistrarConsumo - Devia ter exatamente 1 consumo");
            }
            else if (estadia.getConsumos().get(0) != consumo) {
                System.out.println("FALHOU: testarRegistrarConsumo - Consumo registrado incorreto");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumo - excecao inesperada");
        }
    }
 
    // registrarConsumo - caso triste (consumo nulo)
    static void testarRegistrarConsumoNuloFalha() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                estadia.registrarConsumo(null);
                System.out.println("FALHOU: testarRegistrarConsumoNuloFalha - Consumo nulo devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!estadia.getConsumos().isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoNuloFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoNuloFalha - excecao inesperada");
        }
    }
 
    // registrarConsumo - caso triste (estadia encerrada)
    static void testarRegistrarConsumoEstadiaEncerradaFalha() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.of(2026, 11, 1));
            estadia.encerrar(LocalDate.of(2026, 11, 2));
            Consumo consumo = new Consumo(new Servico("Agua", 10.0f), 1);
            try {
                estadia.registrarConsumo(consumo);
                System.out.println("FALHOU: testarRegistrarConsumoEstadiaEncerradaFalha - Consumo em estadia encerrada devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                if (!estadia.getConsumos().isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoEstadiaEncerradaFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoEstadiaEncerradaFalha - excecao inesperada");
        }
    }

    // getDias - caso feliz (01/11 a 04/11 = 3 dias)
    static void testarGetDiasVariosDias() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.of(2026, 11, 1));
            estadia.encerrar(LocalDate.of(2026, 11, 4));
            if (estadia.getDias() != 3) {
                System.out.println("FALHOU: testarGetDiasVariosDias - Esperado 3 dias");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetDiasVariosDias - excecao inesperada");
        }
    }
 
    // getDias - caso limite (entrada e saida no mesmo dia = 1 dia)
    static void testarGetDiasMesmoDia() {
        total++;
        try {
            LocalDate dia = LocalDate.of(2026, 11, 1);
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), dia);
            estadia.encerrar(dia);
            if (estadia.getDias() != 1) {
                System.out.println("FALHOU: testarGetDiasMesmoDia - Esperado minimo de 1 dia");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetDiasMesmoDia - excecao inesperada");
        }
    }
 
    // getDias - estadia ativa criada hoje
    static void testarGetDiasAtivaRecemCriada() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            if (estadia.getDias() != 1) {
                System.out.println("FALHOU: testarGetDiasAtivaRecemCriada - Esperado 1 dia");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetDiasAtivaRecemCriada - excecao inesperada");
        }
    }
 
    // getDias - estadia ativa conta ate a data atual
    static void testarGetDiasAtivaComInicioNoPassado() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"), LocalDate.now().minusDays(3));
            if (estadia.getDias() != 3) {
                System.out.println("FALHOU: testarGetDiasAtivaComInicioNoPassado - Esperado 3 dias");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetDiasAtivaComInicioNoPassado - excecao inesperada");
        }
    }

    // getTotalConsumos - caso feliz
    static void testarGetTotalConsumos() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            estadia.registrarConsumo(new Consumo(new Servico("Agua", 10.0f), 3));
            estadia.registrarConsumo(new Consumo(new Servico("Cafe", 2.5f), 4));
            if (estadia.getTotalConsumos() != 40.0f) {
                System.out.println("FALHOU: testarGetTotalConsumos - Esperado total de 40.0");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetTotalConsumos - excecao inesperada");
        }
    }
 
    // getTotalConsumos - sem consumos
    static void testarGetTotalConsumosVazio() {
        total++;
        try {
            Estadia estadia = new Estadia(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            if (estadia.getTotalConsumos() != 0.0f) {
                System.out.println("FALHOU: testarGetTotalConsumosVazio - Esperado total de 0.0");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetTotalConsumosVazio - excecao inesperada");
        }
    }

    // getReservas - caso triste (lista nao modificavel)
    static void testarGetReservasNaoModificavelFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.getReservas().clear();
                System.out.println("FALHOU: testarGetReservasNaoModificavelFalha - Alterar a lista devolvida devia lancar UnsupportedOperationException");
            } catch (UnsupportedOperationException e) {
                if (hotel.getReservas().size() != 1) {
                    System.out.println("FALHOU: testarGetReservasNaoModificavelFalha - A reserva nao devia ter sido removida");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetReservasNaoModificavelFalha - excecao inesperada");
        }
    }

    // getEstadias - caso triste (lista nao modificavel)
    static void testarGetEstadiasNaoModificavelFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.getEstadias().clear();
                System.out.println("FALHOU: testarGetEstadiasNaoModificavelFalha - Alterar a lista devolvida devia lancar UnsupportedOperationException");
            } catch (UnsupportedOperationException e) {
                if (hotel.getEstadias().size() != 1) {
                    System.out.println("FALHOU: testarGetEstadiasNaoModificavelFalha - A estadia nao devia ter sido removida");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarGetEstadiasNaoModificavelFalha - excecao inesperada");
        }
    }

    // consultarApartamento - apartamento livre
    static void testarConsultarAptoLivre() {
        total++;
        Hotel hotel = new Hotel();
        try {
            hotel.consultarApartamento(0, 0);
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsultarAptoLivre - excecao inesperada");
        }
    }

    // consultarApartamento - apartamento reservado
    static void testarConsultarAptoReservadoMostraHospede() {
        total++;
        Hotel hotel = new Hotel();
        hotel.reservarApartamento(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
        try {
            hotel.consultarApartamento(0, 0);
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsultarAptoReservadoMostraHospede - excecao inesperada");
        }
    }

    // consultarApartamento - apartamento ocupado
    static void testarConsultarAptoOcupadoMostraHospede() {
        total++;
        Hotel hotel = new Hotel();
        hotel.realizarCheckin(0, 0, new Hospede("789", "Carlos", "Rua Z", "7777", "carlos@x"));
        try {
            hotel.consultarApartamento(0, 0);
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsultarAptoOcupadoMostraHospede - excecao inesperada");
        }
    }

    // cadastrarServico - caso feliz
    static void testarCadastrarServicoNoCardapio() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Cafe", 12.5f);
            if (hotel.getServicos().size() != 1) {
                System.out.println("FALHOU: testarCadastrarServicoNoCardapio - Devia existir exatamente 1 servico");
            }
            else if (!hotel.getServicos().get(0).getNome().equals("Cafe")) {
                System.out.println("FALHOU: testarCadastrarServicoNoCardapio - Nome do servico incorreto");
            }
            else if (hotel.getServicos().get(0).getPreco() != 12.5f) {
                System.out.println("FALHOU: testarCadastrarServicoNoCardapio - Preco do servico incorreto");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastrarServicoNoCardapio - excecao inesperada");
        }
    }

    // cadastrarServico - ordem do cardapio
    static void testarCadastrarServicosMantemOrdem() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Cafe", 12.5f);
            hotel.cadastrarServico("Agua", 5.0f);
            if (hotel.getServicos().size() != 2) {
                System.out.println("FALHOU: testarCadastrarServicosMantemOrdem - Devia existir 2 servicos");
            }
            else if (!hotel.getServicos().get(0).getNome().equals("Cafe")) {
                System.out.println("FALHOU: testarCadastrarServicosMantemOrdem - O primeiro servico devia ser Cafe");
            }
            else if (!hotel.getServicos().get(1).getNome().equals("Agua")) {
                System.out.println("FALHOU: testarCadastrarServicosMantemOrdem - O segundo servico devia ser Agua");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastrarServicosMantemOrdem - excecao inesperada");
        }
    }

    // cadastrarServico - caso triste (nome vazio)
    static void testarCadastrarServicoNomeVazioFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            try {
                hotel.cadastrarServico("", 5.0f);
                System.out.println("FALHOU: testarCadastrarServicoNomeVazioFalha - Nome vazio devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getServicos().isEmpty()) {
                    System.out.println("FALHOU: testarCadastrarServicoNomeVazioFalha - Nenhum servico devia ter sido cadastrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastrarServicoNomeVazioFalha - excecao inesperada");
        }
    }

    // cadastrarServico - caso triste (preco negativo)
    static void testarCadastrarServicoPrecoNegativoFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            try {
                hotel.cadastrarServico("Agua", -1.0f);
                System.out.println("FALHOU: testarCadastrarServicoPrecoNegativoFalha - Preco negativo devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getServicos().isEmpty()) {
                    System.out.println("FALHOU: testarCadastrarServicoPrecoNegativoFalha - Nenhum servico devia ter sido cadastrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarCadastrarServicoPrecoNegativoFalha - excecao inesperada");
        }
    }

    // registrarConsumo - caso feliz
    static void testarRegistrarConsumoAptoOcupado() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean ok = hotel.registrarConsumo(0, 0, 0, 3);
            if (!ok) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - Consumo em apartamento ocupado devia retornar true");
            }
            else if (hotel.getConsumosDoApartamento(0, 0).size() != 1) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - Devia existir exatamente 1 consumo");
            }
            else if (hotel.getConsumosDoApartamento(0, 0).get(0).getQuantidade() != 3) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - Quantidade incorreta");
            }
            else if (!hotel.getConsumosDoApartamento(0, 0).get(0).getServico().getNome().equals("Agua")) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - Servico incorreto");
            }
            else if (hotel.getEstadias().get(0).getTotalConsumos() != 30.0f) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - Total de consumos da estadia incorreto");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoAptoOcupado - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (livre e reservado)
    static void testarRegistrarConsumoAptoNaoOcupadoRetornaFalse() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            boolean livre = hotel.registrarConsumo(0, 0, 0, 1);
            hotel.reservarApartamento(0, 1, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            boolean reservado = hotel.registrarConsumo(0, 1, 0, 1);
            if (livre) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoNaoOcupadoRetornaFalse - Consumo em apartamento livre devia retornar false");
            }
            else if (reservado) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoNaoOcupadoRetornaFalse - Consumo em apartamento reservado devia retornar false");
            }
            else if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoNaoOcupadoRetornaFalse - Nenhum consumo devia existir no apto livre");
            }
            else if (!hotel.getConsumosDoApartamento(0, 1).isEmpty()) {
                System.out.println("FALHOU: testarRegistrarConsumoAptoNaoOcupadoRetornaFalse - Nenhum consumo devia existir no apto reservado");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoAptoNaoOcupadoRetornaFalse - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (apos check-out)
    static void testarRegistrarConsumoAposCheckoutRetornaFalse() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.realizarCheckout(0, 0);
            boolean ok = hotel.registrarConsumo(0, 0, 0, 1);
            if (ok) {
                System.out.println("FALHOU: testarRegistrarConsumoAposCheckoutRetornaFalse - Consumo apos o check-out devia retornar false");
            }
            else if (!hotel.getEstadias().get(0).getConsumos().isEmpty()) {
                System.out.println("FALHOU: testarRegistrarConsumoAposCheckoutRetornaFalse - A estadia encerrada nao devia receber consumos");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoAposCheckoutRetornaFalse - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (indice negativo)
    static void testarRegistrarConsumoIndiceNegativoFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.registrarConsumo(0, 0, -1, 1);
                System.out.println("FALHOU: testarRegistrarConsumoIndiceNegativoFalha - Indice negativo devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoIndiceNegativoFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoIndiceNegativoFalha - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (indice fora do cardapio)
    static void testarRegistrarConsumoIndiceForaDoCardapioFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.registrarConsumo(0, 0, 1, 1);
                System.out.println("FALHOU: testarRegistrarConsumoIndiceForaDoCardapioFalha - Indice inexistente devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoIndiceForaDoCardapioFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoIndiceForaDoCardapioFalha - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (quantidade zero)
    static void testarRegistrarConsumoQuantidadeZeroFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.registrarConsumo(0, 0, 0, 0);
                System.out.println("FALHOU: testarRegistrarConsumoQuantidadeZeroFalha - Quantidade zero devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoQuantidadeZeroFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoQuantidadeZeroFalha - excecao inesperada");
        }
    }

    // registrarConsumo - caso triste (quantidade negativa)
    static void testarRegistrarConsumoQuantidadeNegativaFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.registrarConsumo(0, 0, 0, -2);
                System.out.println("FALHOU: testarRegistrarConsumoQuantidadeNegativaFalha - Quantidade negativa devia lancar IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                    System.out.println("FALHOU: testarRegistrarConsumoQuantidadeNegativaFalha - Nenhum consumo devia ter sido registrado");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRegistrarConsumoQuantidadeNegativaFalha - excecao inesperada");
        }
    }

    // getConsumosDoApartamento - sem estadia ativa
    static void testarConsumosSemEstadiaVazio() {
        total++;
        try {
            Hotel hotel = new Hotel();
            if (hotel.getConsumosDoApartamento(0, 0) == null) {
                System.out.println("FALHOU: testarConsumosSemEstadiaVazio - Devia retornar lista vazia, nao null");
            }
            else if (!hotel.getConsumosDoApartamento(0, 0).isEmpty()) {
                System.out.println("FALHOU: testarConsumosSemEstadiaVazio - A lista devia estar vazia");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsumosSemEstadiaVazio - excecao inesperada");
        }
    }

    // getConsumosDoApartamento - consumo nao vaza para o proximo hospede
    static void testarConsumosNaoVazamEntreHospedes() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 0, 0, 2);
            hotel.realizarCheckout(0, 0);
            hotel.realizarCheckin(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            boolean vazioParaNovo = hotel.getConsumosDoApartamento(0, 0).isEmpty();
            hotel.registrarConsumo(0, 0, 0, 1);
            if (!vazioParaNovo) {
                System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - O novo hospede nao devia herdar consumos do anterior");
            }
            else if (hotel.getConsumosDoApartamento(0, 0).size() != 1) {
                System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - O novo hospede devia ter apenas o seu consumo");
            }
            else if (hotel.getEstadias().get(0).getConsumos().size() != 1) {
                System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - O historico da estadia anterior devia ser preservado");
            }
            else if (hotel.getEstadias().get(0).getConsumos().get(0).getQuantidade() != 2) {
                System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - Consumo da estadia anterior alterado");
            }
            else if (hotel.getEstadias().get(1).getConsumos().get(0).getQuantidade() != 1) {
                System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - Consumo da estadia atual incorreto");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsumosNaoVazamEntreHospedes - excecao inesperada");
        }
    }

    // getConsumosDoApartamento - apartamentos distintos
    static void testarConsumosIndependentesPorApartamento() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.realizarCheckin(0, 1, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            hotel.registrarConsumo(0, 0, 0, 2);
            if (hotel.getConsumosDoApartamento(0, 0).size() != 1) {
                System.out.println("FALHOU: testarConsumosIndependentesPorApartamento - O apto 0/0 devia ter 1 consumo");
            }
            else if (!hotel.getConsumosDoApartamento(0, 1).isEmpty()) {
                System.out.println("FALHOU: testarConsumosIndependentesPorApartamento - O apto 0/1 nao devia ter consumos");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsumosIndependentesPorApartamento - excecao inesperada");
        }
    }

    // getConsumosDoApartamento - caso triste (lista nao modificavel)
    static void testarConsumosNaoModificavelFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 0, 0, 1);
            try {
                hotel.getConsumosDoApartamento(0, 0).clear();
                System.out.println("FALHOU: testarConsumosNaoModificavelFalha - Alterar a lista devolvida devia lancar UnsupportedOperationException");
            } catch (UnsupportedOperationException e) {
                if (hotel.getConsumosDoApartamento(0, 0).size() != 1) {
                    System.out.println("FALHOU: testarConsumosNaoModificavelFalha - O consumo nao devia ter sido removido");
                }
                else {
                    passou++;
                }
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarConsumosNaoModificavelFalha - excecao inesperada");
        }
    }

    // emitirFatura - caso feliz (Simples, sem consumo)
    static void testarEmitirFaturaSimplesSemConsumo() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            Fatura fatura = hotel.emitirFatura(0, 0);
            if (fatura.getDias() != 1) {
                System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - Esperado 1 dia");
            }
            else if (fatura.getTotalDiarias() != 150.0f) {
                System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - Total de diarias incorreto");
            }
            else if (fatura.getTotalConsumos() != 0.0f) {
                System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - Total de consumos devia ser 0");
            }
            else if (fatura.getTotalGeral() != 150.0f) {
                System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - Total geral incorreto");
            }
            else if (!fatura.getConsumos().isEmpty()) {
                System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - A fatura nao devia ter consumos");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaSimplesSemConsumo - excecao inesperada");
        }
    }

    // emitirFatura - caso feliz (Premium, com consumo)
    static void testarEmitirFaturaPremiumComConsumo() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 13, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 13, 0, 3);
            Fatura fatura = hotel.emitirFatura(0, 13);
            if (fatura.getTotalDiarias() != 350.0f) {
                System.out.println("FALHOU: testarEmitirFaturaPremiumComConsumo - Total de diarias incorreto");
            }
            else if (fatura.getTotalConsumos() != 30.0f) {
                System.out.println("FALHOU: testarEmitirFaturaPremiumComConsumo - Total de consumos incorreto");
            }
            else if (fatura.getTotalGeral() != 380.0f) {
                System.out.println("FALHOU: testarEmitirFaturaPremiumComConsumo - Total geral incorreto");
            }
            else if (fatura.getConsumos().size() != 1) {
                System.out.println("FALHOU: testarEmitirFaturaPremiumComConsumo - A fatura devia ter 1 consumo");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaPremiumComConsumo - excecao inesperada");
        }
    }

    // emitirFatura - sem efeito colateral
    static void testarEmitirFaturaNaoAlteraEstado() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 0, 0, 1);
            Fatura primeira = hotel.emitirFatura(0, 0);
            Fatura segunda = hotel.emitirFatura(0, 0);
            if (!hotel.getApartamento(0, 0).estaOcupado()) {
                System.out.println("FALHOU: testarEmitirFaturaNaoAlteraEstado - O apartamento devia continuar OCUPADO");
            }
            else if (!hotel.getEstadias().get(0).estaAtiva()) {
                System.out.println("FALHOU: testarEmitirFaturaNaoAlteraEstado - A estadia devia continuar ativa");
            }
            else if (hotel.getConsumosDoApartamento(0, 0).size() != 1) {
                System.out.println("FALHOU: testarEmitirFaturaNaoAlteraEstado - Os consumos nao deviam mudar");
            }
            else if (primeira.getTotalGeral() != segunda.getTotalGeral()) {
                System.out.println("FALHOU: testarEmitirFaturaNaoAlteraEstado - Emitir duas vezes devia dar o mesmo total");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaNaoAlteraEstado - excecao inesperada");
        }
    }

    // emitirFatura - fatura antiga nao muda com novos consumos
    static void testarEmitirFaturaEhRetratoFixo() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 0, 0, 1);
            Fatura antes = hotel.emitirFatura(0, 0);
            hotel.registrarConsumo(0, 0, 0, 5);
            Fatura depois = hotel.emitirFatura(0, 0);
            if (antes.getConsumos().size() != 1) {
                System.out.println("FALHOU: testarEmitirFaturaEhRetratoFixo - A fatura antiga devia manter 1 consumo");
            }
            else if (antes.getTotalConsumos() != 10.0f) {
                System.out.println("FALHOU: testarEmitirFaturaEhRetratoFixo - O total da fatura antiga devia ser 10");
            }
            else if (depois.getConsumos().size() != 2) {
                System.out.println("FALHOU: testarEmitirFaturaEhRetratoFixo - A fatura nova devia ter 2 consumos");
            }
            else if (depois.getTotalConsumos() != 60.0f) {
                System.out.println("FALHOU: testarEmitirFaturaEhRetratoFixo - O total da fatura nova devia ser 60");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaEhRetratoFixo - excecao inesperada");
        }
    }

    // emitirFatura - nao inclui consumo de hospede anterior
    static void testarEmitirFaturaIgnoraEstadiaAnterior() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.cadastrarServico("Agua", 10.0f);
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.registrarConsumo(0, 0, 0, 4);
            hotel.realizarCheckout(0, 0);
            hotel.realizarCheckin(0, 0, new Hospede("456", "Maria", "Rua Y", "8888", "maria@x"));
            Fatura fatura = hotel.emitirFatura(0, 0);
            if (!fatura.getConsumos().isEmpty()) {
                System.out.println("FALHOU: testarEmitirFaturaIgnoraEstadiaAnterior - A fatura nao devia ter consumos do hospede anterior");
            }
            else if (fatura.getTotalConsumos() != 0.0f) {
                System.out.println("FALHOU: testarEmitirFaturaIgnoraEstadiaAnterior - Total de consumos devia ser 0");
            }
            else {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaIgnoraEstadiaAnterior - excecao inesperada");
        }
    }

    // emitirFatura - caso triste (apartamento livre)
    static void testarEmitirFaturaAptoLivreFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            try {
                hotel.emitirFatura(0, 0);
                System.out.println("FALHOU: testarEmitirFaturaAptoLivreFalha - Fatura de apartamento livre devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaAptoLivreFalha - excecao inesperada");
        }
    }

    // emitirFatura - caso triste (apartamento reservado)
    static void testarEmitirFaturaAptoReservadoFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.reservarApartamento(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            try {
                hotel.emitirFatura(0, 0);
                System.out.println("FALHOU: testarEmitirFaturaAptoReservadoFalha - Fatura de apartamento reservado devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaAptoReservadoFalha - excecao inesperada");
        }
    }

    // emitirFatura - caso triste (apos check-out)
    static void testarEmitirFaturaAposCheckoutFalha() {
        total++;
        try {
            Hotel hotel = new Hotel();
            hotel.realizarCheckin(0, 0, new Hospede("123", "Joao", "Rua X", "9999", "joao@x"));
            hotel.realizarCheckout(0, 0);
            try {
                hotel.emitirFatura(0, 0);
                System.out.println("FALHOU: testarEmitirFaturaAposCheckoutFalha - Fatura sem estadia ativa devia lancar IllegalStateException");
            } catch (IllegalStateException e) {
                passou++;
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarEmitirFaturaAposCheckoutFalha - excecao inesperada");
        }
    }

    //Helper
    /** Verifica: existe reserva ativa em (andar, numero) se e somente se o apartamento esta RESERVADO. */
    static boolean invarianteReservas(Hotel hotel) {
        for (int a = 0; a < Hotel.NUM_ANDARES; a++) {
            for (int n = 0; n < Hotel.APTOS_POR_ANDAR; n++) {
                int ativas = 0;
                for (Reserva r : hotel.getReservas()) {
                    if (r.estaAtiva() && r.getAndar() == a && r.getNumero() == n) {
                        ativas++;
                    }
                }
                boolean reservado = hotel.getApartamento(a, n).estaReservado();
                if (reservado && ativas != 1) {
                    return false;
                }
                if (!reservado && ativas != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}