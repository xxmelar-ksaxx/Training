package Connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Entities.Products;

//import Entities.Products;

public class Connect {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(String DML) {
		  
		  if (sessionFactory == null) {
		   try {
		  
		   Configuration configuration = new Configuration();
		   
		    // Hibernate settings equivalent to hibernate.cfg.xml's properties
		    Properties settings = new Properties();
		    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate"); // Database schema name
		    settings.put(Environment.USER, "jroot");   //DB User Name 
		    settings.put(Environment.PASS, "1234");    // DB Password
		    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

		    settings.put(Environment.SHOW_SQL, "true");

		    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		    
		    if(DML=="create")  
		    	settings.put(Environment.HBM2DDL_AUTO, "create");
		    	    	
	    	configuration.setProperties(settings);
	    	
	    	// The Entities 
	    	configuration.addAnnotatedClass(Products.class);
	    	

		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		      .applySettings(configuration.getProperties()).build();
		    System.out.println("Hibernate Java Config serviceRegistry created");
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    return sessionFactory;

		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return sessionFactory;
		 }
	
	
	
	
}
