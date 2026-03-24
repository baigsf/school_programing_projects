import javax.swing.SwingUtilities;

public class TicTacToeRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeFrame tttFrame = new TicTacToeFrame();
            tttFrame.show();
        });
    }
}
