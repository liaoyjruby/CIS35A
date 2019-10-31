import java.util.*;

// for user friendly interface with program
public class UI {

	static Scanner in = new Scanner(System.in);
	static Store st = new Store();

	UI() {
		System.out.printf("Welcome to Franchise Analyzer 9000!");
	}

	public void menu(Franchise f) {
		System.out.printf("\n\nData available for %d stores over past 5 weeks.\n\nAnalyze store:", f.numberOfStores());
		System.out.printf(
				  "\n  1. San Jose - Saratoga Ave."
				+ "\n  2. San Jose - Story Rd."
				+ "\n  3. Cupertino"
				+ "\n  4. Palo Alto"
				+ "\n  5. Mountain View"
				+ "\n  6. Milpitas");
		System.out.printf("\n\nSelect a store (1 - %d):  ", f.numberOfStores());
		int store = in.nextInt(); // Stores which store chosen by user
		while (store < 1 || store > 6) {
			System.out.printf("\nEnter a number between 1 and %d:  ", f.numberOfStores());
			store = in.nextInt();
		}

		System.out.printf("\nStore %d selected.", store);

		int option = 0; // Stores which option chosen by user
		do { // Allows for return to data analysis menu
			System.out.printf("\n\nData analysis for Store %d:"
					+ "\n  1. Total sales by week"
					+ "\n  2. Average daily sales by week"
					+ "\n  3. Total sales for all weeks"
					+ "\n  4. Average weekly sales"
					+ "\n  5. Week with highest sales"
					+ "\n  6. Week with lowest sales"
					+ "\n  7. Analyze all (1 - 6)"
					+ "\n  8. Return to store selection"
					+ "\n\nChoose analysis (1 - 8): ", store);
			option = in.nextInt();
			while (option < 1 || option > 8) { // Check if option input is valid
				System.out.printf("\nEnter a number between 1 and 8:  ");
				store = in.nextInt();
			}
			if (option == 8)
				menu(f); // Allows for return to store selection menu
			st.print(f, store, option);
			System.out.printf("\n\nEnter \"8\" to return to analysis menu: ");
			option = in.nextInt();
		} while (option == 8);
	}
}