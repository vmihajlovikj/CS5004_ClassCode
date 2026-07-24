package model.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Image;

public class ImageDatabaseImpl implements ImageDatabase {
  private final Map<String, Image> images;

  public ImageDatabaseImpl() {
    this.images = new HashMap<String, Image>();
  }

  //It overwrites the value if the key exists.
  @Override
  public void addImage(Image image, String id) {
    if ( image == null || id == null || id.isEmpty() ) {
      throw new IllegalArgumentException("Image or id is null or empty");
    }
    //What do I do if the id is already in the map.
    this.images.put(id, image);
  }

  @Override
  public void removeImage(String id) {
    if ( id == null || id.isEmpty() ) {
      throw new IllegalArgumentException("Image id is null or empty");
    }

    if ( !this.images.containsKey(id) ) {
      throw new IllegalArgumentException("Image not found");
    }

    this.images.remove(id);

  }

  @Override
  public boolean containsImage(String id) {
    if ( id == null || id.isEmpty() ) {
      throw new IllegalArgumentException("Image id is null or empty");
    }
    return this.images.containsKey(id);
  }

  @Override
  public List<String> imageIDs() {
    return new ArrayList<String>(this.images.keySet());
  }

  @Override
  public Image getImage(String id) throws IllegalArgumentException {
    if ( id == null || id.isEmpty() ) {
      throw new IllegalArgumentException("Image id is null or empty");
    }
    if ( !this.images.containsKey(id) ) {
      throw new IllegalArgumentException("Image not found");
    }
    return this.images.get(id);
  }
}
