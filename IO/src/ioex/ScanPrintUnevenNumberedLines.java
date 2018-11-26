package ioex;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ScanPrintUnevenNumberedLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = null;
		Scanner fileInput = null;
		PrintStream fileOutput = null;
		try {
			int lineCount = 0;
			file = new File("try005");
			fileInput = new Scanner(file, "UTF-8");
			fileOutput = new PrintStream("try005Output", "UTF-8");

			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				lineCount++;
				if (lineCount % 2 != 0) {
					fileOutput.println(line);
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		} catch (UnsupportedEncodingException ufe) {
			System.out.println("Unsupported format! Please try with another file.");
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
