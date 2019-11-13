package account;

public class Driver2 {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SpecialSavings(2000, 1); //SpecialSavings account 1 starts with $2000.00
		SavingsAccount saver2 = new SpecialSavings(3000, 2); // SpecialSavings account 2 starts with $3000.00
		
		SavingsAccount.modifyInterestRate(4); // Set annual interest rate to 4%

		// Account 1 actions
		saver1.deposit(10000);
		saver1.calculateMonthlyInterest();
		saver1.withdraw(123.40);
		saver1.withdraw(9999.99);
		saver1.calculateMonthlyInterest();
		saver1.deposit(12345.67);
		saver1.calculateMonthlyInterest();
		
		// Account 2 actions
		saver2.calculateMonthlyInterest();
		saver2.deposit(1.23);
		saver2.deposit(2345.67);
		saver2.withdraw(5.99);
		saver2.calculateMonthlyInterest();
		saver2.deposit(5123566.12);
		saver2.calculateMonthlyInterest();

	}
}
