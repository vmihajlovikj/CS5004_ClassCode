package controller.commands;

import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.TracingTurtleGraphics;

public class GetLinesCommand implements Command {
  private final TracingTurtleGraphics model;
  private final Scanner scanner;
  private final Appendable view;
  public GetLinesCommand(TracingTurtleGraphics model, Scanner scanner, Appendable view) {

    if ( model == null || scanner == null || view == null ) {
      throw new IllegalArgumentException("Model or View or Scanner is null");
    }
    this.model = model;
    this.scanner = scanner;
    this.view = view;
  }
  @Override
  public void run() {
    List<Line2D> lines = this.model.getLines();
    try{
      for(Line2D line : lines){
        view.append( line.getP1() + " " + line.getP2() + "\n");
      }
    }catch(IOException e){
      throw new IllegalStateException(e);
    }
  }
}
