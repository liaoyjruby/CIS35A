import java.util.*;
// for user friendly interface with program
public class UI {
	
	static Scanner in = new Scanner(System.in);
	static Store st = new Store();
	
	public UI() {
		System.out.printf("Welcome to Franchise Analyzer 9000!\n\nEnter an option: ");

		int option = in.nextInt();
		st.print(option);
	}
}

	// welcome menu
	// can make user friendly by giving each store a location
	// loop for entering store number
	// ex. if they enter 9, it's invalid
	// select operation
	// use loop to check for number validation (make sure it's within range)
		// don't need to do data type validation lol
	
	/*
	 * Start with a user-friendly invitation message - 
Welcome to Franchise App etc....
We have data for 6 stores for last 5 weeks.
Loop
Select a store # you want to see analytics for - enter <1 through 6> 9
Select operation - 
1. Enter 1 for total sales for each week 
2. Enter 2 for average daily sales for each week
3. Enter 3 for total sales for all weeks
4. Enter 4 for average weekly sales
5. Enter 5 for week with the highest amount in sales. 
6. Enter 6 for week with the lowest amount in sales. 
7. Enter 7 for all analytical data. (1 through 6)
*/
