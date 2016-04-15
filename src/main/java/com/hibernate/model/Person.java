package com.hibernate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persons_tbl")
public class Person {

	private int pid;
	private String name;
	private int age;
	private String email;
	private String mobile;
	private String gender;
	
	private Set<Address> addresses=new HashSet<Address>();  

	private Passport pass;
	private List<Cars> car;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_address_tbl", 
	joinColumns={@JoinColumn(name="pid")}, 
	inverseJoinColumns={@JoinColumn(name="aid")})
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	public List<Cars> getCar() {
		return car;
	}

	public void setCar(List<Cars> car) {
		this.car = car;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "person1")
	public Passport getPass() {
		return pass;
	}

	public void setPass(Passport pass) {
		this.pass = pass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", age=" + age + ", email=" + email + ", mobile=" + mobile
				+ ", gender=" + gender + ", addresses=" + addresses + ", pass=" + pass + ", car=" + car + "]";
	}
	
	
}
