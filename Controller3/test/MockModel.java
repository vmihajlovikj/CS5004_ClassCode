import model.Calculator;

public class MockModel implements Calculator {
  private StringBuilder stringBuilder;

  public MockModel(StringBuilder stringBuilder) {
    if ( stringBuilder == null ){
      throw new IllegalArgumentException("Input is null");
    }
    this.stringBuilder = stringBuilder;
  }

  @Override
  public double add(double a, double b) {
    stringBuilder.append( a );
    stringBuilder.append( " " );
    stringBuilder.append( b );
    return 0;
  }

  @Override
  public double subtract(double a, double b) {
    stringBuilder.append( a );
    stringBuilder.append( " " );
    stringBuilder.append( b );
    return 0;
  }

  @Override
  public double multiply(double a, double b) {
    stringBuilder.append( a );
    stringBuilder.append( " " );
    stringBuilder.append( b );
    return 0;
  }

  @Override
  public double divide(double a, double b) {
    stringBuilder.append( a );
    stringBuilder.append( " " );
    stringBuilder.append( b );
    return 0;
  }
}
