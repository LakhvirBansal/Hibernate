package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_contact")
public class Student_contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contact_id")
	private Long contactId;

	@Column(name="address_line_1")
	private String addrLine1;
	
	@Column(name="address_line_2")
	private String addrLine2;
	
	@Column(name="pin")
	private Long pin;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id"/*, referencedColumnName="STD_ID"*/)
	private Student student;
	
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
