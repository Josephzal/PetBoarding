package mainPackage;

// Boarding entity class

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boarding  {
	@Id
	private int boardingID;
	private int petID;
	private int customerID;
	private String dropOffDate;
	private String pickUpDate;
	private String boardingStatusID;
	
	public Boarding() {
		
	}


	
	public int getPetID() {
		return petID;
	}




	public int getBoardingID() {
		return boardingID;
	}



	public void setBoardingID(int boardingID) {
		this.boardingID = boardingID;
	}



	public int getOwnerID() {
		return customerID;
	}



	public void setOwnerID(int ownerID) {
		this.customerID = ownerID;
	}



	public String getDropOffDate() {
		return dropOffDate;
	}



	public void setDropOffDate(String dropOffDate) {
		this.dropOffDate = dropOffDate;
	}



	public String getPickUpDate() {
		return pickUpDate;
	}



	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}



	public String getBoardingStatusID() {
		return boardingStatusID;
	}



	public void setBoardingStatusID(String boardingStatusID) {
		this.boardingStatusID = boardingStatusID;
	}



	public void setPetID(int petID) {
		this.petID = petID;
	}



	@Override
	public String toString() {
		return "Boarding [boardingID=" + boardingID + ", petID=" + petID + ", ownerID=" + customerID + ", dropOffDate=" + dropOffDate + 
				", pickUpDate=" + pickUpDate + ", boardingStatusID=" + boardingStatusID + "]";
	}


}