package com.example.student;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="studentproject")
public class Student {
   private 	String sname;
   private 	String sClass;
	private String emailId;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@Id
	private int sId;
	
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sClass=" + sClass + ", emailId=" + emailId + ", address=" + address
				+ ", sId=" + sId + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	
}
