package com.solutions;

import java.util.HashMap;

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
		HashMap<Character, Integer> scoreboard = new HashMap<Character, Integer>();
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (scoreboard.get(c) == 1) {
				ch = c;
				break;
			}
		}
		return ch;
	}

}
