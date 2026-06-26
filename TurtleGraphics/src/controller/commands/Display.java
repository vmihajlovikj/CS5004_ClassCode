package controller.commands;

import java.io.IOException;
import java.util.Scanner;
import model.TurtleGraphics;

public class Display implements Command {
  private final TurtleGraphics model;
  private final Appendable view;

  public Display(TurtleGraphics model, Appendable view) {
    if ( model == null || view == null ) {
      throw new IllegalArgumentException("Model or View or Scanner is null");
    }
    this.model = model;
    this.view = view;
  }
  @Override
  public void run() {
     try{
       this.view.append(model.getCurrentPosition() + " " + model.getCurrentAngle() + "\n");
     }catch(IOException e){
       throw new IllegalArgumentException(e);
     }
  }
}
