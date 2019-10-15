public class Person {

	private String name;
	private String address;
	private int age;
	private int phone;

	private static int numberOfPeople = 0;
	// counter

	public Person() {
		numberOfPeople++;
	}

	public Person(String name, String address, int age, int phone) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}

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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void print() {
		System.out.printf("\nPerson %d\nName: %s\nAddress: %s\nAge: %d\nPhone number: %s\n", numberOfPeople, name,
				address, age, phone);
	}

}
