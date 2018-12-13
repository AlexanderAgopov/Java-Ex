public class MethodSortArray {

	public static int[] sort(int... numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int tempVar = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = tempVar;
				}
			}
		}
		return numbers;

	}

	public static void printNumbers(int... numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(" " + numbers[i]);
			if (i < numbers.length - 1) {
				System.out.print(",");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = sort(34, -2, 45, 104, -98, 32);
		printNumbers(numbers);

	}

}
