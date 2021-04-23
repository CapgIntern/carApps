package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "O_R_D_E_R")

public class Order {
	@Id
	@Column(name = "orderId")
	private long orderId;
	@Column(name = "amount")
	private double amount;
	@Column(name = "billingdate")
	private LocalDate billingDate;
	@Column(name = "paymentid")
	private long paymentId;
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
	public Order(long orderId, double amount, LocalDate billingDate, long paymentId) {
		super();
		this.amount = amount;
		this.billingDate = billingDate;
		this.orderId = orderId;
		this.paymentId = paymentId;
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
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

}
