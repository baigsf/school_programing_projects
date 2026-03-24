public class Game {
    private TTTBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int moveCount;

    public Game() {
        board = new TTTBoard();
        player1 = new Player("X", true);
        player2 = new Player("O", true);
        currentPlayer = player1;
        moveCount = 0;
    }

    public void setBoard(TTTBoard board) {
        this.board = board;
    }

    public TTTBoard getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col) {
        if (board.isCellEmpty(row, col)) {
            board.markCell(row, col, currentPlayer.getSymbol());
            moveCount++;
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean checkWin() {
        if (moveCount < 5) {
            return false;
        }
        return board.checkWin(currentPlayer.getSymbol());
    }

    public boolean checkTie() {
        return board.isFull() && !checkWin();
    }

    public boolean checkTieBeforeFull() {
        if (moveCount < 7) {
            return false;
        }
        if (checkWin() || board.isFull()) {
            return false;
        }
        return !board.canWinInOneMove(currentPlayer.getSymbol());
    }

    public void reset() {
        currentPlayer = player1;
        moveCount = 0;
        board.reset();
    }
}
