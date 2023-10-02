public class GameBoard {
    private char[][] board;
    private String boardLayout;

    //Code to check if the tile is empty.
    public boolean isTileEmpty(int row, int col) {
        return board[row][col] != ' '; // ' ' represents an empty tile.
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

    private boolean checkThree(char player, int row1, int col1, int row2, int col2, int row3, int col3) {
        return board[row1][col1] == player && board[row2][col2] == player && board[row3][col3] == player;
    }

    public boolean hasPlayerWon(char player) {
        for (int i = 0; i < 3; i++) {
            if (checkThree(player, i, 0, i, 1, i, 2)) {
                return true;
            }

            if (checkThree(player, 0, i, 1, i, 2, i)) {
                return true;
            }
        }
        if (checkThree(player, 0, 0, 1, 1, 2, 2)) {
            return true;
        }
        if (checkThree(player, 0, 2, 1, 1, 2, 0)) {
            return true;
        }
        return false;
    }

    public GameBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';  // Start with all tiles marked as empty.
            }
        }
        updateBoardLayout();
    }


    /*The code used to produce a board.
     The first loop checks the rows and the second loop inside the first one checks the columns.
     row 26: board [i][j] tells the program if it is X, O or empty cell.
     */
    public void updateBoardLayout() {
        boardLayout = "             ______ ______ ______\n";
        for (int i = 0; i < 3; i++) {
            boardLayout += "            |      |      |      |\n";
            boardLayout += "            |";
            for (int j = 0; j < 3; j++) {
                boardLayout += "  " + board[i][j] + "   |";
            }
            boardLayout += "\n            |______|______|______|\n";
        }
    }

    public String getBoardLayout() {
        return boardLayout;
    }

    public void setMove(int row, int col, char player) {
        board[row][col] = player;
        updateBoardLayout();
    }
}