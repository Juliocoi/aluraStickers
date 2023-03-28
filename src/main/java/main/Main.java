package main;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
    // filtragem dos dados.
    JsonParser jsonParser = new JsonParser();

    List<Map<String, String>> movieList = jsonParser.parse(body);

    FigureFactory factory = new FigureFactory();

    for (Map<String, String> movie : movieList) {
      String urlImage = movie.get("image");
      String movieTitle = movie.get("title");
      String archiveName = movieTitle + ".png";

      InputStream inputStream = new URL(urlImage).openStream();

      factory.prodution(inputStream,archiveName);
      System.out.printf("\u001b[1m Rank:\u001b[m " + movie.get("rank") + "\n");
      System.out.printf("\u001b[1m Título:\u001b[m" + movieTitle + "\n");
      System.out.printf("\u001b[1m imDbRating:\u001b[m " + movie.get("imDbRating") + "\n");
      System.out.println();
    }
  }
}