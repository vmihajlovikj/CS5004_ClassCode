package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorImplTest {

  @Test
  public void add() {
    Calculator calculator = new CalculatorImpl();
    double result = calculator.add(1.0, 2.0);
    assertEquals(3.0, result, 0.01);
  }
}