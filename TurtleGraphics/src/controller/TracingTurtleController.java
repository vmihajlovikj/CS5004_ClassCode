package controller;

import controller.commands.GetLinesCommand;
import controller.commands.TraceCommand;
import model.TracingTurtleGraphics;
import model.TurtleGraphics;

public class TracingTurtleController extends ControllerImpl {

  public TracingTurtleController(TracingTurtleGraphics model, Appendable view, Readable input) {
    super(model, view, input);

    this.commands.put("trace", ()->new TraceCommand(model, scanner));
    this.commands.put("getLines", ()->new GetLinesCommand(model, scanner, view));

  }
}
