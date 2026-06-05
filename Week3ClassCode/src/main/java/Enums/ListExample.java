package Enums;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
  List<Integer> list = new ArrayList<Integer>();
  public void example(){
    list.add(1);
    list.get( list.size()-1 );
    for ( Integer i : list){

    }
  }
}
