public class GameBoard {
    private final char[][] board;
    public String boardLayout;

    public String getBoardLayout() {
        return boardLayout;
    }

    //Creates an interactive board to play on.
    //The array is creating a 2D layout consisting of three rows and columns
    //i is the indicator of rows and j is the indicator of the columns.
    public GameBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';  // Start with all tiles marked as empty.
            }
        }
        updateBoardLayout();
    }

    /*  A method to implement a player's character placement in the board.
        If the player types in "1, 1, X" it puts an X on row 1, column 1.
        The code then updates the board to the current condition with the X placed
        instead of an empty tile.
    */
    public void setMove(int row, int col, char player) {
        board[row][col] = player;
        updateBoardLayout();
    }

    public boolean isTileOccupied(int row, int col) {
        return board[row][col] != ' '; // ' ' represents an empty tile aka whitespace.
    }

    //Code to check if the board is completely full and no input is possible.
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /*The code used to produce a board.
    The first loop checks the rows and the second loop inside the first one checks the columns.
    "board [i][j]" tells the program if it is X, O or empty cell.
    */
    public void updateBoardLayout() {
        boardLayout = "\n               A      B      C\n";
        boardLayout += "             ______ ______ ______\n";
        for (int i = 0; i < 3; i++) {
            boardLayout += "            |      |      |      |\n";
            boardLayout += "          " + (i+1) + " |";
            for (int j = 0; j < 3; j++) {
                boardLayout += "  " + board[i][j] + "   |";
            }
            boardLayout += "\n            |______|______|______|\n";
        }
    }

    private boolean checkThree(char player, int row0, int col0, int row1, int col1, int row2, int col2) {
        return board[row0][col0] == player && board[row1][col1] == player && board[row2][col2] == player;
    }
    //a boolean to check if the player has three of the same symbols in a row and hence wins the game.
    //each code is used for different types of win-conditions.
    //first is a row, second is a column, third is a diagonal from top left to bottom right
    //and fourth from top right to bottom left.
    public boolean hasPlayerWon(char player) {
        for (int i = 0; i < 3; i++) {
            if (checkThree(player, 0, i, 1, i, 2, i)) {
                return true;
            }
            if (checkThree(player, i, 0, i, 1, i, 2)) {
                return true;
            }
        }
        if (checkThree(player, 0, 0, 1, 1, 2, 2)) {
            return true;
        }
        return checkThree(player, 0, 2, 1, 1, 2, 0);
    }
}