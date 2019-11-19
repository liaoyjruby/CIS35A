package util;

import java.io.*;
import java.util.*;
import model.Student;

public class FileIO {
	private boolean DEBUG = false;

	public FileIO() { // Constructor --> no default b/c file name can't be null
	}

	public Student[] readFile(String fileName, Student[] dataArr) {

		try {
			FileReader file = new FileReader("/home/ruby/git/test-git/test/ReadSource.java"); // open file
			BufferedReader buff = new BufferedReader(file); // open buffer
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else {
					if (DEBUG = true)
						System.out.println(line);
					buildStudent(dataArr, line);

				}
			}
			buff.close();
		} catch (IOException e) {d
			System.out.println("Error -- " + e.toString());
		}

		return stu;

		// Reads the file and builds student array.
		// Open the file using FileReader Object.
		// In a loop read a line using readLine method.
		// Tokenize each line using StringTokenizer Object
		// Each token is converted from String to Integer using parseInt method
		// Value is then saved in the right property of Student Object.

	}
	
	public Student buildStudent(String temp) {
		Student stud = new Student();
		String s1 = ""; // Store tokens in this String
		int[] scoreArr = new int[5]; // Set quiz scores as student score array
		
		StringTokenizer st = new StringTokenizer(temp); // Tokenize line
		while (st.hasMoreTokens()) {
			if (DEBUG = true)
				System.out.println(st.nextToken());
			for (int i = 0; i < scoreArr.length; i++) // For loop breaks single line into five rows
			{
				s1 = st.nextToken(); // Takes value from beginning of sales row and puts it into s1; will remove what
										// it takes from temp; "string chopper"
				scoreArr[i] = Integer.parseInt(s1); // Convert String to int
			} 	
			stud.setScores(scoreArr);
		}
		return stud;
		
	}

}
