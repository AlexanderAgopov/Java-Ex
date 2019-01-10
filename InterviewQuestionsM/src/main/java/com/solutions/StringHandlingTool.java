package com.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * This class contains methods that represent answers to frequently asked string
 * coding questions from programming job interviews
 * 
 * @author a
 * 
 */
public class StringHandlingTool {

	public String reverseStringRecursively(String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseStringRecursively(str.substring(1)) + str.charAt(0);
	}

	public String reverseStringIteratively(String str) {
		String reversedString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversedString += str.charAt(i);
		}
		return reversedString;
	}

	public boolean areStringsAnagrams(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {
			boolean anagrams = true;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
					anagrams = false;
					break;
				}
			}
			return anagrams;
		}
	}

	/**
	 * This method finds the first non-repeated character in a string using nested
	 * loops.
	 * 
	 * @param s - the string
	 * @return the first non-repeated character in the string. Returns blank space
	 *         if all characters in the string are repeated.
	 */
	public char getFirstNonRepeatedCharUsingNestedLoops(String s) {
		char ch = ' ';
		boolean repeated = false;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					repeated = true;
				}
			}
			if (repeated == false) {
				ch = s.toCharArray()[i];
				break;
			}
		}
		return ch;
	}

	/**
	 * This method finds the first non-repeated character in a string using HashMap.
	 * 
	 * @param s the string
	 * @return
	 */
	public char getFirstNonRepeatedCharUsingHashMap(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == 1) {
				ch = c;
				break;
			}
		}
		return ch;
	}

	/**
	 * This method checks if a string contains only digits.
	 * 
	 * @param s - the string
	 * @return true if the string contains only digits
	 */
	public boolean areAllCharsDigitsUsingForLoop(String s) {
		boolean digits = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 0 || s.charAt(i) > 9) {
				digits = false;
			}
		}
		return digits;
	}

	public HashSet<Character> getAllDuplicateChars(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		HashSet<Character> duplicateChars = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) >= 2) {
				duplicateChars.add(s.charAt(i));
			}
		}
		return duplicateChars;
	}

	public int[] countVowelsAndConsonants(String s) {
		int vowels = 0;
		int consonants = 0;
		int[] values = { vowels, consonants };
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'y') {
				vowels++;
			} else {
				consonants++;
			}
		}
		return values;
	}

	public int countCharOccurrences(String s, char c) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				counter++;
			}
		}
		return counter;
	}

	public String reverseWordsInSentenceUsingWhileLoop(String sentence) {
		String reversedSentence = "";
		while (sentence.lastIndexOf(' ') != -1) {
			reversedSentence = reversedSentence + sentence.substring(sentence.lastIndexOf(' ')) + " ";
			sentence = sentence.substring(0, sentence.lastIndexOf(' '));
		}
		return reversedSentence;
	}

	public boolean isPalindrome(String s) {
		boolean palindrome = true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.length() - 1 - s.charAt(i)) {
				palindrome = false;
				break;
			}
		}
		return palindrome;
	}

}
