import javax.swing.JButton;
import java.awt.Font;

public class TicTacToeButton extends JButton {
    private int row;
    private int col;
    private String player;

    public TicTacToeButton(int row, int col) {
        this.row = row;
        this.col = col;
        this.player = "";
        setFont(new Font("Arial", Font.BOLD, 60));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
        setText(player);
    }

    public boolean isEmpty() {
        return player.isEmpty();
    }

    public void reset() {
        player = "";
        setText("");
    }
}
