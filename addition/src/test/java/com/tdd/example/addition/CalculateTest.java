package com.tdd.example.addition;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	private Calculator calculator = new Calculator();

	@Test
	public void canCreateAddMethod(){
		assertEquals(1, calculator.add("1"));
	}

	@Test
	public void returnZeroForEmptyString(){
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void returnSumForASingleNumber(){
		assertEquals(3, calculator.add("3"));
	}
	
	@Test
	public void returnSumForTwoCommaSeparatedNumbers(){
		assertEquals(5, calculator.add("1,4"));
	}
}
