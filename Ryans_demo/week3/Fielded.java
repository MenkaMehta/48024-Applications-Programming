public class Fielded {
    public static char[] values = { 'a', 'b', 'c', 'd', 'e' };

    public static void main(String[] args) {
        int index;
        while (bad(index = readIndex()))
            System.out.println("  Index must be 0-" + (values.length - 1));
        System.out.println("  You chose " + values[index]);
    }

    public static int readIndex() {
        System.out.print("Index: ");
        return In.nextInt();
    }

    public static boolean bad(int index) {
        return (index < 0) || (index >= values.length);
    }
}
