import java.util.Scanner;

public class Game {

    private GameBoard board;
    private final Player player1;
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
        while (true) {
            String input = sc.nextLine().toUpperCase();
            if (input.isEmpty()) {
                System.out.println("Empty input, empty brain. \nThis almost rhymes, try again.");
            }
            else if (input.charAt(0) != 'X' && input.charAt(0) != 'O') {
                System.out.println("The only valid symbols are solely \"X\" and \"O\". Try again.");
            }
            else {
                char player1Symbol = input.charAt(0);
                player1 = new Player(player1Name, player1Symbol);
                currentPlayer = player1;
                break;
            }
        }

        System.out.println("Enter name for player 2:");
        String player2Name = sc.nextLine();
        if (player2Name.equalsIgnoreCase(player1Name)) {
            player2Name = player2Name.concat(" 2");
            System.out.println("Identical name. Second player is now: " + player2Name);
        }
        char player2Symbol = (player1.getSymbol() == 'X') ? 'O' : 'X';
        player2 = new Player(player2Name, player2Symbol);
    }

    public boolean makeMove(int row, int col) {
        if (row == 666 || col == 666) {
            return true;
        } else {
            if (col < 0 || col > 2 || row < 0 || row > 2) {
                System.out.println("Invalid move. Row values must be 1 to 3 " +
                        "and column values must be A to C. Pick again.");
                return false;
            } else if (board.isTileEmpty(row, col)) {
                System.out.println("The tile is already occupied. Try again");
                return false;
            } else {
                board.setMove(row, col, currentPlayer.getSymbol());
                return true;
            }
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