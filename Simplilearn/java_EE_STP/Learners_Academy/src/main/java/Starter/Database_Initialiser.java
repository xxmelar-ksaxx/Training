package Starter;


import org.hibernate.Session;
import org.hibernate.Transaction;


import Control.Hibernate_2;
import Entities.Adminstorator;
import Entities.Classes;
import Entities.Subjects;

public class Database_Initialiser {

	static Session session = Hibernate_2.getSessionFactory("create").openSession();
	
	public void createAdminstorator(String name,String password) {
            session.save(new Adminstorator(name, password));
    }	
	
	public Subjects createSubjects(String name,int credits) {
			Subjects s=new Subjects(name, credits);
			session.save(s);
			return s;
	}
	public void createclasses(Subjects name,int roomno,int time) {
		session.save(new Classes(name, roomno, time));
}
	
	public void send() {
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
		Database_Initialiser dba=new Database_Initialiser();
		
		dba.createAdminstorator("yousif", "1234");  // The Admin Credentials
		
		dba.send();
		
	}
	
	
}
