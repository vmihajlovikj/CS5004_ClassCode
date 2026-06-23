import static org.junit.Assert.*;

import controller.Controller;
import controller.ControllerImpl;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import model.Calculator;
import model.CalculatorImpl;
import org.junit.Test;
import view.View;
import view.ViewImpl;

public class ControllerImplTest {

  @Test
  public void testAdd1(){
    testGoHelper("+ 2 3", "5.0");
  }

  @Test
  public void testAdd2(){
    testGoHelper("-2 2", "0.0");
  }

  @Test(expected=IllegalStateException.class)
  public void testIOException(){
    Readable input = new StringReader("2 3");

    Appendable output = new FakeAppendable();

    View view = new ViewImpl(output);

    Controller controller = new ControllerImpl(input, view );
    controller.go(new CalculatorImpl());

    assertEquals("5.0", output.toString());
  }

  @Test
  public void testMockModel(){
    Readable input = new StringReader("2 3");
    Appendable output = new StringBuilder();

    View view = new ViewImpl( output );

    StringBuilder stringBuilder = new StringBuilder();
    Calculator mockModel = new MockModel(stringBuilder);
    Controller controller = new ControllerImpl(input, view );
    controller.go(mockModel);

    assertEquals("2.0 3.0", stringBuilder.toString());

  }

  public void testGoHelper(String expectedInput, String expectedOutput) {
    Reader input = new StringReader(expectedInput);
    Appendable output = new StringBuilder();

    View view = new ViewImpl( output );
    Controller controller = new ControllerImpl(input, view);
    controller.go( new CalculatorImpl() );

    assertEquals(expectedOutput, output.toString());


  }

  @Test
  public void testMockModel2(){
    Readable input = new StringReader("2 3");
    Appendable output = new StringBuilder();

    View view = new ViewImpl( output );

    StringBuilder stringBuilder = new StringBuilder();
    Calculator mockModel = new RealMockModel2(stringBuilder, new CalculatorImpl());

    Controller controller = new ControllerImpl(input, view );
    controller.go(mockModel);

    assertEquals("5.0", stringBuilder.toString());
  }

}