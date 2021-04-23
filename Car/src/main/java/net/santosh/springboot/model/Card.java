package net.santosh.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_a_r_d")
public class Card {
	@Id
	private Long id;
	@Column(name = "userid")
	private String userId;
	@Column(name = "card_name")
	private String cardName;
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "card_expiry")
	private LocalDate cardExpiry;
	@Column(name = "cvv")
	private int cvv;

	/****************************
	 * Method: Card Description: It is used to initialize the empty constructor.
	 * Created By CHITTA YASWANTH SAI Created Date 24-MARCH-2021
	 *****************************/

	public Card() {
		super();
	}

	/****************************
	 * Method: Card Description: It is used to initialize the parameterized
	 * constructor. Created By CHITTA YASWANTHSAI Created Date 24-MARCH-2021
	 *****************************/

	public Card(long id, String cardName, String cardNumber, LocalDate cardExpiry, int cvv, String userId) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.userId = userId;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate=" + cardExpiry
				+ ", cvv=" + cvv + "]";
	}

}