package account;

public class Driver1 {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000, 1); // SavingsAccount 1 starts with $2000.00
		SavingsAccount saver2 = new SavingsAccount(3000, 2); // SavingsAccount 2 starts with $3000.00
		
		SavingsAccount.modifyInterestRate(4); // Set annual interest rate to 4%
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		SavingsAccount.modifyInterestRate(5); // Set annual interest rate to 5%
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
	}
}
