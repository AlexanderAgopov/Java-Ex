import java.util.Scanner;
public class TriangleL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of lines: ");
		int line = input.nextInt();
		
		
		for (int z = 1; z <= 100; z+=10) {
			for (int i = z; i <= line - 1 + z; i++) {
			printLine(z, i);
		}
		for (int j = line - 1 + z - 1; j >= z; j--) {
			printLine(z, j);
			
		}
		System.out.println();
		}
		
		
		

	}
	
	
	private static void printLine(int start, int stop) {
		
		for (int y = start; y <= stop; y++) {
			System.out.print(" " + y);
		}
		System.out.println();
		
	}

}
