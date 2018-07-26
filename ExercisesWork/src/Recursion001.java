import java.util.Scanner;
public class Recursion001 {
	
	public static long fib(int n) {
		if (n <= 2) {
			return 1;
			}
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = input.nextInt();
		
		for (int i = 1; i < x; i++) {
			System.out.print(fib(i) + " ");
		}
		
		
		
		

	}

}
