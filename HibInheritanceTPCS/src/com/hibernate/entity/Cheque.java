package com.hibernate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cheque")
@AttributeOverrides({
	  @AttributeOverride(name="id", column=@Column(name="PAYMENT_ID")),  
	    @AttributeOverride(name="amount", column=@Column(name="AMOUNT"))
})
public class Cheque extends Payment{
	
	@Column(name="CHEQUE_TYPE")
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

}
