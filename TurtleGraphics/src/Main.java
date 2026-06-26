import controller.Controller;
import controller.ControllerImpl;
import controller.ControllerImpl2;
import java.io.InputStreamReader;
import model.TurtleGraphics;
import model.TurtleGraphicsImpl;

public class Main {
  public static void main(String[] args) {
    TurtleGraphics turtleGraphics = new TurtleGraphicsImpl();
    Controller controller = new ControllerImpl2(
                                          turtleGraphics,
                                          System.out,
                                          new InputStreamReader(System.in));

    controller.run();
  }
}
