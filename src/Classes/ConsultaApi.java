package Classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por realizar a comunicação com a API externa do ViaCEP.
 */
public class ConsultaApi {

    /**
     * Busca um endereço completo a partir de um CEP fornecido.
     *
     * @param cep O CEP a ser consultado (espera-se uma string de 8 dígitos).
     * @return Um objeto Endereco preenchido com os dados retornados pela API.
     * @throws RuntimeException Se o CEP não for encontrado, for inválido, ou se ocorrer um erro de comunicação.
     */
    public Endereco buscaEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Verifica se a resposta da API contém um erro
            if (json.contains("\"erro\": true")) {
                throw new RuntimeException("CEP não encontrado ou inválido.");
            }

            return new Gson().fromJson(json, Endereco.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}
