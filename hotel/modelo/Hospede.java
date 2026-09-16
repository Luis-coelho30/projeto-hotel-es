package hotel.modelo;

public class Hospede {
    private String cpf;
    private String nome;
    private String endereco;
    private String celular;
    private String email;

    /**
     * Cria uma nova instância de Hospede com os dados informados
     * 
     * @param cpf CPF do Hospede
     * @param nome Nome do Hospede
     * @param endereco Endereço do Hospede
     * @param celular Número de celular do Hospede
     * @param email Endereço de email do Hospede
     * @throws IllegalArgumentException se algum dos campos for null
     */
    public Hospede(String cpf, String nome, String endereco, String celular, String email) {
        this.cpf = validarCampo(cpf, "CPF");
        this.nome = validarCampo(nome, "Nome");
        this.endereco = validarCampo(endereco, "Endereco");
        this.celular = validarCampo(celular, "Celular");
        this.email = validarCampo(email, "Email");
    }

    /**
     * Retorna o CPF do Hospede
     * 
     * @return O CPF do Hospede
     */
    public String getCpf() { return cpf; }
    
    /**
     * Retorna o nome do Hospede
     * 
     * @return O Nome do Hospede
     */
    public String getNome() { return nome; }
    
    /**
     * Retorna o endereço do Hospede
     * 
     * @return O Endereço do Hospede 
     */
    public String getEndereco() { return endereco; }
    
    /**
     * Retorna o celular do Hospede
     * 
     * @return O Celular do Hospede
     */
    public String getCelular() { return celular; }
    
    /**
     * Retorna o email do Hospede
     * 
     * @return O Email do Hospede
     */
    public String getEmail() { return email; }

    /**    
     * Retorna uma representação em texto do Hospede, contendo seu nome e CPF
     * 
     * @return Nome e CPF do Hospede
     */
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
     * Retorna o código hash desta instância com base no CPF
     * 
     * @return Código hash baseado no CPF
     */
    @Override
    public int hashCode() {
        return this.cpf.hashCode();
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