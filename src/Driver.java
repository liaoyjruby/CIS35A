import java.util.*;

public class Driver {

	static Scanner in = new Scanner(System.in).useDelimiter("\\n");

	public static void main(String[] args) {

		// Store each entry in Person[] array; maximum of 10 entries
		Person[] personArray = new Person[10];

		// Loop to ask if more entries needed
		System.out.printf("Please input each person's information.");
		int count = 0;
		String next;
		do {
			next = "n";
			personArray[count] = new Person();
			input(personArray[count]);
			System.out.printf("\nPerson %d", count + 1);
			personArray[count].print();
			count++;

			System.out.printf("\nAdd another entry? (Y/N)  > ");
			next = in.next();
		} while (count < 10 && next.substring(0, 1).equalsIgnoreCase("y"));

		// Ask if user wants to reprint previous inputs
		System.out.printf("Input complete. Display all entries? (Y/N)  > ");
		next = in.next();
		if (next.substring(0, 1).equalsIgnoreCase("y")) {
			printAll(personArray, count);
		}

	}

	// Prompt for and store data inputted through Scanner
	public static void input(Person a) {
		// Prompt for and store name as string
		System.out.printf("\n\nEnter full name: ");
		a.setName(in.next());

		// Prompt for and store address as string
		System.out.printf("\nEnter address: ");
		a.setAddress(in.next());

		// Prompt for and store age as int
		System.out.printf("\nEnter age (ex. 20): ");
		// Check for valid int input
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number: ");
			in.next();
		}
		a.setAge(in.nextInt());
		a.setAge(checkNeg(a.getAge()));

		// Prompt for and store phone number as string
		System.out.printf("\nEnter 10-digit phone number (ex.4081234567): ");
		a.setPhone(in.next());
		a.setPhone(checkLength(a.getPhone()));

	}

	// Ensure positive input value
	public static int checkNeg(int input) {
		int result = 0;
		while (input <= 0) {
			System.out.printf("\nEnter a valid value.\n\nEnter value again: ");
			input = in.nextInt();
		}
		result = input;
		return result;
	}

	// Ensure 10 digit phone number input
	public static String checkLength(String input) {
		String result;
		while (input.length() < 10 || input.length() > 10) {
			System.out.printf("\nPlease enter a 10 digit phone number (ex.4081234567):");
			input = in.next();
		}
		result = input;
		return result;
	}

	// Display all entries
	public static void printAll(Person[] personArray, int entries) {
		int count;
		for (count = 0; count < entries; count++) {
			System.out.printf("\nPerson %d", count + 1);
			personArray[count].print();
		}
		System.out.printf("\nTotal entries: %d", entries);
	}
}
