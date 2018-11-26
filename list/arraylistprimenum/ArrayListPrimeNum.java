package list.arraylistprimenum;

import java.util.ArrayList;

public class ArrayListPrimeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int start1 = 5;
		int end1 = 50;
		ArrayList<Integer> primeNum = primeNum(start1, end1);
		System.out.printf("The prime numbers between %d and %d are:%n", start1, end1);
		for (int i = 0; i < primeNum.size(); i++) {
			System.out.print(primeNum.get(i) + " ");
		}

	}

	private static ArrayList<Integer> primeNum(int start, int end) {
		ArrayList<Integer> primeNum = new ArrayList<Integer>();

		for (int num = start; num < end; num++) {
			boolean prime = true;
			for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
				if (num % divisor == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				primeNum.add(num);
			}
		}
		return primeNum;
	}

}
