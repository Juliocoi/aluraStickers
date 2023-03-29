package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {
  public String searchData(String url){
    try {
      URI uriCreate = URI.create(url);
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder(uriCreate).GET().build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      return response.body();

    } catch (IOException | InterruptedException ex){
      throw new RuntimeException(ex);
    }

  }
}
