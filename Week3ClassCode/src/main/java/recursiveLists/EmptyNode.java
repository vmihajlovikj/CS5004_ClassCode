package recursiveLists;

import book.Book;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements INode<T>{

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int sizeHelper(int accumulator) {
    return accumulator;
  }

  @Override                      // HP1\nHP2\n                HP3
  public String toStringHelper(String accumulator, String previousNodeBookTitle) {
    return accumulator +  previousNodeBookTitle; //+"\n"
        //  HP1\nHP2\n  +   HP3
  }

  @Override
  public INode<T> filter(Predicate<T> condition) {
    return new EmptyNode<T>();
  }

  @Override
  public INode<T> copy() {
    return null;
  }

  @Override
  public INode<T> addAtEnd(T data) {
    return new Node<T>(data, new EmptyNode<>());
  }

  @Override
  public <R> R accumulateMethod(BiFunction<T,R,R> accumulator, R seed) {
    return seed;
  }

  @Override
  public <R> INode<R> map(Function<T, R> mapper) {
    return new EmptyNode<R>();
  }

  // HP1->emptyNode
  // HP1.accumualteMethod( accumulator)
  //

  @Override
  public String toString() {
    return "";
  }
}
