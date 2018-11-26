package binFileToByteArr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;

public class binFileToByteArr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print(Arrays.toString(binFileToByteArray("/home/a/Documents/exercises/multiply.class")));
		fileOutput();

	}

//Reads binary file and returns its content as a byte array
	private static byte[] binFileToByteArray(String filePath) throws IOException {
		File f = new File("/home/a/Documents/exercises/multiply.class");

		FileInputStream fis = new FileInputStream(f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int read = 0;
		while ((read = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, read);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	}

	//Creates new file and inserts in it the content of the byte array
	private static void fileOutput() throws IOException {
		String filePath = null;

		File nf = new File("/home/a/Documents/exercises/newfile.txt");
		FileOutputStream fos = new FileOutputStream(nf);

		// Creates a file if the file does not exist
		if (!nf.exists()) {
			nf.createNewFile();
		}
		// Uses the array returned by the method "binFileToByteArray"
		byte[] contentInBytes = binFileToByteArray(filePath);

		fos.write(contentInBytes);
		fos.flush();
		fos.close();

	}

}
