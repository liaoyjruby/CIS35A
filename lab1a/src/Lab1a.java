import java.util.Scanner;

public class Lab1a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double monthlyInterestRate, monthlyPayment, totalPayment, principal, interest, balance;
		int numberOfYears, month, annualInterestRate;
		String year = "year";

		// Prompt for balance, check for validity
		System.out.printf("Enter loan amount: ");

		while (!in.hasNextDouble()) {
			System.out.printf("\nEnter a numerical value.\n\nEnter loan amount: ");
			in.next();
		}
		balance = in.nextDouble();

		while (balance <= 0) {
			System.out.printf("\nEnter a positive value.\n\nEnter loan amount: ");
			balance = in.nextDouble();
		}

		// Prompt for numberOfYears, check for validity
		System.out.printf("\nEnter number of years: ");

		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number.\n\nEnter number of years: ");
			in.next();
		}
		numberOfYears = in.nextInt();

		while (numberOfYears <= 0) {
			System.out.printf("\nEnter a positive value.\n\nEnter number of years: ");
			numberOfYears = in.nextInt();
		}

		// Prompt for annualInterestRate, check for validity
		System.out.printf("\nEnter annual interest rate: ");
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number.\n\nEnter annual interest rate: ");
			in.next();
		}
		annualInterestRate = in.nextInt();

		while (annualInterestRate <= 0 || annualInterestRate >= 100) {
			System.out.printf("\nEnter a valid number.\n\nEnter annual interest rate: ");
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

		// Loop table contents
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