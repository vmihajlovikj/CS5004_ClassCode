package recursiveLists;

import book.Person;
import java.util.function.Predicate;

public class OddAgePredicate implements Predicate<Person> {
  /**
   * Evaluates this predicate on the given argument.
   *
   * @param person the input argument
   * @return {@code true} if the input argument matches the predicate,
   * otherwise {@code false}
   */
  @Override
  public boolean test(Person person) {
    return person.getAge() % 2 == 1;
  }
}
