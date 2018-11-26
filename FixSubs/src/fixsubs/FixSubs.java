package fixsubs;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class FixSubs {

	private static final int ADD_TIME = 5000;
	private static final String INPUT_FILE = "subs";
	private static final String OUTPUT_FILE = "fixedSubs";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner fileInput = null;
		PrintStream fileOutput = null;

		try {
			fileInput = new Scanner(new File(INPUT_FILE), "UTF-8");
			fileOutput = new PrintStream(new File(OUTPUT_FILE), "UTF-8");
			String line;
			while (fileInput.hasNextLine()) {
				line = fileInput.nextLine();
				String fixedLine = fixLine(line);
				fileOutput.println(fixedLine);
			}
			System.out.println("Done!");
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

	public static String fixLine(String line) {
		int start = line.indexOf("}");
		String startTime = line.substring(1, start);
		int newStart = Integer.parseInt(startTime) + ADD_TIME;
		int end = line.indexOf("}", start + 1);
		String endTime = line.substring(start + 2, end);
		int newEnd = Integer.parseInt(endTime) + ADD_TIME;

		String fixedLine = ("}" + newStart + "}{" + newEnd + "}" + line.substring(end + 1));
		return fixedLine;
	}

}
