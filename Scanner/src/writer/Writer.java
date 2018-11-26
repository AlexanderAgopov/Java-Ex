package writer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Writer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintStream fileWriter1 = null;
		PrintStream fileWriter2 = null;

		try {
			fileWriter1 = new PrintStream("try2", "UTF-8");

			String text = "We are writing in a file! Wohooo!";

			fileWriter1.println(text);

			for (int i = 0; i < 21; i++) {
				fileWriter1.print(i + " ");
			}

			fileWriter2 = new PrintStream("try3", "UTF-8");

			for (int i = 0; i < 50; i++) {
				fileWriter2.println("Good vibes Good vibes");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Warning! File not found!");
		} catch (UnsupportedEncodingException uee) {
			System.out.println("Error! Unsupported Encoding! Please use UTF-8.");
		} finally {
			if (fileWriter1 != null) {
				fileWriter1.close();
			}
			if (fileWriter2 != null) {
				fileWriter2.close();
			}

		}

	}

}
