package net.santosh.springboot.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Table(name="card")

public class Card {
	@Id
	private String cardNumber;

	@Column(name = "cardname")
	private String cardName;

	@Column(name = "cardexpiry")
	
    private LocalDate cardExpiry;

	@Column(name = "cvv")
    private int cvv;
    
    
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
