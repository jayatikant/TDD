package com.tdd.example.addition;

import com.tdd.example.addition.exception.NegativesNotAllowed;

public class Calculator {

	public int add(String numbers) throws NegativesNotAllowed {
		int sum = 0;
		if (numbers.equals("")) {
			return sum;
		}
		String delimiter = ",|\n";
		String numbersToBeAdded = numbers;
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, numbers.indexOf("\n"));
			numbersToBeAdded = numbers.substring(numbers.indexOf("\n") + 1,
					numbers.length());
		} 
		return add(numbersToBeAdded, delimiter);
	}

	private int add(String numbers, String delimiter) throws NegativesNotAllowed {

		int sum = 0;
		String[] split = numbers.split(delimiter);
		for (String numberString : split) {
			int number = Integer.valueOf(numberString.trim());
			if(number< 0){
				throw new NegativesNotAllowed("Negatives not allowed : ["+number+"]");
			}
			sum += number;
		}
		return sum;
	}

}
