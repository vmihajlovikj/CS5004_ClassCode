import static org.junit.Assert.*;

import Enums.ChessPiece;
import Enums.ChessPieceImpl;
import org.junit.Test;

public class ChessPieceImplTest {
  @Test
  public void chessPieceExample() {
    ChessPieceImpl chessPiece1 = ChessPieceImpl.ROOK;
    ChessPieceImpl chessPiece2 = ChessPieceImpl.KNIGHT;

    assertEquals("ROOK", chessPiece1.toString());



  }
}