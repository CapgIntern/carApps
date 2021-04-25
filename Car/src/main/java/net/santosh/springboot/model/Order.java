package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ORDER_TABLE")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderid")
	private long orderId;
	@Column(name = "amount")
	private double amount;
	@Column(name = "billingdate")
	private LocalDate billingDate;
	@Column(name = "userid")
	private String userId;
	@Column(name = "saleid")
	private long saleId;
	@Column(name = "appointmentid")
	private long appointmentId;
	/************************************************************************************
	 * Method:                          Order 
	 * Description:                     It is used to initialize the empty constructor.
	 * Created By                       V Raghuveer
	 * Created Date                     24-MARCH-2021
	 *************************************************************************************/
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	/************************************************************************************
	 * Method:                          Order
     *Description:                      It is used to initialize the parameterized constructor.
     *Created By                        V Raghuveer
     *Created Date                      24-MARCH-2021  
	*************************************************************************************/
	public Order(long orderId, double amount, LocalDate billingDate, String userId, long saleId, long appointmentId) {
		super();
		this.amount = amount;
		this.billingDate = billingDate;
		this.orderId = orderId;
		this.userId = userId;
		this.saleId = saleId;
		this.appointmentId = appointmentId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getSaleId() {
		return saleId;
	}
	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	

}
