import controller.Difficulty;
import controller.Player;
import controller.PlayerImpl;
import controller.TTTController;
import controller.TicTacToeController;
import controller.strategy.CombinedStrategyRecursive;
import controller.strategy.HumanStrategy;
import controller.strategy.PlayAnyOpenSpot;
import controller.strategy.PlayCenter;
import java.io.InputStreamReader;
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
    TicTacToeController controller = new TTTController(model,
                                                        System.out,
                                                        new InputStreamReader(System.in));

//    Player easyAIPlayer = new PlayerImpl( new PlayAnyOpenSpot(), Piece.X);
//    Player mediumAIPlayer = new PlayerImpl( new CombinedStrategyRecursive(new PlayCenter(), new PlayAnyOpenSpot()), Piece.O);
      Player human1 = new PlayerImpl( new HumanStrategy(System.in), Piece.X);
      Player human2 = new PlayerImpl( new HumanStrategy(System.in), Piece.O);
    controller.play(human1, human2);

  }
}
