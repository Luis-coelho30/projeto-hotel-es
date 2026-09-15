package hotel.modelo;

public class Hospede {
    private String cpf;
    private String nome;
    private String endereco;
    private String celular;
    private String email;

    public Hospede(String cpf, String nome, String endereco, String celular, String email) {
        if(cpf == null) {
            throw new IllegalArgumentException("CPF nao pode ser nulo");
        }
        if(nome == null) {
            throw new IllegalArgumentException("Nome nao pode ser nulo");
        } 
        if(endereco == null) {
            throw new IllegalArgumentException("Endereco nao pode ser nulo");
        } 
        if(celular == null) {
            throw new IllegalArgumentException("Celular nao pode ser nulo");
        } 
        if(email == null) {
            throw new IllegalArgumentException("Email nao pode ser nulo");
        } 
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
        this.email = email;
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getCelular() { return celular; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
