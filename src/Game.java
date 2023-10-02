public class Game {
    private GameBoard board;
    private char currentPlayer;

    public Game(char startingPlayer) {
        board = new GameBoard();
        currentPlayer = startingPlayer; //The first user chooses what symbol to start with.
    }

    public void makeMove(int row, int col) {
        if (board.isTileEmpty(row, col)) {
            System.out.println("The tile is already occupied. Try again");
        } else {
            board.setMove(row, col, currentPlayer);
            switchPlayer();
        }
    }

    private void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
