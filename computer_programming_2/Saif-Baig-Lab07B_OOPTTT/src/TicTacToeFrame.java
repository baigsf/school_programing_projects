import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame {
    private JFrame frame;
    private Game game;
    private TTTBoard board;
    private JPanel boardPanel;
    private JButton quitButton;

    public TicTacToeFrame() {
        game = new Game();
        board = game.getBoard();
        createGUI();
    }

    public void createGUI() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        boardPanel = new JPanel(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TicTacToeButton button = new TicTacToeButton(row, col);
                board.setCell(row, col, button);
                button.addActionListener(new ButtonListener());
                boardPanel.add(button);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to quit?",
                    "Quit Game",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        bottomPanel.add(quitButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton button = (TicTacToeButton) e.getSource();

            if (!button.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "That square is already taken! Choose another.",
                        "Invalid Move",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            game.makeMove(button.getRow(), button.getCol());

            if (game.checkWin()) {
                JOptionPane.showMessageDialog(frame,
                        "Congratulations! Player " + game.getCurrentPlayer().getSymbol() + " wins!",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                askToPlayAgain();
            } else if (game.checkTie()) {
                JOptionPane.showMessageDialog(frame,
                        "It's a tie! The board is full.",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                askToPlayAgain();
            } else if (game.getMoveCount() >= 7) {
                if (game.checkTieBeforeFull()) {
                    JOptionPane.showMessageDialog(frame,
                            "It's a tie! No more moves possible.",
                            "Game Over",
                            JOptionPane.INFORMATION_MESSAGE);
                    askToPlayAgain();
                } else {
                    game.switchPlayer();
                }
            } else {
                game.switchPlayer();
            }
        }
    }

    private void askToPlayAgain() {
        int choice = JOptionPane.showConfirmDialog(frame,
                "Would you like to play another game?",
                "Play Again",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            resetBoard();
        } else {
            System.exit(0);
        }
    }

    public void resetBoard() {
        game.reset();
    }
}
