package controller;

import java.awt.geom.Point2D;
import model.Piece;
import model.TicTacToeModel;

public interface Player {
  Piece getPiece();
  Point2D getPosition(TicTacToeModel model);
}
