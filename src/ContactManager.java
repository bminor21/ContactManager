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
	private static Configuration configuration;
	
	static {
			Configuration configuration = new Configuration();
			configuration.addClass( ContactInformation.class );
			configuration.configure("hibernate.cfg.xml");
	} 
	
	public void displayEntries(){
		
		Transaction tx = session.beginTransaction();
		try {
			List contacts = session.createQuery("from ContactInformation").list();
			for( Iterator itr = contacts.iterator(); itr.hasNext(); ){
				ContactInformation info = (ContactInformation) itr.next();
				info.getPrintLine();
			}
			tx.commit();
		} catch ( Exception E ){
			System.out.println( "Caught error: " + E.getMessage() );
			tx.rollback();
		} finally {
			closeSession();
		}
	}
	
	public void updateContact( int id ) {
		
		openSession();
		Transaction tx = session.beginTransaction();

		try {
			ContactInformation info = (ContactInformation)session.get( ContactInformation.class, id );
			session.update( info );
			tx.commit();
		} catch( Exception E ) {
			System.out.println( "Caught error: " + E.getMessage() );
			tx.rollback();
		} finally {
			System.out.println( "Entry has been deleted\n" );
			closeSession();
		}
	}
	
	public void deleteContact( int id ) {
		
		openSession();
		Transaction tx = session.beginTransaction();
		try {
			ContactInformation info = (ContactInformation)session.get( ContactInformation.class, id );
			session.delete( info );
			tx.commit();
		} catch( Exception E ) {
			System.out.println( "Caught error: " + E.getMessage() );
			tx.rollback();
		} finally {
			System.out.println( "Entry has been deleted\n" );
			closeSession();
		}
	}
	
	public void addNewContact( ContactInformation info ) {
		openSession();
		
		Transaction tx = session.beginTransaction();
		try {
		session.save(info);
		tx.commit();
		} catch( Exception E ){
			System.out.println( "Caught error: " + E.getMessage() );
			tx.rollback();
		} finally {
			displayEntries();
			closeSession();
		}
	}
	
	
	public void openSession() {
		
		if( !session.isOpen() )
		{
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build();

			sessionFactory = configuration.buildSessionFactory( serviceRegistry );
			session = sessionFactory.openSession();
		}
	}
	
	public void closeSession(){
		
		if( session.isOpen() )
			session.close();
		
		if( sessionFactory.isOpen() )
			sessionFactory.close();
	}
	
}
