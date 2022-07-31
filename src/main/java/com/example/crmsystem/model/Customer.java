package com.example.crmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "customer_gen")
	@SequenceGenerator(name = "customer_gen", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
	private int id;

	@Column(unique = true)
	private String name;
	private String address;

	public Customer( String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Customer() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
