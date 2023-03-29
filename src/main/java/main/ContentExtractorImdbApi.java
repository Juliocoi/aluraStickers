package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorImdbApi implements ContentExtractor{
  public List<Content> contentsExtraction(String json){
    // filtragem dos dados.
    JsonParser jsonParser = new JsonParser();
    List<Map<String, String>> attributesList = jsonParser.parse(json);

    List<Content>contentsList = new ArrayList<>();
    // popular lista de conteúdos
    for (Map<String, String> attribute : attributesList) {
      String itemTitle = attribute.get("title");
      String urlImage = attribute.get("image")
          .replaceAll("(@+)(.*).jpg$", "$1.jpg");
      Content content = new Content(itemTitle, urlImage);

      contentsList.add(content);
    }

    return contentsList;
  }
}
