public class NoMethod {
    public static void main(String[] args) {
        char[] values = { 'a', 'b', 'c', 'd', 'e' };
        System.out.print("Index: ");
        int index = In.nextInt();
        while ((index < 0) || (index >= values.length)) {
            System.out.println("  Index is 0-" + (values.length - 1));
            System.out.print("Index: ");
            index = In.nextInt();
        }
        System.out.println("  You chose " + values[index]);
    }
}
