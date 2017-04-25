import java.text.*;

public class Account {
    private String type;
    private double balance;

    public Account() {
        type = readType();
        balance = readBalance();
    }

    private String readType() {
        System.out.print("Account type: ");
        return In.nextLine();
    }

    private double readBalance() {
        System.out.print("Initial " + type + " balance: $");
        return In.nextDouble();
    }

    public String getType() {
        return type;
    }

    public boolean hasType(String type) {
        return type.equals(this.type);
    }

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 'd': deposit(); break;
            case 'w': withdraw(); break;
            case 'v': view(); break;
            default: help(); break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Choice (d/w/v/x): ");
        return In.nextChar();
    }

    private void deposit() {
        balance += readAmount("deposit");
    }

    private void withdraw() {
        balance -= readAmount("withdraw");
    }

    private double readAmount(String action) {
        System.out.print("Amount to " + action + ": ");
        return In.nextDouble();
    }

    private void view() {
        System.out.println(this);
    }

    private void help() {
        System.out.println("Account menu options:");
        System.out.println("d = deposit");
        System.out.println("w = withdraw");
        System.out.println("v = view");
        System.out.println("x = exit");
    }

    @Override
    public String toString() {
        return type + " account has $" + formatted(balance);
    }

    private String formatted(double amount) {
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
