package DAL;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Subjects;
import Entities.Teachers;
public class Teachers_DAL {
	
	public void saveUser(Teachers teacher) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the Teacher object
            session.save(teacher);
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
    public List < Teachers > getAllUser() {
		
        Transaction transaction = null;
        List < Teachers > listOfUser = null;
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
        
            String shq="from Entities.Teachers";
            Query<Subjects> q = session.createQuery(shq);
            List<Subjects> res=q.list();
            
            listOfUser = session.createQuery("from Entities.Teachers").getResultList();

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
            Teachers user = session.get(Teachers.class, id);
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
