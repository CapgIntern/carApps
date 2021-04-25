package net.santosh.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "for_sale")
public class ForSale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "saleid")
	private long saleId;
	@Column(name = "carId")
	private long carId;
	@Column(name = "userId")
	private String userId;
	@Column(name = "cost")
	private double cost;
	
	public ForSale() {
		super();
	}
	/**
	 * @param saleId
	 * @param carId
	 * @param userId
	 * @param cost
	 */
	public ForSale(long saleId, long carId, String userId, double cost) {
		super();
		this.saleId = saleId;
		this.carId = carId;
		this.userId = userId;
		this.cost = cost;
	}
	public long getSaleId() {
		return saleId;
	}
	public void setSaleId(long saleId) {
		this.saleId = saleId;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
