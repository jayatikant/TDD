package com.tdd.example.addition;

public class Calculator {

	public int add(String numbers) {
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

	private int add(String numbers, String delimiter) {

		int sum = 0;
		String[] split = numbers.split(delimiter);
		for (String number : split) {
			sum += Integer.valueOf(number);
		}
		return sum;
	}

}
