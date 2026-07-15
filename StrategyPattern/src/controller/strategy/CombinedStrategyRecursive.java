package controller.strategy;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import model.TicTacToeModel;

public class CombinedStrategyRecursive implements TTTStrategy{
  private final TTTStrategy firstStrategy;
  private final TTTStrategy secondStrategy;

  public CombinedStrategyRecursive(TTTStrategy firstStrategy, TTTStrategy secondStrategy) {
      if ( firstStrategy == null || secondStrategy == null ) {
        throw new IllegalArgumentException("firstStrategy or secondStrategy is null");
      }

      this.firstStrategy = firstStrategy;
      this.secondStrategy = secondStrategy;
  }

  @Override
  public Point2D getPosition(TicTacToeModel model) {
     Point2D position = this.firstStrategy.getPosition(model);
     if ( position == null ) {
       return this.secondStrategy.getPosition(model);
     }
     return null;
  }
}
