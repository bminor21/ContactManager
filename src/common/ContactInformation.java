package common;

public class ContactInformation {
	
	/* Class variables */
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	/* Constructors */
	public ContactInformation() {}
	
	/* Copy */
	public void copyInformation( ContactInformation ref ){
		this.firstName = ref.firstName;
		this.lastName = ref.lastName;
		this.address = ref.address;
		this.city = ref.address;
		this.state = ref.state;
		this.zipCode = ref.zipCode;
	}
	
	/* Getters and Setters */
	public int getId() {
		return id;
	}
	public void setId( int i ){
		this.id = i;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String name) {
		this.lastName = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/* Utility Functions */
	
	public void getPrintLine() {
		System.out.printf("%4d | %s %s %s %s, %s %s\n", this.id, this.firstName, this.lastName, this.address, this.city, this.state, this.zipCode );
		
	}
	
	
}
