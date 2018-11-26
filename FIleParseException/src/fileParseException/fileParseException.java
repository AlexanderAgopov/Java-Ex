package fileParseException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class fileParseException {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readFilePrintIntegers("/home/a/Documents/try001.txt");

	}

	public static void readFilePrintIntegers(String fileName) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			int count = 0;
			int len = 0;

			while ((line = br.readLine()) != null) {
				System.out.println(line);

				len++;
			}
			System.out.println(len);

			String[] arrBuffer = new String[len];
			for (int i = 0; i < arrBuffer.length; i++) {
				arrBuffer[i] = br.readLine();
			}
			
			System.out.println(Arrays.toString(arrBuffer));
			

			//int[] result = new int[arrBuffer.length];
			//try {
		//		for (int j = 0; j < arrBuffer.length; j++) {
			//		result[j] = Integer.parseInt(arrBuffer[j]);
				//	System.out.println(result[j]);
			//	}
			//} catch (NumberFormatException ex) {
				//System.out.println(
					//	"Error! The file contains data other than integer numbers! Please try with another file.");
			//}
			br.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found! Please run the program again and" + " enter another file path.");
		} finally {

		}

	}

}
