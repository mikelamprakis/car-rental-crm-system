package com.example.crmsystem;

import static org.junit.jupiter.api.Assertions.*;
import com.example.crmsystem.persistence.ManagerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import com.example.crmsystem.model.Manager;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class ManagerLoginTest {

	Model model;
	Manager manager1;
	
	@Autowired
	private ManagerDao managerDao;
	
	
	@BeforeEach
	void setUp() {
		Manager manager1 = new Manager();
		manager1.setUsername("Jonny");
		manager1.setPassword("jonny123");
		managerDao.save(manager1);
	}
	
	@Test
	void test_ifLoginDetailsCorrectManagerExistInDatabase() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject( "manager", new Manager());
		Manager userFromDatabase = managerDao.findByUsernameAndPassword("Jonny", "jonny123");
		assertTrue(userFromDatabase != null);
	}
	
	@Test
	void test_ifLoginDetailsCorrectManagerDoesntExistInDatabase() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject( "manager", new Manager());
		Manager userFromDatabase = managerDao.findByUsernameAndPassword("Stefan", "jonny123");
		assertFalse(userFromDatabase != null);
	}



	
	
	
}
