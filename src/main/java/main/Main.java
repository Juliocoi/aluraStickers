package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws Exception {
    String urlApi = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    URI uriCreate = URI.create(urlApi);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(uriCreate).GET().build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String body = response.body();
    // extração dos dados que queremos
    JsonParser jsonParser = new JsonParser();

    List<Map<String, String>> movieList = jsonParser.parse(body);

    for (Map<String, String> movie : movieList) {
//
      System.out.printf("\u001b[1m Rank:\u001b[m " + movie.get("rank") + "\n");
      System.out.printf("\u001b[1m Título:\u001b[m" + movie.get("title") + "\n");
      System.out.printf("\u001b[1m imDbRating:\u001b[m " + movie.get("imDbRating") + "\n");
      System.out.println();
    }

  }
}