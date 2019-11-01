
public class Driver {

	public static void main(String[] args) {
		// Windows: C:\\Users\\rubsy\\git\\Lab3\\src\\Salesdat.txt
		// Linux: /home/ruby/git/Lab3/src/Salesdat.txt
		// Change to appropriate fully-qualified file path as needed
		FileIO a1 = new FileIO("C:\\Users\\rubsy\\git\\Lab3\\src\\Salesdat.txt"); // Accesses Salesdat.txt file
		Franchise f = a1.readData(); // Creates new franchise object from data read by FileIO class
		f.computeData(); // Computes calculations for all stores in Franchise
		UI UI = new UI();

		for (int storeChoice = 0; storeChoice != 7;) { // For looping store menu
			UI.storeMenu(); // Displays store menu
			storeChoice = UI.storeChoice();
			if (storeChoice == 7)
				break; // Exits to end of program
			Store store = f.getStores(storeChoice - 1); // Saves which store is chosen

			for (int dataChoice = 0; dataChoice != 8;) { // For looping data analysis menu
				UI.dataMenu(storeChoice); // Displays analysis menu
				dataChoice = UI.dataChoice();
				if (dataChoice != 8) { // Allows for exit to either data analysis menu or store selection
					store.print(dataChoice);
					System.out.printf("\n\nNavigation:"
							+ "\n  7. Return to data analysis menu"
							+ "\n  8. Return to store selection "
							+ "\n\nEnter choice (7 or 8): ");
					dataChoice = UI.dataChoice();
				}
			}
		}
		UI.exit(); // Goodbye message
	}
}
