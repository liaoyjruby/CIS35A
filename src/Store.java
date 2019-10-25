// add 7 - 8 methods here
// add 6 instance variables here

public class Store {
	private float[][] salesByWeek; // data populated within sales by week
	private float[] totalSalesByWeek; // a
	private float[] avgDailySales; // b
	private float totalSales; // c
	private float avgWeeklySales; // d
	private float[] highestSaleWeek; // e
	private float[] lowestSaleWeek; // f

	// all calculated values should be store in instance variables of Store class

	// two dim object that's 5 x 7 because 35 entries for each store=
	// # of rows = week, # of days = columns
	Store() {
		salesByWeek = new float[5][7];
	}

	// getter and setters
	// setsaleforweekdayintersection(int week, int day, float sale)
	public void setsaleforweekdayintersection(int week, int day, float sale) {
		salesByWeek[week][day] = sale;
	}

	public void printData() { // used in FileIO debug
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(salesByWeek[i][j] + " ");
			}
			System.out.println("");
		}
	}

	// ** can only do this with instance variables, and each one happens in a
	// separate method
	// float [] getsalesforentireweek(int week)
	// float getsaleforweekdayintersection(int week, int day)
	// businessmethod
	// a. totalsalesforweek - add sales of each week sum each j of that i
	// access one i frist, then
	// if you do a, B through F are based on A
	public float[] totalSalesByWeek() { // store sum of week's days into single dim array
		int weeks = 5; // find better way to count # of wks?
		totalSalesByWeek = new float[weeks];
		for (int i = 0; i < weeks; i++) {
			float weekSum = 0;
			for (int j = 0; j < salesByWeek.length; j++) {
				weekSum += salesByWeek[i][j];
			}
			totalSalesByWeek[i] = weekSum;
		}
		return totalSalesByWeek;

	}

	// b. avgsalesforweek -
	// take all values by week and divide by 7 to get daily avg
	public float[] avgDailySalesByWeek() {
		avgDailySales = new float[totalSalesByWeek.length];
		for (int i = 0; i < totalSalesByWeek.length; i++) {
			avgDailySales[i] = totalSalesByWeek[i] / 7;
		}
		return avgDailySales;

	}

	// c. totalsalesforallweeks - everything added together
	// take a and sum it up!
	public float totalSales() {
		for (int i = 0; i < totalSalesByWeek.length; i++) {
			totalSales += totalSalesByWeek[i];
		}
		return totalSales;
	}

	// d. averageweeklysales -
	// take b and add then divide by 5 ? to get everything together
	public float avgWeeklySales() {
		float avgSum = 0;
		for (int i = 0; i < avgDailySales.length; i++) {
			avgSum += avgDailySales[i];
		}
		avgWeeklySales = avgSum / 5;
		return avgWeeklySales;
	}

	// e. weekwithhighestsaleamt
	// highest value of a
	public float[] highestSaleWeek() { // [1] is for week #, [2] is for value at week #
		highestSaleWeek = new float[2];
		highestSaleWeek[1] = selectSort(totalSalesByWeek)[totalSalesByWeek.length - 1]; // Take last value of
																						// totalSalesByWeek sorted in
																						// ascending order
		highestSaleWeek[0] = seqSearch(totalSalesByWeek, highestSaleWeek[1]);
		return highestSaleWeek;
	}

	// f. weekwithlowestsaleamt
	// lowest value of a
	public float[] lowestSaleWeek() { // [1] is for week #, [2] is for value at week #
		lowestSaleWeek = new float[2];
		lowestSaleWeek[1] = selectSort(totalSalesByWeek)[0]; // Take first value of totalSalesByWeek sorted in ascending
																// order
		lowestSaleWeek[0] = seqSearch(totalSalesByWeek, lowestSaleWeek[1]) + 1;
		return lowestSaleWeek;
	}

	// call a through f, does all 6 business methods at the same time
	public void analyzeResults() { // run all sales calculations
		totalSalesByWeek(); // float[5]
		avgDailySalesByWeek(); // float[5]
		totalSales(); // float
		avgWeeklySales(); // float
		highestSaleWeek(); // float[2]
		lowestSaleWeek(); // float[2]

	}

	// print(int option) --> option is value btwn 1 through 7
	// 1 - print a; 2 - print b; ...
	public void print(int option) {
		switch (option) {
		case 1:
			System.out.printf("Total sales by week:\n");
			for (int i = 0; i < totalSalesByWeek.length; i++) {
				System.out.printf("  Week %d: $%1.2f", i + 1, totalSalesByWeek[i]);
			}
			break;
		case 2:
			System.out.printf("Average daily sale by week:\n");
			for (int i = 0; i < avgDailySales.length; i++) {
				System.out.printf("  Week %d: $%1.2f", i + 1, avgDailySales[i]);
			}
			break;
		case 3:
			System.out.printf("Total sales for all weeks: $%1.2f", totalSales);
			break;
		case 4:
			System.out.printf("Average weekly sales: $%1.2f", avgWeeklySales);
			break;
		case 5:
			System.out.printf("Week with highest sales:\n Week %d: $%1.2f", (int) highestSaleWeek[1], highestSaleWeek[2]);
			break;
		case 6:
			System.out.printf("Week with lowest sales:\n Week %d: $%1.2f", (int) lowestSaleWeek[1], lowestSaleWeek[2]);
			break;
		case 7:
			System.out.printf("Showing all: \n\n");
		default: System.out.printf("Error!!!!!");

		}
		// option is value btwn 1 through 7, with each option calling a method

	}

	// Sequential search
	private int seqSearch(float[] array, float value) {
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				return i;
			}
		}
		return -1; // for if int isn't found in array
	}

	// Ascending selection sort
	private float[] selectSort(float[] arrIn) {
		float[] arrOut = arrIn;
		for (int i = 0; i < arrOut.length - 1; i++) { // it is length-1 b/c you can't check the last value in array
														// against a next one
			float current = arrOut[i]; // Value of min
			int currentIndex = i; // Index of min

			// Finds min in list
			for (int j = i + 1; j < arrOut.length; j++) {
				if (current > arrOut[j]) {
					current = arrOut[j]; // changes current value to minimum value
					currentIndex = j; // changes current index to index of minimum value
				}
			}

			// Swap current spot with identified min value;
			if (currentIndex != i) {
				arrOut[currentIndex] = arrOut[i];
				arrOut[i] = current;
			}
		}
		return arrOut;
	}

}
