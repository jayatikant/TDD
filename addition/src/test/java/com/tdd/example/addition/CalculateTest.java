package com.tdd.example.addition;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.example.addition.exception.NegativesNotAllowed;

public class CalculateTest {

	private Calculator calculator = new Calculator();

	@Test
	public void canCreateAddMethod() throws NegativesNotAllowed{
		assertEquals(1, calculator.add("1"));
	}

	@Test
	public void returnZeroForEmptyString() throws NegativesNotAllowed{
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void returnSumForASingleNumber() throws NegativesNotAllowed{
		assertEquals(3, calculator.add("3"));
	}
	
	@Test
	public void returnSumForTwoCommaSeparatedNumbers() throws NegativesNotAllowed{
		assertEquals(5, calculator.add("1,4"));
	}
	
	@Test
	public void returnSumForThreeCommaSeparatedNumbers() throws NegativesNotAllowed{
		assertEquals(6, calculator.add("1,4,1"));
	}
	
	@Test
	public void returnSumOfTwoNewLineSeparatedNumbers() throws NegativesNotAllowed{
		assertEquals(5, calculator.add("1\n4"));
	}
	
	@Test
	public void returnsSumOfThreeMixedDelimiterNumbers() throws NegativesNotAllowed{
		assertEquals(6, calculator.add("1\n2,3"));
	}
	
	@Test
	public void returnSumWithSpecifiedDeleimiter() throws NegativesNotAllowed{
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	
	@Test(expected = NegativesNotAllowed.class)
	public void negativeNumbersInInputGiveException() throws NegativesNotAllowed{
		calculator.add("1, -2");
	}
	
	@Test
	public void negativeNumbersInInputGiveExceptionWithNumber() {
		try {
			calculator.add("1, -2");
			fail("Failed to process negative numbers");
		} catch (NegativesNotAllowed e) {
			assertEquals( "Negatives not allowed : [-2]", e.getMessage());
		}
	}
	
	@Test
	public void multipleNeagtiveNumbersAppearInExceptionMessage(){
		try {
			calculator.add("1, -2, -3");
			fail("Failed to process negative numbers");
		} catch (NegativesNotAllowed e) {
			assertEquals( "Negatives not allowed : [-2, -3]", e.getMessage());
		}
	}
}
