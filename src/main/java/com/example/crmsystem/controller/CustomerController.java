package com.example.crmsystem.controller;
import com.example.crmsystem.persistence.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.crmsystem.model.Customer;

 @Controller
public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("showCustomers")
	public ModelAndView showCustomers() {
		return new ModelAndView("WEB-INF/allCustomers.jsp", "customers", customerDao.findAll());
	}
	
	@RequestMapping("addCustomer")
	public String openAddCarForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "WEB-INF/addCustomer.jsp";
	}
	
	@PostMapping("insertCustomer")
	public String customerDetailsSubmit(
			@ModelAttribute("customer")Customer customer, Model model) {
		Customer customerFromDatabase = customerDao.findByNameAndAddress(customer.getName(), customer.getAddress());
		if (customerFromDatabase != null) {
			model.addAttribute("message", "This customer name already exists");
			logger.info("Cannot create customer because the customer already exist in the database");
			return "WEB-INF/addCustomer.jsp";
		}
		customerDao.save(customer);
		logger.info("Customer created successfully");
		return "welcome.jsp";
	}
	

}
