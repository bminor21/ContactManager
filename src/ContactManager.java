import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import common.ContactInformation;;

public class ContactManager {

	private static Session session;
	private static SessionFactory sessionFactory;
	
	static {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build();
			
			sessionFactory = configuration.buildSessionFactory( serviceRegistry );
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
