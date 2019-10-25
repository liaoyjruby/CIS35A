
public class Driver {
	
	public static void main(String[] args) {
		// Windows: C:\\Users\\rubsy\\git\\Lab3\\src\\Salesdat.txt
		// Linux: /home/ruby/git/Lab3/src/Salesdat.txt
		FileIO a1 = new FileIO("/home/ruby/git/Lab3/src/Salesdat.txt"); // Put appropriate fully-qualified file path
		Franchise f = a1.readData(); // Creates new franchise object from data read by FileIO class
		// System.out.println("Reading data done!"); // Confirm data accurately read
		f.computeData(); // compute data for entire franchise
		UI UI = new UI();
		
	
	}

}
