package com.example.crmsystem.controller;

import com.example.crmsystem.persistence.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.crmsystem.model.Manager;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerDao managerDao;
	
	@GetMapping("Login")
	public ModelAndView login() {
		return new ModelAndView("login.jsp", "manager", new Manager());
	}
	
	@PostMapping("LoginSubmit")
	public String loginSubmit(@ModelAttribute("manager")Manager manager,
			Model model) {
		
		Manager userFromDatabase = managerDao.findByUsernameAndPassword(manager.getUsername(), manager.getPassword());
		if (userFromDatabase == null) {
			model.addAttribute("message", "Incorrect username or password");
			return "login.jsp";
		}
		model.addAttribute("user", userFromDatabase);
		return "welcome.jsp";
	}
	
	@GetMapping("logout")
	public ModelAndView logout() {
		return new ModelAndView("login.jsp", "manager", new Manager());
	}
	
	@GetMapping("homepage")
	public ModelAndView homepage() {
		return new ModelAndView("welcome.jsp", "manager", new Manager());
	}
	
	
	
	
	

}
