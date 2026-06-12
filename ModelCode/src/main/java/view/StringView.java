package view;

import model.TicTacToe;
import model.TicTacToeState;

public class StringView implements View {
  private final TicTacToeState model;

  public StringView(TicTacToeState model) {
    if ( model == null) {
      throw new IllegalArgumentException("model cannot be null.");
    }
    this.model = model;
  }
  @Override
  public String render() {
    String result = "";
    for ( int i = 0; i < model.getSize(); i++){
      for(int j = 0; j < model.getSize(); j++){
        result += model.getPlayerAt(i,j) + " ";
      }
      result += "\n";
    }
    return result;
  }
}
