
public class Driver {

	public static void main(String[] args) {
		Simulation s1 = new Simulation();

		System.out.printf("Coin Toss Simulator! :^)");

		// Toss Coin 1 "quarter" and print
		Coin quarter = new Coin();
		s1.tossForSimulation(quarter);
		s1.printSimulation(quarter);

		// Toss Coin 2 "dime" and print
		Coin dime = new Coin();
		s1.tossForSimulation(dime);
		s1.printSimulation(dime);

		// Toss Coin 3 "nickel" and print
		Coin nickel = new Coin();
		s1.tossForSimulation(nickel);
		s1.printSimulation(nickel);

		System.out.printf("\n\nCoin tosses complete!\n ");
	}

}
