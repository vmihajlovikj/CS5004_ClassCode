package controller;

import controller.commands.BrightenCommand;
import controller.commands.Command;
import controller.commands.LoadCommand;
import controller.commands.LoadCommandSupplier;
import controller.commands.RedGrayScaleCommand;
import controller.commands.SaveCommand;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import model.DB.ImageDatabase;
import model.DB.ImageDatabaseImpl;

public class ControllerImpl implements Controller {
  private final Appendable out;
  private final Readable in;
  private final ImageDatabase database;
  private final Map<String, Supplier<Command>> commands;
  public ControllerImpl(Appendable out, Readable in) {
    if ( out == null || in == null) {
      throw new IllegalArgumentException("The argument 'out' or 'in' cannot be null.");
    }
    this.in = in;
    this.out = out;
    this.database = new ImageDatabaseImpl();
    this.commands = new HashMap<>();
    Supplier<Command> loadCommandSupplier = new LoadCommandSupplier();
    this.commands.put("load", loadCommandSupplier );
    this.commands.put("save", ()->new SaveCommand() );
    this.commands.put("red", ()-> new RedGrayScaleCommand() );
    this.commands.put("brighten", () ->new BrightenCommand() );
  }


  private void write(String message){
    try{
      this.out.append(message);
    }catch(IOException e){
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void go() {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String input  = scanner.next();//koala.ppm koala
      if ( input.equals("exit") ) {
        write("Exiting.");
        return;
      }

      if ( input.equals("list") ) {
        for ( String id : this.database.imageIDs() ){
          write( id );
          write( "\n" );
        }
        continue;
      }

      //koala.ppm koala
                                            //save, load, brighten
      Supplier<Command> commandSupplier = commands.getOrDefault(input,null);
      if ( commandSupplier == null ) {
        write("Command not found. Try again.");
        continue;
      }
      Command command = commandSupplier.get();
      try {
        command.run(scanner, database);
      }catch(IllegalArgumentException e){
        throw e; //Try it this way, it might be better to pass the appendable to the command.
        //But ok if it stays like this, just make sure it works for other exceptions thrown by other commands.
      }
    }
  }
}
