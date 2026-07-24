package model.DB;

import java.util.List;
import model.Image;

public interface ImageDatabase {
  void addImage(Image image, String id);
  void removeImage(String id) throws IllegalArgumentException;
  boolean containsImage(String id);
  List<String> imageIDs();
  Image getImage(String id) throws IllegalArgumentException;
}
