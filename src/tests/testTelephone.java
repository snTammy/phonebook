package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pb.*;

public class testTelephone {

	
	@Test
	public void test_printPhone() {
//		Telephone t1 = new Telephone().setTelephoneNum(6366435698L);
		Telephone t1 = new Telephone(6366435698L);
		
		String formatted_tele1 = "(636) 643-5698";
		
		String tele1 = t1.printPhone();

		assertEquals(formatted_tele1, tele1);
		
//		John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
//		John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
//		John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375

	}	
}
