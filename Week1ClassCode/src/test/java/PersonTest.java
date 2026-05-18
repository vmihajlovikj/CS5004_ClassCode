import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PersonTest {
  @Test
  public void testToString(){
    Person person1 = new Person("Jack London", 1921);
    Person person2 = new Person("Jack London", 1921);
//    assertTrue( person1.equals(person2));
//    assertEquals(person1.hashCode(), person2.hashCode());

    Map<Person, Integer> people = new HashMap<>();
    people.put(person1, 1); // people[person1] = 1;
    people.put(person2, 2);//  people[person2] = 2;
    assertEquals( 1,people.size());
  }

}