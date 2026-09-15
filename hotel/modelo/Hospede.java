package hotel.modelo;

public class Hospede {
    private String cpf;
    private String nome;
    private String endereco;
    private String celular;
    private String email;

    public Hospede(String cpf, String nome, String endereco, String celular, String email) {
        this.cpf = validarCampo(cpf, "CPF");
        this.nome = validarCampo(nome, "Nome");
        this.endereco = validarCampo(endereco, "Endereco");
        this.celular = validarCampo(celular, "Celular");
        this.email = validarCampo(email, "Email");
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

    /**
     * Verifica se um objeto é igual a esta instância com base no CPF.
     * 
     * @param obj Objeto a ser comparado
     * @return true se o objeto for um Hospede com o mesmo CPF;
     *         false caso o contrário
     */
    @Override 
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Hospede hospede) {
            if(this.cpf.equals(hospede.cpf)){
                return true;
            }
        }

        return false;
    }

    /**
     * Valida um campo de texto, verificando se ele não é nulo e retornando seu valor
     * 
     * @param valor Valor do campo a ser validado
     * @param campo Nome do campo, utilizado na mensagem de erro
     * @return O valor validado
     * @throws IllegalArgumentException se o valor for nulo
     */
    private String validarCampo(String valor, String campo) {
        if (valor == null)
            throw new IllegalArgumentException(campo + " nao pode ser nulo");
        
        return valor;
    }
}