package controller;

import java.awt.geom.Point2D;
import model.Piece;
import model.TicTacToeModel;

public class PlayAnyOpenSpot implements TTTStrategy{
  @Override
  public Point2D getPosition(TicTacToeModel model) {
    if (model == null ){
      throw new IllegalArgumentException("model is null");
    }
    for (  int i = 0; i < model.getWidth(); i++ ) {
      for ( int j = 0; j < model.getHeight(); j++ ) {
        if ( model.getPieceAt(i,j) == Piece.EMPTY ) {
          return new Point2D.Double(i,j);
        }
      }
    }
    return null;
  }
}
