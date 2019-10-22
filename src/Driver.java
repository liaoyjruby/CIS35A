
public class Driver {

	public static void main(String[] args) {
		// Windows: C:\\Users\\rubsy\\git\\Lab3\\src\\Salesdat.txt
		// Linux: /home/ruby/git/Lab3/src/Salesdat.txt
		FileIO a1 = new FileIO("/home/ruby/git/Lab3/src/Salesdat.txt"); // Put appropriate fully-qualified file path
		Franchise f = a1.readData(); // returns franchise information
		System.out.println("Reading data done!");
	}

}
