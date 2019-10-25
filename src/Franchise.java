
// add 1 method here -- computeData()
public class Franchise {
	private Store stores[]; // array of objects; array of Store is a "property" of franchises
	
	public Franchise(int num) {
			stores = new Store[num]; // a franchise contains int num number of stores
	}

	// getter for Store
	public Store getStores(int i) {
		return stores[i];
	}

	// setter for Store
	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}
	
	// returns number of Stores saved
	public int numberOfStores()
	{
		return stores.length;
	}
	
	// Runs all calculations from Store.java file
	public void computeData() {
		for(int i = 0; i<stores.length; i++) {
				stores[i].analyzeResults(); // analyzeResults() method is in Store class
		}
	}
	
}
