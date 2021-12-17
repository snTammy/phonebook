package pb;
import java.util.Scanner;

/*
 * is a component of PhoneBook for Claim Academy J082021
 * author: Heather Tilley
 */
public class MainMenu {

	public MainMenu() {
		//default constructor
	}
	
	public static void run1() {
		// create scanner obj
		Scanner sc = new Scanner(System.in);
		// print welcome message
		System.out.println("Welcome to PhoneBook\n");

		while (true) {
			int option = readOption(sc);
			if (option == -1) {
				System.out.println("Session ended");
				System.exit(0);
			}

			switchBoard(option);
		}
	}
	
	public static void displayMenu() {
		// print selection menu
		System.out.println("Please select an option from the menu or enter -1 to exit");
		System.out.println("*********************************************************");
		System.out.println("\n" 
		+   "1: Add new entry " 
		+ "\t2: Search menu"
		+ "\n3: Delete an entry" 
		+ "\t4: Update an entry"
		+ "\n5: Show all records");
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
		
	}
		
	public static void displayRemoveMenu() {
		System.out.println("Please enter the 10-digit phone number for the person you'd like to remove from the phonebook or -1 to exit");
		System.out.println("*********************************************************");
		System.out.println("e.g. - 6366435698");
		System.out.println("*********************************************************");
		Person p = new Person();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		PhoneBook pb = new PhoneBook();
			
		p.assignData(pb.readEntry(input));
		
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
		
	public static int readOption(Scanner sc) {
		int choice =-2;
		String option = null;
		

		while(choice <-1 || choice >5) {
			//print selection menu
			displayMenu();
		
		//input validation
			try {
				option = sc.next();
				choice = Integer.parseInt(option); //pull value from user input and convert to int
				if (choice <= 0 || choice > 5) {
					if(choice==-1) {
						return choice;
					}
					System.out.println(choice + " is an invalid choice");
				}
			}catch(Exception e) {
				System.out.println(option + " is an invalid input.");
			}

		}
		
		return choice;
	}
	
	
	public static boolean switchBoard(int key) {
		
		switch(key) {
		case 1 : System.out.println("You selected #1\n"); 
		displayAddMenu();
		break;
		
		case 2 : System.out.println("You selected #2\n");
		displaySearchMenu();
		break;
		
		case 3 : System.out.println("You selected #3\n");
		//displaySubMenu(key);
		break;
		
		case 4 : System.out.println("You selected #4\n");
		//displaySubMenu(key);
		break;
		
		case 5 : System.out.println("You selected #5\n");
		//displaySubMenu(key);
		break;

		
		}
		
	return false;
	}
	
}
