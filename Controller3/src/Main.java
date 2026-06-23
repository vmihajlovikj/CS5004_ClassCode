import controller.Controller;
import controller.ControllerImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;
import model.Calculator;
import model.CalculatorImpl;
import view.View;
import view.ViewImpl;

public class Main {
  public static void main(String[] args) {
    View view  = new ViewImpl();
    Controller controller = new ControllerImpl( new InputStreamReader(System.in), view);
    controller.go( new CalculatorImpl() );

  }
}
