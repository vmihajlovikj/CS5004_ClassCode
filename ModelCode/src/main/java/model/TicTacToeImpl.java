package model;

import java.util.List;

public class TicTacToeImpl implements TicTacToe {
  private final Player[][] board;
  private Player nextPlayer;
  private int totalMovesMade;
  private int maxMoves;
  private GameState gameState;
  private Player winner;
  public TicTacToeImpl() {
    this.board = new Player[3][3];
    //Initializing the board.
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.board[i][j] = Player.EMPTY;
      }
    }
    this.nextPlayer = Player.X;
    this.totalMovesMade = 0;
    this.maxMoves = 9;
    this.gameState = GameState.PLAYING;
    this.winner = null;
  }

  private void advancePlayer(){
    if ( this.nextPlayer == Player.X ) {
      this.nextPlayer = Player.O;
    }else{
      this.nextPlayer = Player.X;
    }
  }
  private void updateGameState(){

  }

  @Override
  public void move(int row, int col) throws IllegalArgumentException {
    if ( row < 0 || row > 3 || col < 0 || col > 3) { //TODO:Test invalid move for all of these
      throw new IllegalArgumentException("Invalid row or column");
    }

    if ( this.gameState == GameState.GAME_OVER ) {
      throw new IllegalArgumentException("Game over");
    }

    if ( this.board[row][col] != Player.EMPTY ) {
      throw new IllegalArgumentException("Not an empty spot.");
    }

    this.board[row][col] = nextPlayer;
    this.totalMovesMade++;
    advancePlayer();
    updateGameState();
  }

  @Override
  public int getSize() {
    return 3;
  }

  @Override
  public Player getPlayerAt(int row, int col) throws IllegalArgumentException {
    if ( row < 0 || row >= 3 || col < 0 || col >= 3) {
      throw new IllegalArgumentException("Invalid row or column");
    }
    return this.board[row][col];
  }

  @Override
  public boolean isGameOver() {
    return this.gameState == GameState.GAME_OVER;
  }

  @Override
  public boolean hasWinner() {
    //Do some logic here.
    return true;
  }

  @Override
  public Player getWinner() throws IllegalStateException {
    //TODO: Fix this : ).
    return null;
  }

  @Override
  public Player nextTurn() {
    return null;
  }
}
