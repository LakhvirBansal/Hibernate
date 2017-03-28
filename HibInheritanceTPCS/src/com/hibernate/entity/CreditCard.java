package com.hibernate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="credit_card")
@AttributeOverrides({
	  @AttributeOverride(name="id", column=@Column(name="PAYMENT_ID")),  
	    @AttributeOverride(name="amount", column=@Column(name="AMOUNT"))
})
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
