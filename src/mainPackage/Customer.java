package mainPackage;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

// Customer entity class

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Customer  {
	@Id
	@Column(name="customerID")
	private int customerID;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;
	private String customerEmail;
	private String customerAddress;


    
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	List<Pet> children = new ArrayList<Pet>();
    
	public Customer() {
		
	}

	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getCustFirstName() {
		return customerFirstName;
	}



	public void setCustFirstName(String custFirstName) {
		this.customerFirstName = custFirstName;
	}



	public String getCustLastName() {
		return customerLastName;
	}



	public void setCustLastName(String custLastName) {
		this.customerLastName = custLastName;
	}



	public String getCustPhone() {
		return customerPhone;
	}



	public void setCustPhone(String custPhone) {
		this.customerPhone = custPhone;
	}



	public String getCustEmail() {
		return customerEmail;
	}



	public void setCustEmail(String custEmail) {
		this.customerEmail = custEmail;
	}



	public String getCustAddress() {
		return customerAddress;
	}



	public void setCustAddress(String custAddress) {
		this.customerAddress = custAddress;
	}



	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", custFirstName=" + customerFirstName + ", custLastName=" + customerLastName + 
				", custPhone=" + customerPhone + ", custEmail=" + customerEmail + ", custAddress=" + customerAddress + "]";
	}


}