import java.util.*;

public class Driver {

	// If running application on Linux/Unix/MacOS system, change to .useDelimiter("\\n")
	// If running application on Windows system, change to .useDelimiter("\\r\\n")
	static Scanner in = new Scanner(System.in).useDelimiter("\\n");

	public static void main(String[] args) {
		// Store each entry in Person[] array; maximum of 10 entries
		Person[] personArray = new Person[10];
		Driver read = new Driver();

		int count = 0; // Counts how many entries are inputted, also used to access objects in array
		String next; // Used to store "Y" or "N" when asked for another entry or display of inputs

		// Loop to ask if more entries needed
		System.out.printf("Please input each person's information.");
		do {
			next = "n";
			personArray[count] = new Person();
			read.input(personArray[count]);
			System.out.printf("\nPerson %d", count + 1);
			personArray[count].print();
			count++;

			System.out.printf("\nAdd another entry? (Y/N)  > ");
			next = in.next();
			next = read.checkNext(next.substring(0, 1));
		} while (count < 10 && next.substring(0, 1).equalsIgnoreCase("y"));

		// Ask if user wants to reprint previous inputs
		System.out.printf("Input complete. Display all entries? (Y/N)  > ");
		next = in.next();
		next = read.checkNext(next.substring(0, 1));
		if (next.substring(0, 1).equalsIgnoreCase("y")) {
			read.printAll(personArray, count);
		}

	}

	// Prompt for and store data inputted through Scanner
	public void input(Person a) {
		// Prompt for and store name as String
		System.out.printf("\n\nEnter full name: ");
		a.setName(in.next());

		// Prompt for and store address as String
		System.out.printf("\nEnter address: ");
		a.setAddress(in.next());

		// Prompt for and store age as int
		System.out.printf("\nEnter age: ");
		// Ensure input is an int
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number: ");
			in.next();
		}
		a.setAge(in.nextInt());
		a.setAge(checkNeg(a.getAge()));

		// Prompt for and store phone number as string
		System.out.printf("\nEnter 10 digit phone number: ");
		a.setPhone(in.next());
		a.setPhone(checkLength(a.getPhone()));

	}

	// Ensure positive input value
	public int checkNeg(int input) {
		int result = 0;
		while (input <= 0) {
			System.out.printf("\nEnter a positive whole number (ex. 19): ");
			input = in.nextInt();
		}
		result = input;
		return result;
	}

	// Ensure 10 digit phone number input
	public String checkLength(String input) {
		while (input.length() < 10 || input.length() > 10) {
			System.out.printf("\nPlease enter a 10 digit phone number (ex.4081234567):");
			input = in.next();
		}
		String result = input;
		return result;
	}

	// Ensure input for String 'next' is "Y" or "N"
	public String checkNext(String next) {
		while (!next.equalsIgnoreCase("y") && !next.equalsIgnoreCase("n")) {
			System.out.printf("Please input either \"Y\" or \"N\":  > ");
			next = in.next();
		}
		String result = next;
		return result;
	}

	// Display all entries
	public void printAll(Person[] personArray, int entries) {
		int count;
		for (count = 0; count < entries; count++) {
			System.out.printf("\nPerson %d", count + 1);
			personArray[count].print();
		}
		System.out.printf("\nTotal entries: %d \n", entries);
	}
}
