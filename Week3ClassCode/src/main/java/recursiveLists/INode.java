package recursiveLists;

import book.Book;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface INode<T> {
  int size();
  //Don't worry about it, for now : )
  int sizeHelper(int accumulator);
  String toStringHelper(String accumulator, String previousNodeBookTitle);
  INode<T> filter(Predicate<T> condition);
  INode<T> copy();
  INode<T> addAtEnd(T data);
  <R> R accumulateMethod(BiFunction<T,R,R> accumulator, R seed );
  <R> INode<R> map( Function<T,R> mapper );
}
