import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testInitialPlayerIsX() {
        assertEquals("X", game.getCurrentPlayer().getSymbol());
    }

    @Test
    public void testInitialMoveCountIsZero() {
        assertEquals(0, game.getMoveCount());
    }

    @Test
    public void testMakeMove() {
        assertTrue(game.makeMove(0, 0));
        assertEquals(1, game.getMoveCount());
    }

    @Test
    public void testMakeMoveOnOccupiedCell() {
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0));
    }

    @Test
    public void testSwitchPlayer() {
        assertEquals("X", game.getCurrentPlayer().getSymbol());
        game.switchPlayer();
        assertEquals("O", game.getCurrentPlayer().getSymbol());
        game.switchPlayer();
        assertEquals("X", game.getCurrentPlayer().getSymbol());
    }

    @Test
    public void testCheckWinFalseWithLessThan5Moves() {
        game.makeMove(0, 0);
        game.makeMove(1, 1);
        assertFalse(game.checkWin());
    }

    @Test
    public void testCheckWinRow() {
        game.makeMove(0, 0);
        game.switchPlayer();
        game.makeMove(1, 0);
        game.switchPlayer();
        game.makeMove(0, 1);
        game.switchPlayer();
        game.makeMove(1, 1);
        game.switchPlayer();
        game.makeMove(0, 2);
        assertTrue(game.checkWin());
    }

    @Test
    public void testCheckWinColumn() {
        game.makeMove(0, 0);
        game.switchPlayer();
        game.makeMove(0, 1);
        game.switchPlayer();
        game.makeMove(1, 0);
        game.switchPlayer();
        game.makeMove(1, 1);
        game.switchPlayer();
        game.makeMove(2, 0);
        assertTrue(game.checkWin());
    }

    @Test
    public void testCheckWinDiagonal() {
        game.makeMove(0, 0);
        game.switchPlayer();
        game.makeMove(1, 0);
        game.switchPlayer();
        game.makeMove(1, 1);
        game.switchPlayer();
        game.makeMove(2, 0);
        game.switchPlayer();
        game.makeMove(2, 2);
        assertTrue(game.checkWin());
    }

    @Test
    public void testCheckWinAntiDiagonal() {
        game.makeMove(0, 2);
        game.switchPlayer();
        game.makeMove(1, 0);
        game.switchPlayer();
        game.makeMove(1, 1);
        game.switchPlayer();
        game.makeMove(2, 0);
        game.switchPlayer();
        game.makeMove(2, 2);
        assertTrue(game.checkWin());
    }

    @Test
    public void testCheckTie() {
        game.makeMove(0, 0);
        game.switchPlayer();
        game.makeMove(0, 1);
        game.switchPlayer();
        game.makeMove(0, 2);
        game.switchPlayer();
        game.makeMove(1, 1);
        game.switchPlayer();
        game.makeMove(1, 0);
        game.switchPlayer();
        game.makeMove(1, 2);
        game.switchPlayer();
        game.makeMove(2, 0);
        game.switchPlayer();
        game.makeMove(2, 2);
        game.switchPlayer();
        game.makeMove(2, 1);
        assertTrue(game.checkTie());
    }

    @Test
    public void testReset() {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.reset();
        assertEquals(0, game.getMoveCount());
        assertEquals("X", game.getCurrentPlayer().getSymbol());
        assertTrue(game.getBoard().isCellEmpty(0, 0));
        assertTrue(game.getBoard().isCellEmpty(0, 1));
    }
}
