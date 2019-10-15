import java.util.*;

public class Driver {

	static Scanner in = new Scanner(System.in).useDelimiter("\\n");

	public static void main(String[] args) {

		System.out.printf("Please input personal data.");

		// Person 1
		Person a1 = new Person();
		readData(a1);
		a1.print();

		System.out.printf("\n\nNext entry:");

		// Person 2
		Person a2 = new Person();
		readData(a2);
		a2.print();

		System.out.printf("\n\nNext entry:");

		// Person 3
		Person a3 = new Person();
		readData(a3); 
		a3.print();

	}

	// Prompt for and store data inputted through Scanner
	public static void readData(Person a) {
		//Prompt for and store name as string
		System.out.printf("\n\nEnter full name: ");
		a.setName(in.next());
		
		//Prompt for and store address as string
		System.out.printf("\nEnter address: ");
		a.setAddress(in.next());
		
		//Prompt for and store age as int
		System.out.printf("\nEnter age (ex. 20): ");
		//Check for valid int input
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a whole number: ");
			in.next();
		}
		a.setAge(in.nextInt());
		a.setAge(checkNeg(a.getAge()));
		
		//Prompt for and store phone number as int
		System.out.printf("\nEnter phone number (ex.4081234567): ");
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter valid number (no punctuation): ");
			in.next();
		}
		a.setPhone(in.nextInt());
		a.setPhone(checkNeg(a.getPhone()));

	}

	//Ensure positive input value
	public static int checkNeg(int input) {
		int result = 0;
		while (input <= 0) {
			System.out.printf("\nEnter a valid value.\n\nEnter value again: ");
			input = in.nextInt();
		}
		result = input;
		return result;
	}

}
