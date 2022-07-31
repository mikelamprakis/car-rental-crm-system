package com.example.crmsystem;

import static org.junit.jupiter.api.Assertions.*;
import com.example.crmsystem.model.Car;
import com.example.crmsystem.persistence.CarDao;
import com.example.crmsystem.persistence.CustomerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.ui.Model;
import com.example.crmsystem.controller.CarsController;
import com.example.crmsystem.controller.CustomerController;
import com.example.crmsystem.model.Customer;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class Car_CustomerTest {
	
	Model model;

	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CarsController carsController;
	
	@Autowired
	private CustomerController customerController;
	
	@BeforeEach
	void setUp() {
	}

	//--- CAR TESTS ---//
	
	@Test
	void test_CarCreation() {
		Car car = new Car("Toyota Yaris", 35);
		carDao.save(car);
		assertTrue(car.getId() > 0);
	}
	
	
	@Test
	void test_submitNewCarDetails() {
		Car car = new Car("Toyota Yaris", 35);
		carsController.submitCarDatails(car, model);
		assertTrue(carDao.findById(6).get().getDay_rate() == 35);
	}
	
	@Test
	void testUpdateDayRateCar() {
		Car car = carDao.findById(1).get();
		car.setDay_rate(80);
		carDao.save(car);
		car = carDao.findById(1).get();
		assertEquals(80,car.getDay_rate());
	}
	
	@Test
	void testCarFindById() {
		Car car = carDao.findById(1).get();
		assertEquals("Toyota Yaris", car.getModel());
	}
	
	@Test
	void testFindAllCars() {
		assertTrue(carDao.findAll().size() > 0);
	}
	
	@Test
	void testFindCarrByModel() {
		Car car = carDao.findByModel("Toyota Yaris");
		assertEquals(1,car.getId());
	}


	//--- CUSTOMER TESTS ---//


	@Test
	void test2() {
		Customer customer = new Customer("Jonny B", "14 Gilpin View");
		customerDao.save(customer);
		assertTrue(customer.getId() > 0);
	}
	
	@Test
	void test_submitNewCustomerDetails() {
		Customer customer = new Customer("Jonny B", "14 Gilpin View");
		customerController.customerDetailsSubmit(customer, model);
		assertTrue(customerDao.findById(2).get().getAddress().equals("14 Gilpin View"));
	}
	
	
	@Test
	void testUpdateCustomerAdress() {
		Customer customer = customerDao.findById(1).get();
		customer.setAddress("4 Tong Road");
		customerDao.save(customer);
		customer = customerDao.findById(1).get();
		assertEquals("4 Tong Road",customer.getAddress());
	}
	
	@Test
	void testCustomerFindById() {
		Customer customer = new Customer("Jonny B", "14 Gilpin View");
		customerDao.save(customer);
		customer = customerDao.findById(2).get();
		assertEquals("Jonny B", customer.getName());
	}
	
	@Test
	void testFindAllCustomers() {
		assertTrue(customerDao.findAll().size() > 0);
	}
	
	

}
