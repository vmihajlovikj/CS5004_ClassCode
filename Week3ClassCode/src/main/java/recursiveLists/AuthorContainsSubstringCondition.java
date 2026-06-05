package recursiveLists;

import book.Book;
import java.util.function.Predicate;

public class AuthorContainsSubstringCondition implements Predicate<Book> {
  private final String substring;
  public AuthorContainsSubstringCondition(String substring) {
    if ( substring == null ){
      throw new IllegalArgumentException("substring cannot be null");
    }
    this.substring = substring;
  }
  @Override
  public boolean test(Book book) {
    return book.getAuthor().toString().contains(substring);
  }
}
