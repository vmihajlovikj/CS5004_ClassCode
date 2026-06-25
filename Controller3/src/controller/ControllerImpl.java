package controller;

import controller.commands.AbsCommand;
import controller.commands.AbstractCommand;
import controller.commands.AddCommand;
import controller.commands.Command;
import controller.commands.DivideCommand;
import controller.commands.InputPair;
import controller.commands.MultiplyCommand;
import controller.commands.SubtractCommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Supplier;
import model.Calculator;
import view.View;

public class ControllerImpl implements Controller {
  private final Readable controllerInput;
  protected final View view;
  protected final Scanner scanner;
  protected final Map<String, Supplier<Command>> commands;
  protected final Stack<Command> undoStack;
  protected final Calculator calculator;
  public ControllerImpl(Readable controllerInput, View view ,Calculator calculator) {
    if ( controllerInput == null) {
      throw new IllegalArgumentException("Controller input is null");
    }
    if ( view == null) {
      throw new IllegalArgumentException("Controller output is null");
    }

    if ( calculator == null) {
      throw new IllegalArgumentException("Calculator is null");
    }

    this.controllerInput = controllerInput;
    this.view = view;
    this.scanner = new Scanner(controllerInput);
    this.commands = new HashMap<>();
    this.calculator = calculator;

    //Command addCommand = //0x100
    Command subtractCommand = new SubtractCommand(calculator, view);
    Command divideCommand = new DivideCommand(calculator, view);
    Command multiplyCommand = new MultiplyCommand(calculator, view);

    Supplier<Command> supplier;
    this.commands.put("+", new Supplier<Command>() {
      @Override
      public Command get() {
        return new  AddCommand(calculator, view);
      }
    }); // put("+", 0x100);

    this.commands.put("-",  ()->new SubtractCommand(calculator,  view) );

    this.commands.put("*",  ()->new DivideCommand(calculator,  view) );
    this.commands.put("/", ()->new MultiplyCommand(calculator,  view) );

    this.undoStack = new Stack<>();
  }


  @Override
  public void go() throws IllegalStateException {

    List<Double> parsedResult;
    while ( scanner.hasNext() ) {
      String input = scanner.next();
      if ( input.equalsIgnoreCase("q") ) {
        view.renderMessage("Exiting.");
        return;
      }

      if ( input.equalsIgnoreCase("undo") ){
        if ( undoStack.isEmpty() ) {
          view.renderMessage("Nothing to undo.");
        }else {
          Command lastCommandRun = undoStack.pop();
          lastCommandRun.undo();
        }
      }
      //+ 2 3 + 4 5 undo undo                 +
      Supplier<Command> supplier = commands.getOrDefault(input, null);
      Command command = supplier.get(); //(new AddCommand(calculator, view) );
      //       0x100
      if ( command != null ) {     //0x100 ( inputA=4, inputB=5 )
        InputResult quitOrNot = command.runCommand(scanner);
        this.undoStack.push(command);
        //0x100
        //0x200

        if ( quitOrNot == InputResult.QUIT ) {
          view.renderMessage("Exiting.");
          return;
        }

      }
    }
    throw new IllegalStateException("Run out of input.");
  }
}
