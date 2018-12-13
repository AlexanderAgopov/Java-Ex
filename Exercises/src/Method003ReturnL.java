import java.util.Scanner;
public class Method003ReturnL {
	
	public static int bigger(int a, int b) {
		
		if (a > b) {
			return 1;
		} else {
			if (a == b) {
				return 0;
			} else { 
				return -1;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int m = input.nextInt();
		System.out.println("Enter the second number: ");
		int n = input.nextInt();
		
		bigger(m, n);
		input.close();

	}

}
