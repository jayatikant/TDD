package com.tdd.example.addition;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void canCreateCalculator	() {
		Calculator calculator = new Calculator();
	}
	
	@Test
	public void canCreateAddMethod(){
		Calculator calculator = new Calculator();
		int sum = calculator.add("1");
		assertEquals(1, sum);
	}

}
