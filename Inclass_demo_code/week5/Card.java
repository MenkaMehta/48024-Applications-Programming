public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return cardName() + " of " + suit;
    }

    private String cardName() {
        switch (number) {
        case 13: return "King";
        case 12: return "Queen";
        case 11: return "Jack";
        case 1: return "Ace";
        default: return "" + number;
        }
    }
}
