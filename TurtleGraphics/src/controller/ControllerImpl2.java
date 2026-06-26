package controller;

import controller.commands.SquareCommand;
import model.TurtleGraphics;

public class ControllerImpl2 extends ControllerImpl{
  public ControllerImpl2(TurtleGraphics model, Appendable view, Readable input) {
    super(model, view, input);

    this.commands.put("square", ()->new SquareCommand(model,view, this.scanner) );
  }
}
