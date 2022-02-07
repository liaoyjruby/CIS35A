package ship;

import java.util.*;

public class Ship {
	private int length, width, area, shipNumber;
	private String name, owner, departingPort, arrivalPort;
	static Random random = new Random(); // For randomly generating port location

	public Ship(int length, int width, String name, String owner) { // Constructor
		shipNumber = 0;
		area = length * width;
		this.length = length;
		this.width = width;
		this.name = name;
		this.owner = owner;
		setPorts();
	}

	// Getters/setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(int shipNumber) {
		this.shipNumber = shipNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDepartingPort() {
		return departingPort;
	}

	public void setDepartingPort(String departingPort) {
		this.departingPort = departingPort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public void setPorts() { // Randomly generates arrival/departure ports for ship
		String[] ports = { "Seattle", "Oakland", "Los Angeles", "New York", "Virginia", "Miami" };
		int ran1 = random.nextInt(6), ran2 = random.nextInt(6);
		departingPort = ports[ran1];
		arrivalPort = ports[ran2];
	}

	public void identification() { // Prints basic info of ship
		System.out.printf("\n\nShip (%d) - %s\nOwner: %s", shipNumber, name, owner);
	}

	public void properties() { // Prints properties of ship
		System.out.printf("\nSize: %d square feet\n  (%d ft x %d ft)", area, length, width);
	}

	public void journey() { // Prints location or path of ship
		if (departingPort.equals(arrivalPort)) {
			System.out.printf("\n>> %s is currently docked at %s", name, departingPort);
		} else {
			System.out.printf("\n>> %s departed from %s and will arrive at %s", name, departingPort, arrivalPort);
		}
	}

	public void print() { // Print using printing methods previously defined
		identification();
		properties();
		journey();
	}
}
