package driver;

import model.*; // Student and Statistics class
import exception.*; // StudentGradingException, Helper, and Helper1to100 class
import util.*; // FileIO class

public class Driver1 {
	public static void main(String[] args) {

		Student[] dataArr = new Student[40]; // Student array with max 40 records
		String file = "C:\\Users\\rubsy\\git\\Lab6\\data\\input\\StudentData2.txt";
		FileIO IO = new FileIO();
		try {
            dataArr = IO.readFile(file, dataArr); // Read text file contents to Student array
        } catch(StudentGradingException e) { // Exception is encountered
            dataArr = e.fix(file, dataArr); // Fix exception as encountered
        }
		Statistics stats = new Statistics(); // Calculate statistics with data stored in Student array
		stats.checkData(dataArr); // Check if there's student data present at all
		stats.findLow(dataArr);
		stats.findHigh(dataArr);
		stats.findAvg(dataArr);
		
		if (IO.isDEBUG()) { // Change DEBUG in line 10 of FileIO.java to "true" to access
			Driver1 d = new Driver1();
			// Print raw student data saved to dataArr
			d.printArray(dataArr, IO.isDEBUG());
			stats.printStats(1); // Low scores
			stats.printStats(2); // High scores
			stats.printStats(3); // Average scores
		} 
		stats.printStats(4); // Print all scores (default)

	}

	public void printArray(Student[] dataArr, boolean DEBUG) { // Check raw data stored in student record array
		if (DEBUG) { // Only works if DEBUG = true in
			int counter = 0; // Counts number of entries stored
			try {
				for (counter = 0; counter < dataArr.length; counter++) { // Print each entry in Student[]
					dataArr[counter].printStudent();
				}
				System.out.printf("%n%d students recorded.%n", counter); // Shows # of records when no NPE encountered
			} catch (NullPointerException e) { // When NPE encountered, printing stops and shows # of records
				if (counter == 1) {
					System.out.printf("%n%d student recorded.%n", counter);
				} else {
					System.out.printf("%n%d students recorded.%n", counter);
				}
			}
		}
	}

}
