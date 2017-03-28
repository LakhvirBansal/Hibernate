package com.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STD_ID")
	private Long id;
	
	@Column(name="STD_FNAME")
	private String firstName;
	
	@Column(name="STD_MNAME")
	private String middleName;
	
	@Column(name="STD_LNAME")
	private String lastName;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Student_contact.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName="STD_ID")
	private List<Student_contact> contacts;
	
	/* -------------------------- or---------------------------
	 * @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
		private Set<Student_contact> contacts;
	 */

	public List<Student_contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Student_contact> contacts) {
		this.contacts = contacts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
