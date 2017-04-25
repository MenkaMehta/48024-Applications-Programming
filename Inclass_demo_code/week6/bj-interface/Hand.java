import java.util.*;

public class Hand {
    private LinkedList<Card> cards = new LinkedList<Card>();

    public Hand() {
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int value() {
        int total = 0;
        for (Card card : cards)
            total += card.value();
        return total;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && has(1) && has(10);
    }

    public boolean has(int value) {
        for (Card card : cards)
            if (card.hasValue(value))
                return true;
        return false;
    }

    public boolean busted() {
        return value() > 21;
    }

    public boolean beats(Hand other) {
        return !busted() && (value() > other.value() || other.busted());
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards)
            s += card + " ";
        return s.trim() + ": " + value();
    }
}
