package DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Classes;

public class Classes_DAL {

	public void saveUser(Classes classes) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the Teacher object
            
            session.save(classes);
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
        
            String qqr="select C.id, S.name, C.roomNo, C.time from Entities.Classes C, Entities.Subjects S where C.f_name=S.id";
            
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
            Classes user = session.get(Classes.class, id);
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
	
	@SuppressWarnings("unchecked")
    public List get_Class_Info(String class_id) {
		
        Transaction transaction = null;
        List<Object[]> listOfUser = null;
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            String xx="1";
            String qqr="select distinct S.name, C.roomNo,T.name ,count(ST.id) from Entities.Classes C, Entities.Students ST, Entities.Subjects S, Entities.Teachers T, Entities.Teachers_Classes TC where S.id=C.f_name and ST.class1=C.id and ST.class1='"+class_id+"' and C.id=TC.c_id";
            
            Query q=session.createQuery(qqr);
            
            listOfUser = q.getResultList();
            System.err.println("The value is: -"+class_id+"-");
            for(Object[] c: listOfUser)
            {
            	System.out.println("###$$$ : "+c[0]);
            	System.out.println("###$$$ : "+c[1]);
            	System.out.println("###$$$ : "+c[2]);
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
	
	
	
	
	
}
