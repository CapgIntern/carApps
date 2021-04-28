package net.santosh.springboot.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/************************************************************************************
 *class:                            Appointment
 *Description:                      It is used to create the table appointment with required 
 *                                  columns.
 *Created By                        R saisantosh kumar reddy
 *Created Date                      24-MARCH-2021  
*************************************************************************************/
@Entity
@Table(name = "appointment")

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointmentid")
	private long appointmentId;
	@Column(name = "userid")
	private String userId;
	@Column(name = "carId")
	private long carId;
	@Column(name = "location")
	private String location;
	@Column(name = "inspectiontype")
	private String inspectionType;
	@Column(name = "preferreddate")
	private LocalDate preferredDate;
	@Column(name = "preferredtime")
	private LocalTime preferredTime;
	
	/************************************************************************************
	 * Method:                          Appointment
     *Description:                      It is used to initialize the parameterized constructor.
     *Created By                        R saisantosh kumar reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/
	
	public Appointment(String location, String inspectionType, LocalDate preferredDate) {
		super();
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
	}

	public Appointment(String userId, long carId, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime) {
		super();
		this.userId = userId;
		this.carId = carId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
	}

	/************************************************************************************
	 * Method:                          Appointment
     *Description:                      It is used to initialize the empty constructor.
     *Created By                        R saisantosh kumar reddy
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}



}