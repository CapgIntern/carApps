package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	@Id
	@Column(name = "carId")
	private long carId;
	@Column(name = "userId")
	private String userId;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	@Column(name = "variant")
	private String variant;
	@Column(name = "registrationyear")
	private LocalDate registrationYear;
	@Column(name = "registrationstate")
	private String registrationState;

	/************************************************************************************
	 * Method:                          Car
     *Description:                      It is used to initialize the empty constructor.
     *Created By                        G Gagandeep Reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/
	public Car() {
		super();
	}

	/************************************************************************************
	 * Method:                          Car
     *Description:                      It is used to initialize the parameterized constructor.
     *Created By                        G Gagandeep Reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/
	public Car(long carId, String userId, String brand, String model, String variant, LocalDate registrationYear,
			String registrationState) {
		super();
		this.carId = carId;
		this.userId = userId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public LocalDate getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

}