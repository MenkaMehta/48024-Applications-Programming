import java.util.*;

public class Dealer implements Person {
    public static void main(String[] args) { new Dealer().use(); }
    private Deck deck;
    private Hand hand;
    private LinkedList<Player> players = new LinkedList<Player>();
    private LinkedList<Person> everyone = new LinkedList<Person>();

    public Dealer() {
        deck = new Deck();
        hand = new Hand();
        players.add(new Player("Jack"));
        players.add(new Player("Jill"));
        everyone.addAll(players);
        everyone.add(this);
    }

    private void use() {
        shuffle();
        deal();
        deal();
        if (!hand.isBlackjack())
            goRound();
        decide();
    }

    private void shuffle() {
        deck.shuffle();
    }

    private void deal() {
        for (Person person : everyone)
            person.drawCard(deck);
    }

    private void goRound() {
        System.out.println(this);
        for (Person person : everyone)
            person.haveTurn(deck);
    }
    
    @Override
    public void drawCard(Deck deck) {
        hand.add(deck.removeCard());
        if (hand.busted()) {
            System.out.println("Dealer busts with " + hand + "!");
        }
    }
    
    @Override
    public void haveTurn(Deck deck) {
        while (hand.value() < 17)
            drawCard(deck);
    }

    private void decide() {
        if (!hand.busted())
            System.out.println(this);
        for (Player player : players)
            player.decide(hand);
    }

    @Override
    public String toString() {
        return "Dealer has " + hand;
    }
}
