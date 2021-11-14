package mainPackage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

// Pet entity class

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pet  {
	@Id
	private int petID;
	
	private int customerID;
	private String petName;
	private String speciesID;
	private String breedID;
	private String petAge;
	private String sexID;
	//private String petBoardingStatusID;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerID", insertable = false, updatable = false)
	Customer customer;
    //List<Boarding> children = new ArrayList<>();
	
	public Pet() {
		
	}


	
	public int getPetID() {
		return petID;
	}



	public void setPetID(int petID) {
		this.petID = petID;
	}



	public int getPetOwnerID() {
		return customerID;
	}



	public void setPetOwnerID(int petOwnerID) {
		this.customerID = petOwnerID;
	}



	public String getPetName() {
		return petName;
	}



	public void setPetName(String petName) {
		this.petName = petName;
	}



	public String getSpeciesID() {
		return speciesID;
	}



	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}



	public String getBreedID() {
		return breedID;
	}



	public void setBreedID(String breedID) {
		this.breedID = breedID;
	}



	public String getPetAge() {
		return petAge;
	}



	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}



	public String getSexID() {
		return sexID;
	}



	public void setSexID(String sexID) {
		this.sexID = sexID;
	}



//	public String getPetBoardingStatusID() {
//		return petBoardingStatusID;
//	}
//
//
//
//	public void setPetBoardingStatusID(String petBoardingStatusID) {
//		this.petBoardingStatusID = petBoardingStatusID;
//	}



	@Override
	public String toString() {
		return "Pet [petID=" + petID + ", petOwnerID=" + customerID + ", petName=" + petName+ ", speciesID=" + speciesID + 
				", breedID=" + breedID + ", petAge=" + petAge + ", sexID=" + sexID + "]";
	}


}