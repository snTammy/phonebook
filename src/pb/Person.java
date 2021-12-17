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

	private Address address;
	
	public Person() {
		//default constructor
	}
	

	public Person(String fullName, Address address, long phoneNumber) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.telephone = new Telephone(phoneNumber);
	}

	public Person(String firstName, String lastName, Telephone tele, Address address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = tele;
		this.address = address;
	}
	
	public Person(String string, Address address2, Telephone t) {
	// TODO Auto-generated constructor stub
}
	public static String[] readInput(String s) {
		//take user input and return array of tokens to assign to a person object
		String[] tokens= s.split(", ");

		return tokens;
	}
	
	public String readName(String s) {
		String[] tokens = readInput(s);
		String[] name= tokens[0].split(" ");
		
		if(name.length==2) {
			setFullName(name[0] +" "+ name[1]);
			setFirstName(name[0]);
			setLastName(name[1]);
			return getFullName();
		}
		
		if(name.length==3) {
			setFullName(name[0] +" "+ name[1]+" "+ name[2]);
			setFirstName(name[0]);
			setLastName(name[2]);
			return getFullName();
		}
		
		if(name.length==4) {
			setFullName(name[0] +" "+ name[1]+" "+ name[2] +" "+ name[3]);
			setFirstName(name[0]);
			setLastName(name[3]);
			return getFullName();
		}
		//take user input and return array of tokens to assign to a person object

		
		return "Error in name";
	}
	
	public Person assignData(String[] data) {
		//know length of [] data = 6
		String phoneLiteral = data[5].substring(data[5].lastIndexOf(" "), data[5].length());
		phoneLiteral = phoneLiteral.strip()+"L"; //strips whitespace and appends L, now can be cast to type Long
		//System.out.println(phoneLiteral);
		//this.phoneNumber = Long.parseLong(phoneLiteral);
		
		Telephone telephone = new Telephone(Long.parseLong(phoneLiteral));
				
		//handling for full name
		Person p = new Person(data[0],new Address(data[1],data[2],data[3],Integer.parseInt(data[4])),Long.parseLong(phoneLiteral));
		//or alternatively
		Person person = new Person(data[0],new Address(data[1],data[2],data[3],Integer.parseInt(data[4])),telephone);
		
		//data[0] = full name, can vary
		//data[1] = street address
		//data[2] = city
		//data[3] = state
		//data[4] = zipcode
		//data[5] = phone number
		
		return person;
		
	}
	
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		return this.getFullName()==((Person) obj).getFullName();
	}
	
	public int compareTo(Person p) {
		return this.fullName.compareTo(p.getFullName());
	}
	
	public String getSearchString() {
		return fullName + " " + address.toString() + " " 
				+ telephone.toString();
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

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Name: "+ fullName + "\nPhone number: " + telephone.printPhone() + "\n"
				+ address + "\n\n*****************************\n";
	}

	
}
