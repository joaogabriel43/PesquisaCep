package Classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar a persistência dos dados de endereço em um arquivo JSON.
 * Encapsula toda a lógica de leitura e escrita do arquivo 'enderecos.json'.
 */
public class GeradorArquivo {

    private final Gson gson;
    private final String nomeArquivo = "enderecos.json";

    public GeradorArquivo() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Carrega a lista de endereços do arquivo 'enderecos.json'.
     * Se o arquivo não existir ou estiver vazio, retorna uma lista vazia.
     *
     * @return Uma lista de objetos Endereco.
     * @throws IOException Se ocorrer um erro durante a leitura do arquivo.
     */
    public List<Endereco> carregarEnderecos() throws IOException {
        try (FileReader reader = new FileReader(nomeArquivo)) {
            Type listType = new TypeToken<ArrayList<Endereco>>(){}.getType();
            List<Endereco> enderecos = gson.fromJson(reader, listType);
            return enderecos != null ? enderecos : new ArrayList<>();
        } catch (IOException e) {
            // Se o arquivo não existir, o catch (IOException) tratará e retornará uma lista vazia.
            return new ArrayList<>();
        }
    }

    /**
     * Salva (sobrescreve) a lista de endereços fornecida no arquivo 'enderecos.json'.
     *
     * @param enderecos A lista de endereços a ser salva.
     * @throws IOException Se ocorrer um erro durante a escrita do arquivo.
     */
    public void salvarEnderecos(List<Endereco> enderecos) throws IOException {
        try (FileWriter escrita = new FileWriter(nomeArquivo)) {
            escrita.write(gson.toJson(enderecos));
        }
    }
}
