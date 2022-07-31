package com.example.crmsystem.functionality;
import com.example.crmsystem.model.Car;

public class Availability {
	
	private String from;
	private String to;
	private Car car;

	public Availability() {	
	}

	public static boolean isAvailable(Car car, String from, String to) {
		boolean isAvailable = false;
		int countUnavailable = 0;
		for (StringBuilder date : Dates.inDates(from, to)) {
			for (String occupiedDate : car.getOccupieddDates()) {
				if (date.toString().equals(occupiedDate)) {	
					countUnavailable++;
				}
			}
		}
		if (countUnavailable>0) {
			isAvailable = false;
		}else {
			isAvailable = true;
		}
		return isAvailable;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}

