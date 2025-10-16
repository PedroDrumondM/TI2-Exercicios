import java.net.http.*;
import java.net.URI;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SentimentAnalysis {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase para análise de sentimento: ");
        String frase = sc.nextLine();
        sc.close();

        String endpoint = "https://pedroia.cognitiveservices.azure.com/";
        String key = "CxRPZ8I4xNsTwpR1Z9gx9wfYbyUDzXzSDo3EQNYuSZdfGQp57PLRJQQJ99BJACZoyfiXJ3w3AAAaACOGKC1d";
        String url = endpoint + "text/analytics/v3.0/sentiment";

        String jsonBody = """
        {
          "documents": [
            {"id": "1", "language": "pt", "text": "%s"}
          ]
        }
        """.formatted(frase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", key)
                .POST(BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\nResposta da API:");
        System.out.println(response.body());
    }
}