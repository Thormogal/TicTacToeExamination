import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public class SwitchClass {
        public void runSwitch(int menuUserChoice) {
            switch (menuUserChoice) {

                case 1 -> {
                    boolean isRunning = true;
                    Game game = new Game();
                    game.CreatePlayers(true);

                    do {
                        while (isRunning) {
                            System.out.println("Quit? Type \"666\"");
                            System.out.println(game.getBoardLayout());

                            int row, col;
                            try {
                                if (game.getCurrentPlayer() instanceof ComputerPlayer) {
                                    row = 0;
                                    col = 0;
                                    game.makeMove(row, col);

                                } else {
                                    System.out.println(game.getCurrentPlayerName() + ": Enter your move (e.g. \"1A\")");
                                    String move = sc.next().toUpperCase();

                                    if (move.equalsIgnoreCase("666")) {
                                        row = 666;
                                        col = 666;
                                    } else {
                                        row = Character.getNumericValue(move.charAt(0)) - 1;
                                        char column = move.charAt(1);
                                        col = (int) column - 'A';
                                    }

                                    if (!game.makeMove(row, col)) {
                                        continue;
                                    }

                                    if (move.equalsIgnoreCase("666")) {
                                        if (game.getCurrentPlayer().getNumberOfWins()
                                                > game.getOtherPlayer().getNumberOfWins()) {
                                            System.out.println(game.getCurrentPlayerName() + " decided to quit the game!"
                                                    + "\nAnd the winner of the whole session is...." + "\n\uD83C\uDF1F"
                                                    + game.getCurrentPlayerName() + "\uD83C\uDF1F with "
                                                    + game.getCurrentPlayer().getNumberOfWins() + " points! Congratulations!\n" +
                                                    game.getOtherPlayerName() + " placed second with " +
                                                    game.getOtherPlayer().getNumberOfWins() + " points. Better luck next time!");
                                            isRunning = false;
                                        } else if (game.getCurrentPlayer().getNumberOfWins() ==
                                                game.getOtherPlayer().getNumberOfWins()) {
                                            System.out.println(game.getCurrentPlayerName() + " decided to quit the game!"
                                                    + "\nAnd the winner of the whole session is...." + "\n\uD83C\uDF1F"
                                                    + "Equality!\uD83C\uDF1F\nBoth " + game.getCurrentPlayerName() +
                                                    " and " + game.getOtherPlayerName() + " won "
                                                    + game.getCurrentPlayer().getNumberOfWins() + " "
                                                    + game.getCurrentPlayer().getWinningTimesText());
                                            isRunning = false;
                                        }
                                    }


                                    if (game.hasPlayerWon()) {
                                        System.out.println(game.getBoardLayout());
                                        game.getCurrentPlayer().increaseWins();
                                        System.out.println(game.getCurrentPlayerName() + " has won");
                                        System.out.println("Round finished! The winner is: \uD83C\uDF89" +
                                                game.getCurrentPlayerName()
                                                + "\uD83C\uDF89 and his " + game.getCurrentPlayer().getSymbol() +
                                                ". They have now won " + game.getCurrentPlayer().getNumberOfWins()
                                                + " " + game.getCurrentPlayer().getWinningTimesText() + "!"
                                                + "\n" + game.getOtherPlayerName() + " sits with "
                                                + game.getOtherPlayer().getNumberOfWins() + " points so far.");

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
                                }
                                game.switchPlayer();
                            } catch (InputMismatchException | StringIndexOutOfBoundsException inputExc) {
                                System.out.println("Invalid input, try again.");
                                sc.nextLine();
                            }
                        }
                    } while (isRunning);
                }


                case 2 -> {
                    boolean isRunning = true;
                    Game game = new Game();
                    game.CreatePlayers(false);

                    do {
                        while (isRunning) {
                            System.out.println("(Quit? Type \"666\")");
                            System.out.println(game.getBoardLayout());

                            try {
                                System.out.print(game.getCurrentPlayerName() + ": Enter your move (e.g. \"1A\"): ");
                                String move = sc.next().toUpperCase();


                                int row;
                                int col;
                                if (move.equalsIgnoreCase("666")) {
                                    row = 666;
                                    col = 666;
                                } else {
                                    row = Character.getNumericValue(move.charAt(0)) - 1;
                                    char column = move.charAt(1);
                                    col = (int) column - 'A';
                                }

                                if (!game.makeMove(row, col)) {
                                    continue;
                                }

                                if (move.equalsIgnoreCase("666")) {
                                    if (game.getCurrentPlayer().getNumberOfWins()
                                            > game.getOtherPlayer().getNumberOfWins()) {
                                        System.out.println(game.getCurrentPlayerName() + " decided to quit the game!"
                                                + "\nAnd the winner of the whole session is...." + "\n\uD83C\uDF1F"
                                                + game.getCurrentPlayerName() + "\uD83C\uDF1F with "
                                                + game.getCurrentPlayer().getNumberOfWins() + " points! Congratulations!\n" +
                                                game.getOtherPlayerName() + " placed second with " +
                                                game.getOtherPlayer().getNumberOfWins() + " points. Better luck next time!");
                                        isRunning = false;
                                    } else if (game.getCurrentPlayer().getNumberOfWins() ==
                                            game.getOtherPlayer().getNumberOfWins()) {
                                        System.out.println(game.getCurrentPlayerName() + " decided to quit the game!"
                                                + "\nAnd the winner of the whole session is...." + "\n\uD83C\uDF1F"
                                                + "Equality!\uD83C\uDF1F\nBoth " + game.getCurrentPlayerName() +
                                                " and " + game.getOtherPlayerName() + " won "
                                                + game.getCurrentPlayer().getNumberOfWins() + " "
                                                + game.getCurrentPlayer().getWinningTimesText());
                                        isRunning = false;
                                    }
                                }

                                if (game.hasPlayerWon()) {
                                    System.out.println(game.getBoardLayout());
                                    game.getCurrentPlayer().increaseWins();
                                    System.out.println("Round finished! The winner is: \uD83C\uDF89" +
                                            game.getCurrentPlayerName()
                                            + "\uD83C\uDF89 and his " + game.getCurrentPlayer().getSymbol() +
                                            ". They have now won " + game.getCurrentPlayer().getNumberOfWins()
                                            + " " + game.getCurrentPlayer().getWinningTimesText() + "!"
                                            + "\n" + game.getOtherPlayerName() + " sits with "
                                            + game.getOtherPlayer().getNumberOfWins() + " points so far.");

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