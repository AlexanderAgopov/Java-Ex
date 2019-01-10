package com.draft;

import java.util.HashSet;

public class FindAllPairsOfIntegersInArrayWhoseSumIsEqualToAGivenNumber {

	/*
	 * The task is to find all pairs of an integer array elements whose sum is equal
	 * to a given number
	 */

	private void findUsingTwoNestedLoops(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.printf("%d %d %n", arr[i], arr[j]);
				}
			}
		}
	}

	private void findUsingHashSet(int[] numbers, int sum) { // We iterate only once through the array --> O(n)
															// complexity
															// time

		HashSet<Integer> set = new HashSet<Integer>(numbers.length);

		for (int number : numbers) {
			int difference = sum - number;
			if (set.contains(difference)) {
				System.out.println(number + " " + difference);
			} else {
				set.add(number);
			}
		}
	}

	private void printDetails(int[] arr, int sum) {
		System.out.println("=============================");
		System.out.println("The sum should be " + sum);
		System.out.println();
		System.out.println("The array elements are:");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Matching pairs:");
	}

	public static void main(String[] args) {

		int num = 10;
		int[] arr1 = { 3, 2, 8, 6 };
		int[] arr2 = { 1, 3, 5, 5 };

		FindAllPairsOfIntegersInArrayWhoseSumIsEqualToAGivenNumber f = new FindAllPairsOfIntegersInArrayWhoseSumIsEqualToAGivenNumber();

		f.printDetails(arr1, num);
		f.findUsingTwoNestedLoops(arr1, num);
		f.printDetails(arr2, num);
		f.findUsingTwoNestedLoops(arr2, num);
		f.printDetails(arr1, num);
		f.findUsingHashSet(arr1, num);
		f.printDetails(arr2, num);
		f.findUsingHashSet(arr2, num);

	}

}
