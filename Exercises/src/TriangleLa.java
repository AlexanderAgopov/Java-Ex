import java.util.Scanner;

public class TriangleLa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of lines: ");
		int l = input.nextInt();

		printTriangle(l);
		input.close();

	}

	private static void printTriangle(int line) {

		for (int z = 1; z <= 100; z += 10) {
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
