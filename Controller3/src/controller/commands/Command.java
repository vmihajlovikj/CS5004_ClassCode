package controller.commands;

import controller.InputResult;
import java.util.Scanner;
import model.Calculator;
import view.View;

public interface Command {
  InputResult runCommand(Scanner scanner);
  void undo();
}
