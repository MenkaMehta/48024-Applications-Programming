import java.util.*;

public class Deck {
    private LinkedList<Card> cards = new LinkedList<Card>();
    public Deck() {
        for (String suit : new String[] {"C", "D", "H", "S"})
            for (int number = 1; number <= 13; number++)
                cards.add(new Card(number, suit));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        return cards.removeFirst();
    }
}
