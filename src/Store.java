public class Store {
	private float[][] salesByWeek; // Data populated by FileIO.java
	private float[] totalSalesByWeek;
	private float[] avgDailySales;
	private float totalSales;
	private float avgWeeklySales;
	private float[] highestSaleWeek;
	private float[] lowestSaleWeek;

	// Constructor; each store has 5 weeks with 7 days per week
	Store() {
		salesByWeek = new float[5][7];
	}

	// For populating salesByWeek[][] with FileIO
	public void setSaleForWeekdayIntersection(int week, int day, float sale) {
		salesByWeek[week][day] = sale;
	}

	// Used in FileIO debug
	public void printData() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(salesByWeek[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public float[] totalSalesByWeek() {
		int weeks = 5;
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

	public float[] avgDailySalesByWeek() {
		avgDailySales = new float[totalSalesByWeek.length];
		for (int i = 0; i < totalSalesByWeek.length; i++) {
			avgDailySales[i] = totalSalesByWeek[i] / 7;
		}
		return avgDailySales;
	}

	public float totalSales() {
		for (int i = 0; i < totalSalesByWeek.length; i++) {
			totalSales += totalSalesByWeek[i];
		}
		return totalSales;
	}

	public float avgWeeklySales() {
		float avgSum = 0;
		for (int i = 0; i < avgDailySales.length; i++) {
			avgSum += avgDailySales[i];
		}
		avgWeeklySales = avgSum / 5;
		return avgWeeklySales;
	}

	public float[] highestSaleWeek() { // [0] is for week #, [1] is for value at week #
		highestSaleWeek = new float[2];
		// Stores last ($) value of totalSalesByWeek sorted in ascending order
		highestSaleWeek[1] = selectSort(totalSalesByWeek)[totalSalesByWeek.length - 1];
		// Searches for location of highest ($) value in unsorted array
		highestSaleWeek[0] = seqSearch(totalSalesByWeek, highestSaleWeek[1]) + 1;
		return highestSaleWeek;
	}

	public float[] lowestSaleWeek() { // [0] is for week #, [1] is for value at week #
		lowestSaleWeek = new float[2];
		// Stores first ($) value of totalSalesByWeek sorted in ascending order
		lowestSaleWeek[1] = selectSort(totalSalesByWeek)[0];
		// Searches for location of highest ($) value in unsorted array
		lowestSaleWeek[0] = seqSearch(totalSalesByWeek, lowestSaleWeek[1]) + 1;
		return lowestSaleWeek;
	}

	public void analyzeResults() {
		totalSalesByWeek(); // float[5]
		avgDailySalesByWeek(); // float[5]
		totalSales(); // float
		avgWeeklySales(); // float
		highestSaleWeek(); // float[2]
		lowestSaleWeek(); // float[2]
	}

	public void print(int option) {
		switch (option) {
		case 1:
			System.out.printf("\nTotal sales by week:");
			for (int i = 0; i < totalSalesByWeek.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, totalSalesByWeek[i]);
			}
			break;
		case 2:
			System.out.printf("\nAverage daily sale by week:");
			for (int i = 0; i < avgDailySales.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, avgDailySales[i]);
			}
			break;
		case 3:
			System.out.printf("\nTotal sales for all weeks: $%1.2f", totalSales);
			break;
		case 4:
			System.out.printf("\nAverage weekly sales: $%1.2f", avgWeeklySales);
			break;
		case 5:
			System.out.printf("\nWeek with highest sales:\n Week %d: $%1.2f", (int) highestSaleWeek[0],
					highestSaleWeek[1]);
			break;
		case 6:
			System.out.printf("\nWeek with lowest sales:\n Week %d: $%1.2f", (int) lowestSaleWeek[0],
					lowestSaleWeek[1]);
			break;
		case 7: // Code for previous cases copied to Case 7
			System.out.printf("\nShowing all: ");
			// Case 1
			System.out.printf("\n\nTotal sales by week:");
			for (int i = 0; i < totalSalesByWeek.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, totalSalesByWeek[i]);
			}
			// Case 2
			System.out.printf("\n\nAverage daily sale by week:");
			for (int i = 0; i < avgDailySales.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, avgDailySales[i]);
			}
			// Case 3
			System.out.printf("\n\nTotal sales for all weeks: $%1.2f", totalSales);
			// Case 4
			System.out.printf("\n\nAverage weekly sales: $%1.2f", avgWeeklySales);
			// Case 5
			System.out.printf("\n\nWeek with highest sales:\n  Week %d: $%1.2f", (int) highestSaleWeek[0],
					highestSaleWeek[1]);
			// Case 6
			System.out.printf("\n\nWeek with lowest sales:\n  Week %d: $%1.2f", (int) lowestSaleWeek[0],
					lowestSaleWeek[1]);
			break;
		}
	}

	// Sequential search method
	private int seqSearch(float[] array, float value) {
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				return i;
			}
		}
		return -1; // For if int isn't found in array
	}

	// Ascending selection sort method
	private float[] selectSort(float[] arrIn) {
		float[] arrOut = arrIn;
		for (int i = 0; i < arrOut.length - 1; i++) {
			// It is length-1 b/c you can't check the last value in array against a next one
			float current = arrOut[i]; // Value of min
			int currentIndex = i; // Index of min
			// Finds min in list
			for (int j = i + 1; j < arrOut.length; j++) {
				if (current > arrOut[j]) {
					current = arrOut[j]; // Changes current value to minimum value
					currentIndex = j; // Changes current index to index of minimum value
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
