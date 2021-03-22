package net.santosh.springboot.model;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="appointment")

public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	@Column(name="location")
	private String location;
	@Column(name="inspectiontype")
	private String inspectionType;
	@Column(name="preferreddate")
	private LocalDate preferredDate;
	@Column(name="preferredtime")
	private LocalTime preferredTime;
	@Column(name="customer")
	private Customer customer;
	@Column(name="payment")
	private Payment payment;
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getInspectionType() {
		return inspectionType;
	}
	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public LocalTime getPreferredTime() {
		return preferredTime;
	}
	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
