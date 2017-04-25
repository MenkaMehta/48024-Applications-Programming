public class Royalty {
	public static void main(String[] args) {
		int count = 0;

		System.out.print("Enter card number: ");
		int card = In.nextInt();
		while (card != -1) {
			if (card > 10)
				count++;
			System.out.print("Enter card number: ");
			card = In.nextInt();
		}
		System.out.println("Number of royalty cards = " + count);
	}
}
