package controller.commands;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.text.View;
import model.TurtleGraphics;

public class MoveCommandWithView extends MoveCommand {
  private final Appendable view;
  public MoveCommandWithView(TurtleGraphics model, Appendable view, Scanner scanner) {
    super(model, scanner);

    if ( view == null ){
      throw new IllegalArgumentException("The view is null");
    }

    this.view = view;
  }
  @Override
  public void run(){
    super.run();
    try{
      view.append("Move successful.");
    }catch(IOException e){
      throw new IllegalStateException(e);
    }
  }
}
