public class TTTBoard {
    public static final int SIZE = 3;
    private TicTacToeButton[][] grid;

    public TTTBoard() {
        grid = new TicTacToeButton[SIZE][SIZE];
    }

    public TicTacToeButton getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(int row, int col, TicTacToeButton button) {
        grid[row][col] = button;
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col].isEmpty();
    }

    public void markCell(int row, int col, String player) {
        grid[row][col].setPlayer(player);
    }

    public boolean checkWin(String player) {
        return checkRows(player) || checkCols(player) || checkDiagonals(player);
    }

    private boolean checkRows(String player) {
        for (int row = 0; row < SIZE; row++) {
            if (!grid[row][0].isEmpty() &&
                grid[row][0].getPlayer().equals(player) &&
                grid[row][1].getPlayer().equals(player) &&
                grid[row][2].getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCols(String player) {
        for (int col = 0; col < SIZE; col++) {
            if (!grid[0][col].isEmpty() &&
                grid[0][col].getPlayer().equals(player) &&
                grid[1][col].getPlayer().equals(player) &&
                grid[2][col].getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(String player) {
        if (!grid[1][1].isEmpty() && grid[1][1].getPlayer().equals(player)) {
            if (grid[0][0].getPlayer().equals(player) &&
                grid[2][2].getPlayer().equals(player)) {
                return true;
            }
            if (grid[0][2].getPlayer().equals(player) &&
                grid[2][0].getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canWinInOneMove(String player) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col].isEmpty()) {
                    grid[row][col].setPlayer(player);
                    boolean wouldWin = checkWin(player);
                    grid[row][col].reset();
                    if (wouldWin) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void reset() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col].reset();
            }
        }
    }
}
