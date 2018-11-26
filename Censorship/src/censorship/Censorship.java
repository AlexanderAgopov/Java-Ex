package censorship;

public class Censorship {
	/*
	 * This class implements a method called "censor" that replaces all words
	 * considered by the user as inappropriate. The user should specify these words
	 * in separate string. The method parameters are as follows: 1) the string which
	 * includes the whole text; 2) the string which includes the words to be
	 * censored; 3) the regular expression that splits these words in the second
	 * string.
	 */

	public static void main(String[] args) {
		// Implementation example

		String text = "Everybody wants happiness and nobody wants pain, but you can't have a rainbow without a little rain.";
		String censored = "happiness,pain,rainbow,rain";
		System.out.println(text);
		censor(text, censored, ",");

	}

	public static void censor(String text, String censored, String regex) {
		String[] censoredArr = censored.split(regex);
		for (int i = 0; i < censoredArr.length; i++) {
			//Replaces the inappropriate word the first time it is found in the text
			int index = text.indexOf(censoredArr[i]);
			String temp = text.substring(index, index + censoredArr[i].length());
			text = text.replace(temp, "***"); //replaces the inappropriate word with 3 asterisks
			//Replaces the inappropriate word all other times it is found in the text
			while (text.indexOf(censoredArr[i]) != -1) {
				int indexStart2 = text.indexOf(censoredArr[i]);
				int indexEnd2 = text.indexOf(censoredArr[i] + censoredArr[i].length());
				String temp2 = text.substring(indexStart2, indexEnd2);
				text = text.replace(temp2, "***");
			}
		}
		//Prints the censored text
		System.out.println(text);

	}

}
