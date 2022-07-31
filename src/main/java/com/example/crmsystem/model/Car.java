package com.example.crmsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.example.crmsystem.functionality.Dates;

@Entity
public class Car {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "car_gen")
	@SequenceGenerator(name = "car_gen", sequenceName = "CAR_SEQ", allocationSize = 1)
	private  int id;

	private String model;
	private double day_rate;
	
	@ElementCollection
	private  List<String> occupieddDates; 
	
	//-- CONSTRUCTORS --//
	
	public Car() {
	}
	
	public Car(String model, double dayRate) {
		super();
		this.model = model;
		this.day_rate = dayRate;
		occupieddDates = new ArrayList<>();
	}

	public void updateDates(String from, String to) {
		for (StringBuilder date : Dates.inDates(from, to)) {
			String stringDate = date.toString();
			occupieddDates.add(stringDate);
			}
	}
	
	public void deleteDates(String from, String to) {
		for (StringBuilder date : Dates.inDates(from, to)) {
			String stringDate = date.toString();
			occupieddDates.remove(stringDate);
			}
	}


	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getDay_rate() {
		return day_rate;
	}

	public void setDay_rate(double dayRate) {
		this.day_rate = dayRate;
	}
	
	public List<String> getOccupieddDates() {
		return occupieddDates;
	}
	

	@Override
	public String toString() {
		return "Car [car_id=" + id + ", model=" + model + ", day_rate=" + day_rate + "]";
	}

}
