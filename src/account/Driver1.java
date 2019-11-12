package account;

public class Driver1 {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000, 1);
		SavingsAccount saver2 = new SavingsAccount(3000, 2);
		
		SavingsAccount.modifyInterestRate(4);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		SavingsAccount.modifyInterestRate(5);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
	}
}
