package com.control;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;
import com.to.Team;

import java.util.List;

import org.hibernate.*;
import org.hibernate.SessionFactory;

public class HibernateMain {

		public static void main(String[] args) {
			
			try {
				
			
			Configuration configuration = new Configuration().configure();  // Create the configuration.   
			
			configuration.addAnnotatedClass(com.to.Player.class);
			configuration.addAnnotatedClass(com.to.Team.class);

			
			StandardServiceRegistryBuilder builder = 
					 new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());  // get the configuration in the player class
			SessionFactory factory= configuration.buildSessionFactory(builder.build());              // build the session
			
			Session session = factory.openSession();         	    		// create a session
			Transaction transaction=session.beginTransaction();				// create transaction
			
			//Player p1= new Player(112,"kk","ksa",30);
			//Player p2= new Player(20,"ahmed","ksa",35);
			//session.save(p1);
			//session.save(p2);
			
			//Player p =session.get(Player.class, 112);
			//System.out.println("details: "+p);
			//p.setPlayerName("obm");
			
			//Player p3 =session.get(Player.class, 13);
			//session.delete(p3);
			
			//Query query= session.createQuery("from Player where age=:name order by playerName asc"); // (:name) act like varieble
			//query.setString("name","30");
			
			/*
			List<Player> playerList=query.list();
			System.out.println("Player Details: ");
			for(Player p:playerList) {
				System.out.println(p);
			}
			*/
			
			
			Team t1 = new Team("ksa");
			Player p1= new Player("sloom", t1,28);
			session.save(t1);
			session.save(p1);
			
			
			
			
			transaction.commit();
			session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			
			
		}
	
}
