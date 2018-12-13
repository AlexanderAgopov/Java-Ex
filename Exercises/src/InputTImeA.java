import java.util.Scanner;
public class InputTImeA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the hour and the minutes: ");
		int h = input.nextInt();
		int m = input.nextInt();
		
		boolean validTime = validateHours(h) && validateMinutes(m);
		
		if(validTime) {
			System.out.println("The time is " + h +":" + m + " now.");
		} else {
			System.out.println("Incorrect time!");
		}
		
		input.close();
	}
	
	public static boolean validateHours(int hours) {
		boolean result = hours >= 0 && hours < 24;
		return result;
	}
	
	public static boolean validateMinutes(int minutes) {
		boolean result = minutes >= 0 && minutes <+ 59;
		return result;
	}

}
