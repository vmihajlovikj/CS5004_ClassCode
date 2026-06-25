package controller.commands;

import controller.InputResult;
import java.util.Scanner;
import model.Calculator;
import view.View;

public class AddCommand extends AbstractCommand {

  private InputPair inputPairA;
  private InputPair inputPairB;
  private boolean commandRun;
  public AddCommand(Calculator calculator, View view) {
   super(calculator, view);

   inputPairA = null;
   inputPairB = null;
   commandRun = false;
  }

  public InputResult runCommand(Scanner scanner) {
    inputPairA = getNextValidInput(scanner);
    if ( inputPairA.getFirst() == InputResult.QUIT ) {
      view.renderMessage("Quitting.\n");
      return InputResult.QUIT;
    }
    inputPairB = getNextValidInput(scanner);
    if ( inputPairB.getFirst() == InputResult.QUIT ) {
      view.renderMessage("Quitting.\n");
      return InputResult.QUIT;
    }
    double result = calculator.add(inputPairA.getSecond(), inputPairB.getSecond());
    view.renderMessage(String.valueOf(result));
    commandRun = true;
    return InputResult.CONTINUE;
  }

  @Override
  public void undo() {
    if (commandRun) {
      calculator.subtract(inputPairA.getSecond(), inputPairB.getSecond());
      view.renderMessage("Undoing add, subtracrting.");
    }
  }
}
