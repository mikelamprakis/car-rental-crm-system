package com.example.crmsystem;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.example.crmsystem.functionality.Dates;

class DatesTest {
		
	@Test
	void testinDates_ForSameDay_Return1DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("1/1/2021", "1/1/2021");
		assertEquals(1,dates.size());
	}
	
	@Test
	void testinDates_For1Day_Return2DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("1/1/2021", "2/1/2021");
		assertEquals(2,dates.size());
	}
	
	
	@Test
	void testinDates_For29Days_Return30DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("1/1/2021", "30/1/2021");
		assertEquals(30,dates.size());
	}
	
	@Test
	void testinDates_For35Days_Return36DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("1/1/2021", "5/2/2021");
		assertEquals(36,dates.size());
	}
	
	
	@Test
	void testinDates_WhenDatesInputWithZeroBeforeNumber_For35Days_Return36DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("01/01/2021", "05/02/2021");
		assertEquals(36,dates.size());
	}
	
	@Test
	void testinDates_For59Days_Return60DateInListOfDates() {
		ArrayList<StringBuilder> dates = Dates.inDates("01/01/2021", "1/03/2021");
		assertEquals(60,dates.size());
	}
	
	@Test
	void testinDates_For59Days_Return60Days() {
		int days = Dates.findDays("01/01/2021", "1/03/2021");
		assertEquals(59,days);
	}
	
	
	@Test
	void testinDates_ForSameDays_Return1Day() {
		int days = Dates.findDays("01/01/2021", "1/1/2021");
		assertEquals(1,days);
	}
	
	@Test
	void testinDates_For1Days_Return1Day() {
		int days = Dates.findDays("01/01/2021", "1/1/2021");
		assertEquals(1,days);
	}
	
	@Test
	void testinDates_For10Days_Return10Days() {
		int days = Dates.findDays("01/01/2021", "11/1/2021");
		assertEquals(10,days);
	}
	
	@Test
	void testinValidDates_DatesValid_Returntrue() {
		boolean validity = Dates.checkValidDates("01/01/2021", "11/1/2021");
		assertEquals(true,validity);
	}
	
	@Test
	void testinValidDates_DatesSame_ReturnTrue() {
		boolean validity = Dates.checkValidDates("10/01/2021", "10/01/2021");
		assertEquals(true,validity);
	}
	
	@Test
	void testinValidDates_DatesInvalid_ReturnFalse() {
		boolean validity = Dates.checkValidDates("10/01/2021", "05/01/2021");
		assertEquals(false,validity);
	}
	

}
