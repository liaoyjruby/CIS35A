package model;

public class Student {
	private int SID;
	private int scores[] = new int[5];
	
	public Student() { } // Constructor
	
	// Getters/setters
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public void printStudent() { // Print an individual student's information
		System.out.printf("\nStudent ID: %d", SID);
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("\n  Quiz %d: %d", i+1, scores[i]);
		}
	}	
}
