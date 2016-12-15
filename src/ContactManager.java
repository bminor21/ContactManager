import java.util.List;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import common.ContactInformation;

public class ContactManager {

	private static Session session;
	private static SessionFactory sessionFactory;
	
	static {
			Configuration configuration = new Configuration();
			configuration.addClass( ContactInformation.class );
			configuration.configure("hibernate.cfg.xml");
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build();
			
			sessionFactory = configuration.buildSessionFactory( serviceRegistry );
			session = sessionFactory.openSession();
			
		} 
	
	public void displayEntries(){
		Transaction tx = session.beginTransaction();
		List contacts = session.createQuery("from ContactInformation").list();
		for( Iterator itr = contacts.iterator(); itr.hasNext(); ){
			ContactInformation info = (ContactInformation) itr.next();
			System.out.println("-------------------------------------------");
			System.out.println( info.getFirstName() + " " + info.getLastName() );
			System.out.println( info.getAddress() );
			System.out.println( info.getState() + " " + info.getZipCode() );
			System.out.println("-------------------------------------------");
		}
		tx.commit();
}
	
	public void updateContact() {
		
	}
	
	public void deleteContact() {
		
	}
	
	public void addNewContact() {
		Transaction tx = session.beginTransaction();
		ContactInformation info = new ContactInformation();
		info.setFirstName("Brett");
		info.setLastName("Minor");
		info.setAddress("1415 Bardshar Rd");
		info.setCity("Sandusky");
		info.setState("Ohio");
		info.setZipCode("44870");
		
		session.save(info);
		tx.commit();
		displayEntries();
	}
	
	public void close(){
		session.close();
		sessionFactory.close();
	}
	
}
