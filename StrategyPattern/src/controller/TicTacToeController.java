package controller;

import java.util.Scanner;

/**
 * A basic controller interface for TicTacToe
 */
public interface TicTacToeController {
  void play(Player player1, Player player2);
  Scanner getScanner();
}
