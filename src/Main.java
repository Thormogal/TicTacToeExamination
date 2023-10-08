import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Imports the switch from the Menu.java class.
        Menu menuInstance = new Menu();
        Menu.SwitchClass switchInstance = menuInstance.new SwitchClass();
        int menuUserChoice;

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Hello and welcome to this lovely game called Tic Tac Toe.
                The goal of the game is for you to get three symbols in a row before
                your opponent. You get one move each per round.
                It is a tie if the field is totally cluttered with symbols without three of the
                same symbols in a row.
                First of all, please select one of the following by typing the corresponding number:
                1. Play against the computer. 💻
                2. Play local against a friend. 😎
                """);

        boolean invalidInput = true;
        while (invalidInput) {
            try {
                menuUserChoice = sc.nextInt();
                if (menuUserChoice == 1 || menuUserChoice == 2) {
                    switchInstance.runSwitch(menuUserChoice); //runs the switch that is made within the Menu.java class.
                    invalidInput = false;
                } else {
                    System.out.println("You can't fool me. This program only works" +
                            " with number \"1\" or number \"2\"." + "\nPlease pick number 1 or 2: ");
                }
            } catch (InputMismatchException inputExc) {
                System.out.println("""
                        Expecting an error did you?
                        Try again with either number "1" or number "2".
                        Please pick number 1 or 2:""");
                sc.next();
            }
        }
    }
}