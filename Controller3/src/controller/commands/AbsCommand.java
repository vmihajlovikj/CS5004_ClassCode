package controller.commands;

import controller.InputResult;
import java.util.Scanner;
import model.Calculator;
import view.View;

public class AbsCommand extends AbstractCommand {
  public AbsCommand(Calculator calculator, View view) {
    super(calculator, view);
  }
  public InputResult runCommand(Scanner scanner) {
    InputPair inputPairA = getNextValidInput(scanner);
    if ( inputPairA.getFirst() == InputResult.QUIT ) {
      view.renderMessage("Quitting.\n");
      return InputResult.QUIT;
    }

    double input = inputPairA.getSecond();
    if ( input < 0 ){
      view.renderMessage(Double.toString(input));
    }else{
      view.renderMessage(String.valueOf(input*-1));
    }

    return InputResult.CONTINUE;
  }

  @Override
  public void undo() {

  }
}
