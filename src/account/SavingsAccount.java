package account;

public class SavingsAccount {
	private int accountNumber;
	private double savingsBalance;
	private static int annualInterestRate;

	protected SavingsAccount(double savingsBalance, int accountNumber) {
		this.savingsBalance = savingsBalance;
		this.accountNumber = accountNumber;
		System.out.printf("\nAccount (%d) starting balance: $%.2f", accountNumber, savingsBalance); // Prints starting balance at initiation
	}

	//Getters/setters
	protected int getAccountNumber() {
		return accountNumber;
	}

	protected void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	protected double getSavingsBalance() {
		return savingsBalance;
	}

	protected void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	protected static int getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	protected static void modifyInterestRate(int newIntRate) { // Change interest rate
		annualInterestRate = newIntRate;
	}

	protected void calculateMonthlyInterest() { // Calculates interest for each month and adds to balance
		double monthlyIntRate = (double) annualInterestRate / 1200; // Divided by 12 months * 100%
		double monthlyInt = monthlyIntRate * savingsBalance;
		savingsBalance += monthlyInt;
		System.out.printf("\n\n~NEW MONTH~\nAnnual Interest Rate: %d%%\nMonthly Interest Earned: $%.2f\n(%d) Balance: $%.2f",
				annualInterestRate, monthlyInt, accountNumber, savingsBalance); // Print out interest results
	}

	protected void deposit(double deposit) { // Add to savings balance
		savingsBalance += deposit;
		System.out.printf("\n\nAmount deposited: $%.2f\n(%d) Balance: $%.2f", deposit, accountNumber, savingsBalance);
	}

	protected void withdraw(double withdraw) { // Remove from savings balance
		savingsBalance -= withdraw;
		System.out.printf("\n\nAmount withdrawn: $%.2f\n(%d) Balance: $%.2f", withdraw, accountNumber, savingsBalance);
	}
}
