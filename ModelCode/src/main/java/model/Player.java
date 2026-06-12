package model;

public enum Player {
  X("X"), O("O"), EMPTY("_");

  private String value;

  Player(String value) {
    if ( value == null ) {
      throw new IllegalArgumentException();
    }
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
