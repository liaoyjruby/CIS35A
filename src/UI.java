import java.util.*;

public class UI {
	// Array of String with fake store locations
	private String[] s = {"Cupertino", "Milpitas", "Mountain View", "Palo Alto", "San Jose", "Santa Clara"};

	static Scanner in = new Scanner(System.in);

	UI() { // Constructor with program title
		System.out.printf("~ PARIS BAGUETTE SALES ANALYZER ~");
	}

	public void storeMenu() { // Displays store menu options
		System.out.printf("\n\nData available for 6 stores over past 5 weeks.\n\nLocations:");
		System.out.printf("\n  1. %s\n  2. %s\n  3. %s\n  4. %s\n  5. %s\n  6. %s\nNavigation:\n  7. Exit program", s[0], s[1], s[2], s[3], s[4], s[5]);
	}

	public void dataMenu(int store) { // Displays data menu options
		System.out.printf("\nData analysis for Store %d: %s" 
				+ "\n  1. Total sales by week"
				+ "\n  2. Average daily sales by week" 
				+ "\n  3. Total sales for all weeks"
				+ "\n  4. Average weekly sales" 
				+ "\n  5. Week with highest sales" 
				+ "\n  6. Week with lowest sales"
				+ "\n  7. Analyze all (1 - 6)" 
				+ "\nNavigation:"
				+ "\n  8. Return to store selection" 
				+ "\n\nSelect data analysis (1 - 7) or return to store selection (8): ",
				store, s[store-1]);
	}

	public int storeChoice() { // Receives user input on store analysis choice
		System.out.printf("\n\nSelect a store (1 - 6) or exit (7):  ");
		int store = in.nextInt(); // Stores which store chosen by user
		while (store < 1 || store > 7) { // Validate that input is within range
			System.out.printf("\nEnter a number between 1 and 7:  ");
			store = in.nextInt();
		}
		return store;
	}

	public int dataChoice() { // Receives user input on data analysis choice
		int option = 0; // Stores which option chosen by user
		option = in.nextInt();
		while (option < 1 || option > 8) { // Validate that input is within range
			System.out.printf("\nEnter a number between 1 and 8:  ");
			option = in.nextInt();
		}
		return option;
	}
	
	public void exit() { // Program closing message
		System.out.printf("\nThank you using ~ PARIS BAGUETTE SALES ANALYZER ~\nHave a nice day! :^)");
	}
}