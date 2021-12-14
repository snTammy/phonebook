package pb;

/*  Test cases:
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */
public class Person {

	private String firstName;
	private String lastName;
	private String fullName;

	private Telephone telephone;
	private long phoneNumber;
	private String formattedTelephone;
	private Address address;
	
	public Person() {
		//default constructor
	}
	
	public Person(String firstName, String lastName, Address address, long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Person(String fullName, Address address, long phoneNumber) {
		super();
		this.fullName = fullName;
		//if logic to break name into first last and middlename/middleInitial
		//this.firstName = firstName;
		//this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
//	public Person(String firstName, String lastName, long phoneNum, Address address) {
//		
//		this.firstName = firstName;
//		this.lastName = lastName;
//		//this.phoneNumber = phoneNumber;
//		this.formattedTelephone = Telephone.printPhone(phoneNum);
//		this.address = address;
//	}

//	public Person(String firstName, String lastName, Telephone tele, Address address) {
//		
//		this.firstName = firstName;
//		this.lastName = lastName;
//		//this.phoneNumber = phoneNumber;
//		this.formattedTelephone = new Telephone().printPhone(tele.getTelephoneNum());
//		this.address = address;
//	}
	
	public Person(String firstName, String lastName, Telephone tele, Address address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = tele;
		this.address = address;
	}
	
	public Person(String string, Address address2, Telephone t) {
	// TODO Auto-generated constructor stub
}

	public void assignData(String[] data) {
		//know length of [] data = 6
		String phoneLiteral = data[5].substring(data[5].lastIndexOf(" "), data[5].length());
		phoneLiteral = phoneLiteral.strip()+"L"; //strips whitespace and appends L, now can be cast to type Long
		//System.out.println(phoneLiteral);
		//this.phoneNumber = Long.parseLong(phoneLiteral);
		
		Telephone telephone = new Telephone();
		telephone.setTelephoneNum(Long.parseLong(phoneLiteral));
		
		Person p = new Person(data[0],new Address(data[1],data[2],data[3],Integer.parseInt(data[4])),Long.parseLong(phoneLiteral));
		//or alternatively
		Person person = new Person(data[0],new Address(data[1],data[2],data[3],Integer.parseInt(data[4])),telephone);
		
		//data[0] = full name, can vary
		//data[1] = street address
		//data[2] = city
		//data[3] = state
		//data[4] = zipcode
		//data[5] = phone number
		
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
		//implement to compare Person objects
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}

	
}
