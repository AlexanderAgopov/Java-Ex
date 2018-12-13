import java.util.Scanner;

public class InputTime {

	public static boolean validation(int h, int m) {

		if (h >= 0 && h < 24 && m >= 0 && m < 60) {
			return true;
		} else
			return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the hour and the minutes: ");
		int h = input.nextInt();
		int m = input.nextInt();
		if (validation(h, m) == true) {
			System.out.println("The time is " + h + ":" + m + " now.");
		} else {
			System.out.println("Incorrect time!");
		}

		input.close();

	}

}
