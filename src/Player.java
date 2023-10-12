public class Player {
    private final String name;
    private final char symbol;
    private int wins;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumberOfWins() {
        return this.wins;
    }

    public void increaseWins() {
        this.wins++;
    }

    public String getWinningTimesText() {
        if (this.getNumberOfWins() == 1) {
            return "time";
        } else {
            return "times";
        }
    }
}