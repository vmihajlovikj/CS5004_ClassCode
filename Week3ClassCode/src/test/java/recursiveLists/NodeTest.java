package recursiveLists;

import static org.junit.Assert.*;

import book.Book;
import book.Person;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
  private Book hp1;
  private Book hp2;
  private Book hp3;
  private Book hp4;

  @Before
  public void setUp() {
    hp1 = new Book("HP1", new Person("JKR", 63), 20,1999 );
    hp2 = new Book("HP2", new Person("JKR", 63), 30,2002 );
    hp3 = new Book("HP3", new Person("AKR", 63), 40,2004 );
    hp4 = new Book("HP4", new Person("AKR", 63), 50,2006 );

  }

  @Test
  public void polynomialExample(){

  }

//  @Test
//  public void cheaperThan50() {
//    Node HP1 = new Node( hp1,  new Node(hp2, new Node(hp3,  new EmptyNode())));
//    INode cheaperThan50 = HP1.filter( (Book book) -> book.getPrice() <= 40 );
//    assertEquals(2, cheaperThan50.size());
//  }

//  @Test
//  public void allPublicationYears() {
//    Node HP1 = new Node( hp1,  new Node(hp2, new Node(hp3,  new EmptyNode())));
//    String allPublicationYears = HP1.accumulateMethod( (Book b) -> b.getPublicationYear() + " ");//the price of every book.
//    assertEquals("1999 2002 2004 ", allPublicationYears);
//  }
//
//  @Test
//  public void allTitles() {
//    Node HP1 = new Node( hp1,  new Node(hp2, new Node(hp3,  new EmptyNode())));
//    String allPublicationYears = HP1.accumulateMethod( (Book b) -> b.getTitle() + " ");
//    assertEquals("HP1 HP2 ", allPublicationYears);
//  }

//  @Test
//  public void publicationBefore2000(){
//    Node HP1 = new Node( hp1,  new Node(hp2, new Node(hp3,  new EmptyNode())));
//    INode cheaperThan50 = HP1.filter( (Book book) -> book.getPublicationYear() < 2000 );
//    assertEquals(2, cheaperThan50.size());
//  }

//  @Test
//  public void authorContainsSubstring() {
//    Node HP1 = new Node( hp1,  new Node(hp2, new Node(hp3,  new EmptyNode())));
//    INode cheaperThan50 = HP1.filter( (Book book) -> book.getAuthor().toString().contains( "AK" ) );
//    assertEquals(1, cheaperThan50.size());
//  }


  @Test
  public void testSize() {         //HP2            HP3
    Node<Book> HP1 = new Node<Book>( hp1,  new Node<Book>(hp2,
                                              new Node<Book>(hp3,
                                                  new EmptyNode<Book>())));

    assertEquals(  3  ,HP1.size() );
  }




  @Test
  public void testToString() {
    Node<Book> node = new Node<Book>( hp1,
                  new Node<Book>(hp2,
                      new Node<Book>(hp3,
                          new EmptyNode<Book>())));
    assertEquals(  "HP1\nHP2\nHP3"  ,node.toString() );
  }

  @Test
  public void intList(){
    Node<Integer> node1 = new Node<Integer>(12,
                                  new Node<Integer>(14,
                                      new Node<Integer>( 16,
                                          new EmptyNode<Integer>())));
  }

  @Test
  public void map(){
    Node<Person> node1 = new Node<Person>(new Person("Name1", 63),
        new Node<Person>(new Person("Name2", 64),
            new Node<Person>(new Person("Name3", 65),
                new EmptyNode<Person>())));

    INode<Integer> ages = node1.map( (Person p)->p.getAge());

  }

  @Test
  public void mapList(){
    OurList<Person> personList = new OurListImpl<>();

    personList.add(new Person("Name1", 63));
    personList.add(new Person("Name2", 64));
    personList.add(new Person("Name3", 65));

    OurList<Integer> agesList = personList.map( (Person p)->p.getAge());
    assertEquals("63\n64\n65",  agesList.toString());
  }

  @Test
  public void filterList(){
    OurList<Person> personList = new OurListImpl<>();

    personList.add(new Person("Name1", 63));
    personList.add(new Person("Name2", 64));
    personList.add(new Person("Name3", 65));

    OurList<Person> agesList = personList.filter( (Person p)->p.getAge()%2==1);
    assertEquals("Name1 63\nName3 65",  agesList.toString());
  }

  @Test
  public void reduceList(){
    OurList<Person> personList = new OurListImpl<>();

    personList.add(new Person("Name1", 63));
    personList.add(new Person("Name2", 64));
    personList.add(new Person("Name3", 65));

    int totalAges = personList.fold( (Person p, Integer totalAge)->p.getAge()+totalAge, 0);
    assertEquals(192, totalAges);
  }

  @Test
  public void filterMapReduce(){
    List<Person> personList = new ArrayList<>();

    personList.add(new Person("Name1", 63));
    personList.add(new Person("Name2", 64));
    personList.add(new Person("Name3", 65));

    int result = personList.stream().filter( (Person p)->p.getAge()%2==1)
                           .map( (Person p)->p.getAge())
                           .reduce( 0, (Integer currentAge,Integer resultSoFar)->currentAge + resultSoFar);

    assertEquals(128, result);
  }

  @Test
  public void filterMapReduce1(){
    List<Person> personList = new ArrayList<>();

    personList.add(new Person("Name1", 63));
    personList.add(new Person("Name2", 64));
    personList.add(new Person("Name3", 65));

    int result = personList.stream().filter( (Person p)->p.getAge()%2==1)
                                    .map( (Person p)->p.getAge())
                                    .reduce( 0, (Integer currentAge,Integer resultSoFar)->currentAge + resultSoFar);

    assertEquals(128, result);
  }


  @Test
  public void personListFilterAgeOlderThan63(){
    Node<Person> node1 = new Node<Person>(new Person("Name1", 63),
        new Node<Person>(new Person("Name2", 64),
            new Node<Person>(new Person("Name3", 65),
                new EmptyNode<Person>())));


    INode<Person> olderThan63 = node1.filter( (Person p) -> p.getAge() > 63 );
    assertEquals("Name2 64\nName3 65", olderThan63.toString());
  }

  @Test
  public void personAccumulateNames(){
    Node<Person> node1 = new Node<Person>(new Person("Name1", 63),
                            new Node<Person>(new Person("Name2", 64),
                              new Node<Person>(new Person("Name3", 65),
                                new EmptyNode<Person>())));


    String listOfNamesAsString =
            node1.accumulateMethod( (Person person, String result) -> result + person.getName() +" " , "" );

    int allAgesTogethers = node1.accumulateMethod(
        (Person data, Integer resultSoFar) -> data.getAge() + resultSoFar, 0);
                                          //[ Person1, Person3]
    String namesWithOddAges = node1.filter( (Person p) -> p.getAge() % 2 == 1)
            .accumulateMethod( (Person p, String result) -> p.getName() + " " + result , "The name are: " );

    assertEquals("Name1 Name3 ", namesWithOddAges);
    assertEquals("Name1 Name2 Name3 ", listOfNamesAsString);
    assertEquals(192, allAgesTogethers);
  }



    @Test
    public void streamMethods(){
      List<Book> books = new ArrayList<Book>();
      books.add(hp1);
      books.add(hp2);
      books.add(hp3);
    }





}