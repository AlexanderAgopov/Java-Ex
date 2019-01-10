package com.draft;

import java.util.Arrays;

public class HowToReverseAnArray {

	public int[] reverseArray(int[] arr) {
		int[] reversedArray = new int[arr.length];
		int counter = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			reversedArray[counter] = arr[i];
			counter++;
		}
		return reversedArray;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };

		HowToReverseAnArray r = new HowToReverseAnArray();
		System.out.println(Arrays.toString(arr));
		arr = r.reverseArray(arr);
		System.out.print(Arrays.toString(arr));

	}

}
