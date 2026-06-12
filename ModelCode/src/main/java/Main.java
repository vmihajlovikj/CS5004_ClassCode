import controller.TicTacToeController;
import controller.TicTacToeControllerImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import model.TicTacToe;
import model.TicTacToeImpl;
import view.StringView;
import view.StringView2;
import view.View;

public class Main {
  public static void main(String[] args){
    TicTacToe game = new TicTacToeImpl();
    View view = new StringView(game);

    InputStream fakeKeyboard = new ByteArrayInputStream("0 0 1 1 2 2".getBytes());
    OutputStream fakeConsole = new ByteArrayOutputStream();
    TicTacToeController controller = new TicTacToeControllerImpl(game, view, fakeKeyboard, fakeConsole);
    System.out.println( fakeConsole.toString() );
    controller.run();
  }
}
