package app;

import java.util.Scanner;
import java.util.InputMismatchException;

public class multiply {

	public static void main(String[] args) {
		// Multiplies two integer numbers and prints the result
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Please enter the first integer number:");
			int a = input.nextInt();
			System.out.println("Please enter the second integer number:");
			int b = input.nextInt();
			System.out.println("The result is: " + multiplying(a, b));

		} catch (InputMismatchException e) {
			System.out.println("This is not an integer number! Please try again.");
		} finally {
			input.close();
		}

	}

	public static int multiplying(int x, int y) {
		return x * y;
	}

}
