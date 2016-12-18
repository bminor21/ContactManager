import java.util.Scanner;

import org.hibernate.*;

import common.ContactInformation;

public class Main {

	private static ContactManager manager;
	private static Scanner scanner;
	 
	
	/* Static init block */
	static{
		scanner = new Scanner( System.in );
		manager = new ContactManager();
	}
	
	public static void main(String[] args) {
		
		int resp = getMainMenuResponse();
		while( resp != 9 )
		{
			switch( resp ){
			case 1:
				manager.displayEntries();
				break;
			case 2: 
				manager.addNewContact( buildNewContact() );
				break;
			case 3:
				int del = getDeleteId();
				manager.deleteContact( del );
				break;
			case 4:
				int id = getUpdateId();
				manager.updateContact( id );
				break;
			default:
				System.out.println( "Invalid command..." );
				break;
			}
			
			resp = getMainMenuResponse();
		}
		
		System.exit(0);
	}
	
	
	private static int getMainMenuResponse() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Welcome. What would you like to do?\n");
		strBuilder.append("1. View all entries\n");
		strBuilder.append("2. Add new entry\n");
		strBuilder.append("3. Delete an entry\n");
		strBuilder.append("4. Update an entry\n" );
		strBuilder.append("9. Exit\n" );
		System.out.println( strBuilder.toString() );
		
		while( !scanner.hasNextInt() ){
			System.out.println("Invalid input...");
			scanner.next();
		}
		
		return scanner.nextInt();
		
	}
	
	private static int getUpdateId() {
		
		manager.displayEntries();
		System.out.print("Enter ID to update: ");
		
		while( !scanner.hasNextInt() ){
			System.out.println( "Invalid input..." );
			scanner.next();
		}
		
		return scanner.nextInt();
	}
	
	private static int getDeleteId() {
		
		manager.displayEntries();
		
		System.out.print("Enter ID to delete: ");
		
		while( !scanner.hasNextInt() ){
			System.out.println( "Invalid input..." );
			scanner.next();
		}
		
		return scanner.nextInt();
	}
	
	private static ContactInformation buildNewContact() {
		ContactInformation info = new ContactInformation();
		System.out.print("Enter first name: ");
		info.setFirstName( scanner.nextLine() );
		
		System.out.print("Enter last name: ");
		info.setLastName( scanner.nextLine() );
		
		System.out.print("Enter Address: ");
		info.setAddress( scanner.nextLine() );
		
		System.out.print("Enter City: ");
		info.setCity( scanner.nextLine() );
		
		System.out.print("Enter State: ");
		info.setState( scanner.nextLine() );
		
		System.out.print("Enter Zip Code: ");
		info.setZipCode( scanner.nextLine() );
		
		return info;
	}

}
