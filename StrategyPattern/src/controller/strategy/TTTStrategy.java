package controller.strategy;

import java.awt.geom.Point2D;
import model.TicTacToeModel;

public interface TTTStrategy {
  Point2D getPosition(TicTacToeModel model);
}
