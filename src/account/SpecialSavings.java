package account;

public class SpecialSavings extends SavingsAccount {

	protected SpecialSavings(double savingsBalance, int accountNumber) {
		super(savingsBalance, accountNumber);
	}

	protected void calculateMonthlyInterest() {
		if (getSavingsBalance() > 10000) {
			double monthlyIntRate = 10.0 / 1200.0;
			double monthlyInt = monthlyIntRate * getSavingsBalance();
			setSavingsBalance(getSavingsBalance() + monthlyInt);
		System.out.printf("\n\n~NEW MONTH~\nSpecial Interest Rate: 10%%\nMonthly Interest Earned: $%.2f\n(%d) Balance: $%.2f",
					monthlyInt, getAccountNumber(), getSavingsBalance());
		} else {
			super.calculateMonthlyInterest();
		}
	}
}
