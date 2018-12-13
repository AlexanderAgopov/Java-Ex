import java.util.Scanner;
public class iterativeFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = input.nextInt();
		
		int a = 0;
		int b = 1;
		int c = 1;
		
		for (int i = 2; i < x; i++) {
			a = b + c;
			c = b;
			b = a;
		}
		System.out.println(a);

	}

}
