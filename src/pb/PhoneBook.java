package pb;

import java.util.Arrays;

public class PhoneBook {
	private Person[] people;

	public PhoneBook() {
		this.people = new Person[3];
	}

	// generate default person objects
	/*
	 * Test cases: John Doe, 114 Market St, St Louis, MO, 63403, 6366435698 
	 * John E Doe, 324 Main St, St Charles, MO,63303, 8475390126 
	 * John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
	 */
	public void loadEntries() {

		// John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
		Address a1 = new Address("114 Market St","St Louis","MO", 63403);
//		Address a1 = new Address();
//		a1.setStreet("114 Market St");
//		a1.setCity("St Louis");
//		a1.setState("MO");
//		a1.setZipcode(63403);

		Person p1 = new Person("John Doe", a1, 6366435698L);

		// John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
		Address a2 = new Address("324 Main St","St Charles","MO", 63303);
//		a2.setStreet("324 Main St");
//		a2.setCity("St Charles");
//		a2.setState("MO");
//		a2.setZipcode(63303);

		Person p2 = new Person("John E Doe", a2, 8475390126L);

		// John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
		Address a3 = new Address("574 Pole ave","St. Peters","MO", 63333);
//		a3.setStreet("574 Pole ave");
//		a3.setCity("St. Peters");
//		a3.setState("MO");
//		a3.setZipcode(63333);

		Person p3 = new Person("John Michael West Doe", a3, 5628592375L);

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

	public Person[] search(String searchTerm) {
		  Person[] listOfPeople = new Person[0];
		  for(Person p: getPeople()) {
		   if(p.getSearchString().contains(searchTerm)) {
		    listOfPeople = addToResults(listOfPeople, p);
		   }
		  }
		  return listOfPeople;

	}
	 private Person[] addToResults(Person[] list, Person p){
		  Person[] newList = new Person[list.length +1];
		  System.arraycopy(list, 0, newList, 0, list.length);
		  newList[list.length] = p;
		  return newList;
		 }
	public Person[] addPerson(Person p) {
		Person[] pb = getPeople();
		
		//create temp obj array of people, initialized to plus one
		Person[] updatedPb = new Person[pb.length +1];
		//Person[] updatedPb = java.util.Arrays.copyOfRange(pb, 0, pb.length);//getPeople obj
		
		System.arraycopy(getPeople(), 0, updatedPb, 1, pb.length);
		updatedPb[0] = p; //insert at beginning
	
		setPeople(updatedPb);
		
		return this.people;
	}

	public Person[] removePerson(Person personToRemove) {
		  Person[] people = getPeople();
		  Person[] updatedPeople = new Person[people.length - 1];
		  int offset = 0;
		  for (int i = 0; i < people.length; i++) {
		   if (people[i].equals(personToRemove)) {
		    offset = 1;
		   } else {
		    updatedPeople[i - offset] = people[i];
		   }
		  }
		  setPeople(updatedPeople);
		  return this.people;
		 }
	
	public Person[] updatePerson(Person p, int updateIndex) {
		Person[] people = getPeople();
		Person[] updatedPeople = new Person[people.length];
		int offset = 0;
		for (int i = 0; i < people.length; i++) {
			if (i == updateIndex) {
				offset = 1;
			} else {
				updatedPeople[i - offset] = people[i];
			}
		}
		setPeople(updatedPeople);
		return this.people;
	}
	public Person[] getPeople() {
		return this.people;
	}
	
	public void setPeople(Person[] people) {
		this.people = people;
	}

	public Person fetchPersonAtIndex(int i) {
		Person[] people = getPeople();
		//Person p = new Person();
		Person p = people[i];
		return p;
	}
	
	public Person[] sortBook() {

		Person[] people = getPeople();
		Arrays.sort(people);
		setPeople(people);
		return this.people;

	}
	
	@Override
	public String toString() {
		return Arrays.toString(getPeople());
	}
	
}
