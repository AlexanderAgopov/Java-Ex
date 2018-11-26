package fileUnsortedNamesToFileAlphabeticalOrder;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintStream;

public class UnsortedNamesToAlphabeticalOrder {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		File file = null;
		Scanner fileInput = null;
		PrintStream fileOutput = null;
		ArrayList<String> listNames = new ArrayList();

		try {
			file = new File("try3");
			fileInput = new Scanner(file, "UTF-8");
			fileOutput = new PrintStream("sortedNames", "UTF-8");

			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				listNames.add(line);
				System.out.println(line);
			}

			System.out.println(listNames.toString());

			for (int i = 0; i < listNames.size(); i++) {
				fileOutput.println(listNames.get(i));
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		} catch (UnsupportedEncodingException uee) {
			System.out.println("Unsupported encoding!");
		} finally {
			if (fileInput != null) {
				fileInput.close();
			}
			if (fileOutput != null) {
				fileOutput.close();
			}
		}

	}

}
