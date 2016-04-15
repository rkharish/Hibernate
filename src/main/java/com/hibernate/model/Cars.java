package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cars_tbl")
public class Cars {
	
	private int cid;
	private String brand;
	private String model;
	private String color;
	
	private Person person;

	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cars [cid=" + cid + ", brand=" + brand + ", model=" + model + ", color=" + color + ", person=" + person
				+ "]";
	}
	

	
	

}
