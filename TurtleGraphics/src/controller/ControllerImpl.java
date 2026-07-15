package controller;

import controller.commands.Command;
import controller.commands.Display;
import controller.commands.MoveCommand;
import controller.commands.Retrieve;
import controller.commands.Save;
import controller.commands.Turn;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import model.TurtleGraphics;

public class ControllerImpl implements Controller {
  protected final TurtleGraphics model;
  private final Appendable view;
  private final Readable input;
  protected Scanner scanner;
  protected final Map<String, Supplier<Command>> commands;

  public ControllerImpl(TurtleGraphics model, Appendable view, Readable input) {
    if ( model == null ) {
      throw new IllegalArgumentException("model is null");
    }

    if ( view == null ) {
      throw new IllegalArgumentException("view is null");
    }

    if ( input == null ) {
      throw new IllegalArgumentException("readable is null");
    }

    this.model = model;
    this.view = view;
    this.input = input;
    this.scanner = new Scanner(input); //0x100
    this.commands = new HashMap<>();
    this.commands.put("move", ()->{ return new MoveCommand(this.model, this.scanner); });
    this.commands.put("turn", ()->{ return new Turn(this.model, this.view, this.scanner); });
    this.commands.put("save", ()->new Save(this.model, this.view));
    this.commands.put("retrieve", ()->new Retrieve(this.model, this.view));
    this.commands.put("display", ()->new Display(this.model, this.view));
  }

  private void write(String message){
    try{
      this.view.append(message);
    }catch(IOException e){
      throw new IllegalStateException("Cannot append to appendable");
    }
  }
  @Override
  public void run() {
    while (scanner.hasNext()) {
      String nextInput = scanner.next();

      if (nextInput.equalsIgnoreCase("q")) {
        write("Quitting.");
        return;
      }
      Supplier<Command> commandSupplier = commands.getOrDefault(nextInput, null);
      if (commandSupplier != null) {
        Command command = commandSupplier.get();
        command.run();
      }else{
        write("Unknown command. Try again.");
      }
    }
    throw new IllegalStateException("Run out of input!");
  }
}
