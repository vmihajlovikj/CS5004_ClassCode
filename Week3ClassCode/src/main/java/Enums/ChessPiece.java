package Enums;

public enum ChessPiece {
  ROOK("ROOK"), QUEEN("QUEEN"), KNIGHT("KNIGHT"),
  BISHOP("BISHOP"), PAWN("PAWN");

  private final String value;

  private ChessPiece(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
