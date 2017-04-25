public class Player extends Person {
    public Player(String name) {
        super(name);
    }

    @Override
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

    private void help() {
        System.out.println("Player menu options:");
        System.out.println("d = draw");
        System.out.println("s = stand");
    }

    public void decide(Hand dealerHand) {
        if (hand.beats(dealerHand))
            System.out.println(name + " wins with " + hand + "!");
        else if (!hand.busted())
            System.out.println(name + " loses with " + hand + ".");
    }
}
