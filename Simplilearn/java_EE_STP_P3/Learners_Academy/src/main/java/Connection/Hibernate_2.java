package Connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Entities.Adminstorator;
import Entities.Classes;
import Entities.Students;
import Entities.Subjects;
import Entities.Teachers;
import Entities.Teachers_Classes;





public class Hibernate_2 {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(String DML) {
		  
		  if (sessionFactory == null) {
		   try {
		  
		   Configuration configuration = new Configuration();
		   
		    // Hibernate settings equivalent to hibernate.cfg.xml's properties
		    Properties settings = new Properties();
		    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false"); // Database schema name
		    settings.put(Environment.USER, "root");   //DB User Name 
		    settings.put(Environment.PASS, "password");    // DB Password
		    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

		    settings.put(Environment.SHOW_SQL, "true");

		    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		    
		    if(DML=="create")  
		    	settings.put(Environment.HBM2DDL_AUTO, "create");
		    	    	
	    	configuration.setProperties(settings);
	    	// The Entities 
	    	configuration.addAnnotatedClass(Adminstorator.class);
	    	configuration.addAnnotatedClass(Subjects.class);
	    	configuration.addAnnotatedClass(Classes.class);
	    	configuration.addAnnotatedClass(Teachers.class);
	    	configuration.addAnnotatedClass(Teachers_Classes.class);
	    	configuration.addAnnotatedClass(Students.class);
	    	
		  
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
