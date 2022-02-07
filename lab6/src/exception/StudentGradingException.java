package exception;

import java.io.*;

import model.Student;

public class StudentGradingException extends Exception {
	private int errorNo;
	private String errorMsg;

	public StudentGradingException(int errorNo, String errorMsg) {
		super();
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
		printProblem(); // Prints issue upon instantiation
	}

	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void printProblem() { // Log exceptions to ProblemLog.txt in data\output\ folder
		System.out.printf(">> Encountered exception: %d - %s %n    > Fixed and logged to ProblemLog.txt %n", errorNo,
				errorMsg); // Prints exception message to console

		try {
			FileWriter file = new FileWriter("C:\\Users\\rubsy\\git\\Lab6\\data\\output\\ProblemLog.txt", true);
			// Boolean allows for exception to append to end of Problem.txt
			BufferedWriter buff = new BufferedWriter(file);
			PrintWriter print = new PrintWriter(buff);
			print.printf("%n>> Encountered exception: %d - %s", errorNo, errorMsg);
			print.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}

	public Student[] fix(String fileName, Student[] newArr) {
		Helper h1; // Parent Helper class has a child class for each unique exception
		Student[] dataArr = newArr;
		switch (errorNo) { // Switch/case for possible addition of other custom exceptions
		case 1:
			return dataArr;
		case 2: // Exception for when StudentData.txt is missing header row
			h1 = new Helper2();
			dataArr = h1.fixMissingHeader(fileName, dataArr);
			return dataArr;
		case 3:
			return dataArr;
		case 4:
			return dataArr;
		default:
			return dataArr;
		}
	}
}
