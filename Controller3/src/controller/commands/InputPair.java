package controller.commands;

import controller.InputResult;

public class InputPair implements Pair<InputResult, Double> {
  private final InputResult a;
  private final Double b;

  public InputPair(InputResult a, Double b){
    if ( a == null || b == null){
      throw new IllegalArgumentException();
    }
    this.a = a;
    this.b = b;
  }
  @Override
  public InputResult getFirst() {
    return this.a;
  }

  @Override
  public Double getSecond() {
    return this.b;
  }
}
