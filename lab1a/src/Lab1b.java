import java.util.Scanner;

public class Lab1b {

	/*public static double sqrt(long n) {
		
	} */
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		long n1;
		double n2;
		
		System.out.printf("Enter a positive whole number to approximate its square root: ");
		while (!in.hasNextLong()) {
			System.out.printf("\nPlease enter a positive whole number: ");
			in.next();
		}
		n1 = in.nextLong();
		System.out.println("This is n1: " + n1);
		
		n2 = (double) n1;
		

		double nextGuess, lastGuess = 1, diffGuess;

		for (diffGuess = 1; diffGuess < 0.0001;) {
			nextGuess = (lastGuess + n2 / lastGuess) / 2;
			diffGuess = nextGuess - lastGuess;
			lastGuess = nextGuess;
		}
		
		n2 = lastGuess;

		System.out.printf("\nThe approximate square root of %d is %f.", n1, n2);
	
		
	}

}
