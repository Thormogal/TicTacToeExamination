public class Player {
    private final String name;
    private final char symbol;
    private int points;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void increasePoints() {
        this.points++;
    }

    public int getNumberOfWins() {
        return this.points;
    }
    public String getWinningTimesText() {
        if (this.getNumberOfWins() == 1) {
            return "time";
        } else {
            return "times";
        }
    }
}