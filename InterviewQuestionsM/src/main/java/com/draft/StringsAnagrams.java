package com.draft;

public class StringsAnagrams {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "hello";
		String s2 = "asd";
		String s3 = "four";
		String s4 = "olleh";
		
		StringsAnagrams sa = new StringsAnagrams();
		System.out.println(sa.areStringsAnagrams(s1, s2));
		System.out.println(sa.areStringsAnagrams(s1, s3));
		System.out.println(sa.areStringsAnagrams(s1, s4));
		

	}

}
