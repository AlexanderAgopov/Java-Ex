import java.util.Scanner;

public class recursiveFibonacciOptimization {

	/**
	 * @param args
	 */
	public static long[] numbers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = input.nextInt();

		numbers = new long[x + 2];
		numbers[1] = 1;
		numbers[2] = 1;

		long result = fib(x);
		System.out.println("F" + x + " = " + result);
		input.close();

	}

	public static long fib(int n) {
		if (0 == numbers[n]) {
			numbers[n] = fib(n - 1) + fib(n - 2);

		}
		return numbers[n];

	}

}
