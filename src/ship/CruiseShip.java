package ship;

public class CruiseShip extends Ship {
	private double ticketPrice;
	private int numberOfRooms;
	private String buffetMenu, cruiseTier, musician;

	public CruiseShip(int length, int width, String name, String owner, double ticketPrice) {
		super(length, width, name, owner);
		setPorts();
		this.ticketPrice = ticketPrice;
		if (ticketPrice < 1000) { // Cruise ship properties change based on ticket price
			cruiseTier = "Budget";
			buffetMenu = "Fast Food Fiesta";
			musician = "Charli XCX";
		} else if (ticketPrice > 4000) {
			cruiseTier = "Luxury";
			buffetMenu = "Splendid Seafood Spread";
			musician = "Ludwig van Beethoven (resurrected as a hologram)";
		} else {
			cruiseTier = "Premium";
			buffetMenu = "Surf & Turf";
			musician = "Red Velvet";
		}
		numberOfRooms = (getArea() / 200) * 5; // Arbitrary value; each cabin is ~200 sq ft with 5 stories of cabins
	}

	// Getters/setters
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public void setPorts() { // Overridden; randomly generate arrival/departure ports for ship
		int ran1 = random.nextInt(6), ran2 = random.nextInt(6); // Randomly generated values to choose ports
		String[] ports = { "Glacier Bay", "Avignon", "Bora Bora", "Singapore", "Vienna", "Vancouver" }; // Different ports for Cruise
		setDepartingPort(ports[ran1]);
		setArrivalPort(ports[ran2]);
	}
	
	public void properties() { // Overridden; prints Ship properties + Cruise Ship properties
		super.properties();
		System.out.printf("\nNumber of rooms: %d\nTicket price: $%.2f\n  Cruise tier: %s\n  Buffet menu: %s\n  Entertainment: %s", numberOfRooms,
				ticketPrice, cruiseTier, buffetMenu, musician);
	}
}
