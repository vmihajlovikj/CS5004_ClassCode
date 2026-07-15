package model;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class TracingTurtleGraphicsByDelegationImpl implements TracingTurtleGraphics{
  private final List<Line2D> lines;
  private final TurtleGraphics delegate;


  public TracingTurtleGraphicsByDelegationImpl(TurtleGraphics delegate) {
    if ( delegate == null) {
      throw new IllegalArgumentException("delegate cannot be null");
    }

    lines = new ArrayList<Line2D>();
    this.delegate = delegate;
  }

  public TracingTurtleGraphicsByDelegationImpl() {
   this(new TurtleGraphicsImpl());
  }

  @Override
  public void trace(double distance) {
    Point2D.Double start = getCurrentPosition();
    move(distance);
    Point2D.Double end = getCurrentPosition();
    Line2D line = new Line2D.Double(start, end);
    lines.add(line);
  }

  @Override
  public List<Line2D> getLines() {
    List<Line2D> copyLines =  new ArrayList<>();

    for ( Line2D line : lines) {
      Line2D copyLine = new Line2D.Double(line.getX1(), line.getY1(), line.getX2(), line.getY2());
      copyLines.add(copyLine);
    }

    return copyLines;
  }

  @Override
  public void move(double distance) {
    delegate.move(distance);
  }

  @Override
  public void turn(double angle) {
    delegate.turn(angle);
  }

  @Override
  public void save() {
    delegate.save();
  }

  @Override
  public void pop() {
    delegate.pop();
  }

  @Override
  public Point2D.Double getCurrentPosition() {
    return delegate.getCurrentPosition();
  }

  @Override
  public double getCurrentAngle() {
    return delegate.getCurrentAngle();
  }
}
