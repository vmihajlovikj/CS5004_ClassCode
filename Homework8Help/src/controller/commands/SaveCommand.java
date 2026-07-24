package controller.commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.DB.ImageDatabase;
import model.Image;
import model.ImageWriter;
import model.PPMWriter;
import model.operations.ImageOperation;
import model.operations.RedComponent;

public class SaveCommand implements Command {

  private String getNextString(Scanner scanner) {
    if ( scanner.hasNext() ) {
      return scanner.next();
    }else{
      throw new IllegalStateException("Run out of input.");
    }
  }

  //koala ./koala-red.ppm
  @Override
  public void run(Scanner scanner, ImageDatabase imageDatabase) {
    String imageName = getNextString(scanner);
    if ( !imageDatabase.containsImage(imageName) ) {
      throw  new IllegalArgumentException("Image not found");
    }
    Image image = imageDatabase.getImage(imageName);
    String imagePath = getNextString(scanner);

    try{
      Appendable fileWriter = new FileWriter(imagePath);
      ImageWriter imageWriter = new PPMWriter(fileWriter);
      imageWriter.writeImage(image);
    }catch(IOException e){
      throw new IllegalStateException("Cannot write to file");
    }


  }
}
