public class Game {
    private final GameBoard board;
    private char currentPlayer;

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String getBoardLayout() {
        return board.getBoardLayout();
    }
    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    public boolean hasPlayerWon() {
        return board.hasPlayerWon(currentPlayer);
    }

    public Game(char startingPlayer) {
        board = new GameBoard();
        currentPlayer = startingPlayer; //The first user chooses what symbol to start with.
    }

    public void makeMove(int row, int col) {
        if (board.isTileEmpty(row, col)) {
            System.out.println("The tile is already occupied. Try again");
        } else {
            board.setMove(row, col, currentPlayer);
        }
    }

    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
