package recursiveLists;

public interface Polynomial {
  void addTerm(int coefficient, int power);
  void removeTerm(int power);
  int getDegree();
  int getCoefficient(int power);
  double evaluate(double value);
  Polynomial add(Polynomial polynomial);
}
