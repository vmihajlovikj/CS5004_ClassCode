package recursiveLists;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class OurListImpl<T> implements OurList<T>{
  private INode<T> head;

  public OurListImpl() {
    this.head = new EmptyNode<T>();
  }

  private OurListImpl(INode<T> head) {
    if ( head == null) {
      throw new IllegalArgumentException("head is null");
    }
    this.head = head;
  }

  @Override
  public void add(T item) {
    this.head = this.head.addAtEnd(item);
  }

  @Override
  public int size() {
    return this.head.size();
  }

  @Override
  public OurList<T> filter(Predicate<T> predicate) {
    INode<T> filteredListAsNodes = this.head.filter(predicate);
    OurList<T> resultAsAList = new OurListImpl<>(filteredListAsNodes);
    return resultAsAList;

  }

  @Override
  public <R> R fold(BiFunction<T, R, R> accumulator, R seed) {
    return this.head.accumulateMethod( accumulator, seed);
  }

  @Override
  public <R> OurList<R> map(Function<T, R> mapper) {
    INode<R> mappedNodes = this.head.map(mapper);
    OurList<R> resut = new OurListImpl<R>(mappedNodes);
    return resut;
  }

  @Override
  public String toString() {
    return this.head.toString();
  }
}
