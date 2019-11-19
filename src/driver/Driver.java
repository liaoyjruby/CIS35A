package driver;

import model.*;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {

		Student[] dataArr = new Student[40]; // make student array
		FileIO IO = new FileIO();
		//Linux: "/home/ruby/git/Lab5/StudentData.txt"
		//Windows: "  "
		dataArr = IO.readFile("/home/ruby/git/Lab5/StudentData.txt", dataArr);
		Statistics stats = new Statistics();
		stats.findLow(dataArr);
		stats.findHigh(dataArr);
		stats.findAvg(dataArr);
		//add calls to findhigh and find average
		//Print the data and statistics
	}

}
