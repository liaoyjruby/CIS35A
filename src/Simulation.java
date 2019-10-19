import java.util.*;

public class Simulation {
	private int count;

	static Scanner in = new Scanner(System.in);

	// No-args constructor
	public Simulation() {
	}

	// Loops for number of times specified by user
	public void tossForSimulation(Coin coin) {
		System.out.printf("\n\nEnter number of times to toss coin: ");
		// Ensure int input
		while (!in.hasNextInt()) {
			System.out.printf("\nEnter a positive whole number (ex. 20): ");
			in.next();
		}
		count = (in.nextInt());

		for (int i = 1; i <= count; i++) {
			coin.toss();
			System.out.printf("\nToss %d - %s", i, coin.getSideUp());
		}
	}

	// Print results after simulation
	public void printSimulation(Coin coin) {
		double percentHeads = ((double) coin.getHeads() / (double) count) * 100; // Calculate heads %
		double percentTails = ((double) coin.getTails() / (double) count) * 100; // Calculate tails %

		System.out.printf("\n\nResult after %d tosses:\nHeads: %d (%1.2f%%)\nTails: %d (%1.2f%%)", count,
				coin.getHeads(), Math.abs(percentHeads), coin.getTails(), Math.abs(percentTails));
	}

}
