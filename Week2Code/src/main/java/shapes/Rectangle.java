package shapes;

import java.util.Objects;

public class Rectangle extends AbstractShape {
  protected final double width;
  protected final double height;

  public Rectangle(double width, double height, Point location) {
    super(location);

    if( width <= 0 || height <= 0 ) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }
  public double getHeight() {
    return height;
  }

  public double getArea() {
    return width * height;
  }
  public double getPerimeter() {
    return  2 * width * height;
  }

  @Override
  public String toString() {
    return "Rectangle " + width + " " + height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
  }
}
