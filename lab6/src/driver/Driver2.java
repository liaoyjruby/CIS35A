package driver;

import exception.StudentGradingException;
import model.*; // Student, Statistics, StudentGrade
import util.FileIO;

public class Driver2 {
	public static void main(String[] args) {
		Driver2 d2 = new Driver2();
		Student[] dataArr = new Student[40]; // Student array with max 40 records
		String file = "C:\\Users\\rubsy\\git\\Lab6\\data\\input\\StudentData3.txt";
		FileIO IO = new FileIO();
		try {
			dataArr = IO.readFile(file, dataArr);
		} catch (StudentGradingException e) {
			dataArr = e.fix(file, dataArr); // Fix exception as encountered
		}

		Statistics stats = new Statistics(); // Create Statistics object and populate values with its functions
		stats.checkData(dataArr);
		stats.findLow(dataArr);
		stats.findHigh(dataArr);
		stats.findAvg(dataArr);

		StudentGrade[] sga = new StudentGrade[40]; // returns student grade array
		sga = d2.buildStudentGradeArray(dataArr, stats);
		IO.serializeStudentGrade(sga);
		d2.printScores(1234); // Reads serialized file for SID 1234
	}

	public StudentGrade[] buildStudentGradeArray(Student[] dataArr, Statistics stats) {
		// Generate StudentGrade array with Student array and Statistics information
		StudentGrade[] sga = new StudentGrade[40];
		int counter = 0;
		while (dataArr[counter] != null && counter <= 38) {
			sga[counter] = new StudentGrade(dataArr[counter], stats); // Each student has same Statistics
			counter++; // Move on to next student's StudentGrade entry
		}
		return sga;
	}

	public void printScores(int SID) { // Print serialized data depending on SID
		FileIO IO = new FileIO();
		StudentGrade studGrade = IO
				.deserializeStudentGrade("C:\\Users\\rubsy\\git\\Lab6\\data\\output\\" + SID + ".dat");
		studGrade.printScores();
	}
}
