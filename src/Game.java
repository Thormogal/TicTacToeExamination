import java.util.Scanner;

public class Game {

    private GameBoard board;
    private Player player1;
    private final Player player2;
    private Player currentPlayer;
    public void resetBoard() {
        board = new GameBoard();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        if (currentPlayer == player1) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    public Player getOtherPlayer() {
        if (currentPlayer == player1) {
            return player2;
        } else {
            return player1;
        }
    }

    public String getOtherPlayerName() {
        if (currentPlayer == player1) {
            return player2.getName();
        } else {
            return player1.getName();
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
        String player1Name = sc.nextLine();
        System.out.println("Hello " + player1Name + ". Pick a symbol (X or O):");
        char player1Symbol = ' ';
        boolean validInput = false;
        while (!validInput) {
            String input = sc.nextLine().replace(" ", "").toUpperCase();
            if (input.length() > 1 || (input.charAt(0) != 'X' && input.charAt(0) != 'O')) {
                System.out.println("The only valid symbols are \"X\" and \"O\". Try again.");
            } else {
                player1Symbol = input.charAt(0);
                validInput = true;
            }
            player1 = new Player(player1Name, player1Symbol);
            currentPlayer = player1;
        }

        System.out.println("Enter name for player 2:");
        String player2Name = sc.nextLine();
        char player2Symbol;
        if (player1.getSymbol() == 'X') {
            player2Symbol = 'O';
        } else {
            player2Symbol = 'X';
        }
        player2 = new Player (player2Name, player2Symbol);
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move. Row and column values must be between 0 and 2. Pick again.");
            return false;
        } else if (board.isTileEmpty(row, col)) {
            System.out.println("The tile is already occupied. Try again");
            return false;
        } else {
            board.setMove(row, col, currentPlayer.getSymbol());
            return true;
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasPlayerWon() {
        return board.hasPlayerWon(currentPlayer.getSymbol());
    }
}