import java.util.Scanner;

import org.hibernate.*;

public class Main {

	private static ContactManager manager;
	private static Scanner scanner;
	 
	
	/* Static init block */
	static{
		scanner = new Scanner( System.in );
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
				manager.addNewContact();
				break;
			case 3:
				manager.deleteContact();
				break;
			case 4:
				manager.updateContact();
				break;
			default:
				break;
			}
			
			resp = getMainMenuResponse();
		}
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

}
