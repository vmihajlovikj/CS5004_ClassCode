package controller.commands;

import controller.InputResult;
import java.util.Scanner;
import model.Calculator;
import view.View;

public class MultiplyCommand extends AbstractCommand {

  public MultiplyCommand(Calculator calculator, View view) {
    super(calculator, view);
  }
  public InputResult runCommand(Scanner scanner) {
    InputPair inputPairA = getNextValidInput(scanner);
    if ( inputPairA.getFirst() == InputResult.QUIT ) {
      view.renderMessage("Quitting.\n");
      return InputResult.QUIT;
    }
    InputPair inputPairB = getNextValidInput(scanner);
    if ( inputPairB.getFirst() == InputResult.QUIT ) {
      view.renderMessage("Quitting.\n");
      return InputResult.QUIT;
    }
    double result = calculator.multiply(inputPairA.getSecond(), inputPairB.getSecond());
    view.renderMessage(String.valueOf(result));
    return InputResult.CONTINUE;
  }

  @Override
  public void undo() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
