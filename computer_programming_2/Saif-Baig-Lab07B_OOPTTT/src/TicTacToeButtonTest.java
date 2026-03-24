import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeButtonTest {

    private TicTacToeButton button;

    @Before
    public void setUp() {
        button = new TicTacToeButton(1, 1);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(1, button.getRow());
        assertEquals(1, button.getCol());
    }

    @Test
    public void testInitialStateIsEmpty() {
        assertTrue(button.isEmpty());
        assertEquals("", button.getPlayer());
    }

    @Test
    public void testSetPlayer() {
        button.setPlayer("X");
        assertFalse(button.isEmpty());
        assertEquals("X", button.getPlayer());
    }

    @Test
    public void testReset() {
        button.setPlayer("O");
        button.reset();
        assertTrue(button.isEmpty());
        assertEquals("", button.getPlayer());
    }
}
