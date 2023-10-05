import java.util.InputMismatchException;
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
                    Game game = new Game();
                    do {
                        while (true) {
                            //Prints out the current state of the board´s layout.
                            System.out.println(game.getBoardLayout());
                            System.out.println(game.getCurrentPlayerName() +
                                    " please enter your move (row and column): ");
                            try {
                                System.out.print("Row: ");
                                int row = sc.nextInt();
                                System.out.print("Column: ");
                                int col = sc.nextInt();

                                if (!game.makeMove(row, col)) {
                                    continue;
                                }

                                if (game.hasPlayerWon()) {
                                    System.out.println(game.getBoardLayout());
                                    game.increasePoints();
                                    System.out.println("Game finished! The winner is: \uD83C\uDF89" +
                                            game.getCurrentPlayerName()
                                            + "\uD83C\uDF89 and his " + game.getCurrentPlayer() +
                                            ". They have now won " + game.getNumberOfWins() + " times!");
                                    game.resetBoard();
                                    break;
                                }
                                if (game.isBoardFull()) {
                                    System.out.println(game.getBoardLayout());
                                    System.out.println("Game over! It's a draw.");
                                    System.out.println(game.player1Name + " has won " + game.getNumberOfWins() +
                                      "\n" +    game.player2Name + " has won " + game.getNumberOfWins());
                                    game.resetBoard();
                                    break;
                                }
                                game.switchPlayer();
                            } catch (InputMismatchException inputExc) {
                                System.out.println("Invalid input, try again");
                                sc.nextLine();
                            }
                        }
                    } while (!sc.nextLine().equalsIgnoreCase("Quit"));
                }
            }
        }
    }
}
