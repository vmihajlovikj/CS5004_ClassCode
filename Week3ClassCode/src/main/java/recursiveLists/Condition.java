package recursiveLists;
import book.Book;

public interface Condition<T> {
  boolean evaluate(T data);
}
