import controller.Controller;
import controller.ControllerImpl;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.FieldPosition;
import model.Image;
import model.ImageLoader;
import model.ImageUtil;//demo main
import model.ImageWriter;
import model.PPMIMageLoader;
import model.PPMWriter;
import model.operations.ImageOperation;
import model.operations.RedComponent;

public class Main {
  public static void main(String[] args) {
      Controller controller = new ControllerImpl(System.out,
                                                  new InputStreamReader(System.in));

      controller.go();
  }
}