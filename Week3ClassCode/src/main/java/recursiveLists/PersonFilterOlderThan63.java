package recursiveLists;

import book.Person;

public class PersonFilterOlderThan63 implements Condition<Person> {
  @Override
  public boolean evaluate(Person person) {
    return person.getAge() > 63;
  }
}
