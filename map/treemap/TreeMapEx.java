package map.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

/**
 * This class uses tree map in order to count the occurrences of each one of the
 * words used in given string.
 * 
 * @author a
 *
 */
public class TreeMapEx {
	private static final String text = "This text is an example of a text . The TExt is A teXt after A l l.";

	// Custom comparator which overrides the default comparator in order the program
	// to be case insensitive.

	/**
	 * Returns tree map using default comparator. The keys of the map entries are
	 * the words from the text. The values of the map entries are the number of
	 * occurrences of the words.
	 * 
	 * @param text - the string containing the text.
	 * @return tree map.
	 */
	private static Map<String, Integer> createWordsCounts(String text) {
		Scanner textScanner = new Scanner(text);
		//Creates tree map using the default comparator
		Map<String, Integer> words = new TreeMap<String, Integer>();

		while (textScanner.hasNext()) {
			String word = textScanner.next();
			Integer count = words.get(word);

			if (count == null) {
				count = 0;
			}
			words.put(word, count + 1);
		}
		textScanner.close();
		return words;
	}

	/**
	 * Returns tree map using case insensitive comparator. The keys of the map
	 * entries are the words from the text. The values of the map entries are the
	 * number of occurrences of the words. The values of the map entries are the
	 * number of occurrences of the words.
	 * 
	 * @param text - the string containing the text.
	 * @return tree map.
	 */
	private static Map<String, Integer> createWordsCountsCI(String text) {
		Scanner textScanner = new Scanner(text);
		// Custom comparator that is case insensitive and is defined by anonymous class
		// in which we
		// override the compareTo() method.
		Comparator<String> caseInsensitiveComparator = new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareToIgnoreCase(arg1);
			}
		};
		Map<String, Integer> wordsCI = new TreeMap<String, Integer>(caseInsensitiveComparator);
		while (textScanner.hasNext()) {
			String word = textScanner.next();

			Integer countCI = wordsCI.get(word);

			if (countCI == null) {
				countCI = 0;
			}
			wordsCI.put(word, countCI + 1);
		}
		textScanner.close();
		return wordsCI;
	}

	/**
	 * Prints all map keys and entries from the tree map returned by the method
	 * called "createWordsCounts(String text)".
	 * 
	 * @param words - the tree map.
	 */
	private static void printWordsCount(Map<String, Integer> words, Map<String, Integer> wordsCI) {
		System.out.println("CASE SENSITIVE:");
		System.out.println();
		for (Map.Entry<String, Integer> wordEntry : words.entrySet()) {
			System.out.printf("The word \"%s\" was found %d times in the text%n", wordEntry.getKey(),
					wordEntry.getValue());
		}

		System.out.println();
		System.out.println();
		System.out.println("CaSe iNsEnSiTiVe:");
		System.out.println();
		for (Map.Entry<String, Integer> wordEntry : wordsCI.entrySet()) {
			System.out.printf("The word \"%s\" was found %d times in the text%n", wordEntry.getKey(),
					wordEntry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printWordsCount(createWordsCounts(text), createWordsCountsCI(text));

	}

}
