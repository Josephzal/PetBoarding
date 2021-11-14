package mainPackage;


import java.util.ArrayList;
import java.util.List;



import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustImpl {

	// These methods access the HibernateUtil class to open the session
	// and perform respective tasks

	public void saveCustomer(Customer customer) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		// might need to use this way to check for dupes or current way below, not sure
		
//		try {
//			Customer owner = (Customer) session.load(Customer.class, customer.getCustomerID());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		//try {
			session.save(customer);
			transaction.commit();
			session.close();
		//} catch (Exception e) {
		//	System.out.println(e);
		//}

	}

	public List<Customer> displayCustomers() {
		List<Customer> customerList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Customer");
		customerList = query.list();
		return customerList;
	}

	public void deleteCustomer(Customer customer) {
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//session.delete(customer);
		
		session.delete(session.get(Customer.class, customer.getCustomerID()));
		transaction.commit();
		session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editCustomer(int customerID, String custFirstName, String custLastName, String custPhone, String custEmail, String custAddress) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customer customer = (Customer) session.load(Customer.class, customerID);
			customer.setCustomerID(customerID);
			customer.setCustFirstName(custFirstName);
			customer.setCustLastName(custLastName);
			customer.setCustPhone(custPhone);
			customer.setCustEmail(custEmail);
			customer.setCustAddress(custAddress);
			
			session.update(customer);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}



	}

}
