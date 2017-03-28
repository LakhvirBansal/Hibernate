package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="credit_card")
@PrimaryKeyJoinColumn(name="PAYMENT_ID")  
public class CreditCard extends Payment{

	@Column(name="CREDIT_CARD_TYPE")
	private String creditCardType;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
}
