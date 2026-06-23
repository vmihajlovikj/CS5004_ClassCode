import static org.junit.Assert.*;

import model.CalculatorImpl;

public class CalculatorImplTest {

  @org.junit.Test
  public void add() {
    CalculatorImpl calc = new CalculatorImpl();
    double result = calc.add(1.0, 2.0);
    assertEquals(3.0, result, 0.01);
  }
}