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

}
