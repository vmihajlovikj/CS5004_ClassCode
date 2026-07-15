package controller;

import controller.strategy.TTTStrategy;
import java.awt.geom.Point2D;
import model.Piece;
import model.TicTacToeModel;

public class PlayerImpl implements Player {
  private final TTTStrategy strategy;
  private final Piece piece;

  public PlayerImpl(TTTStrategy strategy, Piece piece) {
    if ( strategy == null || piece == null ) {
      throw new IllegalArgumentException("Strategy and piece can't be null");
    }
    this.strategy = strategy;
    this.piece = piece;
  }


  @Override
  public Piece getPiece() {
    return this.piece;
  }

  @Override
  public Point2D getPosition(TicTacToeModel model) {
    return this.strategy.getPosition(model);
  }
}
