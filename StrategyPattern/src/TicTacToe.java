import controller.Difficulty;
import controller.Player;
import controller.PlayerImpl;
import controller.TTTController;
import controller.TicTacToeController;
import controller.strategy.CombinedStrategyRecursive;
import controller.strategy.HumanStrategy;
import controller.strategy.PlayAnyOpenSpot;
import controller.strategy.PlayCenter;
import controller.strategy.TryToBlock;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import model.Piece;
import model.TTTModelImpl;
import model.TicTacToeModel;

/**
 * Driver for the TicTacToe game
 */
public class TicTacToe {
  public static void main(String[] args) {
    int h = 3;
    int w = 3;
    int g = 3;
    TicTacToeModel model = new TTTModelImpl(h, w, g);

    StringReader readable = new StringReader("1 1 0 0 2 2 0 1 q");

    TicTacToeController controller = new TTTController(model,
                                                        System.out, readable);
      // Player mediumAIPlayer = new PlayerImpl( new CombinedStrategyRecursive(new TryToBlock(),
      //                                                  new CombinedStrategyRecursive(new PlayCenter(), new PlayAnyOpenSpot())), Piece.O);
      //Player easyAIPlayer = new PlayerImpl( new PlayAnyOpenSpot(), Piece.O);

    Scanner scanner = controller.getScanner();
    scanner.nextLine();

    Player human1 = new PlayerImpl( new HumanStrategy(controller.getScanner()), Piece.X);
    Player human2 = new PlayerImpl( new HumanStrategy(controller.getScanner()), Piece.O);

    controller.play(human1, human2);

  }
}
