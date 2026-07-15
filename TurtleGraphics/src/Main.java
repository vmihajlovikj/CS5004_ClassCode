import controller.Controller;
import controller.ControllerImpl;
import controller.ControllerImpl2;
import controller.TracingTurtleController;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.TracingTurtleGraphics;
import model.TracingTurtleGraphicsByExtensionImpl;
import model.TurtleGraphics;
import model.TurtleGraphicsImpl;

public class Main {
  public static void main(String[] args) {

    //TurtleGraphics turtleGraphics = new TurtleGraphicsImpl();

    TracingTurtleGraphics tracingTurtleGraphics = new TracingTurtleGraphicsByExtensionImpl();

    Controller controller = new TracingTurtleController(
                                          tracingTurtleGraphics,
                                          System.out,
                                          new InputStreamReader(System.in));

    controller.run();
  }
}
