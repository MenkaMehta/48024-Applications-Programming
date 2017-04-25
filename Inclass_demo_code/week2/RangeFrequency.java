/**
 * This program reads in numbers and shows the frequency of
 * numbers in the range 0-9, 10-19, ..., 90-99
 */
public class RangeFrequency {
	public static void main(String[] args) {
		int[] count = new int[10];

		System.out.print("Number: ");
		int value = In.nextInt();
		while (value != -1) {
			count[value/10]++; // this is the key line of code
			System.out.print("Number: ");
			value = In.nextInt();
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(i + "0's: " + count[i]);
		}
	}
}
