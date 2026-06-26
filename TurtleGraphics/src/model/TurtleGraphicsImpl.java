package model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Stack;

public class TurtleGraphicsImpl implements TurtleGraphics {
  private Point2D.Double currentPosition;
  private double currentAngle;
  private final Stack<Point2D.Double> positions;
  private final Stack<Double> angles;

  public TurtleGraphicsImpl( ) {
    this.currentPosition = new  Point2D.Double(0, 0);
    this.currentAngle = 0;
    this.positions = new Stack<>();
    this.angles = new Stack<>();
  }
 //SOH CAH TOA
  @Override
  public void move(double distance) {
    double newX = this.currentPosition.getX() + Math.sin( Math.toRadians( currentAngle ) ) * distance;
    double newY = this.currentPosition.getY() + Math.cos(Math.toRadians( currentAngle ) ) * distance;


    this.currentPosition = new Point2D.Double( newX, newY );
  }

  @Override
  public void turn(double angle) {
    this.currentAngle += angle;
  }

  @Override
  public void save() {
    this.positions.push(this.currentPosition);//0x300, 0x200,0x100
    this.angles.push(this.currentAngle);
  }

  @Override
  public void pop() {
    if (!this.positions.isEmpty() && !this.angles.isEmpty()) {
      this.currentPosition = positions.pop();
      this.currentAngle = angles.pop();
    }else{
      throw new IllegalStateException("Cannot pop an empty turtle");
    }
  }

  @Override
  public Point2D.Double getCurrentPosition() {
    return new Point2D.Double(this.currentPosition.getX(), this.currentPosition.getY()); //0x100
  }

  @Override
  public double getCurrentAngle() {
    return this.currentAngle;
  }
}
