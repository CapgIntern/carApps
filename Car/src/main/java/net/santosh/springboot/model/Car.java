package net.santosh.springboot.model;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="car")
public class Car {
	@Id
	private long carId;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "variant")
	private String variant;
	
	@Column(name = "registrationyear")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate registrationYear;
	
	@Column(name = "registrationstate")
	private String registrationState;
	

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", referencedColumnName = "userId")
	  private Customer customer;
	
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(Long carId, String brand, String model, String variant, LocalDate registrationYear, String registrationState) {
		super();
		this.carId = carId;
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