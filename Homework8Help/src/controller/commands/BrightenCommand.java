package controller.commands;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.DB.ImageDatabase;
import model.Image;
import model.operations.ImageOperation;
import model.operations.RedComponent;

public class BrightenCommand implements Command {

  //Put this into an abstract class.
  private String getNextString(Scanner scanner) {
    if ( scanner.hasNext() ) {
      return scanner.next();
    }else{
      throw new IllegalStateException("Run out of input.");
    }
  }

  @Override
  public void run(Scanner scanner, ImageDatabase imageDatabase) {
    // 10 brightenKoalla
    String imageName = getNextString(scanner);
    if ( !imageDatabase.containsImage(imageName) ) {
      throw  new IllegalArgumentException("Image not found");
    }
    Image image = imageDatabase.getImage(imageName);
    String amount = getNextString(scanner);
    try{
      Integer amountInt = Integer.parseInt(amount);
     // ImageOperation brighten = new BrightenOperation(amountInt);
//      Image redScaleImage = brighten.run(image);
//      String newImageName = getNextString(scanner);
//      imageDatabase.addImage(redScaleImage, newImageName);
    }catch(InputMismatchException e){
      //....
    }

  }
}
