package Initializer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.Hibernate_2;
import Entities.User;

public class Entities_Initializing {

	static Session session = Hibernate_2.getSessionFactory("create").openSession();  // Hibernate session
	
	public void newUser(String name, String email, String pass, String role ) {
		
		session.save(new User(name, email,pass,role));
		
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
		
		e.newUser("yousif", "melar@hotmail", "1234","admin");
		
		e.send();
		
		
	}

	
	
}
