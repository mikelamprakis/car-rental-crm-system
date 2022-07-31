package com.example.crmsystem.functionality;

public class Discount {

	private Discount(){}

	public static double discount(String from, String to) {
		double discount ;
		int daysOfRent = Dates.findDays(from, to);
		if (daysOfRent>=5 && daysOfRent <=10) {
			discount = 0.9;
		}else if (daysOfRent>=11 && daysOfRent <=20) {
			discount = 0.85;
		}else if (daysOfRent >20) {
			discount = 0.8;
		}else {
			discount = 1;
		}
		return discount;
	}

	
	public static String showDiscount(String from, String to) {
		String showDiscount;
		double discount = discount(from, to);
		if (discount ==0.9) {
			showDiscount = "10 %";
		}else if (discount ==0.85) {
			showDiscount= "15 %";
		}else if (discount ==0.8) {
			showDiscount = "20 %";
		}else {
			showDiscount = " - ";
		}
		return showDiscount;
	}
	
	
	
	
	
	
	
	
	
	
}
