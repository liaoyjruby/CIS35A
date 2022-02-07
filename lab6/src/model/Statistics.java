package model;

import java.io.Serializable;

public class Statistics implements Serializable {
	private int[] lowScores = new int[5];
	private int[] highScores = new int[5];
	private float[] avgScores = new float[5];
	private boolean dataPresent = true;

	public Statistics() { // Constructor
		
	}

	public void checkData(Student[] dataArr) { // Boolean is used in case of 0 records
		if (dataArr[0] == null)
			dataPresent = false;
	}

	public void findLow(Student[] dataArr) { // Find lowest scores for each quiz
		if (dataPresent) {// Check against no student data NPE
			for (int i = 0; i < lowScores.length; i++) { // Access which quiz
				lowScores[i] = dataArr[0].getScore(i);
				for (int j = 1; j < dataArr.length; j++) { // Access student's score in specific quiz
					if (dataArr[j] != null) { // Stop loop when it reaches a "null" student
						if (lowScores[i] > dataArr[j].getScore(i)) { // Replaces if next value is LOWER
							lowScores[i] = dataArr[j].getScore(i);
						}
					}
				}
			}
		} else {
			System.out.printf("%nNo data to find low.");
		}
	}

	public void findHigh(Student[] dataArr) { // Find highest scores for each quiz
		if (dataPresent) {// Check against no student data NPE
			for (int i = 0; i < highScores.length; i++) { // Access which quiz
				highScores[i] = dataArr[0].getScore(i);
				for (int j = 1; j < dataArr.length; j++) { // Access student's score in specific quiz
					if (dataArr[j] != null) { // Stop loop when it reaches a "null" student
						if (highScores[i] < dataArr[j].getScore(i)) { // Replaces if next value is HIGHER
							highScores[i] = dataArr[j].getScore(i);
						}
					}
				}
			}
		} else {
			System.out.printf("%nNo data to find high.");
		}
	}

	public void findAvg(Student[] dataArr) { // Find average score for each quiz
		if (dataPresent) {// Check against no student data NPE
			for (int i = 0; i < avgScores.length; i++) {
				int sum = 0; // Stores sum of students' scores for specific quiz
				int counter = 0; // Stores number of students present
				for (int j = 0; j < dataArr.length; j++) {
					if (dataArr[j] != null) { // Stop loop when it reaches a "null" student
						sum += dataArr[j].getScore(i);
						counter++;
					}
				}
				avgScores[i] = (float) sum / counter; // Cast average of scores to a float
			}
		} else {
			System.out.printf("%nNo data to find average.");
		}
	}

	public void printStats(int option) {
		if (dataPresent) {
			switch (option) { // Options 1-4
			case 1: // Print lowScores array
				System.out.printf("%nLow scores:%n  Quiz:     1      2      3      4      5%n  Score:    ");
				for (int i = 0; i < lowScores.length; i++) {
					System.out.printf("%-7d", lowScores[i]);
				}
				break;
			case 2: // Print highScores array
				System.out.printf("%nHigh scores:%n  Quiz:     1      2      3      4      5%n  Score:    ");
				for (int i = 0; i < highScores.length; i++) {
					System.out.printf("%-7d", highScores[i]);
				}
				break;
			case 3: // Print avgScores array
				System.out.printf("%nAverage scores:%n  Quiz:     1      2      3      4      5%n  Score:    ");
				for (int i = 0; i < avgScores.length; i++) {
					System.out.printf("%-7.1f", avgScores[i]);
				}
				break;
			case 4: // Print all
				System.out.printf("%nClass Results:%n  Quiz:     1      2      3      4      5%n  Low:      ");
				for (int i = 0; i < lowScores.length; i++) {
					System.out.printf("%-7d", lowScores[i]);
				}
				System.out.printf("%n  High:     ");
				for (int i = 0; i < highScores.length; i++) {
					System.out.printf("%-7d", highScores[i]);
				}
				System.out.printf("%n  Average:  ");
				for (int i = 0; i < avgScores.length; i++) {
					System.out.printf("%-7.1f", avgScores[i]);
				}
				break;
			}
		} else {
			System.out.printf("%nNo results to print.");
		}

	}
}
