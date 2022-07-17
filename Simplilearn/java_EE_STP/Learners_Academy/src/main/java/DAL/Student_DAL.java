package DAL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Students;
import Entities.Subjects;
import Entities.Teachers;

public class Student_DAL {

	public void saveUser(Students student) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the Teacher object
            session.save(student);
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
    public List getAllUser() {
		
        Transaction transaction = null;
        List<Object[]> listOfUser = null;
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            
           // String shq="from Entities.Students";
           // Query<Students> q = session.createQuery(shq);
          //  List<Students> res=q.list();
            
            listOfUser = session.createQuery("select distinct ST.id, ST.name, ST.email, ST.jender,ST.age,ST.role, S.name from Entities.Students ST, Entities.Classes C, Entities.Subjects S where ST.class1=S.id").getResultList();
            
            for(Object[] c:listOfUser) {
            	System.out.println("@@@@"+c[0]);
            }
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
	
	public void deleteUser(int id) {

        Transaction transaction = null;
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Students user = session.get(Students.class, id);
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
	
}
