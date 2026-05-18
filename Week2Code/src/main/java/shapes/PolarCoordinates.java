package shapes;

public class PolarCoordinates implements Point {
  private final double angle;
  private final double distance;

  public PolarCoordinates(double angle, double distance) {
    this.angle = angle;
    this.distance = distance;
  }

  public double getAngle() {
    return angle;
  }
  public double getDistance() {
    return distance;
  }

  @Override
  public double getX() {
    return Math.cos(angle) * distance;
  }
  //SOH CAH TOA
  @Override
  public double getY() {
    return Math.sin(angle) * distance;
  }
}
