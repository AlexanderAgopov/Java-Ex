package com.draft;

import java.util.HashMap;

public class FindDuplicateNumbersInArray {

	public HashMap<Integer, Integer> find(int[] arr) {
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

	public void printUtility(HashMap<Integer, Integer> map) {

		for (Integer number : map.keySet()) {
			System.out.printf("Number: %d Repetitions: %d%n", number, map.get(number));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 3, 6, 8, 2, 6, 45, 54, 8, 6, 6 };

		FindDuplicateNumbersInArray f = new FindDuplicateNumbersInArray();
		f.printUtility(f.find(arr1));

	}

}
