package controller.commands;

import controller.InputResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Calculator;
import view.View;

public abstract class AbstractCommand implements Command {
  protected final Calculator calculator;
  protected final View view;

  public AbstractCommand(Calculator calculator, View view) {
    if(calculator == null || view == null) {
      throw new IllegalArgumentException("The calculator and view argument cannot be null.");
    }
    this.calculator = calculator;
    this.view = view;
  }

  protected InputPair getNextValidInput(Scanner scanner) {
    List<Double> resultList = new ArrayList<>();
    while ( scanner.hasNext() ){
      String input = scanner.next();

      if ( input.equalsIgnoreCase("q") ){
        return  new InputPair(InputResult.QUIT, 0.0);//the list is going to be empty.
      }

      try{
        double inputAsDouble = Double.parseDouble(input);
        return   new InputPair(InputResult.CONTINUE, inputAsDouble);
      }catch(NumberFormatException e){
        //this.view.renderMessage("Invalid input\n");
      }
    }
    throw new IllegalStateException("Run out of input.");
  }
}
