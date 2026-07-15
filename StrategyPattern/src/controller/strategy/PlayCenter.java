package controller;

import java.awt.geom.Point2D;
import model.Piece;
import model.TicTacToeModel;

public class PlayCenter implements TTTStrategy{
  @Override
  public Point2D getPosition(TicTacToeModel model) {
    if (model == null ){
      throw new IllegalArgumentException("model is null");
    }
    if ( model.getPieceAt(1,1) == Piece.EMPTY){
      return new Point2D.Double(1,1);
    }
    return null;
  }
}
