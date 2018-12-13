import java.util.Scanner;


public class FahrenheitToCelsius {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature acoordinf to Fahrenheit temperature scale: ");
		double f = input.nextInt();
		
		double c = (f - 32) * 5 / 9;
		
		if (c < 37 && c >= 36) {
			System.out.print("Your body temperature in Celsius degrees is " + c + ". It is normal.");
		} else {
			if (c < 36) {
				System.out.print("Your body temperature in Celsius degrees is " + c + ". You are too cold.");
			} else {
				System.out.print("Your body temperature in Celsius degrees is " + c + ". You are too hot.");
			}
		}
		
		

	}

}
