package recursiveLists;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface OurList<T> {
  void add(T item);
  int size();
  OurList<T> filter(Predicate<T> predicate);
  <R> R fold(BiFunction<T, R, R> accumulator, R seed);
  <R> OurList<R> map(Function<T, R> mapper);
}
