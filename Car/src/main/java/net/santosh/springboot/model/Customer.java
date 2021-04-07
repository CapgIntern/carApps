package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	private String userId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "address_id")
	Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/************************************************************************************
	 * Method:                          Customer 
	 * Description:                     It is used to initialize the empty constructor.
	 * Created By                       G Sai Nikesh 
	 * Created Date                     24-MARCH-2021
	 *************************************************************************************/
	public Customer() {
		super();
	}
	/************************************************************************************
	 * Method:                          Customer
     *Description:                      It is used to initialize the parameterized constructor.
     *Created By                        G Sai Nikesh
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/

	public Customer(String userId, String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + "]";
	}

}
