package com.solutions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * This class contains methods that represent answers to frequently asked array
 * coding questions from programming job interviews.
 * 
 * @author a
 *
 */
public class ArrayHandlingTool {

	/**
	 * {@code} <b><i>findAllPairsUsingNestedLoops</i></b><br/>
	 * <br/>
	 * <code>private void findAllPairsUsingNestedLoops(int[] arr, int sum)</code><br/>
	 * This method finds all pairs of integer array elements whose sum is equal to a
	 * given number<br/>
	 * <br/>
	 * 
	 * @param arr - the integer array
	 * @param sum - the number set as a reference
	 * @return a HashMap containing all pairs of integer array elements whose sum is
	 *         equal to a given number
	 */
	private HashMap<Integer, Integer> findAllPairsUsingNestedLoops(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					map.put(arr[i], arr[j]);
				}
			}
		}
		return map;
	}

	/**
	 * {@code} <b><i>findAllPairsUsingHashSet</i></b><br/>
	 * <br/>
	 * <code>private void findAllPairsUsingHashSet(int[] arr, int sum)</code><br/>
	 * This method finds all pairs of integer array elements whose sum is equal to a
	 * given number<br/>
	 * <br/>
	 * 
	 * @param arr - the integer array
	 * @param sum - the number set as a reference
	 * @return a HashMap containing all pairs of integer array elements whose sum is
	 *         equal to a given number
	 */
	private HashMap<Integer, Integer> findAllPairsUsingHashSet(int[] arr, int sum) { // We iterate only once through the
																						// array
		// --> O(n) complexity time

		HashSet<Integer> set = new HashSet<Integer>(arr.length);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int number : arr) {
			int difference = sum - number;
			if (set.contains(difference)) {
				map.put(difference, number);
			} else {
				set.add(number);
			}
		}
		return map;
	}

	/**
	 * {@code} <b><i>findAllDuplicateNumbersInArray</i></b><br/>
	 * <br/>
	 * <code>private void findAllDuplicateNumbersInArray(int[] arr)</code><br/>
	 * This method finds duplicate numbers in array<br/>
	 * <br/>
	 * 
	 * @param arr - the integer array
	 * @return a HashMap. Each key in the map represents a number that is duplicated
	 *         in the array. The value to which the specified key is mapped
	 *         represents how many times this number is repeated in the array.
	 */
	public HashMap<Integer, Integer> findAllDuplicateNumbersInArray(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : arr) {
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 0);
			}
		}
		return map;
	}

	/**
	 * This is a utility method for printing all pairs in a HashMap.
	 * 
	 * @param map - HashMap
	 */
	public void printUtility(HashMap<Integer, Integer> map) {

		for (Integer number : map.keySet()) {
			System.out.printf("%d %d%n", number, map.get(number));
		}
	}

	/**
	 * {@code} <b><i>findTheSmallestAndTheBiggestNumberInArray</i></b><br/>
	 * <br/>
	 * <code>private void findTheSmallestAndTheBiggestNumberInArray(int[] arr)</code><br/>
	 * This method finds the smallest and the biggest number in array<br/>
	 * <br/>
	 * 
	 * @param arr - the integer array
	 * @return an array containing only the smallest and the biggest number from the
	 *         initial array.
	 */
	public int[] findTheSmallestAndTheBiggestNumberInArray(int[] arr) {
		int smallest = arr[0];
		int biggest = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] >= biggest) {
				biggest = arr[i];
			} else {
				if (arr[i] <= smallest)
					smallest = arr[i];
			}
		}
		int[] smallestAndBiggestNumber = { smallest, biggest };
		return smallestAndBiggestNumber;
	}

	/**
	 * This method returns an array that is a mirror image of the initial array,
	 * i.e. its elements are the same as those of the initial array but are ordered
	 * reversely.
	 * 
	 * @param arr - the integer array
	 * @return an array that is a mirror image of the initial array
	 */
	public int[] reverseArray(int[] arr) {
		int[] reversedArray = new int[arr.length];
		int counter = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			reversedArray[counter] = arr[i];
			counter++;
		}
		return reversedArray;
	}

}
