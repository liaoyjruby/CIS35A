// Import necessary libraries
import java.io.*;
import java.util.*;

public class FileIO {
	private String fname = null; // Instance variable for file name
	private boolean DEBUG = false; // Flag to be used to turn on printlns or turn off; debugging information, see what's being processed

	public FileIO(String fname) { //constructor --> no default bc file name can't be null
		this.fname = fname;
	}

	public Franchise readData() {
		Franchise a1 = null; // declare Franchise object to later be populated in readData()
		int counter = 0; // Tracks number of rows in .txt file, react accordingly when in which row
		try { // Required for exception handling for check exception
			FileReader file = new FileReader(fname); // Open text file
			BufferedReader buff = new BufferedReader(file); // Associate buffer to next file; read data in small chunks rather than one byte at a time (this is PFP!)
			String temp; // Used for processing the line that is read; good b/c can change value
			boolean eof = false;
			while (!eof) { // loop 1
				String line = buff.readLine(); // Read first line
				counter++; // Increment counter
				if (line == null) // If it reaches end of file, line is null
					eof = true;
				else {
					if (DEBUG) // every time a change is made, debug statement is printed out
						System.out.println("Reading" + line);
					if (counter == 1) { //
						temp = line; // Take the line that's read and put it into temp; line itself is still unchanged if need to be used later
						a1 = new Franchise(Integer.parseInt(temp)); // convert first line value from temp to integer, then instantiates Franchise object with int "6" (this is in .txt file) to create 6 stores
						if (DEBUG)
							System.out.println("d  " + a1.numberOfStores());
					}
					if (counter == 2) // ignore 2nd line, no action taken
						; // 2nd line is the Day# header of table
					if (counter > 2) {
						  	int x = buildStore(a1, (counter-3), line); // Pass franchise object, pass counter-3, and line; counter is -3 so counter-3 = 0 so 0th store is populated
							if (DEBUG) // get data that was just read and print it out
								System.out.println("Reading Store # "+(counter-2)+" Number of weeks read =  " +  x);
							if (DEBUG)
							{	
								System.out.println("Data read:");
								a1.getStores(counter-3).printData();
							}
					} // end inner if
				} // end if
			} // end loop
			buff.close(); // If it's on end of line (eof = true), file closes
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}
		return a1;
	}

	public int buildStore(Franchise a1, int counter, String temp) {
		Store tstore = new Store(); // local variable
		String s1  =  "";
		float sale = 0.0f; // populate
		int week = 0; // populate row of 2d array
		int day = 0; // populate column of 2d array
		StringTokenizer st = new StringTokenizer(temp); // temp variable has 35 values, so string tokenizer chops long string into small tokesn b/c space delimited
	    while (st.hasMoreTokens()) { // are there values or is it null? will become null when all tokens are taken through .nextToken()
	         for(day=0;day<7;day++) // for loop breaks single line into five rows
	         {
		    	 s1 = st.nextToken(); // takes value from beginning of sales row and puts it into s1; will remove what it takes from temp; "string chopper"
		         sale = Float.parseFloat(s1); // convert string to float
	        	 tstore.setsaleforweekdayintersection(week, day, sale); // set correct values in appropriate place
	         } // can use try-catch block to check if data input is ok --> can implement for lab 5!
	         week++;
	    }
		a1.setStores(tstore, counter); // from franchise class
	    return week; // return to tell how many weeks of data are read
	}
}
