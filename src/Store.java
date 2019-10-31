public class Store {
	private float[][] salesByWeek; // Data populated by FileIO.java
	private float[] totalSalesByWeek; // a
	private float[] avgDailySales; // b
	private float totalSales; // c
	private float avgWeeklySales; // d
	private float[] highestSaleWeek; // e
	private float[] lowestSaleWeek; // f

	Store() {
		salesByWeek = new float[5][7];
	}

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

	public float[] totalSalesByWeek() { // store sum of week's days into single dim array
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
		highestSaleWeek[1] = selectSort(totalSalesByWeek)[totalSalesByWeek.length - 1]; // Last value of
																						// totalSalesByWeek sorted in
																						// ascending order
		highestSaleWeek[0] = seqSearch(totalSalesByWeek, highestSaleWeek[1]) + 1;
		return highestSaleWeek;
	}

	public float[] lowestSaleWeek() { // [0] is for week #, [1] is for value at week #
		lowestSaleWeek = new float[2];
		lowestSaleWeek[1] = selectSort(totalSalesByWeek)[0]; // First value of totalSalesByWeek sorted in ascending
																// order
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

	public void print(Franchise f, int store, int option) {
		switch (option) {
		case 1:
			System.out.printf("\nTotal sales by week:");
			for (int i = 0; i < f.getStores(store).totalSalesByWeek.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, f.getStores(store).totalSalesByWeek[i]);
			}
			break;
		case 2:
			System.out.printf("\nAverage daily sale by week:");
			for (int i = 0; i < f.getStores(store).avgDailySales.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, f.getStores(store).avgDailySales[i]);
			}
			break;
		case 3:
			System.out.printf("\nTotal sales for all weeks: $%1.2f", f.getStores(store).totalSales);
			break;
		case 4:
			System.out.printf("\nAverage weekly sales: $%1.2f", f.getStores(store).avgWeeklySales);
			break;
		case 5:
			System.out.printf("\nWeek with highest sales:\n Week %d: $%1.2f",
					(int) f.getStores(store).highestSaleWeek[0], f.getStores(store).highestSaleWeek[1]);
			break;
		case 6:
			System.out.printf("\nWeek with lowest sales:\n Week %d: $%1.2f", (int) f.getStores(store).lowestSaleWeek[0],
					f.getStores(store).lowestSaleWeek[1]);
			break;
		case 7:
			System.out.printf("\nShowing all: ");
			//Case 1
			System.out.printf("\n\nTotal sales by week:");
			for (int i = 0; i < f.getStores(store).totalSalesByWeek.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, f.getStores(store).totalSalesByWeek[i]);
			}
			//Case 2
			System.out.printf("\n\nAverage daily sale by week:");
			for (int i = 0; i < f.getStores(store).avgDailySales.length; i++) {
				System.out.printf("\n  Week %d: $%1.2f", i + 1, f.getStores(store).avgDailySales[i]);
			}
			//Case 3
			System.out.printf("\n\nTotal sales for all weeks: $%1.2f", f.getStores(store).totalSales);
			//Case 4
			System.out.printf("\n\nAverage weekly sales: $%1.2f", f.getStores(store).avgWeeklySales);
			//Case 5
			System.out.printf("\n\nWeek with highest sales:\n  Week %d: $%1.2f",
					(int) f.getStores(store).highestSaleWeek[0], f.getStores(store).highestSaleWeek[1]);
			//Case 6
			System.out.printf("\n\nWeek with lowest sales:\n  Week %d: $%1.2f", (int) f.getStores(store).lowestSaleWeek[0],
					f.getStores(store).lowestSaleWeek[1]);
			break;
		}		
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
