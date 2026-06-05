package recursiveLists;

import book.Book;

public class BookTitleAccumulator implements Accumulator<Book, String> {

  @Override
  public String evaluate(Book book, String resultSoFar) {
    return resultSoFar + book.getTitle();
  }
}
