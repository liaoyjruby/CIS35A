package model;

import java.io.Serializable;

public class Student implements Serializable {
	private int SID;
	private int[] scores = new int[5];

	public Student() { // Constructor
	}

	public int getSID() { // Getters/setters
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getScore(int i) {
		return scores[i];
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	public void printStudent() { // Print an individual student's information
		System.out.printf("%nStudent ID: %d%n  Quiz:     1     2     3     4     5%n  Score:    ", SID);
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%-6d", scores[i]);
		}
	}
}
