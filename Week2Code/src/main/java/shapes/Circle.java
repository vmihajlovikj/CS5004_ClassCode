package shapes;

import java.util.Objects;

public class Circle extends AbstractShape {
  private final double radius;

  public Circle(double radius, Point point) {
    super(point);

    if (radius < 0)
      throw new IllegalArgumentException("radius cannot be negative");

    this.radius = radius;
  }

  public double getArea(){
    return radius * radius * Math.PI;
  }

  public double getPerimeter(){
    return 2 * radius * Math.PI;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString(){
    return "Circle " + this.radius;
  }

  @Override
  public int hashCode() {
    return Objects.hash(radius);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if ( ! (o instanceof Circle)) return false;

    Circle circle = (Circle) o;
    return Double.compare(circle.radius, radius) == 0;
  }
}
