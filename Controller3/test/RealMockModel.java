import model.CalculatorImpl;

public class RealMockModel extends CalculatorImpl{
  private final StringBuilder builder;

  public RealMockModel(StringBuilder builder) {
    if (builder == null) {
      throw new NullPointerException("builder cannot be null");
    }
    this.builder = builder;
  }

  @Override
  public double add(double a, double b) {
    double result = super.add(a, b);
    builder.append(result);
    return result;
  }
  @Override
  public double subtract(double a, double b) {
    double result = super.subtract(a, b);
    builder.append(result);
    return result;
  }
  @Override
  public double multiply(double a, double b) {
    double result = super.multiply(a, b);
    builder.append(result);
    return result;
  }
  @Override
  public double divide(double a, double b) {
    double result = super.divide(a, b);
    builder.append(result);
    return result;
  }
}
