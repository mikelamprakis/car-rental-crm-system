package com.example.crmsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.crmsystem.functionality.Discount;


class DiscountTest {

	@Test
	void test_For4Days_Return1() {
		double result = Discount.discount("10/3/2021", "14/3/2021");
		assertEquals(1,result);
	}
	
	@Test
	void test_For5Days_Return0point9() {
		double result = Discount.discount("10/3/2021", "15/3/2021");
		assertEquals(0.9,result);
	}
	
	@Test
	void test_For11Days_Return0point85() {
		double result = Discount.discount("10/3/2021", "21/3/2021");
		assertEquals(0.85,result);
	}
	
	@Test
	void test_For21Days_Return0point8() {
		double result = Discount.discount("10/3/2021", "31/3/2021");
		assertEquals(0.8,result);
	}
	
	
	@Test
	void test_For4Days_ReturnNothing() {
		String result = Discount.showDiscount("10/3/2021", "14/3/2021");
		assertEquals(" - ",result);
	}
	
	@Test
	void test_For5Days_Return10Percent() {
		String result = Discount.showDiscount("10/3/2021", "15/3/2021");
		assertEquals("10 %",result);
	}
	
	@Test
	void test_For11Days_Return15Percent() {
		String result = Discount.showDiscount("10/3/2021", "21/3/2021");
		assertEquals("15 %",result);
	}
	
	@Test
	void test_For21Days_Return20Percent() {
		String result = Discount.showDiscount("10/3/2021", "31/3/2021");
		assertEquals("20 %",result);
	}


}
