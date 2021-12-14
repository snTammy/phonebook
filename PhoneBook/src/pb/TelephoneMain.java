package pb;


public class TelephoneMain {

/*  Test cases:
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */
	public static void main(String[] args) {
		
//		PhoneBook pb = new PhoneBook();
//		pb.createEntries();
//		//pb.loadEntries(); //load People Objects into PhoneBook People[]
//
//		/**********************************/
//		MainMenu m = new MainMenu();
//		m.run();
		String name ="John Doe, 114 Market St, St Louis, MO, 63403, 6366435698";
		
		//take user input and return array of tokens to assign to a person object
		String[] tokens= name.split(", ");
		int length = tokens.length;
		System.out.println(length);
		for (int i = 0; i < tokens.length; i++) {
			String string = tokens[i];
			System.out.println(tokens[i]);
		}
		
		
		
		String name2 ="John E Doe, 324 Main St, St Charles, MO,63303, 8475390126";
		System.out.println(name2.substring(0, name2.indexOf(" ")));
		
		
		//System.out.println(name2.substring(name2.lastIndexOf(" "), name2.length())); //gets phone number
		String phoneLiteral = name2.substring(name2.lastIndexOf(" "), name2.length());
		phoneLiteral = phoneLiteral.strip()+"L"; //strips whitespace and appends L, now can be cast to type Long
		System.out.println(phoneLiteral);
	}

}
