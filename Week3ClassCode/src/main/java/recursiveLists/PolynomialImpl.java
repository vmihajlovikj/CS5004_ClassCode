package recursiveLists;

public class PolynomialImpl implements Polynomial {
  INode<Integer> head;


  public PolynomialImpl(INode<Integer> head) {
    this.head = new EmptyNode<>();
  }

  @Override
  public void addTerm(int coefficient, int power) {

  }

  @Override
  public void removeTerm(int power) {

  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public double evaluate(double value) {
    return 0;
  }

  @Override
  public Polynomial add(Polynomial polynomial) {
    return null;
  }
}
