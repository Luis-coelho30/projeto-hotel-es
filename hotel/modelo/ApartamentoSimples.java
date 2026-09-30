package hotel.modelo;

public class ApartamentoSimples extends Apartamento {
    private static final float PRECO_DIARIA = 150.0f;

    /**
     * Inicializa a unidade chamando o construtor da classe base
     * 
     * @pre (nenhuma)
     * @post instância de ApartamentoSimples é criada com o status inicial LIVRE
     */
    public ApartamentoSimples() {
        super();
    }

    /**
     * Retorna o preço fixo da diária para este tipo de apartamento
     * 
     * @return O valor correspondente à diária Simples (150.0f)
     * @pre o objeto ApartamentoSimples deve estar instanciado
     * @post retorna o valor da diária
     */
    @Override
    public float getPrecoDiaria() {
        return PRECO_DIARIA;
    }
}
