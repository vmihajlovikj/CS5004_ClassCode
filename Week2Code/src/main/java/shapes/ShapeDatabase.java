package shapes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ShapeDatabase {
  private final List<Shape> shapes;


  public ShapeDatabase(){
    this.shapes = new LinkedList<>();
  }

  public void addShape(Shape shape){
    shapes.add(shape);
  }

  public int size(){
    return shapes.size();
  }

}
