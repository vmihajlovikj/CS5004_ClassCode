package controller.strategy;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import model.TicTacToeModel;

public class CombinedStrategy implements TTTStrategy{
  private final List<TTTStrategy> strategies;

  public CombinedStrategy( TTTStrategy... strategies) {
    this.strategies = new ArrayList<>();
    for ( TTTStrategy strategy : strategies) {
      this.strategies.add(strategy);
    }
  }

  @Override
  public Point2D getPosition(TicTacToeModel model) {
    for ( TTTStrategy strategy : strategies ) {
      Point2D position = strategy.getPosition(model);
      if (position != null) {
        return position;
      }
    }
    return null;
  }
}
