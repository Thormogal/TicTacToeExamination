import java.util.Scanner;
public class Menu {
Scanner sc = new Scanner(System.in);
    public class SwitchClass {
        public void runSwitch(int menuUserChoice) {
            switch (menuUserChoice) {
                case 1 -> {
                    System.out.println("not done yet");
                    sc.nextLine();
                }
                case 2 -> {
                    char symbol = ' ';
                    boolean validInput = false;
                    System.out.println("Which symbol should player 1 start with? \"X\" or \"O\"?");
                    while (!validInput) {
                        String input = sc.nextLine().replace(" ", "").toUpperCase();
                        if (input.length() > 1 || (input.charAt(0) != 'X' && input.charAt(0) != 'O')) {
                            System.out.println("The only valid symbols are \"X\" and \"O\". Try again.");
                        } else {
                            symbol = input.charAt(0);
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
}
