package controller.commands;

import java.util.Scanner;
import model.DB.ImageDatabase;

public interface Command {
  void run(Scanner scanner, ImageDatabase imageDatabase);
}
