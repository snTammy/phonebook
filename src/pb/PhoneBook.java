package pb;

public class PhoneBook {
	private Person[] people;

	public PhoneBook() {
		this.people = new Person[3];
	}

	public void loadEntries() {
		// generate default person objects
		/*
		 * Test cases: John Doe, 114 Market St, St Louis, MO, 63403, 6366435698 John E
		 * Doe, 324 Main St, St Charles, MO,63303, 8475390126 John Michael West Doe, 574
		 * Pole ave, St. Peters, MO, 63333, 5628592375
		 */

		// John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
		Address a1 = new Address();
		a1.setStreet("114 Market St");
		a1.setCity("St Louis");
		a1.setState("MO");
		a1.setZipcode(63403);

		Person p1 = new Person("John", "Doe", a1, 6366435698L);

		// John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
		Address a2 = new Address();
		a2.setStreet("324 Main St");
		a2.setCity("St Charles");
		a2.setState("MO");
		a2.setZipcode(63303);

		Person p2 = new Person("John", "Doe", a2, 8475390126L);

		// John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
		Address a3 = new Address();
		a3.setStreet("574 Pole ave");
		a3.setCity("St. Peters");
		a3.setState("MO");
		a3.setZipcode(63333);

		Person p3 = new Person("John", "Doe", a3, 5628592375L);
		
//		Person[] arr = getPeople();
//		
//		arr[0] = p1;
//		arr[1] = p2;
//		arr[2] = p3;
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;

	}

	public String[] readEntry(String data) {
		// parse command line entry into tokens by comma
		// String name ="John Doe, 114 Market St, St Louis, MO, 63403, 6366435698";
		String[] tokens = data.split(", ");
		int length = tokens.length;
		System.out.println(length);
		for (int i = 0; i < tokens.length; i++) {
			String string = tokens[i];
			System.out.println(tokens[i]);
		}
		return tokens;
	}

	public void sortBook() {
		//TODO
	}
	public Person[] addPerson(Person p) {
		//getPeople obj
		//get length of getPeople
		//create temp obj array of people, initialized to plus one
		//store reference to new person in last index
		//return setPeople(temp[]);
		return this.people;
	}
	public Person[] removePerson(Person p, int index) {
		//getPeople obj
		//get length of getPeople
		//create temp obj array of people, initialized to plus one
		//store reference to new person in last index
		//return setPeople(temp[]);
		return this.people;
	}
	public Person[] updatePerson(Person p, int index) {
		//getPeople obj
		//get length of getPeople
		//create temp obj array of people, initialized to plus one
		//store reference to new person in last index
		//return setPeople(temp[]);
		return this.people;
	}
	public Person[] getPeople() {
		return this.people;
	}
	
	public void setPeople(Person[] people) {
		this.people = people;
	}
}
