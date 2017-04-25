public class Triangle {
	public static void main(String[] args) {
		System.out.print("Size: ");
		int size = In.nextInt();
		showDiamond(size);
	}

	public static void showDiamond(int size) {
		showTop(size);
		showMiddle(size);
		showBottom(size);
	}

	public static void showTop(int size) {
		for (int length = 1; length < size; length++)
			showLine(length, size);
	}

	public static void showMiddle(int size) {
		showLine(size, size);
	}

	public static void showBottom(int size) {
		for (int length = size - 1; length >= 1; length--)
			showLine(length, size);
	}

	public static void showLine(int howManyStars, int size) {
		int howManySpaces = size - howManyStars;
		repeat(howManySpaces, " ");
		repeat(howManyStars, "* ");
		System.out.println();
	}

	public static void repeat(int howMany, String what) {
		for (int i = 0; i < howMany; i++)
			System.out.print(what);
	}
}
