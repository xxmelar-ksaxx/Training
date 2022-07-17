package DAL;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Control.Hibernate_2;
import Entities.Adminstorator;
import Entities.Subjects;

public class login_DAL {

	public boolean loginValidation(String name,String password) {
        Transaction transaction = null;
        boolean state=false;
        
        try (Session session = Hibernate_2.getSessionFactory("none").openSession()) {
            // start a transaction
        	
            transaction = session.beginTransaction();
            String t="Adminstorator A";
            String query="select  A.name, A.password from "+t;
            Query q=session.createQuery(query);
            
            List<Object[]> oa=q.list();
          
            String qname="";
            String qpass="";
            
            for(Object[] u:oa) {
            	qname=(String)u[0];
            	qpass=(String)u[1];
            }
            
            if(qname.equals(name) && qpass.equals(password) ) {
            	state=true;
            }
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        // return the if found
        return state;
        
    }	
	
}
