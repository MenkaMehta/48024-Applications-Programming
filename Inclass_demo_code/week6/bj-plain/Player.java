public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.removeCard());
        if (hand.busted())
            System.out.println(name + " busts with " + hand + "!");
    }

    public void haveTurn(Deck deck) {
        char choice;
        while (!hand.busted() && (choice = readChoice()) != 's') {
            switch (choice) {
            case 'd': drawCard(deck); break;
            default: help(); break;
            }
        }
    }

    private char readChoice() {
        System.out.print(name + " has " + hand + " - choice (d/s): ");
        return In.nextChar();
    }

    public void decide(Hand dealerHand) {
        if (hand.beats(dealerHand))
            System.out.println(name + " wins with " + hand + "!");
        else if (!hand.busted())
            System.out.println(name + " loses with " + hand + ".");
    }

    private void help() {
        System.out.println("Player menu options:");
        System.out.println("d = draw");
        System.out.println("s = stand");
    }

    @Override
    public String toString() {
        return name + " has " + hand;
    }
}
