package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name="userId")
	private String userId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="contactNo")
	private String contactNo;
	@Column(name="dob")
	private LocalDate dob;


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
