package assignment5_2a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Professor.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			
			// start a transaction
			session.beginTransaction();
			
			// create a customer
			Customer tempCustomer = new Customer("Gabby", "16085 Pebble Beach Lane, Chino Hills, CA 91709");
			
			// save the customer
			session.save(tempCustomer);
			
			// create a professor
			Professor tempProfessor = new Professor("1234", "Computer Science");
			
			tempProfessor.setCustomer(tempCustomer);
			
			// save the professor
			session.save(tempProfessor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
