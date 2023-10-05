import java.util.Scanner;

public class Game {

    private GameBoard board;
    private final String player1Name;
    private final String player2Name;
    private char player1Symbol;
    private final char player2Symbol;
    private char currentPlayer;
    public void resetBoard() {
        board = new GameBoard();
    }
    private int increasePoints = 0;
    public void increasePoints() {
        this.increasePoints++;
    }
    public int getNumberOfWins() {
        return this.increasePoints;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        if (currentPlayer == player1Symbol) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    public String getBoardLayout() {
        return board.getBoardLayout();
    }

    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    public Game() {
        board = new GameBoard();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name for player 1:");
        player1Name = sc.nextLine();
        System.out.println("Hello " + player1Name + ". Pick a symbol (X or O):");
        player1Symbol = ' ';
        boolean validInput = false;
        while (!validInput) {
            String input = sc.nextLine().replace(" ", "").toUpperCase();
            if (input.length() > 1 || (input.charAt(0) != 'X' && input.charAt(0) != 'O')) {
                System.out.println("The only valid symbols are \"X\" and \"O\". Try again.");
            } else {
                player1Symbol = input.charAt(0);
                validInput = true;
            }
            currentPlayer = player1Symbol;
        }

        System.out.println("Enter name for player 2:");
        player2Name = sc.nextLine();


        if (player1Symbol == 'X') {
            player2Symbol = 'O';
        } else {
            player2Symbol = 'X';
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move. Row and column values must be between 0 and 2. Pick again.");
            return false;
        } else if (board.isTileEmpty(row, col)) {
            System.out.println("The tile is already occupied. Try again");
            return false;
        } else {
            board.setMove(row, col, currentPlayer);
            return true;
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1Symbol) {
            currentPlayer = player2Symbol;
        } else {
            currentPlayer = player1Symbol;
        }
    }

    public boolean hasPlayerWon() {
        return board.hasPlayerWon(currentPlayer);
    }
}