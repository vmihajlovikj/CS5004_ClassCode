package model;

public interface TicTacToeState {
  int getSize();
  Player getPlayerAt(int row, int col) throws IllegalArgumentException;
  boolean isGameOver();
  boolean hasWinner();
  Player getWinner() throws IllegalStateException;
  Player nextTurn();
}
