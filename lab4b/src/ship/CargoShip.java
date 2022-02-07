package ship;

public class CargoShip extends Ship {
	private String cargoType, loadingMethod;
	private int numberOfCranes, numberOfContainers;
	private double cargoValue;

	public CargoShip(int length, int width, String name, String owner, String cargoType, String loadingMethod) {
		super(length, width, name, owner);
		setPorts();
		this.cargoType = cargoType;
		this.loadingMethod = loadingMethod;
		numberOfContainers = (getArea() / 400) * 10; // Arbitrary value; container is ~ 40 x 10 sq. ft, stacked 10 high 
		numberOfCranes = length / 500; // Arbitrary value; about one crane every 500 ft
		cargoValue = numberOfContainers * 1234567.89; // Arbitrary value for value per container
	}

	//Getters/setters
	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public String getLoadingMethod() {
		return loadingMethod;
	}

	public void setLoadingMethod(String loadingMethod) {
		this.loadingMethod = loadingMethod;
	}	
	
	public void setPorts() { // Overridden method; randomly generate arrival/departure ports for cargo ship
		int ran1 = random.nextInt(6), ran2 = random.nextInt(6); // Randomly generated values to choose ports
		String[] ports = { "Shanghai", "Singapore", "Hong Kong", "Busan", "Dubai", "Los Angeles" }; // Different ports for Cargo
		setDepartingPort(ports[ran1]);
		setArrivalPort(ports[ran2]);
	}

	public void properties() { // Overridden method; prints Ship properties + Cargo Ship properties
		super.properties();
		System.out.printf("\nContainer capacity: %d\nCargo type: %s\nCargo value: $%.2f\nNumber of cranes: %d\nLoading method: %s",
				numberOfContainers, cargoType, cargoValue, numberOfCranes, loadingMethod);
	}
}
