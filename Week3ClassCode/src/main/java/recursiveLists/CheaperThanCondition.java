package recursiveLists;

import book.Book;
import java.util.function.Predicate;

public class CheaperThanCondition implements Predicate<Book> {
  private final double price;
  public CheaperThanCondition(double price) {
    if ( price < 0 ) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }
  @Override
  public boolean test(Book book) {
    return book.getPrice() < price;
  }
}
