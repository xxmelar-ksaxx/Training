package Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.bytebuddy.dynamic.scaffold.TypeInitializer.None;

public class Transaction_Service {

	//static Session sessionCreate = Hibernate_2.getSessionFactory("create").openSession();  // create new table/entity
	static Session sessionNone = Hibernate_2.getSessionFactory("none").openSession();     // none to avoid creating new table/entity
	private static Object Select_Return=null;
	public Object dbTransaction(String Operation) {
		
		List<Object[]> list= null;
		
		
		
		return list;
	}
	 
	public Object dbTransaction(String Operation ,Object Entity) {
		
		
		
		if(Operation.equals("insert")) {
			saveRow(Entity);
		}
		if(Operation.equals("update")) {
			updateRow(Entity);
		}
		else if(Operation.equals("delete")) {
			deleteRow(Entity);
		}
		else if(Operation.equals("read")) {
			Select_Return=readRow(Entity);
				
		}
		else
			System.out.println("Error!  none selected  { [from dbTransaction] in [Transaction_Service] class }");
		
		
		return Select_Return ;
		
	}
	
	public void saveRow(Object obj) {
		sessionNone.save(obj);
		send(sessionNone);
		sessionNone.evict(obj);
	}
	
	public void updateRow(Object obj) {
		sessionNone.update(obj);
		//sessionNone.createQuery((String)obj).executeUpdate();
		send(sessionNone);
		sessionNone.evict(obj);
	}
	
	public void deleteRow(Object obj) {
		sessionNone.delete(obj);
		//Query quar= sessionNone.createQuery((String)obj);
		//quar.executeUpdate();
		
		
		send(sessionNone);
	}
	
	public List readRow(Object obj) {
		String qqr=obj.toString();
		Query query = sessionNone.createQuery(qqr);
		
		List<Object[]> listOfThings = query.getResultList();
		try {
			
		for(Object[] o:listOfThings) {
			System.out.println("@@@@@###############@@@@@@@@@@@@@@@@######################");
			
			System.out.println("The Base64 string length is: "+((String) o[2]).length());
		}
		} catch (Exception e) {
			System.out.println("Error at for each  -> { [from readRow] in [Transaction_Service] class }");
		}
		
		
		
		send(sessionNone);
		return listOfThings;
	}
	
	
	public void send(Session session) {
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
	
	
	
	
	
}
