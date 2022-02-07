public class Franchise {
	private Store[] stores; // Array of objects; array of Store is a "property" of franchises

	public Franchise(int num) {
		stores = new Store[num]; // a franchise contains int num number of stores
	}

	// Getter for Stores[]
	public Store getStores(int i) {
		return stores[i];
	}

	// Setter for Stores[]
	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}

	// Returns number of Stores saved in Stores[]
	public int numberOfStores() {
		return stores.length;
	}

	// Runs all calculations from Store.java file
	public void computeData() {
		for (int i = 0; i < stores.length; i++) {
			stores[i].analyzeResults(); // analyzeResults() method is in Store class
		}
	}

}
