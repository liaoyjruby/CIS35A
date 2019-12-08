package util;

import java.io.*; // FileReader, BufferedReader, Serializable
import java.util.StringTokenizer;
import exception.StudentGradingException;
import model.*; // Student, StudentGrade

public class FileIO implements Serializable {

	private boolean DEBUG = false;

	public FileIO() { // Constructor
	}

	public boolean isDEBUG() { // Getter for DEBUG value
		return DEBUG;
	}

	public Student[] readFile(String fileName, Student[] dataArr) throws StudentGradingException {
		int counter = 0; // Indicates which line readFile() is on
		try {
			FileReader file = new FileReader(fileName); // Open file
			BufferedReader buff = new BufferedReader(file); // Open buffer
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				counter++; // Move to next line
				if (line == null) // When line is empty, end of file is reached and loop is exited
					eof = true;
				else {
					if (DEBUG) // Only prints what is read when DEBUG = true
						System.out.println("Reading " + line);
					if (counter == 1 && !line.contains("Stud")) {
						throw new StudentGradingException(2, "Missing Header");
					}
					if (counter > 1 && counter <= 41) // Skips first line of file, the data table header
						// Creates student object in Student[] up to the 40th record in .txt
						dataArr[counter - 2] = buildStudent(line);
				}
			}
			buff.close();
		} catch (IOException e) { // In case of exception during file reading, will print exception
			System.out.println("Error: " + e.toString());
		}
		return dataArr;
	}

	public Student buildStudent(String line) {
		Student student = new Student();
		int[] scoreArr = new int[5]; // Temporary array for storing scores read in
		StringTokenizer st = new StringTokenizer(line); // Tokenize line
		while (st.hasMoreTokens()) { // While tokens are still left in line
			student.setSID(Integer.parseInt(st.nextToken())); // First token of line is parsed to student's SID (int)
			for (int i = 0; i < scoreArr.length; i++) // Loop sets rest of tokens in respective locations of score array
			{
				scoreArr[i] = Integer.parseInt(st.nextToken()); // Remaining tokens parsed to quiz scores (int)
			}
			student.setScores(scoreArr); // Set constructed quiz score array to student's score array
		}
		return student;
	}

	public void serializeStudentGrade(StudentGrade[] sga) { // Serialize StudentGrade object as .dat file
		int counter = 0;
		while (sga[counter] != null) {
			try {
				File file = new File("C:\\Users\\rubsy\\git\\Lab6\\data\\output\\"
						+ sga[counter].getStud().getSID() + ".dat"); // SID name is passed to new file name
				FileOutputStream fileOut = new FileOutputStream(file.getAbsolutePath());
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(sga[counter]);
				objOut.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			}
			counter++; // Move on to next student in sga array
		}
	}

	public StudentGrade deserializeStudentGrade(String fileName) { // Return .dat file as StudentGrade object
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			try {
				StudentGrade studGrade = (StudentGrade) in.readObject();
				return studGrade;
			} catch (ClassNotFoundException e) {
				System.out.println("Error: " + e.toString());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
		return null; // In case exception is caught
	}
}
