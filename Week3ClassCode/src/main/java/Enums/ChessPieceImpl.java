package Enums;

public class ChessPieceImpl {
  public final static ChessPieceImpl ROOK = new ChessPieceImpl("ROOK");
  public final static ChessPieceImpl KNIGHT = new  ChessPieceImpl("KNIGHT");
  public final static ChessPieceImpl PAWN = new ChessPieceImpl("PAWN");
  public final static ChessPieceImpl QUEEN = new ChessPieceImpl("QUEEN");
  public final static ChessPieceImpl BISHOP = new ChessPieceImpl("BISHOP");


  private final String value;

  private ChessPieceImpl(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }



}
