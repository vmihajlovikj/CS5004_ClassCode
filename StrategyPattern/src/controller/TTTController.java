package controller;

import controller.strategy.CombinedStrategy;
import controller.strategy.CombinedStrategyRecursive;
import controller.strategy.HumanStrategy;
import controller.strategy.PlayAnyOpenSpot;
import controller.strategy.PlayCenter;
import controller.strategy.TTTStrategy;
import controller.strategy.TryToBlock;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;
import model.Piece;
import model.ReadonlyTicTacToeModel;
import model.Status;
import model.TicTacToeModel;


/**
 * Simple TicTacToe controller
 */
public class TTTController implements TicTacToeController {
  private final TicTacToeModel model;
  private final Appendable output;
  private final Readable readable;
  private final Scanner scanner;
  public TTTController(TicTacToeModel model, Appendable output, Readable readable) {
    this.model = Objects.requireNonNull(model);
    this.output = Objects.requireNonNull(output);
    this.readable = Objects.requireNonNull(readable);
    this.scanner = new Scanner(readable);
  }

  public Scanner getScanner() {
    return scanner;
  }

  private void write(String message){
    try{
      this.output.append(message);
    }catch(IOException e){
      throw new IllegalStateException(e);
    }
 }

  @Override
  public void play(Player player1, Player player2) {
    List<Player> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);
    int currentPlayerIndex = 0;
    while (this.model.gameStatus() == Status.Playing) {
      this.printBoard();

      while( true ) {
        Player player = players.get(currentPlayerIndex); // currentPlayerIndex = 0;
        write("Player " + player + " enter position: ");
        Point2D position = player.getPosition( new ReadonlyTicTacToeModel(model));
        if ( position == null ) {
          throw new IllegalStateException("Could not find position for " + player + ", exiting.");
        }
        try {
          this.model.setPieceAt((int)position.getX(), (int)position.getY(), player.getPiece());
          break;
        } catch (IllegalArgumentException e) {
          write("Invalid position. Please try again.");
        }
      }

      currentPlayerIndex = ( currentPlayerIndex + 1 ) %  players.size();;
    }


    //After we are done playing.
    this.printBoard();
    try {
      if (this.model.gameStatus() == Status.Won)
        output.append("Player " + this.model.getWinner().toString() + " won");
      else
        output.append("Tie game");
    } catch (IOException e) {

    }
  }

  public void printBoard() {
    try {
      output.append("\n");
      for (int r = 0; r < this.model.getHeight(); r++) {
        if (r > 0) {
          for (int c = 0; c < this.model.getWidth(); c++) {
            if (c > 0)
              output.append("+");
            output.append("-");
          }
          output.append("\n");
        }
        for (int c = 0; c < this.model.getWidth(); c++) {
          if (c > 0) output.append("|");
          output.append(this.model.getPieceAt(r, c).toString());
        }
        output.append("\n");
      }
    } catch (IOException e) {

    }
  }
}
