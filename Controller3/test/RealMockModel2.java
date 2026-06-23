import model.Calculator;
import model.CalculatorImpl;

public class RealMockModel2 extends CalculatorImpl{
  private final StringBuilder builder;
  private final Calculator newSuper;

  public RealMockModel2(StringBuilder builder, Calculator newSuper) {
    if (builder == null) {
      throw new NullPointerException("builder cannot be null");
    }
    this.builder = builder;
    this.newSuper = newSuper;
  }


  public double add(double a, double b) {
    double result = newSuper.add(a, b);
    builder.append(result);
    return result;
  }

  public double subtract(double a, double b) {
    double result = newSuper.subtract(a, b);
    builder.append(result);
    return result;
  }

  public double multiply(double a, double b) {
    double result = newSuper.multiply(a, b);
    builder.append(result);
    return result;
  }

  public double divide(double a, double b) {
    double result = newSuper.divide(a, b);
    builder.append(result);
    return result;
  }
}
