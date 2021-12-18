package pb;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelephoneMain {

/*  Test cases:
 *  Kathleen Madigan, 112 Market St, St Louis, MO, 63403, 6364455698
 * 	John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
 *  John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
 *  John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
 */
	public static void main(String[] args) {
		PhoneBook pb = PhoneBookFactory.getInstance();
		pb.loadEntries(); //load People Objects into PhoneBook People[]


		/**********************************/
		runMenu(pb);
	}
	public static void runMenu(PhoneBook pb) {
		//pb.loadEntries();
		Scanner sc = new Scanner(System.in);
		
		boolean continueRun = true;
		do {
			displayMenu();
			
			//get user selection
		
			int choice = sc.nextInt();
	
		switch(choice) {
		case 0:
			System.out.println("Session ended");
			continueRun = false;
			break;
		case 1:
			try {
				System.out.println("add record\n".toUpperCase());
				displayAddMenu();
				//take user input :: 
				//John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
				System.out.println("Record added successfully");
				//TODO print phonebook
				printBook(pb);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error! Input must be a number!\n" + e);
			}catch(InputMismatchException e) {
				System.out.println("Error! One of your entries was in an incorrect format!\n");
				e.printStackTrace();
			}catch(NullPointerException e2) {
				System.out.println("Error! Nully!\n" + e2);
			}
			break;
		case 2:
			try {
				System.out.println("Search records\n".toUpperCase());
				displaySearchMenu();
				System.out.println(pb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				System.out.println("Delete record\n".toUpperCase());
				displayRemovePerson();
				System.out.println(pb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				System.out.println("Update record\n".toUpperCase());
				displayUpdateMenu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				System.out.println("Show all records\n".toUpperCase());
				//TODO sort phonebook
				//TODO print phonebook
				pb.sortBook();
				System.out.println(pb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			try {
				System.out.println("Exit program\n".toUpperCase());
				System.exit(0);
				continueRun = false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			throw new InputMismatchException();
			
			
		}//end switch for choice
			
		}while(continueRun);
		
	}
	public static void displaySearchMenu() {
		// print selection menu
		System.out.println("Please enter your search query to see if it exists in the phonebook or -1 to exit");
		System.out.println("*********************************************************");
		
		PhoneBook pb = PhoneBookFactory.getInstance();

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
		System.out.println("e.g. - Jane Doe, 110 Market St, St Louis, MO, 63403, 6364445698");
		System.out.println("*********************************************************");
		Person p = new Person();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		PhoneBook pb = PhoneBookFactory.getInstance();
			
		p.assignData(pb.readEntry(input));
		pb.addPerson(p);
	}
	
	
	public static void displayUpdateMenu() {
		System.out.println("Please enter the record you'd like to update in the phonebook or -1 to exit");
		System.out.println("*********************************************************");
		System.out.println("e.g. - Jane Doe, 110 Market St, St Louis, MO, 63403, 6364445698");
		System.out.println("*********************************************************\n");
		
		Person p = new Person();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		PhoneBook pb = PhoneBookFactory.getInstance();
			
		p.assignData(pb.readEntry(input));
		pb.addPerson(p);
	}
	
	public static void displayRemovePerson() {
		
		PhoneBook pb = PhoneBookFactory.getInstance();
		Scanner sc = new Scanner(System.in);
		Person[] results = new Person[pb.getPeople().length];
				
		System.out.println("Please enter criteria for the record you want deleted and press enter");
		//should be able to delete by users phone number
		//matches on phonenumber or any other portion of a record
		String nameToSearch = sc.nextLine();
		results = pb.search(nameToSearch);
//		
//		for (int i = 0; i < results.length; i++) {
//			if(results[i]!=null) {
//				System.out.println(i);
//				System.out.println(results[i].toString());
//				
//			}else {
//				System.out.println("No results match your query: " + nameToSearch);
//			}
//
//		}
		
		System.out.println("Please enter the index number for the record you desire removed then press enter");
		int indexToRemove = sc.nextInt();
		//get Person obj at this object's index as selected by user
		
		results = pb.removePerson(pb.fetchPersonAtIndex(indexToRemove));
		pb = PhoneBookFactory.getInstance(); //pull new instance after deletion event
		System.out.println("Phonebook has been updated and now reflects: \n");
		//System.out.println(pb.toString());//doesn't print correct result
		
		for (int i = 0; i < results.length; i++) {
			if(results[i]!=null) {
			System.out.println(i);
				System.out.println(results[i].toString());
				
			}else {
				System.out.println("No results match your query: " + nameToSearch);
			}

		}
		
	}
	
	public static void displayMenu() {
		// print selection menu
		System.out.println("Please select an option from the menu or enter 6 to exit");
		System.out.println("*********************************************************");
		System.out.println("\n" 
		+   "1: Add new entry " 
		+ "\t2: Search menu"
		+ "\n3: Delete an entry" 
		+ "\t4: Update an entry"
		+ "\n5: Show all records"
		+ "\n6: Exit");
}
	
	public static void printBook(PhoneBook pb) {
		Person[] personas = pb.getPeople();

		for (int i = 0; i < pb.getPeople().length; i++) {
			if(personas[i]==null) {
				break;
			}
			System.out.println(personas[i].toString());
		}


	}
}
