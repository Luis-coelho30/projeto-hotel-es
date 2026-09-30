package hotel.modelo;

public class ApartamentoPremium extends Apartamento {
    private static final float PRECO_DIARIA = 350.0f;

    /**
     * Inicializa a unidade chamando o construtor da classe base
     * 
     * @pre (nenhuma)
     * @post Uma instância de ApartamentoPremium é criada com o status LIVRE
     */
    public ApartamentoPremium() {
        super();
    }

    /**
     * Retorna o preço fixo da diária para este tipo de apartamento (Premium)
     * 
     * @return O valor correspondente à diária Premium (350.0f)
     * @pre o objeto ApartamentoPremium deve estar instanciado
     * @post retorna o valor da diária
     */
    @Override
    public float getPrecoDiaria() {
        return PRECO_DIARIA;
    }
}