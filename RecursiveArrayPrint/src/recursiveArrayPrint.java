import java.util.Scanner;
public class recursiveArrayPrint {
	//Initiating array
	public static int[] arr = {2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12};
	
	// Recursive way to print all elements 	
	public static void printArr(int i) {
		if (i == 0) {
			return;
		} else {
			printArr(i - 1);
			System.out.println("[" + (i - 1) + "] " + arr[i - 1]);
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		// Entering the value of i
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the value of i: ");
		int i = input.nextInt();
		input.close();
		
		printArr(i);

	}

}
