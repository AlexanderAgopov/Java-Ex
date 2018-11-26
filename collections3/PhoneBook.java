package collections3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Даден е текстов файл, който съдържа имена на хора, техните градове и
 * телефони.Да се напише програма, която отпечатва всички градове по азбучен ред
 * и за всеки от тях отпечатва всички имена на хора по азбучен ред и съответния
 * им телефон. Задачата можем да решим по много начини, например като сортираме
 * по два критерия: на първо място по град и на второ място по телефон и след
 * това отпечатаме телефонния указател. Нека, обаче решим задачата без
 * сортиране, като използваме стандартните структури от данни в Java.
 * 
 * @author a
 *
 */
public class PhoneBook {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		TreeMap<String, TreeMap<String, String>> phonesByTown = new TreeMap<String, TreeMap<String, String>>();
		Scanner sc = new Scanner(new File("phonebook1"));
		try {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] lineComponents = line.split("\\s*\\|\\s*");
				String name = lineComponents[0];
				String town = lineComponents[1];
				String phone = lineComponents[2];
				TreeMap<String, String> phonebook = phonesByTown.get(town);
				if (phonebook == null) {
					phonebook = new TreeMap<String, String>();
					phonesByTown.put(town, phonebook);
				}
				phonebook.put(name, phone);
			}
		} finally {
			sc.close();
		}

		Set<String> towns = phonesByTown.keySet();
		for (String town : towns) {
			System.out.println("Town: " + town);
			TreeMap<String, String> names = phonesByTown.get(town);
			for (Map.Entry<String, String> entry : names.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}

		}

	}
}
