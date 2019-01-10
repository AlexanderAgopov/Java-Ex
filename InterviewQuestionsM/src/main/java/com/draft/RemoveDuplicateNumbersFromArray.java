package com.draft;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateNumbersFromArray {

	public Object[] remove(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer num : arr) {
			if (!list.contains(num))
				list.add(num);
		}
		return list.toArray();
	}

	//Solution without Java Collections API
	public static int[] removeDuplicates(int[] numbersWithDuplicates) {

		// Sorting array to bring duplicates together
		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];
		int previous = numbersWithDuplicates[0];
		result[0] = previous;
		int finalArrayLength = 1;

		for (int i = 1; i < numbersWithDuplicates.length; i++) {
			int ch = numbersWithDuplicates[i];

			if (previous != ch) {
				result[i] = ch;
				finalArrayLength++;
			}
			previous = ch;
		}
		int counter = 0;
		int[] finalArray = new int[finalArrayLength];
		for(Integer num : result) {
			if(num != 0) {
				finalArray[counter] = num;
				counter++;
			}
		}
		
		return finalArray;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 14, 12, 31, 54, 54, 12, 18, 11 };
		RemoveDuplicateNumbersFromArray r = new RemoveDuplicateNumbersFromArray();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(r.remove(arr)));
		System.out.println(Arrays.toString(removeDuplicates(arr)));

	}

}
