import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private TicTacToeButton[][] board;
    private String currentPlayer;
    private int moveCount;
    private JButton quitButton;

    public TicTacToeFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentPlayer = "X";
        moveCount = 0;

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        board = new TicTacToeButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].addActionListener(new ButtonListener());
                boardPanel.add(board[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to quit?",
                    "Quit Game",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton button = (TicTacToeButton) e.getSource();

            if (!button.isEmpty()) {
                JOptionPane.showMessageDialog(TicTacToeFrame.this,
                        "That square is already taken! Choose another.",
                        "Invalid Move",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            button.setPlayer(currentPlayer);
            moveCount++;

            if (checkWin()) {
                JOptionPane.showMessageDialog(TicTacToeFrame.this,
                        "Congratulations! Player " + currentPlayer + " wins!",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                askToPlayAgain();
            } else if (checkTie()) {
                JOptionPane.showMessageDialog(TicTacToeFrame.this,
                        "It's a tie! The board is full.",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                askToPlayAgain();
            } else if (moveCount >= 7) {
                if (checkTieBeforeFull()) {
                    JOptionPane.showMessageDialog(TicTacToeFrame.this,
                            "It's a tie! No more moves possible.",
                            "Game Over",
                            JOptionPane.INFORMATION_MESSAGE);
                    askToPlayAgain();
                } else {
                    switchPlayer();
                }
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    private boolean checkWin() {
        if (moveCount < 5) {
            return false;
        }
        return checkRows() || checkCols() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            if (!board[row][0].isEmpty() &&
                board[row][0].getPlayer().equals(board[row][1].getPlayer()) &&
                board[row][0].getPlayer().equals(board[row][2].getPlayer())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCols() {
        for (int col = 0; col < 3; col++) {
            if (!board[0][col].isEmpty() &&
                board[0][col].getPlayer().equals(board[1][col].getPlayer()) &&
                board[0][col].getPlayer().equals(board[2][col].getPlayer())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (!board[1][1].isEmpty()) {
            if (board[0][0].getPlayer().equals(board[1][1].getPlayer()) &&
                board[1][1].getPlayer().equals(board[2][2].getPlayer())) {
                return true;
            }
            if (board[0][2].getPlayer().equals(board[1][1].getPlayer()) &&
                board[1][1].getPlayer().equals(board[2][0].getPlayer())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTie() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkTieBeforeFull() {
        if (moveCount < 7) {
            return false;
        }
        if (!checkWin() && !checkTie()) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col].isEmpty()) {
                        String testPlayer = currentPlayer;
                        board[row][col].setPlayer(testPlayer);
                        boolean wouldWin = checkWinForTie();
                        board[row][col].reset();
                        if (wouldWin) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkWinForTie() {
        return checkRows() || checkCols() || checkDiagonals();
    }

    private void askToPlayAgain() {
        int choice = JOptionPane.showConfirmDialog(this,
                "Would you like to play another game?",
                "Play Again",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    private void resetGame() {
        currentPlayer = "X";
        moveCount = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].reset();
            }
        }
    }
}
