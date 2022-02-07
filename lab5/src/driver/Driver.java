package driver;

import model.*; // Student and Statistics class
import util.*; // FileIO class

public class Driver {
	public static void main(String[] args) {

		Student[] dataArr = new Student[40]; // Student array with max 40 records
		FileIO IO = new FileIO();
		// Linux path: "/home/ruby/git/Lab5/StudentData.txt"
		// Windows path: "C:\Users\rubsy\git\Lab5\StudentData.txt" C:\\Users\\rubsy\\Documents\\CIS35A\\Lab3\\src\\Salesdat.txt
		dataArr = IO.readFile("C:\\Users\\rubsy\\Documents\\CIS35A\\Lab5\\StudentData.txt", dataArr);
		Statistics stats = new Statistics();
		stats.checkData(dataArr); // Check if there's student data present at all
		stats.findLow(dataArr);
		stats.findHigh(dataArr);
		stats.findAvg(dataArr);
		if (IO.isDEBUG()) { // Change DEBUG in line 9 FileIO.java to "true" to access
			Driver d = new Driver();
			// Print raw student data saved to dataArr
			d.printArray(dataArr, IO.isDEBUG());
			// to "true" to check other options for printStats()
			stats.printStats(1); // Low scores
			stats.printStats(2); // High scores
			stats.printStats(3); // Average scores
		}
		stats.printStats(4); // Print all scores
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
