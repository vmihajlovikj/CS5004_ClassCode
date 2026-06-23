package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Calculator;
import model.CalculatorImpl;
import view.View;

public class ControllerImpl implements Controller {
  private final Readable controllerInput;
  private final View view;

  public ControllerImpl(Readable controllerInput, View view) {
    if ( controllerInput == null) {
      throw new IllegalArgumentException("Controller input is null");
    }
    if ( view == null) {
      throw new IllegalArgumentException("Controller output is null");
    }

    this.controllerInput = controllerInput;
    this.view = view;
  }

  private InputPair getNextValidInput(Scanner scanner) {
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

  @Override
  public void go(Calculator calculator) throws IllegalStateException {
    Scanner scanner = new Scanner(this.controllerInput);
    List<Double> parsedResult;
    while ( scanner.hasNext() ) {
      String input = scanner.next();
      if ( input.equalsIgnoreCase("q") ) {
        view.renderMessage("Exiting.");
        return;
      }
      //Assume is one of these four operations: +, -, *, / sin 45
      double a = 0;
      double b = 0;
      double result = 0;
      //Why can I not read both numbers here.
      switch ( input ) {
        case "+":
          InputPair inputPairA = getNextValidInput(scanner);
          if ( inputPairA.getSecond() <= 0 ) {
            view.renderMessage("Quitting.\n");
            return;
          }
          InputPair inputPairB = getNextValidInput(scanner);
          if ( inputPairB.getFirst() == InputResult.QUIT ) {
            view.renderMessage("Quitting.\n");
            return;
          }
          result = calculator.add(inputPairA.getSecond(), inputPairB.getSecond());
          view.renderMessage(String.valueOf(result));
          break;
        case "-":
          a = getNextValidInput(scanner);
          b = getNextValidInput(scanner);
          result = calculator.subtract(a, b);
          view.renderMessage(String.valueOf(result));
          break;
        case "*":
          a = getNextValidInput(scanner);
          b = getNextValidInput(scanner);
          result = calculator.multiply(a, b);
          view.renderMessage(String.valueOf(result));
          break;
        case "/":
          a = getNextValidInput(scanner);
          b = getNextValidInput(scanner);

          try {
            result = calculator.divide(a, b);
            view.renderMessage(String.valueOf(result));
          }catch(ArithmeticException e){
            view.renderMessage( e.getMessage() );
          }
          break;
        default:
          view.renderMessage("Invalid input.\n");
      }
    }
    throw new IllegalStateException("Run out of input.");
  }
}
