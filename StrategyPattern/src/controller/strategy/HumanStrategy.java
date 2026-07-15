package controller.strategy;

import java.awt.geom.Point2D;
import java.io.InputStream;
import java.util.Scanner;
import model.TicTacToeModel;

public class HumanStrategy implements TTTStrategy{
  private final Scanner scanner;

  public HumanStrategy(InputStream in) {
    if ( in == null ) {
      throw new IllegalArgumentException("Input stream is null");
    }
    scanner = new Scanner(in);
  }

  @Override
  public Point2D getPosition(TicTacToeModel model) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    return new Point2D.Double(x, y);
  }
}
