package controller.commands;

import java.util.Scanner;
import model.TurtleGraphics;

public class Turn implements Command {
  private final TurtleGraphics model;
  private final Appendable view;
  private final Scanner scanner;

  public Turn(TurtleGraphics model, Appendable view, Scanner scanner) {
    if ( model == null || view == null || scanner == null ) {
      throw new IllegalArgumentException("Model or View or Scanner is null");
    }
    this.model = model;
    this.view = view;
    this.scanner = scanner;
  }
  @Override
  public void run() {
    double angle = scanner.nextDouble();//make sure there is something to read and its a double
    this.model.turn(angle);
  }
}
