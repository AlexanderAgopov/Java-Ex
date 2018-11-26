package collections4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Даден е телефонен указател, записан в текстов файл, който съдържа имена на
 * хора, техните градове и телефони. Имената на хората могат да бъдат във формат
 * малко име или прякор или име + фамилия или име + презиме + фамилия. Възможно
 * е да има няколко души, записани под едно и също име, дори и от един и същ
 * град. Възможно е някой да има няколко телефона и в такъв случай той се
 * изписва няколко пъти във входния файл. Телефонният указател може да бъде
 * доста голям (до 1 000 000 записа). Даден е файл със заявки за търсене.
 * Заявките са два вида: 
 * - Търсене по име / прякор / презиме / фамилия. Заявката има вида list(name). 
 * - Търсене по име / прякор / презиме / фамилия + град. Заявката има вида find(name, town).
 * 
 * @author a
 *
 */

public class PhonebookQuery {
	private static final String PHONEBOOK_FILE = "phonebook1";
	private static final String QUERIES_FILE = "queries";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static HashMap<String, ArrayList<String>> readPhonebook(String fileName) throws FileNotFoundException {
		HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
		Scanner input = new Scanner(new File(fileName), "Unicode-8");
		try {
			while (input.hasNext()) {
				String entry = input.nextLine();
				String[] phonebookEntry = entry.split("\\s*\\|\\s*");
				String names = phonebookEntry[0];
				String town = phonebookEntry[1];
				String[] nameTokens = names.split("\\s+");
				for (String name : nameTokens) {
					//addToPhonebook(phonebook, name, entry);
					String nameAndTOwm = combineNameAndTown(town, name);
					//addToPhonebook(phonebook, nameAndTown, entry);
				}
			}
		} finally {
			input.close();
		}
		return phonebook;
	}

	private static String combineNameAndTown(String town, String name) {
		return name + " from " + town;
	}

	private static void processQueries(String fileName, HashMap<String, ArrayList<String>> phonebook)
			throws IOException {
		Scanner input = new Scanner(new File(fileName), "Unicode-8");
		try {
			while (input.hasNext()) {
				String query = input.nextLine();
				processQuery(phonebook, query);
			}
		} finally {
			input.close();
		}

	}

	private static void processQuery(HashMap<String, ArrayList<String>> phonebook, String query) {
		if (query.startsWith("list(")) {
			String name = query.substring("list(".length(), query.length() - 1);
			name = name.trim().toLowerCase();
			printAllMatches(name, phonebook);
		} else {
			if (query.startsWith("find(")) {
				int commaIndex = query.indexOf(",");
				String name = query.substring("find(".length(), commaIndex);
				name = name.trim().toLowerCase();
				String town = query.substring(commaIndex + 1, query.length() - 1);
				town = town.trim().toLowerCase();
				String nameAndTown = combineNameAndTown(town, name);
				printAllMatches(nameAndTown, phonebook);
			}
		}

	}

	private static void printAllMatches(String key, HashMap<String, ArrayList<String>> phonebook) {
		ArrayList<String> allMatches = phonebook.get(key);
		if (allMatches != null) {
			for (String entry : allMatches) {
				System.out.println(entry);
			}
		} else {
			System.out.println("Not found!");
		}
		System.out.println();
	}

}
