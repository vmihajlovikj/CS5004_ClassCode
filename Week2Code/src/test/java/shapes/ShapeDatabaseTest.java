package shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ShapeDatabaseTest {
  @Test
  public void shapeDatabaseTest() {



    ShapeDatabase shapeDatabase = new ShapeDatabase();

    Shape circle1 = new Circle(10, new PolarCoordinates(45, 1));
    Shape circle2 = new Circle(20, new Point2D(0,0));
    Shape circle3 = new Circle(20, new SuperMegaPoint());
    Shape rectangle1 = new Rectangle(10,10, new Point2D(0,0));
    Shape rectangle2 = new Rectangle(10,10, new Point2D(0,0));
    Shape triangle1 = new Triangle(10,10, new Point2D(0,0));


    shapeDatabase.addShape(circle1);
    shapeDatabase.addShape(circle2);
    shapeDatabase.addShape(rectangle1);
    shapeDatabase.addShape(rectangle2);
    shapeDatabase.addShape(triangle1);

    assertEquals(4, shapeDatabase.size());
  }
}