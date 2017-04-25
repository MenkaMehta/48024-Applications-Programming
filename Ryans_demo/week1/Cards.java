public class Cards {
	public static void main(String[] args) {
		int sum = 0;

		System.out.print("Enter card number: ");
		int card = In.nextInt();
		while (card != -1) {
			sum += card;
			System.out.print("Enter card number: ");
			card = In.nextInt();
		}
		System.out.println("Total card value = " + sum);
	}
}
