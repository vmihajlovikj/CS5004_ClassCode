package model;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.Line;

public class TracingTurtleGraphicsByExtensionImpl extends TurtleGraphicsImpl implements TracingTurtleGraphics{
  private final List<Line2D> lines;

  public TracingTurtleGraphicsByExtensionImpl(){
    super();

    lines = new ArrayList<Line2D>();
    //lines = 0x100;
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
}
