package controller.commands;

import java.io.IOException;
import java.util.Scanner;
import model.TurtleGraphics;

public class SquareCommand implements Command {
  private final TurtleGraphics model;
  private final Appendable view;
  private final Scanner scanner;
  public SquareCommand(TurtleGraphics model, Appendable view, Scanner scanner) {
    if ( model == null || view == null || scanner == null ) {
      throw new IllegalArgumentException("Model or View or Scanner is null");
    }
    this.model = model;
    this.view = view;
    this.scanner = scanner;
  }
  @Override
  public void run() {
     double squareSize = scanner.nextDouble();
     this.model.move(squareSize);
     this.model.turn(90);
     this.model.move(squareSize);
     this.model.turn(90);
     this.model.move(squareSize);
     this.model.turn(90);
     this.model.move(squareSize);
  }
}
