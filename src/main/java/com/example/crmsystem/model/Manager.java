package com.example.crmsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Manager {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "manager_gen")
	@SequenceGenerator(name = "manager_gen", sequenceName = "MANAGER_SEQ", allocationSize = 1)
	private int managerId;
	private String username;
	private String password;
	

	public Manager() {	
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
