package file.io.phrase;
import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
/*
 * Напишете програма, която заменя всяко срещане на подниза "start" с
"finish" в текстов файл.
 */
public class ReplacePhrase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = null;
		Scanner scan = null;
		PrintStream write = null;
		File temp = null;
		Scanner scanTemp = null;
		PrintStream writeFromTemp = null;
		try {
		file = new File("text1");
		temp = new File("temp");
		scan = new Scanner(file, "UTF-8");
		//scanTemp = new Scanner(temp, "UTF-8");
		
		write = new PrintStream(temp, "UTF-8");
		//writeFromTemp = new PrintStream(file,"UTF-8");
		
		String start = "World Cup";
		String end = "WC";
		while(scan.hasNextLine()) {
			write.println(scan.nextLine().replaceAll(start, end));		
		}
		
		//while(scanTemp.hasNextLine()) {
		//	writeFromTemp.println(scanTemp.nextLine());		
		//}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} finally {
			scan.close();
			write.close();
		}
		
	

	}

}
