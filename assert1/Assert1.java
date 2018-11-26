package assert1;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assert1 {

	private static final int LIGHT_SPEED = 299792;

	private static int shipSpeed() {
		int x = 2000;
		int y = 300;
		int z = x * y;
		assert z <= LIGHT_SPEED : "This number surpasses the speed of light. There is a bug.";
		return z;
	}

	private static Double sqrtValue(int x) {
		assert x > 0 : "The input number is negative. Try with positive number or 0"; // We should not use assert in
																							// this case, rather we have
																							// to use try-catch
																							// construction because
																							// assert is needed only
																							// when a condition should
																							// be fulfilled and the
																							// reason why this condition
																							// is not fulfilled is a bug
																							// in the program. So we use
																							// assert only at the
																							// development stage of the
																							// program

		return Math.sqrt(x);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		if (x < 0)
			throw new InputMismatchException("Not a valid number! Please insert positive integer number.");
		System.out.println(sqrtValue(x));
		
		int a = 1000000;
		assert a < LIGHT_SPEED : "This number surpasses the speed of light. There is a bug.";
		System.out.println(a);

		//System.out.println(shipSpeed());
		input.close();

	}

}
