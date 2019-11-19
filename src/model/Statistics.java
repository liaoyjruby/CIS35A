package model;

public class Statistics {
	private int [] lowScores = new int [5];
	private int [] highScores = new int [5];
	private float [] avgScores = new float [5];

	public Statistics() {	} //Constructor

	void findLow(Student [] a) {
	/* This method will find the lowest score and store it in an array names lowscores. 
		nest for loop
			for each quiz score(i) // quiz score is outer loop
				lowscores[i] = a.getStudent(0).getScore(i);
				for each student(j) // student is inner loop
					if(lowScores[i] < a.getStudent(j).getScore(i));
						(lowScores[i] = a.getStudent(j).getScore(i)); */
		
				// don’t create many variables, “PFP!”
				// same strat for low, high, and avg

	}

	void findHigh(Student [] a) {
	/* This method will find the highest score and store it in an array names highscores. */
	}

	void findAvg(Student [] a) {
	/* This method will find avg score for each quiz and store it in an array names avgscores. */
	}

	//add methods to print values of instance variables.
	public void print(int i) { // i = 1 (low), i = 2 (high), i = 3 (avg), i = 4 (print everything),  i = 0 (print nothing)

}
}
