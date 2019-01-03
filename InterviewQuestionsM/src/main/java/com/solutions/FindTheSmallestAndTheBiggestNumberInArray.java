package com.solutions;

import java.util.Random;

public class FindTheSmallestAndTheBiggestNumberInArray {

	public static void main(String[] args) {
		int[] arr = new int[10];

		Random rndm = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rndm.nextInt(100);
			System.out.print(arr[i] + " ");
		}

		int smallest = arr[0];
		int biggest = arr[0];

		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] >= biggest) {
				biggest = arr[i];
			} else {
				if(arr[i] <= smallest)
				smallest = arr[i];
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(smallest);
		System.out.println();
		System.out.println(biggest);

	}

}
