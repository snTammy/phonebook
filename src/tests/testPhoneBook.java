package tests;
import pb.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class testPhoneBook {
	/*  Test cases:
	 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
	 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
	 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
	 */
	
	
	@Test
	public void test_addPerson() {
		Address a1 = new Address();
		a1.setStreet("112 Lloyd Ave");
		a1.setCity("St Louis");
		a1.setState("MO");
		a1.setZipcode(63403);
		Person p1 = new Person("Kathleen Madigan", a1, 6366435698L);
		
		PhoneBook pb = new PhoneBook();
		pb.loadEntries();
		pb.addPerson(p1);
		
		
	}
	@Test
	public void test_search() {
		Address a1 = new Address();
		a1.setStreet("112 Lloyd Ave");
		a1.setCity("St Louis");
		a1.setState("MO");
		a1.setZipcode(63403);
		Person p1 = new Person("Kathleen Madigan", a1, 6366435698L);
		
		PhoneBook pb = new PhoneBook();
		pb.loadEntries();
		pb.addPerson(p1);
		
		//pb should have 4 entries at this point
		
		Person[] updatedPb = new Person[pb.getPeople().length];
		updatedPb = pb.search("John");
		//but have 3 John(s)
		assertEquals(3, updatedPb.length);
		
		
	}
	
	
	
	
	
	
	
}