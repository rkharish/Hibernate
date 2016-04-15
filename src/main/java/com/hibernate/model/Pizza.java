package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="pizza_tbl")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//	    name="discriminator",
//	    discriminatorType=DiscriminatorType.STRING
//	)
//	@DiscriminatorValue(value="P")
public class Pizza {
	
	private int pid;
	private String type;
	private String base;
	private String description;
	private String size;
	
	@Id
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(length=20)
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Pizza [pid=" + pid + ", type=" + type + ", base=" + base + ", description=" + description + ", size="
				+ size + "]";
	}
	
	
	
	
}
