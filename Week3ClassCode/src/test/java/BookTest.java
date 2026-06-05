import book.Book;
import book.Person;
import org.junit.Test;

public class BookTest {
  @Test
  public void testSameAuthor(){
    Book book1 = new Book("Call of the wild",
                      new Person("Jack London", 60),
                          20, 1961);

    Book book2 = new Book("Call of the wild",
        new Person("Jack London", 60),
        20, 1961);

   Person person1 = new Person("Jack London", 60);
   Person person2 = new Person("Jack London", 60);

  }



}