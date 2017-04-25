/**
 * This program displays a circle.
 *
 * It looks a little wonky for small radii.
 */
public class Circle {
	public static void main(String[] args) {
		System.out.print("Radius: ");
		int radius = In.nextInt();
		showCircle(radius);
	}

	private static void showCircle(int radius) {
		for (int y = -radius; y <= radius; y++) {
			int x = (int)(Math.sqrt(radius*radius - y*y));
			showLine(2*x, 2*radius);
		}
	}

	private static void showLine(int howManyStars, int size) {
		int howManySpaces = (size - howManyStars)/2;
		repeat(howManySpaces, ' ');
		repeat(howManyStars, '*');
		System.out.println();
	}

	private static void repeat(int n, char c) {
		for (int i = 0; i < n; i++) {
			System.out.print(c + " ");
		}
	}
}
