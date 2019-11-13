package driver;
import ship.*;

public class Driver {
	public static void main(String[] args) {
		Ship[] shipArray = new Ship[7]; // New array of 7 ships
		// Ship parameters: int length, int width, String name, String owner
		shipArray[0] = new Ship(100, 10, "Normandy", "Shepard");
		shipArray[1] = new Ship(123, 12, "Adrestia", "Kassandra");
		// Cargo ship parameters: int length, int width, String name, String owner, String cargoType, String loadingMethod,int numberOfCranes, int numberOfContainers, double cargoValue
		shipArray[2] = new CargoShip(1300, 200, "Bubboat", "Bubbles Shipping Co.", "Canned fish", "Air dropped");
		shipArray[3] = new CargoShip(1234, 123, "Palamecia", "Sanctum Skyfleet", "Military weapons", "Ramp loaded");
		// Cruise ship parameters: int length, int width, String name, String owner, double ticketPrice
		shipArray[4] = new CruiseShip(1181, 154, "Hyperion", "Andromeda Cruises", 5678.90);
		shipArray[5] = new CruiseShip(662, 92, "Athena", "Overwatch Adventures", 123.45);
		shipArray[6] = new CruiseShip(1004, 118, "Horizon Lunar Dawn", "Andromeda Cruises", 2222.22);
		
		for (int i = 0; i < shipArray.length; i++) { // Print information of all ships
			shipArray[i].setShipNumber(i+1);
			shipArray[i].print();
		}
		
		
	}
}
