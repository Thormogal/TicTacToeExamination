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
                    boolean isRunning = true;
                    Game game = new Game();
                    do {
                        while (isRunning) {
                            System.out.println(game.getBoardLayout());

                            try {
                                System.out.print(game.getCurrentPlayerName() + ": Enter your move (e.g. '1A'): ");
                                String move = sc.next().toUpperCase();

                                if (move.equalsIgnoreCase("Quit")) {
                                    isRunning = false;
                                    if (game.getCurrentPlayer().getNumberOfWins()
                                            > game.getOtherPlayer().getNumberOfWins()) {
                                        System.out.println(game.getCurrentPlayerName() + " decided to quit the game!"
                                        + "\nAnd the winner of the whole session is...." + "\n\uD83C\uDF1F"
                                        + game.getCurrentPlayerName() + "\uD83C\uDF1F with "
                                        + game.getCurrentPlayer().getNumberOfWins() + " points! Congratulations!\n" +
                                        game.getOtherPlayerName() + " got in second place with " +
                                        game.getOtherPlayer().getNumberOfWins() + " points. Well done!");
                                    }
                                }

                                int row = Character.getNumericValue(move.charAt(0)) - 1;
                                char column = move.charAt(1);

                                int col = (int) column - 'A'; //
                                if (!game.makeMove(row, col)) {
                                    continue;
                                }

                                if (game.hasPlayerWon()) {
                                    System.out.println(game.getBoardLayout());
                                    game.getCurrentPlayer().increasePoints();
                                    System.out.println("Round finished! The winner is: \uD83C\uDF89" +
                                            game.getCurrentPlayerName()
                                            + "\uD83C\uDF89 and his " + game.getCurrentPlayer().getSymbol() +
                                            ". They have now won " + game.getCurrentPlayer().getNumberOfWins()
                                            + " " + game.getCurrentPlayer().getWinningTimesText() + "!"
                                            + "\n" + game.getOtherPlayerName() + " sits with "
                                            + game.getOtherPlayer().getNumberOfWins() + " points so far");

                                    game.resetBoard();
                                    break;
                                }
                                if (game.isBoardFull()) {
                                    System.out.println(game.getBoardLayout());
                                    System.out.println("Round over! It's a draw.");
                                    System.out.println(game.getCurrentPlayerName() + " has won " +
                                            game.getCurrentPlayer().getNumberOfWins() + "." +
                                            "\n" + game.getOtherPlayerName() + " has won " +
                                            game.getOtherPlayer().getNumberOfWins() + ".");
                                    game.resetBoard();
                                    break;
                                }
                                game.switchPlayer();
                            } catch (InputMismatchException | StringIndexOutOfBoundsException inputExc) {
                                System.out.println("Invalid input, try again.");
                                sc.nextLine();
                            }
                        }
                    } while (isRunning);
                }
            }
        }
    }
}