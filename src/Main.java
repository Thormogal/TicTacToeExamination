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
        1. Play against the computer.
        2. Play local against a friend.
        3. Change the size of the board and how many rows of symbol that are required for a win.
        """);

        menuUserChoice = sc.nextInt();
        switchInstance.runSwitch(menuUserChoice); //runs the switch that is made within the Menu.java class.

    }
}