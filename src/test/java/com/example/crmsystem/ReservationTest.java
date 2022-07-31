package com.example.crmsystem;
import static org.junit.jupiter.api.Assertions.*;
import com.example.crmsystem.model.Car;
import com.example.crmsystem.persistence.CarDao;
import com.example.crmsystem.persistence.CustomerDao;
import com.example.crmsystem.persistence.ReservationDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.ui.Model;
import com.example.crmsystem.controller.ReservationController;
import com.example.crmsystem.functionality.Dates;
import com.example.crmsystem.functionality.Discount;
import com.example.crmsystem.functionality.Status;
import com.example.crmsystem.model.Customer;
import com.example.crmsystem.model.Reservation;


@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class ReservationTest {
	
	Model model;
	Car car1;
	Customer customer1 ;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private ReservationController reservationController;
	
	@BeforeEach
	void setUp() {
		car1 = new Car("Toyota Yaris", 35);
		carDao.save(car1);
		customer1 = new Customer("Mike", "4 Hartbee Road");
		customerDao.save(customer1);
	}
	

	@Test
	void test_reservationCreation() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		reservationDao.save(res1);
		assertTrue(res1.getReservationId() == 2);
	}
	
	@Test
	void testReservationFindById() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		reservationDao.save(res1);
		Reservation res  = reservationDao.findById(2);
		assertEquals("Toyota Yaris", res.getCar().getModel());
	}
	
	
	@Test
	void testUpdateReservationCar() {
		Reservation res1  = reservationDao.findById(1);
		res1.setCar(carDao.findById(2).get());
		reservationDao.save(res1);
		res1 = reservationDao.findById(1);
		assertEquals(2,res1.getCar().getId());
	}
			
	
	@Test
	void testFindAllReservations() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		reservationDao.save(res1);
		assertTrue(reservationDao.findAll().size() > 1);
	}
	
	
	@Test
	void testIfcreate1ReservationOf1Day_return1InOccipiedDaysList() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		res1.getCar().updateDates(res1.getDateFrom(), res1.getDateTo());
		reservationDao.save(res1);
		assertEquals(1,car1.getOccupieddDates().size());
	}
	
	@Test
	void testIfcreate1ReservationOf1Day_return1InOccipiedDaysList2() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		res1.getCar().updateDates(res1.getDateFrom(), res1.getDateTo());
		reservationDao.save(res1);
		res1.getCar().deleteDates(res1.getDateFrom(), res1.getDateTo());
		reservationDao.delete(res1);
		assertEquals(0,res1.getCar().getOccupieddDates().size());
	}
	
	
	@Test
	void test_For1DatReservation_ReturnAmount35NoDiscount() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "10/3/2021" );
		res1.setDiscount(Discount.showDiscount(res1.getDateFrom(),res1.getDateTo()));
		res1.setAmount(Dates.findDays(res1.getDateFrom(), res1.getDateTo())*Discount.discount(res1.getDateFrom(), res1.getDateTo())*res1.getCar().getDay_rate());
		reservationDao.save(res1);
		assertEquals(35,res1.getAmount());
	}
	
	@Test
	void test_For5DatReservation_ReturnAmount157and5With10PercentDiscount() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "15/3/2021" );
		res1.setDiscount(Discount.showDiscount(res1.getDateFrom(),res1.getDateTo()));
		res1.setAmount(Dates.findDays(res1.getDateFrom(), res1.getDateTo())*Discount.discount(res1.getDateFrom(), res1.getDateTo())*res1.getCar().getDay_rate());
		reservationDao.save(res1);
		assertEquals(157.5,res1.getAmount());
	}
	
	@Test
	void test_For11DatReservation_ReturnAmount327and25With15PercentDiscount() {
		Reservation res1 = new Reservation(customer1, car1,"10/3/2021", "21/3/2021" );
		res1.setDiscount(Discount.showDiscount(res1.getDateFrom(),res1.getDateTo()));
		res1.setAmount(Dates.findDays(res1.getDateFrom(), res1.getDateTo())*Discount.discount(res1.getDateFrom(), res1.getDateTo())*res1.getCar().getDay_rate());
		reservationDao.save(res1);
		assertEquals(327.25,res1.getAmount());
	}
	
	
	@Test
	void test_For22DatReservation_ReturnAmount313and25With20PercentDiscount() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "30/3/2021" );
		res1.setDiscount(Discount.showDiscount(res1.getDateFrom(),res1.getDateTo()));
		res1.setAmount(Dates.findDays(res1.getDateFrom(), res1.getDateTo())*Discount.discount(res1.getDateFrom(), res1.getDateTo())*res1.getCar().getDay_rate());
		reservationDao.save(res1);
		assertEquals(616,res1.getAmount());
	}
	
	
	@Test
	void test_For22DatReservation_Return20PercentDiscount() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "30/3/2021" );
		res1.setDiscount(Discount.showDiscount(res1.getDateFrom(),res1.getDateTo()));
		res1.setAmount(Dates.findDays(res1.getDateFrom(), res1.getDateTo())*Discount.discount(res1.getDateFrom(), res1.getDateTo())*res1.getCar().getDay_rate());
		reservationDao.save(res1);
		assertEquals("20 %",res1.getDiscount());
	}
	
	@Test
	void test_ForNewReservation_ReturnRentStatusPENDING() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "30/3/2021" );
		res1.setRentStatus(Status.PENDING);
		reservationDao.save(res1);
		assertEquals(Status.PENDING,res1.getRentStatus());
	}
	
	@Test
	void test_ForNewReservation_ReturnReturnStatusNOTRENTYET() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "30/3/2021" );
		res1.setReturnStatus(Status.NOT_RENT_YET);
		reservationDao.save(res1);
		assertEquals(Status.NOT_RENT_YET,res1.getReturnStatus());
	}
	
	@Test
	void test_ForDateOfReturnAfter2Days_Return2DelayedDays() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "10/3/2021" );
		res1.setDateOfReturn("12/3/2021");
		reservationDao.save(res1);
		reservationController.submitReturnDetails(res1.getReservationId(),res1.getDateOfReturn());
		assertEquals(2,reservationDao.findById(res1.getReservationId()).getDelayedDays());
	}
	
	@Test
	void test_For2daysDelay_Return200Fine() {
		Reservation res1 = new Reservation(customer1, car1,"8/3/2021", "10/3/2021" );
		res1.setDateOfReturn("12/3/2021");
		reservationDao.save(res1);
		reservationController.submitReturnDetails(res1.getReservationId(),res1.getDateOfReturn());
		assertEquals(200,reservationDao.findById(res1.getReservationId()).getFine());
	}
	
	
	

	

	

}
