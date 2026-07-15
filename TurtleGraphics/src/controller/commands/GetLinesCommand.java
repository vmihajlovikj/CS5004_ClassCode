package controller.commands;

import java.util.Scanner;
import model.TracingTurtleGraphics;
import model.TurtleGraphics;

public class TraceCommand implements Command {
  private final TracingTurtleGraphics model;
  private final Scanner scanner;
  public TraceCommand(TracingTurtleGraphics model, Scanner scanner) {
    if ( model == null || scanner == null ) {
      throw new IllegalArgumentException("Model or View or Scanner is null");
    }
    this.model = model;
    this.scanner = scanner;
  }
  @Override
  public void run() {
    double distance = scanner.nextDouble();//make sure there is something to read and its a double
    this.model.trace(distance);
  }
}
