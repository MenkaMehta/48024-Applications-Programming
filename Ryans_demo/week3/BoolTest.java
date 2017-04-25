public class BoolTest {
    public static void main(String[] args) {
        char[] values = { 'a', 'b', 'c', 'd', 'e' };
        int index = readIndex();
        while (bad(index, values)) {
            System.out.println("  Index is 0-" + (values.length - 1));
            index = readIndex();
        }
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
