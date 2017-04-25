/**
 * This program prints the fibonacci sequence.
 *
 * Each number is the sum of the previous two numbers:
 * 0 1 1 2 3 5 8 13 21 34 ...
 *
 * e.g. 3 + 5 = 8
 *
 * Interestingly, you can also look at it in reverse:
 *
 * 8 = 21 - 13
 *
 * And extend the series further left than zero:
 *
 * ... 5 -3 2 -1 1 0 1 1 2 3 5 8 13 21 34 ...
 *
 * So with that in mind, the following program initialises
 * prev1 and prev2 to -1 and 1 so that the very first number
 * is calculated to be zero.
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		int prev1 = -1;
		int prev2 = 1;
		int next;

		for (int i = 0; i < 10; i++) {
			next = prev1 + prev2; // This is the key line of code
			System.out.println(next);
			prev1 = prev2;
			prev2 = next;
		}
	}
}
