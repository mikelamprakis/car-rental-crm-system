package com.example.crmsystem;

import static org.junit.jupiter.api.Assertions.*;

import com.example.crmsystem.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.crmsystem.functionality.Availability;
import com.example.crmsystem.model.Manager;

class AvailabilityTest {

	Car car1;
	Manager manager1;
	
	@BeforeEach
	void setUp() {
		car1 = new Car("Toyota Yaris", 35);
		car1.updateDates("2/3/2021", "5/3/2021");
	}

	@Test
	void test_ifAllDaysOccupied_ReturnFalse() {
		boolean result = Availability.isAvailable(car1, "02/03/2021","03/03/2021");
		assertEquals(false,result);		
	}
	
	@Test
	void test_ifOnlyFirstDaysOccupied_ReturnFalse() {
		boolean result = Availability.isAvailable(car1, "05/03/2021","10/03/2021");
		assertEquals(false,result);		
	}
	
	
	@Test
	void test_ifSomeDaysOccupied_ReturnFalse() {
		boolean result = Availability.isAvailable(car1, "06/02/2021","3/03/2021");
		assertEquals(false,result);		
	}
	
	@Test
	void test__ifNoDaysOccupied_ReturnTrue() {
		boolean result = Availability.isAvailable(car1, "06/02/2021","10/02/2021");
		assertEquals(true,result);		
	}
	
	@Test
	void test__ifSameDayWithDaysOccupiedButDifferentMonth_ReturnTrue() {
		boolean result = Availability.isAvailable(car1, "02/02/2021","5/2/2021");
		assertEquals(true,result);		
	}
	
	
	

}
