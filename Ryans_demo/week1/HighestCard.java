public class HighestCard {
	public static void main(String[] args) {
		int max = 0;

		System.out.print("Enter card number: ");
		int card = In.nextInt();
		while (card != -1) {
			if (card > max)
				max = card;
			System.out.print("Enter card number: ");
			card = In.nextInt();
		}
		System.out.println("Highest card = " + max);
	}
}
