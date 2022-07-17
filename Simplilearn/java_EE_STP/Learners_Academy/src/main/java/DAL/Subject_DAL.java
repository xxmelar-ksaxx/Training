package DAL;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Subjects;

public class Subject_DAL {
	
	
	
	public void saveUser(Subjects subject, String DML) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory(DML).openSession()) {
            // start a transaction
        	
            transaction = session.beginTransaction();
            // save the student object
            session.save(subject);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	
	@SuppressWarnings("unchecked")
    public List < Subjects > getAllUser() {
		
        Transaction transaction = null;
        List < Subjects > listOfUser = null;
        try (Session session = Hibernate_2.getSessionFactory("create-drop").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            
            String shq="from Entities.Subjects";
            Query<Subjects> q = session.createQuery(shq);
            List<Subjects> res=q.list();
            
            listOfUser = session.createQuery("from Entities.Subjects").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            	System.out.println("transaction closed!!");
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
	
	
	
	public void deleteUser(int id, String DML) {

        Transaction transaction = null;
        try (Session session = Hibernate_2.getSessionFactory(DML).openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Subjects user = session.get(Subjects.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	//@SuppressWarnings("unchecked")
	public Subjects getSubject(String name) {

        Transaction transaction = null;
        Subjects user=null;
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            
            String shq="select S.id from Entities.Subjects S where name='"+name+"'";
            Query q = session.createQuery(shq);
            List<Object> res=q.list();
            
            int x=(Integer)res.get(0);          
            user = (Subjects)session.get(Subjects.class, x);
 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
	

}
