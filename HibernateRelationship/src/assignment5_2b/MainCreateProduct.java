package assignment5_2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {

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
			
			// create an order
			Order tempOrder = new Order();
			
			// create some products
			Product tempProduct1 = new Product("almond green milk tea");
			Product tempProduct2 = new Product("wintermelon green tea");
			Product tempProduct3 = new Product("black milk tea");
			
			// add products to order
			tempOrder.addProduct(tempProduct1);
			tempOrder.addProduct(tempProduct2);
			tempOrder.addProduct(tempProduct3);
			
			// save the order
			session.save(tempOrder);
			
			// save the products
			session.save(tempProduct1);
			session.save(tempProduct2);
			session.save(tempProduct3);
			
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