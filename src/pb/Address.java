package pb;
/*  Test cases:
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */
public class Address {
	
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	public Address() {
		//default constructor
	}

	public Address(String street, String city, String state, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public void updateAddress(Address a,String street, String city, String state, int zipcode ) {
		a.setStreet(street);
		a.setCity(city);
		a.setState(state);
		a.setZipcode(zipcode);
	}
	
	@Override
	public String toString() {
		return "Address:\n" + street + "\n"+ city +", " + state +" " + zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
