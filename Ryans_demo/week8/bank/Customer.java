public class Customer {
	private Account account;
	public Customer(String name) {
		account = new Account(name);
	}
	public Account getAccount() {
		return account;
	}
}
