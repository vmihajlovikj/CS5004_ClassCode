package controller;

import controller.commands.AbsCommand;
import view.View;

public class ControllerImpl2 extends ControllerImpl {
  public ControllerImpl2(Readable controllerInput, View view) {
    super(controllerInput, view);

    commands.put("abs", new AbsCommand() );
  }
}
