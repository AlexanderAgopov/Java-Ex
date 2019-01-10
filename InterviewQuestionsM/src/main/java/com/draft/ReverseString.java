package com.draft;

public class ReverseString {

	public String reverseRecursively(String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseRecursively(str.substring(1)) + str.charAt(0);
	}

	public String reverseIteratively(String str) {
		String reversedString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversedString += str.charAt(i);
		}
		return reversedString;
	}

	public static void main(String[] args) {
		String s = "qwerty";
		System.out.println(s);
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseRecursively(s));
		System.out.println(rs.reverseIteratively(s));
	}

}
