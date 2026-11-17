package hotel.repositorio;

import hotel.negocio.Hotel;
import java.io.*;

public class HotelRepo {
    private static final String ARQUIVO = "hotel.dat";

    /**
     * salva o estado completo do hotel no arquivo de dados
     *
     * @param hotel hotel a ser salvo
     * @throws IOException se não for possível gravar o arquivo
     *
     * @pre hotel não nulo
     * @post o arquivo hotel.dat contém o estado do hotel
     */
    public static void salvar(Hotel hotel) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            out.writeObject(hotel);
        }
    }

    /**
     * carrega o estado do hotel a partir do arquivo de dados
     *
     * @return o hotel salvo
     * @throws IOException se o arquivo não existir ou não puder ser lido
     * @throws ClassNotFoundException se o arquivo contiver uma classe desconhecida
     *
     * @pre arquivo hotel.dat existente, gerado por salvar
     * @post nenhuma alteração no arquivo
     */
    public static Hotel carregar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (Hotel) in.readObject();
        }
    }

    /**
     * salva o estado completo do hotel em um arquivo escolhido pelo chamador
     *
     * @param hotel hotel a ser salvo
     * @param arquivo caminho do arquivo de dados
     * @throws IOException se não for possível gravar o arquivo
     *
     * @pre hotel não nulo
     * @post o arquivo informado contém o estado do hotel; hotel.dat não é alterado
     */
    public static void salvar(Hotel hotel, String arquivo) throws IOException {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * carrega o estado do hotel a partir de um arquivo escolhido pelo chamador
     *
     * @param arquivo caminho do arquivo de dados
     * @return o hotel salvo
     * @throws IOException se o arquivo não existir ou não puder ser lido
     * @throws ClassNotFoundException se o arquivo contiver uma classe desconhecida
     *
     * @pre arquivo existente, gerado por salvar
     * @post nenhuma alteração no arquivo
     */
    public static Hotel carregar(String arquivo) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("não implementado");
    }
}
