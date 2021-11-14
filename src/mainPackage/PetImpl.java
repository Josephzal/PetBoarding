package mainPackage;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PetImpl {

	// These methods access the HibernateUtil class to open the session
	// and perform respective tasks

	public void savePet(Pet pet, int ownerID) {
	// need to implement customer and add as parameter to check if customer exists	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customer owner = (Customer) session.load(Customer.class, ownerID);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			session.save(pet);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Pet> displayPets() {
		List<Pet> petList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Pet");
		petList = query.list();
		return petList;
	}

	public void deletePet(Pet pet) {
		try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//session.delete(pet);
		session.delete(session.get(Pet.class, pet.getPetID()));
		transaction.commit();
		session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editPet(int petID, int petOwnerID, String petName, String petSpecies, String petBreed, String petAge,
			String petGender) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Pet pet = (Pet) session.load(Pet.class, petID);
			pet.setPetID(petID);
			pet.setPetOwnerID(petOwnerID);
			pet.setPetName(petName);
			pet.setSpeciesID(petSpecies);
			pet.setBreedID(petBreed);
			pet.setPetAge(petAge);
			pet.setSexID(petGender);
			//pet.setPetBoardingStatusID(petBoardingStatus);
			System.out.println(petAge);
			session.update(pet);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();
		//
		// Pet petT = new Pet();
		// petT.setPetID("S41-122");
		// petT.setPetOwnerID(pet.getPetOwnerID());
		// petT.setPetName(pet.getPetName());
		// petT.setPetSpecies(pet.getPetSpecies());
		// petT.setPetBreed(pet.getPetBreed());
		// petT.setPetAge(pet.getPetAge());
		// petT.setPetGender(pet.getPetGender());
		// petT.setPetBoardingStatus(pet.getPetBoardingStatus());
		//
		// session.merge(pet);
		// transaction.commit();
		// session.close();

	}

}
