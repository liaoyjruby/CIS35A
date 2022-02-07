package model;

import java.io.Serializable;

public class StudentGrade implements Serializable {
	private Student stud;
	private Statistics stats;

	public StudentGrade(Student stud, Statistics stats) { // Puts both Student and Statistics object into one object
		this.stud = stud;
		this.stats = stats;
	}

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public void printScores() {
		stud.printStudent(); // Print individual student scores
		stats.printStats(4); // Print all class statistics
	}

}
