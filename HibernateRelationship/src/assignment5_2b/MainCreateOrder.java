package assignment5_2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Order.class)
								.addAnnotatedClass(Product.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// create some orders
			Order tempOrder1 = new Order();
			Order tempOrder2 = new Order();
			
			// create a product
			Product tempProduct = new Product("almond milk tea");
			
			// add products to order
			tempOrder1.addProduct(tempProduct);
			tempOrder2.addProduct(tempProduct);
			
			// save the orders
			session.save(tempOrder1);
			session.save(tempOrder2);
			
			// save the product
			session.save(tempProduct);
			
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






