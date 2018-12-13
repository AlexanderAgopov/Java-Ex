import java.util.Scanner;

public class recursiveFibonacci {

	/**
	 * @param args
	 */

	public static long fib(int n) {

		if (n <= 2) {
			return 1;
		} else
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = input.nextInt();

		System.out.println(fib(x));

	}

}
