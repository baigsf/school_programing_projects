import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("X", true);
        assertEquals("X", player.getSymbol());
        assertTrue(player.isHuman());
    }

    @Test
    public void testSetSymbol() {
        Player player = new Player("X", true);
        player.setSymbol("O");
        assertEquals("O", player.getSymbol());
    }

    @Test
    public void testSetIsHuman() {
        Player player = new Player("X", true);
        player.setIsHuman(false);
        assertFalse(player.isHuman());
    }
}
