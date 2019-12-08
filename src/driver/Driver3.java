package driver;

import adapter.StudentAPIImpl;

public class Driver3 {

	public static void main(String[] args) {
		StudentAPIImpl studAPI = new StudentAPIImpl();
		// Constructor loads text file, computes statistics, creates StudentGrade, and
		// serializes StudentGrade array

		studAPI.printStudentScore(1234); // For SID 1234
		studAPI.printStatistics(1234);

		studAPI.printStudentScore(3124); // For SID 3124
		studAPI.printStatistics(3124);
	}

}
