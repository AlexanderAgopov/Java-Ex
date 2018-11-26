package scanner;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class WordOccurenceCount {

	public static void main(String[] args) {
		// This program prints the number of occurrences of a specific word or phrase in
		// a text file
		File file = null;
		String fileName = "try3";
		Scanner fileReader = null;
		String gv = "Good vibes"; // This is the phrase we are searching for.
		int occurrences = 0;// counter

		try {
			file = new File(fileName);
			fileReader = new Scanner(file, "UTF-8");
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine(); // Search in each scanned line separately
				int index = line.indexOf(gv);
				while (index != -1) {
					occurrences++;
					index = line.indexOf(gv, (index + 1)); // This code is necessary because this way we count all
															// occurrences of the word in the scanned line not only the
															// first one as it does the indexOf() method
				}
			}
			System.out.println(occurrences);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		} finally {
			fileReader.close();
		}

	}

}
