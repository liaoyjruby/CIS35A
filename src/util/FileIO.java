package util;

import java.io.*; // FileReader, BufferedReader
import java.util.*; // StringTokenizer

import driver.Driver; // For accessing DEBUG variable
import model.Student; // For creating Student object

public class FileIO {

	public FileIO() { // Constructor
	}

	public Student[] readFile(String fileName, Student[] dataArr) {
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
					if (Driver.DEBUG) // Only prints what is read when DEBUG = true
						System.out.println("Reading " + line);
					if (counter > 1 && counter <= 41) // Skips first line of file, the data table header
						// Creates student object in Student[] up to the 40th record in .txt
						dataArr[counter - 2] = buildStudent(line);
				}
			}
			buff.close();
		} catch (IOException e) { // In case of exception during file reading, will print exception
			System.out.println("Error -- " + e.toString());
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

}
