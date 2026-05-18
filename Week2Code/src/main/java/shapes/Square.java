package shapes;

public class Square extends Rectangle {
  private final double size;

  public Square(double size, Point location){
    super(size, size, location);
    this.size = size;
  }

  //square1.equals(retangle1);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if ( ! (o instanceof Square)) return false;

    Square square = (Square) o;
    return width == square.width && height == square.height;
  }
}
