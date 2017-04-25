public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int value() {
        if (number > 10)
            return 10;
        else
            return number;
    }

    public boolean hasValue(int value) {
        return value() == value;
    }

    @Override
    public String toString() {
        return name() + suit;
    }

    private String name() {
        switch (number) {
        case 1: return "A";
        case 11: return "J";
        case 12: return "Q";
        case 13: return "K";
        default: return "" + number;
        }
    }
}
