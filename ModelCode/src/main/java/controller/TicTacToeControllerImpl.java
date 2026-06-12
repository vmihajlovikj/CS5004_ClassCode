package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import model.TicTacToe;
import model.TicTacToeImpl;
import view.StringView;
import view.View;

public class TicTacToeControllerImpl implements TicTacToeController {
  private final TicTacToe model;
  private final View view;
  private final InputStream in;
  private final OutputStream out;
  public TicTacToeControllerImpl(TicTacToe model, View view, InputStream in, OutputStream out) {
    if (model == null || view == null || in == null || out == null) {
      throw new IllegalArgumentException("Model and view and input stream cannot be null");
    }
    this.model = model;
    this.view = view;
    this.in = in;
    this.out = out;
  }

  @Override
  public void run() {
    Scanner scanner = new Scanner(in);
    while ( scanner.hasNext() ) {
        int row =  scanner.nextInt();
        int col = scanner.nextInt();

        try {
          model.move(row, col);
        }catch( IllegalArgumentException e ){
          try {
            out.write("Try again. Invalid move.".getBytes());
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }

      try {
        out.write(view.render().getBytes());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
    if ( model.hasWinner() ) {
      try {
        out.write("We have winner".getBytes());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }else{
      try {
        out.write("Stalemate.".getBytes());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }

  }
}
