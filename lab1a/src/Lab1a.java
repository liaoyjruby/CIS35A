import java.util.Scanner;

public class Lab1a {

	public static double checkNeg(double input) {
		//Method for preventing negative value input
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		double result = 0.0;

		while (input <= 0) {
			System.out.printf("\nEnter a valid value.\n\nEnter value again: ");
			input = in.nextDouble();
		}
		result = input;
		return result;
	}

	public static void main(String[] args) {
		// Scanner delimiter set to a new line so whitespace is not used as delimiter
		Scanner in = new Scanner(System.in).useDelimiter("\\n");

		double monthlyInterestRate, monthlyPayment, totalPayment, principal, interest, balance;
		int numberOfYears, month, annualInterestRate;
		String year = "year";

		System.out.printf("Loan Amortization Schedule\n\n");

		// Prompt for balance, check for validity
		System.out.printf("Enter loan amount: ");
		// Prevent non-double balance input
		while (!in.hasNextDouble()) {
			System.out.printf("\nEnter a numerical value.\n\nEnter loan amount (ex. 10000): ");
			in.next();
		}
		balance = in.nextDouble();
		// Prevent negative balance input
		balance = checkNeg(balance);

		// Prompt for numberOfYears, check for validity
		System.out.printf("\nEnter number of years: ");
		// Prevent non-int numberOfYears input
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number.\n\nEnter number of years (ex. 1): ");
			in.next();
		}
		numberOfYears = in.nextInt();
		// Prevent negative numberOfYears input
		numberOfYears = (int) checkNeg(numberOfYears);

		// Prompt for annualInterestRate, check for validity
		System.out.printf("\nEnter annual interest rate: ");
		// Prevent non-int annualInterestRate input
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number.\n\nEnter annual interest rate (ex. 7): ");
			in.next();
		}
		annualInterestRate = in.nextInt();
		// Prevent out of bounds annualInterestRate input
		annualInterestRate = (int) checkNeg(annualInterestRate);
		while (checkNeg(annualInterestRate) >= 100) {
			System.out.printf("\nEnter a valid value.\n\nEnter value again: ");
			annualInterestRate = in.nextInt();
		}
		monthlyInterestRate = ((double) annualInterestRate / 12.0) / 100.0;

		// Reiterate inputs
		if (numberOfYears > 1)
			year = "years";
		System.out.printf(
				"\nLoan Amount: $%-10.2f\nNumber of Years: %-1d " + year + "\nAnnual Interest Rate: %-1d%%\n\n",
				balance, numberOfYears, annualInterestRate);

		// Payment calculations
		monthlyPayment = balance * monthlyInterestRate
				/ (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
		// Derived from Listing 2.9 - ComputeLoan.java (pg. 61 of textbook)
		totalPayment = monthlyPayment * (numberOfYears * 12);
		System.out.printf("Monthly Payment: $%-10.2f\n", monthlyPayment);
		System.out.printf("Total Payment: $%-10.2f\n\n", totalPayment);

		// Determine column width based on balance input length
		int width = String.valueOf(balance).length() + 10;

		// Display table header
		System.out.printf("%-" + width + "s%-" + width + "s%-" + width + "s%-" + width + "s\n", "Payment", "Interest",
				"Principal", "Balance");

		// Loop table contents with monetary calculations
		for (month = 1; month <= numberOfYears * 12; month++) {
			interest = monthlyInterestRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;

			System.out.printf(
					"%-" + width + "d$%-" + (width - 1) + ".2f$%-" + (width - 1) + ".2f$%-" + (width - 1) + ".2f\n",
					month, interest, principal, Math.abs(balance));
		}

	}
}