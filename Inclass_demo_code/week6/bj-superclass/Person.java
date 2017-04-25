public abstract class Person {
    protected String name;
    protected Hand hand;

    public Person(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.removeCard());
        if (hand.busted()) {
            System.out.println(name + " busts with " + hand + "!");
        }
    }

    public abstract void haveTurn(Deck deck);

    @Override
    public String toString() {
        return name + " has " + hand;
    }
    
}
