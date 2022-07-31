package com.example.crmsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.crmsystem.model.Car;
import com.example.crmsystem.persistence.CarDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.crmsystem.functionality.Availability;
import com.example.crmsystem.functionality.Dates;


@Controller
public class CarsController {
	
	private final Logger logger = LoggerFactory.getLogger(CarsController.class);
	
	@Autowired
	private CarDao carDao;

	@RequestMapping("showCars")
	public ModelAndView showCarrs() {
		return new ModelAndView("WEB-INF/allCars.jsp", "cars", carDao.findAll());
	}
	
	
	@RequestMapping("addCar")
	public String openAddCarForm(Model model) {
		model.addAttribute("car", new Car());
		return "WEB-INF/addcar.jsp";
	}
	
	@PostMapping("insertCar")
	public String submitCarDatails(
			@ModelAttribute("car")Car car, Model model) {
		carDao.save(car);
		logger.info("Car created successfully");
		return "welcome.jsp";
	}
	
	@RequestMapping("checkAvailability")
	public String openAvailabilityForm(Model model) {
		model.addAttribute("availability", new Availability());
		model.addAttribute("allCars", carDao.findAll());
		return "WEB-INF/availabilityForm.jsp";
	}
	
	
	@PostMapping("findAvailability")
	public String showAvailable(
	 @ModelAttribute("availableCars")Availability availability, Model model) {
		if (Dates.checkValidDates(availability.getFrom(), availability.getTo())) {
			List<Car> listofCars = new ArrayList<>();
			for (Car car : carDao.findAll()) {
				if (Availability.isAvailable(car, availability.getFrom(), availability.getTo())) {
					listofCars.add(car);
				}
			}
			model.addAttribute("availableCars", listofCars);
			logger.info("Available cars displayed successfully");
			return "WEB-INF/availability.jsp";
		}
		model.addAttribute("message", "INVALID DATES");
		model.addAttribute("availability", new Availability());
		model.addAttribute("allCars", carDao.findAll());
		logger.info("Invalid Dates");
		return "WEB-INF/availabilityForm.jsp";
	}
	
	
}
