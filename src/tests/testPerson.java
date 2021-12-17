package tests;
import pb.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*  Test cases:
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */

public class testPerson {

	
	@Test
	public void test_readInput() {
		Person p = new Person();
		String name1 ="John Doe, 114 Market St, St Louis, MO, 63403, 6366435698";
		String name2 = "John E Doe, 324 Main St, St Charles, MO,63303, 8475390126";
		String name3 = "John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375";
		String[] arr1=p.readInput(name1);
		String[] arr2=p.readInput(name2);
		String[] arr3=p.readInput(name3);
		assertEquals("John Doe", arr1[0]);
		assertEquals("John E Doe", arr2[0]);
		assertEquals("John Michael West Doe", arr3[0]);
	}
	
	@Test
	public void test_readName() {
		Person p = new Person();
		String name1 ="John Doe, 114 Market St, St Louis, MO, 63403, 6366435698";
		String name2 = "John E Doe, 324 Main St, St Charles, MO,63303, 8475390126";
		String name3 = "John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375";
		String johnDoe=p.readName(name1);
		String johnEdoe=p.readName(name2);
		String johnMichaelWestDoe=p.readName(name3);
		assertEquals("John Doe", johnDoe);
		assertEquals("John E Doe", johnEdoe);
		assertEquals("John Michael West Doe", johnMichaelWestDoe);
	}
}
