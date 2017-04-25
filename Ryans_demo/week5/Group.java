import java.text.*;

public class Group {
    private String name;
    private int capacity;
    private double price;
    private int sold;

    public Group(String name, int capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        sold = 0;
    }

    public boolean hasName(String name) {
        return name.toLowerCase().equals(this.name.toLowerCase());
    }

    public double income() {
        return price * sold;
    }

    public void sell() {
        sold += readNumber();
    }

    private int readNumber() {
        System.out.print("Number of " + name + ": ");
        return In.nextInt();
    }

    @Override
    public String toString() {
        return left() + " " + name + " seats @ $" + formatted(price);
    }

    private int left() {
        return capacity - sold;
    }

    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
