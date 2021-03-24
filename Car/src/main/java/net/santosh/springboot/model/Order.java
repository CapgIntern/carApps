package net.santosh.springboot.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="horder")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	@Column(name = "amount")
	private double amount;
	@Column(name = "billingdate")
	private LocalDate billingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
	  private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fsfds_id")
	
	private Payment payment;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(double amount, LocalDate billingDate, Customer customer) {
		super();
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
