import org.hibernate.Session;
import org.hibernate.SessionFactory;

import common.ContactInformation;;

public class ContactManager {

	private static Session session;
	private static SessionFactory sessionFactory;
	
	static {
		session = sessionFactory.openSession();
	}
	
	public void displayEntries(){
		
	}
	
	public void updateContact() {
		
	}
	
	public void deleteContact() {
		
	}
	
	public void addNewContact() {
		
	}
	
	public void close(){
		
	}
	
}
