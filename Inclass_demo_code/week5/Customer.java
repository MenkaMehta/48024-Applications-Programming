import java.util.*;

public class Customer {
    public static void main(String[] args) { new Customer().use(); }

    private LinkedList<Account> accounts = new LinkedList<Account>();

    public Customer() {
    }

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 'a': add(); break;
            case 'r': remove(); break;
            case 's': select(); break;
            case 'v': view(); break;
            default: help(); break;
            }
        }
    }

    private void add() {
        Account account = new Account();
        Account existingAccount = account(account.getType());
        if (existingAccount == null)
            accounts.add(account);
        else
            System.out.println(account.getType() + " account already exists");
    }

    private void remove() {
        Account account = account(readType());
        if (account != null)
            accounts.remove(account);
        else
            System.out.println("No such account");
    }

    private String readType() {
        System.out.print("Account type: ");
        return In.nextLine();
    }

    private Account account(String type) {
        for (Account account : accounts)
            if (account.hasType(type))
                return account;
        return null;
    }

    private void select() {
        Account account = account(readType());
        if (account != null)
            account.use();
        else
            System.out.println("No such account");
    }

    private char readChoice() {
        System.out.print("Choice (a/r/s/v/x): ");
        return In.nextChar();
    }

    private void view() {
        for (Account account : accounts)
            System.out.println(account);
    }

    private void help() {
        System.out.println("Customer menu options:");
        System.out.println("a = add an account");
        System.out.println("r = remove an account");
        System.out.println("s = select an account");
        System.out.println("v = view all accounts");
        System.out.println("x = exit");
    }
}
