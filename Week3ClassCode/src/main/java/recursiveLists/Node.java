package recursiveLists;

import book.Book;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Node<T> implements INode<T> {
  T data;
  INode<T> next;

  public Node(T data, INode<T> next) {
    if ( data == null  || next == null ) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.data = data;
    this.next = next;
  }

  @Override
  public int size() {
    return  this.sizeHelper(0);
  }
  @Override
  public int sizeHelper(int accumulator){
    return   next.sizeHelper(1 + accumulator);
  }

  public INode<T> copy(){
    return  new Node<T>(data, next.copy());
  }

  public INode<T> addAtEnd(T data) {
    return new Node<T>( this.data, next.addAtEnd(data));
  }

  @Override//
  public <R> R accumulateMethod(BiFunction<T, R, R> accumulator, R seed) {
    //                 apply( T data1, U data2);
    return accumulator.apply(data, this.next.accumulateMethod(accumulator, seed));
            //"Name1 Name2 Name3"

    //                            //
  }

  @Override
  public <R> INode<R> map(Function<T, R> mapper) {
    return new Node<R>( mapper.apply(this.data), next.map(mapper) );
  }

  //Person1(63), new Person(64), new Person(65),
  public INode<T> filter(Predicate<T> condition){
    if ( condition.test(data) ) {
      return new Node<T>(data, next.filter(condition));
    }
    return  this.next.filter(condition);
  }

  @Override
  public String toString() {
    return  this.next.toStringHelper(  "", this.data.toString() );
  }

  @Override
  public String toStringHelper(String accumulator, String previousBookData) {    //  HP3           ""
    return  this.next.toStringHelper(  accumulator + previousBookData + "\n", this.data.toString() );
  }




}
