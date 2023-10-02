import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
        Hello and welcome to this lovely game called Tic Tac Toe.
        The goal of the game is for you to get three symbols in a row before
        your opponent. You get one move each per round.
        It is a tie if the field is totally cluttered with symbols without three of the
        same symbols in a row.
        First of all, please select one of the following by typing the corresponding number:
        1. Play against the computer.
        2. Play local against a friend.
        3. Change the size of the board and how many rows of symbol that are required for a win.
        """);

        int userChoice = sc.nextInt();


        //A switch to let the user choose which option they prefer to pick.
        switch (userChoice) {
            case 1 -> {
            }
            case 2 -> {
                char symbol = ' ';
                boolean validInput = false;
                System.out.println("Which symbol should player 1 start with? \"X\" or \"O\"?");
                while (!validInput) {
                    symbol = Character.toUpperCase(sc.next().charAt(0));
                    if (symbol != 'X' && symbol != 'O') {
                        System.out.println("The only valid symbols are \"X\" and \"O\"");
                    } else {
                        validInput = true;
                    }
                }
                Game game = new Game(symbol);
                while (true) {
                    //Prints out the current state of the board´s layout.
                    System.out.println(game.getBoardLayout());

                    System.out.println("Current player, please enter your move (row and column): ");
                    System.out.print("Row: ");
                    int row = sc.nextInt();
                    System.out.print("Column: ");
                    int col = sc.nextInt();

                    game.makeMove(row, col);

                    if (game.hasPlayerWon()) {
                        System.out.println(game.getBoardLayout());
                        System.out.println("Game over! The winner is: " + game.getCurrentPlayer());
                        break;
                    }
                    if (game.isBoardFull()) {
                        System.out.println(game.getBoardLayout());
                        System.out.println("Game over! It's a draw.");
                        break;
                    }
                    game.switchPlayer();
                }
            }
            case 3 -> {
                System.out.println("""
                        Which size should the board be?
                        You can choose between the following:
                        3x3, 5x5, 7x7.
                        Please input the desired one:
                        """);
                sc.nextLine();
            }
            default -> {
            }
        }
    }
}