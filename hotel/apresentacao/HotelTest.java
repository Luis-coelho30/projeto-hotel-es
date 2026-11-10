package hotel.apresentacao;

import hotel.modelo.*;
import hotel.negocio.Hotel;
import java.util.ArrayList;

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

        testarReservarAptoLivre();
        testarReservarAptoNaoLivreFalha();
        testarReservarHospedeNuloFalha();

        testarCheckinAptoLivre();
        testarCheckinAptoReservado();
        testarCheckinAptoOcupado();
        testarCheckinHospedeNuloFalha();

        testarCheckoutAptoOcupado();
        testarCheckoutAptoLivreFalha();
        testarCheckoutAptoReservadoFalha();

        testarCancelarReservaAptoReservado();
        testarCancelarReservaAptoLivreFalha();
        testarCancelarReservaAptoOcupadoFalha();

        testarReservarApartamentoValido();
        testarReservarApartamentoNaoLivreFalha();
        testarRealizarCheckinAptoLivre();
        testarRealizarCheckinAptoReservado();
        testarRealizarCheckinAptoOcupadoFalha();
        testarRealizarCheckinHospedeNuloFalha();
        testarRealizarCheckoutAptoOcupado();
        testarRealizarCheckoutAptoLivreFalha();
        testarRealizarCheckoutAptoReservadoFalha();

        testarPrecoDiariaFeliz();
        testarAptoHotelFeliz();
        testarAptoHotelTristeTipoIncorreto();

        testarAptoInvalidoTristeNumero();
        testarAptoInvalidoTristeAndar();
        testarAptoValidoFeliz();

        testarHotelCancelarReservaFeliz();
        testarHotelCancelarReservaTristeLivre();
        testarHotelCancelarReservaTristeOcupado();

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

    // reserva - caso feliz
    static void testarReservarAptoLivre() {
        total++;
        Apartamento apto = new Apartamento();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.reservar(h);

        if (apto.estaReservado() && apto.getHospede() == h) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarReservarAptoLivre");
        }
    }

    // reserva - caso triste
    static void testarReservarAptoNaoLivreFalha() {
        total++;
        Apartamento apto = new Apartamento();
        Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        Hospede h2 = new Hospede("456", "Fuba", "Rua Y", "1111", "fuba@x");
        apto.reservar(h1);

        try {
            apto.reservar(h2);
            System.out.println("FALHOU: testarReservarAptoNaoLivreFalha");
        } catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarReservarAptoNaoLivreFalha - exceção inesperada");
        }
    }

    // reserva - caso triste
    static void testarReservarHospedeNuloFalha() {
        total++;
        Apartamento apto = new Apartamento();

        try {
            apto.reservar(null);
            System.out.println("FALHOU: testarReservarHospedeNuloFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarReservarHospedeNuloFalha - exceção inesperada");
        }
    }

    // checkin - caso feliz
    static void testarCheckinAptoLivre() {
        total++;
        Apartamento apto = new Apartamento();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.checkin(h);
        if (apto.estaOcupado() && apto.getHospede() == h) {
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
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.reservar(h);
        apto.checkin(h);
        if (apto.estaOcupado() && apto.getHospede() == h) {
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
        Hospede h1 = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        Hospede h2 = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");
        apto.checkin(h1);
        try {
            apto.checkin(h2);
            System.out.println("FALHOU: testarCheckinAptoOcupado");
        }
        catch (IllegalStateException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckinAptoOcupado - exceção inesperada");
        }
    }

    // checkin - caso triste
    static void testarCheckinHospedeNuloFalha() {
        total++;
        Apartamento apto = new Apartamento();
        try {
            apto.checkin(null);
            System.out.println("FALHOU: testarCheckinHospedeNuloFalha");
        }
        catch (IllegalArgumentException e) {
            passou++;
        }
        catch (Exception e) {
            System.out.println("FALHOU: testarCheckinHospedeNuloFalha - exceção inesperada");
        }
    }

    // checkout - caso feliz
    static void testarCheckoutAptoOcupado() {
        total++;
        Apartamento apto = new Apartamento();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.checkin(h);
        apto.checkout();;
        if (apto.estaLivre() && apto.getHospede() == null) {
            passou++;
        }
        else {
            System.out.println("FALHOU: testarCheckoutAptoOcupado");
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
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.reservar(h);
        try {
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
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.reservar(h);
        apto.cancelarReserva();
        if (apto.estaLivre() && apto.getHospede() == null) {
            passou++;
        } else {
            System.out.println("FALHOU: testarCancelarReservaAptoReservado");
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
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        apto.checkin(h);
        try {
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

            if (resultado
                    && hotel.getApartamento(0, 0).estaReservado()
                    && hotel.getApartamento(0, 0).getHospede() == hospede) {
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

            if (primeiraReserva
                    && !segundaReserva
                    && hotel.getApartamento(0, 0).getHospede() == primeiroHospede) {
                passou++;
            } else {
                System.out.println("FALHOU: testarReservarApartamentoNaoLivreFalha");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarReservarApartamentoNaoLivreFalha - excecao inesperada");
        }
    }

    // Check-in - caso feliz em apartamento livre
    static void testarRealizarCheckinAptoLivre() {
        total++;
        Hotel hotel = new Hotel();
        Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        try {
            boolean resultado = hotel.realizarCheckin(0, 0, hospede);

            if (resultado
                    && hotel.getApartamento(0, 0).estaOcupado()
                    && hotel.getApartamento(0, 0).getHospede() == hospede) {
                passou++;
            } else {
                System.out.println("FALHOU: testarRealizarCheckinAptoLivre");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckinAptoLivre - excecao inesperada");
        }
    }

    // Check-in - caso feliz em apartamento reservado
    static void testarRealizarCheckinAptoReservado() {
        total++;
        Hotel hotel = new Hotel();
        Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        try {
            hotel.reservarApartamento(0, 0, hospede);
            boolean resultado = hotel.realizarCheckin(0, 0, hospede);

            if (resultado
                    && hotel.getApartamento(0, 0).estaOcupado()
                    && hotel.getApartamento(0, 0).getHospede() == hospede) {
                passou++;
            } else {
                System.out.println("FALHOU: testarRealizarCheckinAptoReservado");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckinAptoReservado - excecao inesperada");
        }
    }

    // Check-in - caso triste em apartamento ocupado
    static void testarRealizarCheckinAptoOcupadoFalha() {
        total++;
        Hotel hotel = new Hotel();
        Hospede primeiroHospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");
        Hospede segundoHospede = new Hospede("456", "Maria", "Rua Y", "8888", "maria@x");

        try {
            hotel.realizarCheckin(0, 0, primeiroHospede);
            hotel.realizarCheckin(0, 0, segundoHospede);
            System.out.println("FALHOU: testarRealizarCheckinAptoOcupadoFalha");
        } catch (IllegalStateException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckinAptoOcupadoFalha - excecao inesperada");
        }
    }

    // Check-in - caso triste com hóspede nulo
    static void testarRealizarCheckinHospedeNuloFalha() {
        total++;
        Hotel hotel = new Hotel();

        try {
            hotel.realizarCheckin(0, 0, null);
            System.out.println("FALHOU: testarRealizarCheckinHospedeNuloFalha");
        } catch (IllegalArgumentException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckinHospedeNuloFalha - excecao inesperada");
        }
    }

    // Checkout - caso feliz em apartamento ocupado
    static void testarRealizarCheckoutAptoOcupado() {
        total++;
        Hotel hotel = new Hotel();
        Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        try {
            hotel.realizarCheckin(0, 0, hospede);
            boolean resultado = hotel.realizarCheckout(0, 0);

            if (resultado
                    && hotel.getApartamento(0, 0).estaLivre()
                    && hotel.getApartamento(0, 0).getHospede() == null) {
                passou++;
            } else {
                System.out.println("FALHOU: testarRealizarCheckoutAptoOcupado");
            }
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckoutAptoOcupado - excecao inesperada");
        }
    }

    // Checkout - caso triste em apartamento livre
    static void testarRealizarCheckoutAptoLivreFalha() {
        total++;
        Hotel hotel = new Hotel();

        try {
            hotel.realizarCheckout(0, 0);
            System.out.println("FALHOU: testarRealizarCheckoutAptoLivreFalha");
        } catch (IllegalStateException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckoutAptoLivreFalha - excecao inesperada");
        }
    }

    // Checkout - caso triste em apartamento reservado
    static void testarRealizarCheckoutAptoReservadoFalha() {
        total++;
        Hotel hotel = new Hotel();
        Hospede hospede = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        try {
            hotel.reservarApartamento(0, 0, hospede);
            hotel.realizarCheckout(0, 0);
            System.out.println("FALHOU: testarRealizarCheckoutAptoReservadoFalha");
        } catch (IllegalStateException e) {
            passou++;
        } catch (Exception e) {
            System.out.println("FALHOU: testarRealizarCheckoutAptoReservadoFalha - excecao inesperada");
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

    // cancelar reserva hotel - caso feliz
    static void testarHotelCancelarReservaFeliz(){
        total++;
        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");

        hotel.reservarApartamento(0, 0, h);
        boolean estavaReservadoAntes = hotel.getApartamento(0, 0).estaReservado();

        boolean ok = hotel.cancelarReserva(0, 0);

        if(estavaReservadoAntes && ok && hotel.getApartamento(0, 0).estaLivre()){
            passou++;
        } else {
            System.out.println("FALHOU: testarHotelCancelarReservaFeliz");
        }
    }

    // cancelar reserva hotel - caso triste (quarto livre)
    static void testarHotelCancelarReservaTristeLivre(){
        total++;
        Hotel hotel = new Hotel();
        boolean estavaLivreAntes = hotel.getApartamento(0, 0).estaLivre();

        boolean ok = hotel.cancelarReserva(0, 0);

        if(!ok && hotel.getApartamento(0, 0).estaLivre() && estavaLivreAntes){
            passou++;
        } else {
            System.out.println("FALHOU: testarHotelCancelarReservaTristeLivre");
        }
    }

    // cancelar reserva hotel - caso triste (quarto ocupado)
    static void testarHotelCancelarReservaTristeOcupado(){
        total++;

        Hotel hotel = new Hotel();
        Hospede h = new Hospede("123", "Joao", "Rua X", "9999", "joao@x");        
        hotel.realizarCheckin(0, 0, h);
        boolean estavaOcupadoAntes = hotel.getApartamento(0, 0).estaOcupado();

        boolean ok = hotel.cancelarReserva(0, 0);

        if(!ok && hotel.getApartamento(0, 0).estaOcupado() && estavaOcupadoAntes){
            passou++;
        } else {
            System.out.println("FALHOU: testarHotelCancelarReservaTristeOcupado");
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
}