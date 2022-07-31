package com.example.crmsystem.functionality;

public enum Status {
	
	NOT_RENT_YET("NOT RENT YET"), 
	PENDING("PENDING"), 
	RENT_AND_RETURNED("RENT AND RETURNED"), 
	RETURNED("RETURNED"), 
	RENT("RENT");
	
	private String name;
	
	private Status(String status) {
		name = status;
	}
	
	public String getName() {
		return name;
	}

}
