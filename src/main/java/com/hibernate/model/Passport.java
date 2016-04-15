package com.hibernate.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passport_tbl")
public class Passport {

	private int passid;
	private String passno;
	private String country;
	private byte[] photo;

	private Person person1;

	///When we get person, take his primary key and put it under Pass_id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Pass_id", nullable = false)
	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPassid() {
		return passid;
	}

	public void setPassid(int passid) {
		this.passid = passid;
	}

	public String getPassno() {
		return passno;
	}

	public void setPassno(String passno) {
		this.passno = passno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Passport [passid=" + passid + ", passno=" + passno + ", country=" + country + ", photo="
				+ Arrays.toString(photo) + ", person1=" + person1 + "]";
	}

	

}
