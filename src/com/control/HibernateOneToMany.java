package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Player_OneToMany;

public class HibernateOneToMany {

	public static void main(String[] args) {
		try {
			Configuration config = new Configuration().configure();
			
			config.addAnnotatedClass(com.Player_OneToMany.class);
			config.addAnnotatedClass(com.control.Team.class);
			
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

				
			Team t1 = new Team("Tajikistan");
			Team t2 = new Team("Manchester");
			Team t3 = new Team("USA");
		
			Player_OneToMany p = new Player_OneToMany();
			p.setAge(22);
			p.setPlayerName("Jura");
			p.getTeamList().add(t1);
			//same player in multiple teams
			p.getTeamList().add(t2);
			p.getTeamList().add(t3);
			
			
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(p);
	
			transaction.commit();
			session.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

}
