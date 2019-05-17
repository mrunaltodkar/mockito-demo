package com.capgemini.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest {

	@Mock
	private CalculatorService service;
	
	@InjectMocks
	MathApplication application = new MathApplication(service);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPerformAdditionWithTwoPositiveIntegers() {
		when(service.addition(5, 5)).thenReturn(10);
		assertEquals(10, application.performAddition(5,5));
	}
	
	@Test
	public void testPerformAdditionEithTwoNegativeIntegers() {
		when(service.addition(-5, -3)).thenReturn(-8);
		assertEquals(-8, application.performAddition(-5, -3));
	}
	
	@Test
	public void testPerformAdditionEithOneNegativeAndOnePossitiveIntegers() {
		when(service.addition(-5, 2)).thenReturn(-3);
		assertEquals(-3, application.performAddition(-5, 2));
	}


	@Test
	public void testFindFactorialWithPositiveInteger() {
	when(service.factorial(5)).thenReturn(120L);
	assertEquals(120, application.findFactorial(5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() {
	doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
	application.performDivision(10, 0); 
	}

}
