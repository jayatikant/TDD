package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diamond {

	private static final char START_CHARACTER = 'A';
	private final char middleLetter;

	public Diamond(char middleLetter) {
		this.middleLetter = middleLetter;
	}

	public List<List<Character>> getRows() {
		List<List<Character>> rows = new ArrayList<List<Character>>();
		List<Character> letterSequence = getLetterSequence();
		List<Integer> indentationSequence = getIndentationSequence();
		List<Integer> betweenSequence = getBetweenSequence();
		for (int i = 0; i < letterSequence.size(); i++) {
			rows.add(getOneRow(letterSequence.get(i),
					indentationSequence.get(i), betweenSequence.get(i)));
		}
		return rows;
	}

	public static String print(char middleLetter) {

		Diamond diamond = new Diamond(middleLetter);
		StringBuffer result = new StringBuffer();
		int counter = 0;
		List<List<Character>> rows = diamond.getRows();
		for (List<Character> chars : rows) {
			appendCharactersToResult(result, chars);
			counter++;
			if (counter != rows.size()) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	private static void appendCharactersToResult(StringBuffer result,
			List<Character> chars) {
		for (Character c : chars) {
			result.append(c);
		}

	}

	public static void main(String[] args) {
		if (args.length == 1) {
			System.out.println(Diamond.print(args[0].charAt(0)));
		} else {
			System.out
					.println("please supply one argument: the char of the diamond middle");
		}

	}

	public List<Character> getLetterSequence() {
		List<Character> characters = getFirstHalfOfDiamond();
		reverseAndAddToList(characters);
		return characters;
	}

	private <T> void reverseAndAddToList(List<T> characters) {
		List<T> secondHalfCharacters = new ArrayList<T>(characters);
		Collections.reverse(secondHalfCharacters);
		secondHalfCharacters.remove(0);
		characters.addAll(secondHalfCharacters);
	}

	private List<Character> getFirstHalfOfDiamond() {
		List<Character> characters = new ArrayList<Character>();
		int endValue = Integer.valueOf(middleLetter);
		int startValue = Integer.valueOf(START_CHARACTER);
		for (; startValue <= endValue; startValue++) {
			characters.add(Character.valueOf((char) startValue));
		}
		return characters;
	}

	public List<Integer> getIndentationSequence() {

		List<Integer> indentationSequence = getFirstHalfIndentationSequence();
		reverseAndAddToList(indentationSequence);
		return indentationSequence;
	}

	private List<Integer> getFirstHalfIndentationSequence() {
		List<Integer> indentationSequence = new ArrayList<Integer>();
		int difference = Integer.valueOf(middleLetter)
				- Integer.valueOf(START_CHARACTER);
		for (int i = difference; i >= 0; i--) {
			indentationSequence.add(i);
		}
		return indentationSequence;
	}

	public List<Integer> getBetweenSequence() {
		List<Integer> betweenSequence = getFirstHalfBetweenSequence();
		reverseAndAddToList(betweenSequence);
		return betweenSequence;
	}

	private List<Integer> getFirstHalfBetweenSequence() {
		List<Integer> betweenSequence = new ArrayList<Integer>();
		int difference = Integer.valueOf(middleLetter)
				- Integer.valueOf(START_CHARACTER);
		betweenSequence.add(0);
		for (int i = 1; i <= difference; i++) {
			betweenSequence.add(2 * i - 1);
		}
		return betweenSequence;
	}

	public List<Character> getOneRow(char c, int i, int j) {
		List<Character> oneRow = new ArrayList<Character>();
		addSpacesToRow(i, oneRow);
		oneRow.add(c);
		addSpacesToRow(j, oneRow);
		if (j != 0) {
			oneRow.add(c);
		}
		return oneRow;
	}

	private void addSpacesToRow(int i, List<Character> oneRow) {
		for (int indent = 0; indent < i; indent++) {
			oneRow.add(' ');
		}
	}

}
