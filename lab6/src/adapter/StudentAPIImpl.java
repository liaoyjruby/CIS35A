package adapter;

import driver.Driver2;
import exception.StudentGradingException;
import model.*; // Student, Statistics, StudentGrade
import util.FileIO;

public class StudentAPIImpl implements StudentAPI {

	public StudentAPIImpl() {
		System.out.printf("~ STUDENT GRADE VIEW ~ %n");

		// Load text file
		Student[] dataArr = new Student[40]; // Student array with max 40 records
		String file = "C:\\Users\\rubsy\\git\\Lab6\\data\\input\\StudentData1.txt";
		// Linux path: "/home/ruby/git/Lab6/data/input/StudentData1.txt"
		// Windows path: "C:\\Users\\rubsy\\git\\Lab6\\data\\input\\StudentData1.txt"
		FileIO IO = new FileIO();
		try {
			dataArr = IO.readFile(file, dataArr);
		} catch (StudentGradingException e) {
			dataArr = e.fix(file, dataArr); // Fix exception as encountered
		}

		// Compute statistics
		Statistics stats = new Statistics(); // Create Statistics object and populate values with its functions
		stats.checkData(dataArr);
		stats.findLow(dataArr);
		stats.findHigh(dataArr);
		stats.findAvg(dataArr);

		// Create StudentGrade with Driver2 method
		StudentGrade[] sga = new StudentGrade[40]; // Maximum of 40 student entries
		Driver2 d2 = new Driver2();
		sga = d2.buildStudentGradeArray(dataArr, stats);
		IO.serializeStudentGrade(sga);
	}

	public void printStudentScore(int SID) {
		// Reads the serialized file and prints score using SID as file name
		FileIO IO = new FileIO();
		StudentGrade studGrade = IO
				.deserializeStudentGrade("C:\\Users\\rubsy\\git\\Lab6\\data\\output\\" + SID + ".dat");
		studGrade.getStud().printStudent();
	}

	public void printStatistics(int SID) {
		// Reads serialized file and prints value for statistics (same in all files)
		FileIO IO = new FileIO();
		StudentGrade studGrade = IO
				.deserializeStudentGrade("C:\\Users\\rubsy\\git\\Lab6\\data\\output\\" + SID + ".dat");
		studGrade.getStats().printStats(4);
	}

}
