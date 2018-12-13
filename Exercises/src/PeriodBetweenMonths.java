import java.util.Scanner;
public class PeriodBetweenMonths {

	/**
	 * @param args
	 */
	
	public static void sayMonth(int month) {
		String monthName = "";
		switch(month) {
		case 1: monthName("January");
		break;
		case 2: monthName("February");
		break;
		case 3: monthName("March");
		break;
		case 4: monthName("April");
		break;
		case 5: monthName("May");
		break;
		case 6: monthName("June");
		break;
		case 7: monthName("July");
		break;
		case 8: monthName("August");
		break;
		case 9: monthName("September");
		break;
		case 10: monthName("October");
		break;
		case 11: monthName("November");
		break;
		case 12: monthName("December");
		break;
		default: System.out.println("Error!");
		break;
		}
		System.out.print(monthName);
	}
	
	private static void monthName(String string) {
		// TODO Auto-generated method stub
		System.out.print(string);
		
	}

	public static void monthPeriod(int startMonth, int endMonth) {
		int period = endMonth - startMonth - 1;
		if (endMonth < startMonth) {
			period = endMonth - startMonth - 1 + 12;
		}
			System.out.print("There are " + period + " months between ");
		sayMonth(startMonth);
		System.out.print(" and ");
		sayMonth(endMonth);
		System.out.print(".");
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of the first month: ");
		int firstMonth = input.nextInt();
		System.out.println("Enter the number of the second month: ");
		int secondMonth = input.nextInt();
		System.out.println();
		monthPeriod(firstMonth, secondMonth);
		input.close();
		

	}

}
