/**
 * A class for a Book having a title, author, price and
 * publication year.
 */
public class Book {
  private final String title;
  private final Person author;
  private final double price;
  private final int publicationYear;

  /**
   * Constructs a book object given a title, author, price and publication year.
   *
   * @param title is the name of the book
   * @param author is the first and last name of the author
   * @param price of the book as a float number
   * @param publicationYear the year the book was first published.
   */
  public Book(String title, Person author, double price, int publicationYear) {

    if ((title == null || title.isEmpty())
        || (author == null )
        || (price < 0) || (publicationYear < 0)) {
      throw new IllegalArgumentException("Invalid argument");
    }

    this.title = title;
    this.author = author;
    this.price = price;
    this.publicationYear = publicationYear;
  }

  public String getTitle() {
    return title;
  }

  public Person getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public Book discount(double percent) {
    if ( percent < 0 || percent > 100 ) {
      throw new IllegalArgumentException("Invalid discount percent");
    }
    return new Book(title, author, price - price*(percent/100), publicationYear);
  }

  public boolean sameAuthor(Book other){
    return this.author.equals(other.author);
  }
  //book1.equals(book1); 0x1123.equal(0x1123);
  @Override
  public boolean equals(Object other){
    if ( this == other ) return true;

    if ( ! (other instanceof Book) ) return false;

    Book otherBook = (Book) other;
    String someString;
    return this.title.equals(otherBook.title)
           && this.publicationYear ==(otherBook.publicationYear)
           && this.author.equals(otherBook.author);
  }

}
