package hotel.modelo;

public class Titular {
    private String cpf;
    private String nome;
    private String endereco;
    private String celular;
    private String email;

    /**
     * Cria uma nova instância de Titular com os dados informados
     * 
     * @param cpf CPF do Titular
     * @param nome Nome do Titular
     * @param endereco Endereço do Titular
     * @param celular Número de celular do Titular
     * @param email Endereço de email do Titular
     * @throws IllegalArgumentException se algum dos campos for null
     */
    public Titular(String cpf, String nome, String endereco, String celular, String email) {
        this.cpf = validarCampo(cpf, "CPF");
        this.nome = validarCampo(nome, "Nome");
        this.endereco = validarCampo(endereco, "Endereco");
        this.celular = validarCampo(celular, "Celular");
        this.email = validarCampo(email, "Email");
    }

    /**
     * Retorna o CPF do Titular
     * 
     * @return O CPF do Titular
     */
    public String getCpf() { return cpf; }
    
    /**
     * Retorna o nome do Titular
     * 
     * @return O Nome do Titular
     */
    public String getNome() { return nome; }
    
    /**
     * Retorna o endereço do Titular
     * 
     * @return O Endereço do Titular
     */
    public String getEndereco() { return endereco; }
    
    /**
     * Retorna o celular do Titular
     * 
     * @return O Celular do Titular
     */
    public String getCelular() { return celular; }
    
    /**
     * Retorna o email do Titular
     * 
     * @return O Email do Titular
     */
    public String getEmail() { return email; }

    /**    
     * Retorna uma representação em texto do Titular, contendo seu nome e CPF
     * 
     * @return Nome e CPF do Titular
     */
    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }

    /**
     * Verifica se um objeto é igual a esta instância com base no CPF.
     * 
     * @param obj Objeto a ser comparado
     * @return true se o objeto for um Titular com o mesmo CPF;
     *         false caso o contrário
     */
    @Override 
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Titular titular) {
            if(this.cpf.equals(titular.cpf)){
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