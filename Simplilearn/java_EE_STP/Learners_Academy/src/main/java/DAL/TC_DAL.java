package DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Classes;
import Entities.Subjects;
import Entities.Teachers;
import Entities.Teachers_Classes;

public class TC_DAL {

	public void saveUser(Teachers_Classes TC) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the Teacher object
        
            session.save(TC);
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
            
            String qqr="select TC.tc_id, T.name, S.name ,C.roomNo, C.time from Teachers T,Classes C, Teachers_Classes TC, Subjects S where TC.t_id=T.id and TC.c_id=C.id and C.f_name=S.id";
            
            Query q=session.createQuery(qqr);
            
            listOfUser = q.getResultList();

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
            Teachers_Classes tc = session.get(Teachers_Classes.class, id);
            if (tc != null) {
                session.delete(tc);
                System.out.println("TC is deleted");
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
	public Object getTC_E_info(int id, String type) {

        Transaction transaction = null;
        Teachers teacher=null;
        Classes class1=null;
        Object o=null;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
          
            if(type.equals("T")) {
            	teacher = (Teachers)session.get(Teachers.class, id);
            	o=teacher;
            }
            else if (type.equals("C")) {
            	class1 = (Classes)session.get(Classes.class, id);
            	o=class1;
			}
            else {
            	System.out.println("!! Get TC Entity info Error !!");
            }
 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return o;
    }
	
	
}
