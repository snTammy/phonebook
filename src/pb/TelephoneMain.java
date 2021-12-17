package pb;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

public class TelephoneMain {

/*  Test cases:
 *  Kathleen Madigan, 112 Market St, St Louis, MO, 63403, 6364455698
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */
	public static void main(String[] args) {
		
		PhoneBook pb = new PhoneBook();
		pb.loadEntries(); //load People Objects into PhoneBook People[]

		/**********************************/
//		PhoneBookFactory pb = new PhoneBookFactory();
//				pb.getInstance();
		
//		MainMenu m = new MainMenu();
//		m.run();
		displayAddMenu();
		displaySearchMenu();
		
//		Address a1 = new Address();
//		a1.setStreet("112 Lloyd Ave");
//		a1.setCity("St Louis");
//		a1.setState("MO");
//		a1.setZipcode(63403);
//		Person p1 = new Person("Kathleen Madigan", a1, 6364455698L);
//		pb.addPerson(p1);
//		
//		Person[] personas = pb.getPeople();
//		for (int i = 0; i < pb.getPeople().length; i++) {
//			
//			System.out.println(personas[i].toString());
//		}
//		
//			Person[] updatedPb = new Person[pb.getPeople().length];
//		//personas = pb.search("Kathleen");
//		//personas = pb.search("John");
//		personas = pb.search("6366435698");
//		//but have 3 John(s)
//		for (int i = 0; i < pb.getPeople().length; i++) {
//			if(personas[i]!=null) {
//				System.out.println(personas[i].toString());
//				
//			}
//			
//		}

	

	}
	
	public static void displaySearchMenu() {
		// print selection menu
		System.out.println("Please enter your search query to see if it exists in the phonebook or -1 to exit");
		System.out.println("*********************************************************");
		
		PhoneBook pb = new PhoneBook();
//		pb = PhoneBookFactory.getInstance();
		//PhoneBookFactory pb = new PhoneBookFactory();
		//pb.getInstance();
		Scanner sc = new Scanner(System.in);
		
		Person[] results = new Person[pb.getPeople().length];
		
		
		
		System.out.println("Please enter a name and press enter");
		String nameToSearch = sc.next();
		results = pb.search(nameToSearch);
		for (int i = 0; i < pb.getPeople().length; i++) {
			if(results[i]!=null) {
				System.out.println(results[i].toString());
				
			}else {
				System.out.println("No results match your query: " + nameToSearch);
			}

		}
			
	}

	
	public static void displayAddMenu() {
		System.out.println("Please enter the person you'd like to add to the phonebook or -1 to exit");
		System.out.println("*********************************************************");
		System.out.println("e.g. - John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
		System.out.println("*********************************************************");
		Person p = new Person();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		PhoneBook pb = new PhoneBook();
			
		p.assignData(pb.readEntry(input));
		pb.addPerson(p);
	}
}
