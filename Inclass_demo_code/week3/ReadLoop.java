public class ReadLoop {
    public static void main(String[] args) {
        char[] values = { 'a', 'b', 'c', 'd', 'e' };
        int index;
        while (bad(index = readIndex(), values))
            System.out.println("  Index must be 0-" + (values.length - 1));
        System.out.println("  You chose " + values[index]);
    }

    public static int readIndex() {
        System.out.print("Index: ");
        return In.nextInt();
    }

    public static boolean bad(int index, char[] values) {
        return (index < 0) || (index >= values.length);
    }
}
