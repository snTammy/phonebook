package pb;

import java.util.Scanner;

public class Menu {
	public static void run() {
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
	
	public static String[] readInput() {

		String name ="John Doe, 114 Market St, St Louis, MO, 63403, 6366435698";
		
		//take user input and return array of tokens to assign to a person object
		String[] tokens= name.split(", ");
//		int length = tokens.length;
//		System.out.println(length);
//		for (int i = 0; i < tokens.length; i++) {
//			String string = tokens[i];
//			System.out.println(tokens[i]);
//		}
		return tokens;
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
	
	public static void displaySearchMenu(int opt) {
		// print selection menu
		System.out.println("Please enter an option to search the phonebook or -1 to exit");
		System.out.println("*********************************************************");
	
		switch(opt) {
		case 1 : System.out.println("You selected #1, search by first name \n");
		// First name search
				break;
				
		case 2 : System.out.println("You selected #2, search by last name \n");
		// Last name search
			break;
		
		case 3 : System.out.println("You selected #3, search by full name \n");
		// Full name search: result should return array of Person Objects
			break;
		
		case 4 : System.out.println("You selected #4, search by telephone number \n");
		// telephone number search
		break;
		
		case 5 : System.out.println("You selected #5, search by city");
		// city search
		break;
		
		case 6 : System.out.println("You selected #6, search by state");
		// state search
		break;
		
		default : System.out.println("Invalid input");
		break;
		
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
		//displaySubMenu(key);
		break;
		
		case 2 : System.out.println("You selected #2\n");
		//displaySubMenu(key);
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
