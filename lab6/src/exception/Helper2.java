package exception;

import java.io.*;
import model.Student;
import util.*;

public class Helper2 extends Helper { // Fixes missing header
	public Student[] fixMissingHeader(String fileName, Student[] dataArr) { // Overrides method in Helper.java
		FileIO IO = new FileIO();
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
					if (IO.isDEBUG()) // Only prints what is read when DEBUG = true
						System.out.println("Reading " + line);
					if (counter > 0 && counter <= 40) // DOESN'T skip first line of file because header is missing
						// Creates student object in Student[] up to the 40th record in .txt
						dataArr[counter - 1] = IO.buildStudent(line);
				}
			}
			buff.close();
		} catch (IOException e) { // In case of exception during file reading, will print exception
			System.out.println("Error: " + e.toString());
		}
		return dataArr;
	}
}
