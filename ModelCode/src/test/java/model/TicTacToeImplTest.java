package model;

import static org.junit.Assert.assertEquals;

import model.TicTacToe;
import model.TicTacToeImpl;
import org.junit.Test;
import view.StringView;
import view.StringView2;
import view.View;

public class TicTacToeImplTest {

  @Test
  public void move() {
    TicTacToe ticTacToe = new TicTacToeImpl();
    ticTacToe.move(0, 0);
    View view = new StringView2(ticTacToe);
    assertEquals("X _ _\n_ _ _\n_ _ _", view.render() );
  }

  @Test
  public void getSize() {
  }

  @Test
  public void getPlayerAt() {
  }

  @Test
  public void isGameOver() {
  }

  @Test
  public void hasWinner() {
  }

  @Test
  public void getWinner() {
  }

  @Test
  public void nextTurn() {
  }
}