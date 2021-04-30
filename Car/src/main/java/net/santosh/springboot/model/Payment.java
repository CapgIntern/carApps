package net.santosh.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="paymentid")
	private long paymentId;
	@Column(name="orderid")
	private long orderId;
	@Column(name = "type")
	private String type;
	@Column(name = "status")
	private String status;
	@Column(name = "cardid")
	private long cardId;
	@Column(name = "userid")
	private String userId;

	/****************************
	 * Method: Payment Description: It is used to initialize the empty constructor.
	 * Created By CHITTA YASWANTH SAI Created Date 24-MARCH-2021
	 *****************************/

	public Payment() {
		super();
	}

	/****************************
	 * Method: Payment Description: It is used to initialize the parameterized
	 * constructor. Created By CHITTA YASWANTH SAI Created Date 24-MARCH-2021
	 *****************************/

	public Payment(long paymentId, long orderId,String type, String status, long cardId, String userId) {
		super();
		this.cardId = cardId;
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.userId = userId;
		

	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", cardId=" + cardId + "]";
	}

}