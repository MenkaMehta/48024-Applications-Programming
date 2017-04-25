public class Dealer {
    public static void main(String[] args) {
        new Dealer().use();
    }
    private Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    private void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 's': shuffle(); break;
            case 'd': deal(); break;
            default: help(); break;
            }
        }
    }

    private void shuffle() {
        deck.shuffle();
    }

    private void deal() {
        Card card = deck.removeCard();
        System.out.println(card);
    }

    private void help() {
        System.out.println("Dealer menu:");
        System.out.println("s = shuffle");
        System.out.println("d = deal");
    }

    private char readChoice() {
        System.out.print("Choice (s/d/x): ");
        return In.nextChar();
    }
}
