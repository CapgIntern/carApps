package net.santosh.springboot.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;

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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	
	private Customer customer;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id")
	
	private Payment payment;
	
	

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ppid", referencedColumnName = "userId")
	  private Customer customer1;
	
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(String location, String inspectionType, LocalDate preferredDate, LocalTime preferredTime,
			Customer customer, Payment payment) {
		super();
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.customer = customer;
		this.payment = payment;
	}
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

