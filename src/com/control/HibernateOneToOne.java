package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Player_OneToOne;

public class HibernateOneToOne {

	public static void main(String[] args) {
		try {
			Configuration config = new Configuration().configure();
			
			config.addAnnotatedClass(com.Player_OneToOne.class);
			config.addAnnotatedClass(com.control.Team.class);
			
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

				
			Team t1 = new Team("Tajikistan");
			Player_OneToOne p1 = new Player_OneToOne("Boboi Barfi", t1, 28);
			Player_OneToOne p2 = new Player_OneToOne("Tavarali", t1, 24);
			Player_OneToOne p3 = new Player_OneToOne("Dusti", t1, 25);
			Player_OneToOne p4 = new Player_OneToOne("Ronaldo", t1, 22);
			
			session.save(t1);
			
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);

			transaction.commit();
			session.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

}
