package fileParseException;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class fileParseExceptionAlt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String data = readFileAsString("/home/a/Documents/try001.txt");
		String[] numbers = data.split(" ");
		System.out.println(Arrays.toString(numbers));

		int[] result = new int[numbers.length];
		try {
			for (int j = 0; j < numbers.length; j++) {
				result[j] = Integer.parseInt(numbers[j]);
				System.out.println(result[j]);
			}
		} catch (NumberFormatException ex) {
			System.out
					.println("Error! The file contains data other than integer numbers! Please try with another file.");
		}

	}

	public static String readFileAsString(String fileName) throws IOException {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

}
