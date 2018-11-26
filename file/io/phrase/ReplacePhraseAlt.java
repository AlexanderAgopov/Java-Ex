package file.io.phrase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Напишете програма, която заменя всяко срещане на подниза "start" с
"finish" в текстов файл.
 */

public class ReplacePhraseAlt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String start = "World Cup";
		String finish = "WC";
		
		Path path = Paths.get("/home/a/eclipse photon - workspace/text2");
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll(start, finish);
		Files.write(path, content.getBytes(charset));

	}

}
