package fileParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class fileParseExceptionAlt2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
		File f = new File("resources/try001.txt");
		FileReader fr = new FileReader(f);
		while(fr.read() != -1) {
			System.out.println(Character.getNumericValue(fr.read()));
		}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} 
	}

}
