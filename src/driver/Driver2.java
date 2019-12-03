package driver;
import util.*

public class Driver2 {

	public static void main(String[] args) {
		Driver2 a1 = new Driver2();
		Student a2 [ ] = a1.buildStudentArray(“fname.txt”); // pass file name, return student array
		Statistics s1 = a1.computeStatistics(a2); // return statistics object, may pass in “a2” as needed
		StudentGrade [] sga == a1.buildStudentGradeArray(a2, s1); // returns student grade array
		// sga = student grade array
		FileIO f1 = new FileIO();
		f1.serializeStudentGrade(sga); // create 15 files - if 15 records in txt file
			// naming convention: <studentID>.dat
		a1.printScores(1234); // reads serialized file for “1234.dat”
			// part of driver; call method in FileIO class for reading serialized file

	}

}
