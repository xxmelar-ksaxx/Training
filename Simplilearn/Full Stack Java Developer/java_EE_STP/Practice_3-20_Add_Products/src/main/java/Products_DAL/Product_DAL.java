package Products_DAL;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import Connection.Hibernate_2;
import Entities.Products;

public class Product_DAL {
	
	
	
	public void saveUser(Products product, String DML) {
        Transaction transaction = null;
        
        try (Session session = Hibernate_2.getSessionFactory(DML).openSession()) {
            // start a transaction
        	
            transaction = session.beginTransaction();
            // save the student object
          
            
            
            session.save(product);
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
    public List < Products > getAllProducts() {
		
        Transaction transaction = null;
        List < Products > listOfUser = null;
        try (Session session = Hibernate_2.getSessionFactory("create-drop").openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
          
            listOfUser = session.createQuery("from Entities.Products").getResultList();
            
            System.out.println("The list: "+listOfUser);
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
	
	
	
	public void deleteProduct(int id, String DML) {

        Transaction transaction = null;
        try (Session session = Hibernate_2.getSessionFactory(DML).openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Products user = session.get(Products.class, id);
            
            if (user != null) {
                session.delete(user);
                System.out.println("Product is deleted");
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
