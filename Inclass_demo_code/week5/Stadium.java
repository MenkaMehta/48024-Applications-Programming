import java.text.*;
import java.util.*;

public class Stadium {
    public static void main(String[] args) {
        new Stadium().use();
    }

    private LinkedList<Group> groups = new LinkedList<Group>();

    public Stadium() {
        groups.add(new Group("front", 300, 400.0));
        groups.add(new Group("middle", 1500, 100.0));
        groups.add(new Group("back", 200, 60.0));
    }

    private void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 's': sell(); break;
            case 'v': viewGroups(); break;
            case 'i': viewIncome(); break;
            default: help(); break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Choice (s/v/i/x): ");
        return In.nextChar();
    }

    private void sell() {
        String groupName = readGroup();
        Group group = group(groupName);
        if (group != null)
            group.sell();
        else
            System.out.println("No such group");
    }

    private String readGroup() {
        System.out.print("Group: ");
        return In.nextLine();
    }

    private Group group(String name) {
        for (Group group : groups)
            if (group.hasName(name))
                return group;
        return null;
    }

    private void viewGroups() {
        for (Group group : groups)
            System.out.println(group);
    }

    private void viewIncome() {
        System.out.println("Stadium income: $" + formatted(income()));
    }

    private double income() {
        double sum = 0.0;
        for (Group group : groups)
            sum += group.income();
        return sum;
    }

    private void help() {
        System.out.println("Stadium menu options:");
        System.out.println("s = sell seats");
        System.out.println("v = view groups");
        System.out.println("i = view income");
        System.out.println("x = exit");
    }

    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
