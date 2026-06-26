package model;

import java.awt.geom.Point2D;

public interface TurtleGraphics {
  void move(double distance);
  void turn(double angle);
  void save();
  void pop();
  Point2D.Double getCurrentPosition();
  double getCurrentAngle();
}
