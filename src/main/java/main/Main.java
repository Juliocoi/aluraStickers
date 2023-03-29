package main;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
  public static void main(String[] args) throws Exception {
//    String urlApi = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
//    ContentExtractor contentExtractor = new ContentExtractorImdbApi();

    String urlApi= "https://api.nasa.gov/planetary/apod?api_key=WZpKstdhoiJmbMvDK6ftjvY3b9UYSQd5F2fyZqqp&start_date=2022-06-12&end_date=2022-06-14";
    ContentExtractor contentExtractor = new ContentExtractorNasaApi();

    ClientHttp http = new ClientHttp();
    String json = http.searchData(urlApi);

// extração e manipulação dos dados
    List<Content> contentsList = contentExtractor.contentsExtraction(json);
    FigureFactory factory = new FigureFactory();

    for (int i = 0; i < 3; i++) {

      Content content = contentsList.get(i);

      InputStream inputStream = new URL(content.getUrlImage()).openStream();
      String archiveName = content.getTitle() + ".png";

      factory.prodution(inputStream,archiveName);
//      System.out.printf("\u001b[1m Rank:\u001b[m " + content.get("rank") + "\n");
//      System.out.printf("\u001b[1m Título:\u001b[m" + content.getTitle() + "\n");
//      System.out.printf("\u001b[1m imDbRating:\u001b[m " + content.get("imDbRating") + "\n");
      System.out.println();
    }
  }
}