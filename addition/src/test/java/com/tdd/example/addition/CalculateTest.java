package com.tdd.example.addition;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	private Calculator calculator = new Calculator();

	@Test
	public void canCreateAddMethod(){
		int sum = calculator.add("1");
		assertEquals(1, sum);
	}

	@Test
	public void returnZeroForEmptyString(){
		int sum = calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void returnSumForASingleNumber(){
		int sum = calculator.add("3");
		assertEquals(3, sum);
	}
}
