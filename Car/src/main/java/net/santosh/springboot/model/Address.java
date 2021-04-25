package net.santosh.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/************************************************************************************
 *class:                            Appointment
 *Description:                      It is used to create the table address with required 
 *                                  columns.
 *Created By                        R saisantosh kumar reddy
 *Created Date                      24-MARCH-2021  
*************************************************************************************/
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressid")
	private long addressId;
	@Column(name = "userid")
	private String userId;
	@Column(name = "doorno")
	private String doorNo;
	@Column(name = "street")
	private String street;
	@Column(name = "area")
	private String area;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	
	/************************************************************************************
	 * Method:                          Address
     *Description:                      It is used to initialize the empty constructor.
     *Created By                        R saisantosh kumar reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	/************************************************************************************
	 * Method:                          Address
     *Description:                      It is used to initialize the parameterized constructor.
     *Created By                        R saisantosh kumar reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/


	public Address(String userId, String doorNo, String street, String area, String city, String state,
			int pincode) {
		super();
		this.userId = userId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
