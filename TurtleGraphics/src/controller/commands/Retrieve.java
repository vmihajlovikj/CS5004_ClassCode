package controller.commands;

import model.TurtleGraphics;

public class Retrieve implements Command {
  private final TurtleGraphics model;
  private final Appendable view;

  public Retrieve(TurtleGraphics model, Appendable view) {
    if ( model == null || view == null ) {
      throw new IllegalArgumentException("Model or View is null");
    }
    this.model = model;
    this.view = view;
  }
  @Override
  public void run() {
    this.model.pop();
  }
}
