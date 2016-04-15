package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

@Entity
@Table(name="laptop_tbl")
@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Laptop {
	
	private int lid;
	private String name;
	private String model;
	private String ram;
	private String generation;
	private float price;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", name=" + name + ", model=" + model + ", ram=" + ram + ", generation="
				+ generation + ", price=" + price + "]";
	}
	
	
}
