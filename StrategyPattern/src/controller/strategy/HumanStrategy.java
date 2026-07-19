package controller.strategy;

import java.awt.geom.Point2D;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;
import model.TicTacToeModel;

public class HumanStrategy implements TTTStrategy{
  private final Scanner scanner;

  public HumanStrategy(Scanner scanner) {
    if ( scanner == null ) {
      throw new IllegalArgumentException("Scanner is null");
    }
    this.scanner = scanner;
  }

  @Override
  public Point2D getPosition(TicTacToeModel model) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();

    return new Point2D.Double(x, y);
  }
}
