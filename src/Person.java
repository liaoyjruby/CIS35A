public class Person {

	private String name, address, phone;
	private int age;

	// No-args constructor
	public Person() {
	}

	// Default constructor
	public Person(String name, String address, int age, String phone) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// Ensures capitalization of each word
	public String formatName(String name) {
		String nameFormat = name.substring(0, 1).toUpperCase() + name.substring(1);

		for (int i = 0; i < nameFormat.length(); i++) {
			if (nameFormat.substring(i, i + 1).equals(" ")) {
				nameFormat = nameFormat.substring(0, i + 1) + nameFormat.substring(i + 1, i + 2).toUpperCase()
						+ nameFormat.substring(i + 2);
			}
		}
		return nameFormat;
	}

	// Formats phone number to readable form
	public String formatPhone(String phone) {
		String phoneFormat = "phone";
		phoneFormat = "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6);
		return phoneFormat;
	}

	// Prints all inputs for objects
	public void print() {
		System.out.printf("\nName: %s\nAddress: %s\nAge: %d\nPhone number: %s\n", formatName(name), formatName(address),
				age, formatPhone(phone));
	}

}
