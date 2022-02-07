import java.io.*; // Import necessary libraries
import java.util.*;

public class FileIO {
	private String fname = null; // Instance variable for file name
	private boolean DEBUG = false; // Flag to be used to turn on printlns or turn off; debugging information, see
									// what's being processed

	public FileIO(String fname) { // Constructor --> no default b/c file name can't be null
		this.fname = fname;
	}

	public Franchise readData() {
		Franchise a1 = null; // Declare Franchise object to later be populated in readData()
		int counter = 0; // Tracks number of rows in .txt file, react accordingly when in which row
		try { // Required for exception handling for check exception
			FileReader file = new FileReader(fname); // Open text file
			BufferedReader buff = new BufferedReader(file); // Associate buffer to next file; read data in small chunks
															// rather than one byte at a time (this is PFP!)
			String temp; // Used for processing the line that is read; good b/c can change value
			boolean eof = false;
			while (!eof) { // Loop 1
				String line = buff.readLine(); // Read first line
				counter++; // Increment counter
				if (line == null) // If it reaches end of file, line is null
					eof = true;
				else {
					if (DEBUG) // Every time a change is made, debug statement is printed out
						System.out.println("Reading" + line);
					if (counter == 1) { //
						temp = line; // Take the line that's read and put it into temp; original line itself is still
										// unchanged if need to be used later
						a1 = new Franchise(Integer.parseInt(temp)); // Convert first line value from temp to integer,
																	// then instantiates Franchise object with int "6"
																	// (this is in .txt file) to create 6 stores
						if (DEBUG)
							System.out.println("d  " + a1.numberOfStores());
					}
					if (counter == 2) // Ignore 2nd line, no action taken
						; // 2nd line is just the Day# header of table in Salesdat.txt
					if (counter > 2) {
						int x = buildStore(a1, (counter - 3), line); // Pass franchise object, pass counter-3, and line;
																		// counter is -3 so counter-3 = 0 so 0th store
																		// is populated
						if (DEBUG) // Get data that was just read and print it out
							System.out.println("Reading Store # " + (counter - 2) + " Number of weeks read =  " + x);
						if (DEBUG) {
							System.out.println("Data read:");
							a1.getStores(counter - 3).printData();
						}
					} // End inner if
				} // End if
			} // End loop
			buff.close(); // If it's on end of line (eof == true), file closes
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}
		return a1;
	}

	public int buildStore(Franchise a1, int counter, String temp) {
		Store tstore = new Store(); // Local variable
		String s1 = "";
		float sale = 0.0f; // Populate
		int week = 0; // Populate row of 2D array
		int day = 0; // Populate column of 2D array
		StringTokenizer st = new StringTokenizer(temp); // Temp variable has 35 values, so string tokenizer chops long
														// string into small tokens b/c delimited by spaces
		while (st.hasMoreTokens()) { // Are there values or is it null? Will become null when all tokens are taken
										// through .nextToken()
			for (day = 0; day < 7; day++) // For loop breaks single line into five rows
			{
				s1 = st.nextToken(); // Takes value from beginning of sales row and puts it into s1; will remove what
										// it takes from temp; "string chopper"
				sale = Float.parseFloat(s1); // Convert string to float
				tstore.setSaleForWeekdayIntersection(week, day, sale); // Set correct values in appropriate place in 2D
																		// array
			} // Can use try-catch block to check if data input is ok --> can implement for
				// lab 5!
			week++; // Move onto next week/row
		}
		a1.setStores(tstore, counter); // From Franchise class
		return week; // Return to tell how many weeks of data are read
	}
}
