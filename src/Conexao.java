import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexao {

    private static final HttpClient client = HttpClient.newHttpClient();

    public double getTaxaDeConversao(String url) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            //Verifica status HTTP
            if (response.statusCode() != 200) {
                throw new RuntimeException(
                        "Erro HTTP: " + response.statusCode()
                );
            }

            //Converte para JSON
            JsonObject json = JsonParser
                    .parseString(response.body())
                    .getAsJsonObject();

            //Verifica se a API retornou sucesso
            if (!json.has("conversion_rate")) {
                throw new RuntimeException(
                        "Resposta inválida da API: " + json
                );
            }

            //Retorna a taxa corretamente
            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Erro ao obter taxa de conversão:");
            System.out.println(e.getMessage());
            return -1; // valor inválido explícito
        }
    }
}
