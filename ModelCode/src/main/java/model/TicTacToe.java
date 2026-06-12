package model;//TODAY: MVC Pattern.
//Homework: M - in MVC, the model.
//Let's discuss implementing a model of model.TicTacToe
//SOLID Principles.
//S - single responsibility
//O - Open to extension closed to modification.
//L - Liskov Principles - Use interfaces and inheritance.
//I - Interface Segregation - Need to know bases, keep your
//      interfaces as simple as possible don't force the
//      implementing developer to write methods they don't need
//D - Dependency Inversion - Only depend on the functionality of
//    an object, not on how it does that functionality. Use interfaces
//    for your data types, and do not depend on casting.

public interface TicTacToe extends TicTacToeState {
  void move(int row, int col) throws IllegalArgumentException;
}
