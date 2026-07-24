package controller.commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import model.DB.ImageDatabase;
import model.Image;
import model.ImageLoader;
import model.PPMIMageLoader;

public class LoadCommand implements Command {
  //koala.ppm koala
  @Override
  public void run(Scanner scanner, ImageDatabase imageDatabase) {
    if ( scanner == null || imageDatabase == null ) {
      throw new IllegalArgumentException("Scanner or image database is null");
    }
    if (scanner.hasNext()) { //koala.ppm koala
      String fileName = scanner.next();
      try {
        Readable fileReader = new FileReader(fileName);
        ImageLoader imageLoader = new PPMIMageLoader(fileReader);
        Image image = imageLoader.loadImage();
        if (scanner.hasNext()) {
          String imageId = scanner.next();
          imageDatabase.addImage(image, imageId);
        } else {
          throw new IllegalStateException("Run out of input.");
        }

      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("File not found");
      }
    }
  }
}
