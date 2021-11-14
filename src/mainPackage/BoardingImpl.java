package mainPackage;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BoardingImpl {

	// These methods access the HibernateUtil class to open the session
	// and perform respective tasks

	public void saveBoarding(Boarding boarding) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		// might need to use this way to check for dupes or current way below, not sure
		
//		try {
//			Customer owner = (Customer) session.load(Customer.class, customer.getCustomerID());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		try {
			session.save(boarding);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("**************************************WOOOOOOPS");
		}

	}

	public List<Boarding> displayBoarding() {
		List<Boarding> boardingList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Boarding");
		boardingList = query.list();
		return boardingList;
	}

	public void deleteBoarding(Boarding boarding) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(boarding);
		transaction.commit();
		session.close();
	}

	public void editBoarding(int boardingID, int petID, int ownerID, String dropOffDate, String pickUpDate, String boardingStatusID) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {	
			Boarding boarding = (Boarding) session.load(Boarding.class, boardingID);
			boarding.setBoardingID(boardingID);
			boarding.setPetID(petID);
			boarding.setOwnerID(ownerID);
			boarding.setDropOffDate(dropOffDate);
			boarding.setPickUpDate(pickUpDate);
			boarding.setBoardingStatusID(boardingStatusID);
			session.update(boarding);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}



	}

}
