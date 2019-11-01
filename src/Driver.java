
public class Driver {
	
	public static void main(String[] args) {
		// Windows: C:\\Users\\rubsy\\git\\Lab3\\src\\Salesdat.txt
		// Linux: /home/ruby/git/Lab3/src/Salesdat.txt
		FileIO a1 = new FileIO("/home/ruby/git/Lab3/src/Salesdat.txt"); // Put appropriate fully-qualified file path
		Franchise f = a1.readData(); // Creates new franchise object from data read by FileIO class
		// System.out.println("Reading data done!"); // Confirm data accurately read
		f.computeData(); // Computes calculations for all stores in Franchise
		
		int choice = 0;
		UI UI = new UI();
		do {
		UI.storeMenu(); // Display store menu
		choice = UI.storeChoice();
		Store store = f.getStores(choice); // Which store is chosen
		UI.dataMenu(choice);
		choice = UI.dataChoice();
		if(choice != 8) {
		store.print(choice);
		System.out.printf("\n\nEnter \"8\" to return to analysis menu: "); }}
		while (choice != 8);
		

		
		
		//f.getStores(1).print(1);
		//UI.menu(f); // Generates UI with using values stored in Franchise
		
	
	}

}
