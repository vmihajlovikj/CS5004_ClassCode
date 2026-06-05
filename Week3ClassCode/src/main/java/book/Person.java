package book;

import java.util.Objects;

public class Person extends Object{
  private final String name;
  private final int age;
  public Person(String name, int age) {
    if ( name.isEmpty() || name == null || age < 0) {
      throw new IllegalArgumentException("Name cannot be empty or null " +
          "or age cannot be negative");
    }
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public boolean equals(Object other){
    if ( this == other ){
      return true;
    }
    if ( !(other instanceof Person) ) {
      return false;
    }
    Person otherPerson = (Person) other;
    return this.name.equals(otherPerson.name) && this.age == otherPerson.getAge();
  }

  @Override
  public String toString() {
    return name + " " + age;
  }
}
