package shapes;

import java.util.Objects;

public class Triangle extends AbstractShape {
  private final double height;
  private final double base;

  public Triangle(double height, double base, Point location) {
    super(location);

    if (height < 0 || base < 0) throw new IllegalArgumentException();
    this.height = height;
    this.base = base;

  }

  public double getHeight() {
    return height;
  }
  public double getBase() {
    return base;
  }

  @Override
  public double getPerimeter() {
    return  this.base + this.height;
  }

  @Override
  public double getArea() {
    return 2 * this.base + this.height;
  }

  @Override
  public Point2D getLocation() {
    return this.location;
  }

  @Override
  public String toString(){
    return "Triangle " + this.base + " " + this.height;
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.height, this.base);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if ( !(o instanceof Triangle)) return false;

    Triangle triangle = (Triangle) o;
    return this.height == triangle.height && this.base == triangle.base;
  }
}
