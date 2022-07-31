package com.example.crmsystem.controller;
import com.example.crmsystem.functionality.Availability;
import com.example.crmsystem.functionality.Dates;
import com.example.crmsystem.functionality.Discount;
import com.example.crmsystem.functionality.Status;
import com.example.crmsystem.persistence.CarDao;
import com.example.crmsystem.persistence.CustomerDao;
import com.example.crmsystem.persistence.ReservationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.crmsystem.model.Reservation;


@Controller
public class ReservationController {

	private final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping("showRes")
	public ModelAndView showReservations() {
		return new ModelAndView("WEB-INF/allReservations.jsp", "reservations", reservationDao.findAll());
	}

	@RequestMapping("addRes")
	public ModelAndView openAddResForm() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addReservation.jsp");
		modelAndView.addObject("reservation", new Reservation());
		modelAndView.addObject("allCars", carDao.findAll());
		modelAndView.addObject("allCustomers", customerDao.findAll());
		return modelAndView;
	}
	
	@PostMapping("insertRes")
	public String submitReservationDetails(
			@ModelAttribute("reservation")Reservation reservation, Model model
			) {
		if (Dates.checkValidDates(reservation.getDateFrom(), reservation.getDateTo())) {
			if (Availability.isAvailable(reservation.getCar(), reservation.getDateFrom(), reservation.getDateTo())) {
				reservation.setRentStatus(Status.PENDING);
				reservation.setReturnStatus(Status.NOT_RENT_YET);
				reservation.setDiscount(Discount.showDiscount(reservation.getDateFrom(),reservation.getDateTo()));
				reservation.setAmount(Dates.findDays(reservation.getDateFrom(), reservation.getDateTo())*Discount.discount(reservation.getDateFrom(), reservation.getDateTo())*reservation.getCar().getDay_rate());
				reservation.getCar().updateDates(reservation.getDateFrom(), reservation.getDateTo());
				reservationDao.save(reservation);
				logger.info("Reservation created successfully.");
				return "welcome.jsp";
			}
			model.addAttribute("message", "THIS CAR IS NOT AVAILABLE ON THESE DATES");
			model.addAttribute("reservation", new Reservation());
			model.addAttribute("allCars", carDao.findAll());
			model.addAttribute("allCustomers", customerDao.findAll());
			logger.info("Cannot create reservation because this car is not available on these dates");
			return "WEB-INF/addReservation.jsp" ;
		}
		model.addAttribute("message2", "INVALID DATES");
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("allCars", carDao.findAll());
		model.addAttribute("allCustomers", customerDao.findAll());
		logger.info("Cannot create reservation because the dates are invalid");
		return "WEB-INF/addReservation.jsp" ;
	}
	
	
	@RequestMapping("deleteRes")
	public ModelAndView deleteRes(
			@RequestParam("reservation_id") int reservationId
			) {
		Reservation  reservationFromDB = reservationDao.findById(reservationId);
		reservationFromDB.getCar().deleteDates(reservationFromDB.getDateFrom(), reservationFromDB.getDateTo());
		reservationDao.delete(reservationFromDB);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/allReservations.jsp");
		modelAndView.addObject("reservations", reservationDao.findAll());
		logger.info("Reservation deleted successfully");
		return modelAndView;
	}
	
	
	@RequestMapping("EditRentalStatus")
	public ModelAndView updateRental(
			@RequestParam("reservation_id") int reservationId
			) {
		Reservation  reservationFromDB = reservationDao.findById(reservationId);
		reservationFromDB.setRentStatus(Status.RENT);
		reservationFromDB.setReturnStatus(Status.PENDING);
		reservationDao.save(reservationFromDB);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/allReservations.jsp");
		modelAndView.addObject("reservations", reservationDao.findAll());
		logger.info("Rental status updated");
		return modelAndView;
	}


	@GetMapping("EditReturnStatus")
	public ModelAndView updateReturn(
			@RequestParam("reservation_id") int reservationId
			) {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/returnForm.jsp");
		modelAndView.addObject("reservation_id", reservationId);
		modelAndView.addObject("reservation", reservationDao.findById(reservationId));
		return  modelAndView;
	}


	@PostMapping("returnSubmit")
	public ModelAndView submitReturnDetails(
			@RequestParam("reservation_id") int reservationId,
			@RequestParam("dateOfReturn") String dateOfReturn
			) {
		Reservation reservationFromDB = reservationDao.findById(reservationId);
		reservationFromDB.setRentStatus(Status.RENT_AND_RETURNED);
		reservationFromDB.setReturnStatus(Status.RETURNED);
		reservationFromDB.setDelayedDays(Dates.findDays(reservationFromDB.getDateTo(), dateOfReturn));
		reservationFromDB.setFine(reservationFromDB.getDelayedDays()*100);
		reservationDao.save(reservationFromDB);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/allReservations.jsp");
		modelAndView.addObject("reservation", reservationFromDB);
		modelAndView.addObject( "reservations", reservationDao.findAll());
		logger.info("Return status updated");
		return  modelAndView;
	}

}
