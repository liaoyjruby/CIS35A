import java.util.*;

public class Coin {
	private String sideUp; // Either "Heads" or "Tails"
	private int heads, tails; // Counters for which sideUp

	private Random ran = new Random(); // Initialize Java's Random class to generate random value

	// No-arg constructor with randomized sideUp at initialization
	public Coin() {
		toss(); // Start with random sideUp by using toss()
		heads = 0; // Reset heads/tails counter to 0 after initial toss()
		tails = 0;
	}

	// Default constructor
	public Coin(String sideUp) {
		this.sideUp = sideUp;
	}

	// Getters/setters
	public String getSideUp() {
		return sideUp;
	}

	public void setSideUp(String sideUp) {
		this.sideUp = sideUp;
	}

	public int getHeads() {
		return heads;
	}

	public void setHeads(int heads) {
		this.heads = heads;
	}

	public int getTails() {
		return tails;
	}

	public void setTails(int tails) {
		this.tails = tails;
	}

	// Randomly changes sideUp of coin each time method is run
	public void toss() {
		int random = ran.nextInt(2); // Will randomly be "0 or "1"
		if (random == 0) {
			sideUp = "Heads";
			heads++; // Update heads counter
		} else {
			sideUp = "Tails";
			tails++; // Update tails counter
		}
	}
}
