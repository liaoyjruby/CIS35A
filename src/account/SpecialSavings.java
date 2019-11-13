package account;

public class SpecialSavings extends SavingsAccount {

	protected SpecialSavings(double savingsBalance, int accountNumber) {
		super(savingsBalance, accountNumber);
	}

	protected void calculateMonthlyInterest() { // Overridden method from SavingsAccount
		if (getSavingsBalance() > 10000) { // If balance > $10000, special interest rate applied
			double monthlyIntRate = 10.0 / 1200.0; // 10% annual interest rate / (12 months * 100%)
			double monthlyInt = monthlyIntRate * getSavingsBalance();
			setSavingsBalance(getSavingsBalance() + monthlyInt);
		System.out.printf("\n\n~NEW MONTH~\nSpecial Interest Rate: 10%%\nMonthly Interest Earned: $%.2f\n(%d) Balance: $%.2f",
					monthlyInt, getAccountNumber(), getSavingsBalance()); // Print special interest rate results
		} else {
			super.calculateMonthlyInterest(); // If balance <= $10000, regular monthly interest rate applies
		}
	}
}
