package hotel.apresentacao;

import hotel.modelo.*;
import hotel.negocio.Hotel;

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

}
