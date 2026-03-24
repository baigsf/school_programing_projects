import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TTTBoardTest {
    private TTTBoard board;

    @Before
    public void setUp() {
        board = new TTTBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board.setCell(row, col, new TicTacToeButton(row, col));
            }
        }
    }

    @Test
    public void testInitialCellIsEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    public void testMarkCell() {
        board.markCell(0, 0, "X");
        assertFalse(board.isCellEmpty(0, 0));
        assertEquals("X", board.getCell(0, 0).getPlayer());
    }

    @Test
    public void testCheckWinRow() {
        board.markCell(0, 0, "X");
        board.markCell(0, 1, "X");
        board.markCell(0, 2, "X");
        assertTrue(board.checkWin("X"));
    }

    @Test
    public void testCheckWinColumn() {
        board.markCell(0, 0, "O");
        board.markCell(1, 0, "O");
        board.markCell(2, 0, "O");
        assertTrue(board.checkWin("O"));
    }

    @Test
    public void testCheckWinDiagonal() {
        board.markCell(0, 0, "X");
        board.markCell(1, 1, "X");
        board.markCell(2, 2, "X");
        assertTrue(board.checkWin("X"));
    }

    @Test
    public void testCheckWinAntiDiagonal() {
        board.markCell(0, 2, "O");
        board.markCell(1, 1, "O");
        board.markCell(2, 0, "O");
        assertTrue(board.checkWin("O"));
    }

    @Test
    public void testCheckWinFalse() {
        board.markCell(0, 0, "X");
        board.markCell(0, 1, "O");
        board.markCell(0, 2, "X");
        assertFalse(board.checkWin("X"));
    }

    @Test
    public void testIsFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board.markCell(row, col, "X");
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void testReset() {
        board.markCell(0, 0, "X");
        board.markCell(1, 1, "O");
        board.reset();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    public void testCanWinInOneMove() {
        board.markCell(0, 0, "X");
        board.markCell(0, 1, "X");
        assertTrue(board.canWinInOneMove("X"));
    }

    @Test
    public void testCannotWinInOneMove() {
        board.markCell(0, 0, "X");
        board.markCell(0, 1, "O");
        assertFalse(board.canWinInOneMove("X"));
    }
}
