package shapes;

public abstract class AbstractShape implements Shape {
  protected final Point location;

  public AbstractShape(Point location) {
    if ( location == null ){
      throw new IllegalArgumentException("point cannot be null");
    }

    this.location = location;
  }

  public AbstractShape(PolarCoordinates location) {
    if ( location == null ){
      throw new IllegalArgumentException("point cannot be null");
    }

    this.location = null;
  }

  @Override
  public Point getLocation() {
    if ( location == null ){}
      return location;
  }
}
