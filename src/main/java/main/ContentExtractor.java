package main;

import java.util.List;

public interface ContentExtractor {
  public List<Content> contentsExtraction(String json);

}
