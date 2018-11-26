package scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("try2");
		file1.setReadable(true);// This is not compulsory. In fact it is needless in most of the situations
		System.out.println(file1.canRead());
		Scanner fileReader = null;
		try {

			fileReader = new Scanner(file1, "UTF-8");
			int lineNumber = 0;
			while (fileReader.hasNextLine()) {
				lineNumber++;
				System.out.printf("Line %d: %s%n", lineNumber, fileReader.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}

		File file3 = new File("try3");
		Scanner fileReader2 = null;
		try {
			fileReader2 = new Scanner(file3, "UTF-8");
			while (fileReader2.hasNextLine()) {
				System.out.println(fileReader2.nextLine());
			}
			fileReader2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader2 != null) {
				fileReader2.close();
			}
		}
	}

}
