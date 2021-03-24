package net.santosh.springboot.model;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="card")

public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private String cardNumber;

	@Column(name = "cardname")
	private String cardName;

	@Column(name = "cardexpiry")
	
    private LocalDate cardExpiry;

	@Column(name = "cvv")
    private int cvv;
	

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "paymentId")
	  private Payment payment;
    
    
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(String cardName, LocalDate cardExpiry, int cvv) {
		super();
		this.cardName = cardName;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
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
}
