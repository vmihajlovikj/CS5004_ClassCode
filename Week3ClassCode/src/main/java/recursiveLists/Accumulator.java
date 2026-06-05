package recursiveLists;

import book.Book;

public interface Accumulator<T, R> {
  R evaluate(T data, R resultSoFar);
}
