package file.io.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileMatrix {
	/*
	 * Напишете програма, която чете от файл квадратна матрица от цели числа и
	 * намира подматрицата с размери 2 х 2 с най-голяма сума и записва тази сума в
	 * отделен текстов файл. Първия ред на входния файл съдържа големината на
	 * записаната матрица (N). Следващите N реда съдържат по N числа, разделени с
	 * интервал.
	 */
	public static void main(String[] args) {

		File file = null;
		Scanner scan = null;
		PrintStream fileOutput = null;

		try {
			file = new File("MatrixN");
			scan = new Scanner(file, "UTF-8");
			// Scans the first line of the file. This line contains the number N
			String line1 = scan.nextLine();
			// String "mLength" receives the number N as a char sequence
			String mLength = line1.substring((line1.lastIndexOf(" ") + 1), line1.indexOf(";"));
			// Generates an integer variable using the char sequence from string "mLength"
			int matrixLength = Integer.parseInt(mLength);
			// Creates a matrix with the desired length
			int[][] matrix = new int[matrixLength][matrixLength];
			// Gives values to all elements of the matrix using nested loops
			for (int i = 0; i < matrix.length; i++) {
				String line = scan.nextLine(); // Saves the scanned line as a string
				String[] matrixLineString = line.split(" "); // Splits the line and creates an array from it. The
																// elements
																// of the array are strings containing numbers
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = Integer.parseInt(matrixLineString[j]);// Strings to integers
				}
			}
			// Generates local variables which will be used to find the sub-matrix with the
			// largest sum of its elements
			int bestSum = Integer.MIN_VALUE;
			int bestRow = 0;
			int bestCol = 0;

			for (int i = 0; i < matrix.length - 1; i++) {
				for (int j = 0; j < matrix.length - 1; j++) {
					int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
					if (sum > bestSum) {
						bestSum = sum;
						bestRow = i;
						bestCol = j;
					}
				}
			}
			// Saves results in new file called "bestSum"
			fileOutput = new PrintStream("bestSum", "UTF-8");
			fileOutput.printf("The best sum is %d.%nThe sub-matrix is:%n%d %d%n%d %d", bestSum,
					matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow + 1][bestCol],
					matrix[bestRow + 1][bestCol + 1]);
			System.out.println("Done!");
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
			fnfe.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			System.out.println("Unsupported encoding!");
			uee.printStackTrace();
		} finally {
			scan.close();
			fileOutput.close();
		}

	}

}
