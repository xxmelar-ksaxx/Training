package Initializer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.Hibernate_2;
import Entities.Adminstorator;

public class Entities_Initializing {

	static Session session = Hibernate_2.getSessionFactory("create").openSession();  // Hibernate session
	
	
	public void createAdminstorator(String name,String password) {
        session.save(new Adminstorator(name, password));
	}
	
	
	public void send() {					// Transaction
        Transaction transaction = null;
        
        try  {
            
            transaction = session.beginTransaction();
            
            //session.save(a);
             
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    
	}
	
	
	public static void main(String[] args) {
		
		Entities_Initializing e= new Entities_Initializing();
		
		e.createAdminstorator("yousif", "1234");  // The Admin Credentials
		
		e.send();
		
		
	}

	
	
}
