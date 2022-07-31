package com.example.crmsystem.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.example.crmsystem.functionality.Status;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "reservation_gen")
	@SequenceGenerator(name = "reservation_gen", sequenceName = "RESERVATION_SEQ", allocationSize = 1)
	private int reservationId  ;
	
	private String dateFrom;
	private String dateTo;  
	private double amount;
	@Enumerated
	private Status rentStatus; //
	@Enumerated
	private Status returnStatus;
	
	private String discount;
	private int delayedDays;
	private double fine;
	private String dateOfReturn;
	
	@ManyToOne 
	private Customer customer;
	
	@ManyToOne 
	private Car car ;
	
	
	//------ CONSTRUCTORS -------//
	public Reservation(Customer customer, Car car, String dateFrom, String dateTo) {
		super();
		this.customer = customer;
		this.car = car;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}
	
	public Reservation() {
		
	}
	

	//------ GETTER & SETTERS ---------//
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	
	
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public Status getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(Status rent) {
		this.rentStatus = rent;
	}

	public Status getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Status returned) {
		this.returnStatus = returned;
	}
	
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	public int getDelayedDays() {
		return delayedDays;
	}

	public void setDelayedDays(int delayedDays) {
		this.delayedDays = delayedDays;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "Reservation [customer=" + customer + ", car=" + car + ", reservationId=" + reservationId
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", amount=" + amount + "]";
	}



		
	
}
	
	

