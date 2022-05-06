package assignment5_2a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Professor.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Professor professor = session.get(Professor.class, 2);
			
			session.delete(professor);
						
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
		
	}

}
