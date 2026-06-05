package Enums;

import book.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
  //The starting value when there is no database created.
  private static Database database = null;

  private final List<Person> allPeople;

  private Database() {
    allPeople = new ArrayList<>();
  }
  //Factory method.
  public static Database makeDatabase(){
    if ( database == null ){
      database = new Database();
    }
    return database;
  }

  public void  addPerson(Person person) {
    if ( person == null ) {
      throw new IllegalArgumentException("Person cannot be null.");
    }
    allPeople.add(person);
  }

  List<Person> getAllPeople() {
    return new  ArrayList<>(allPeople);
  }
}
