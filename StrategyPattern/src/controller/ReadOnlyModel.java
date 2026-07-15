package controller;

import model.Piece;
import model.Status;
import model.TicTacToeModel;

public class ReadOnlyModel implements TicTacToeModel {
  private final TicTacToeModel delegate;

  public ReadOnlyModel(TicTacToeModel model){
    if (model == null ){
      throw new IllegalArgumentException("model is null");
    }
    delegate = model;
  }

  @Override
  public int getWidth() {
    return this.delegate.getWidth();
  }

  @Override
  public int getHeight() {
    return this.delegate.getHeight();
  }

  @Override
  public int getGoal() {
    return this.delegate.getGoal();
  }

  @Override
  public Piece getPieceAt(int r, int c) {
    return this.delegate.getPieceAt(r, c);
  }

  @Override
  public void setPieceAt(int r, int c, Piece p) {
    throw new UnsupportedOperationException("The model is read-only.");
  }

  @Override
  public Status gameStatus() {
    return this.delegate.gameStatus();
  }

  @Override
  public Piece getWinner() {
    return this.delegate.getWinner();
  }
}
