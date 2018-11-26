package specifiedUpperCase;

public class SpecifiedUpperCase {
	/*
	 * This class implements a method called "fSpecUpCase" that reformats parts of a
	 * given text using upper case. This method reformats the text between a
	 * substring defined by the user which precedes the part(s) of the text to be
	 * formatted and a substring defined by the user which follows this part(these
	 * parts) of the text.
	 * 
	 * Precondition: the specified by user parts of the text are in lower case, in
	 * lower and upper case or in upper case. 
	 * Postcondition: the specified by user parts of the text are in upper case.
	 */
	public static void main(String[] args) {
		// Implementation example

		String startEx = "<upcase>";
		String endEx = "</upcase>";

		String text = "We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";
		System.out.println(text);

		fSpecUpCase(text, startEx, endEx);

	}

	public static void fSpecUpCase(String text, String start, String end) {
		// Reformats to upper case the first defined by user part of the text
		int indexStart = text.indexOf(start);
		int indexEnd = text.indexOf(end);
		String temp1 = text.substring(indexStart, indexEnd + end.length());
		String temp1UP = temp1.toUpperCase();
		text = text.replace(temp1, temp1UP);
		// Reformats to upper case all other defined by user parts of the text
		while (text.indexOf(start) != -1) {
			int indexStart2 = text.indexOf(start, indexStart);
			int indexEnd2 = text.indexOf(end, indexEnd);
			String temp2 = text.substring(indexStart2, indexEnd2 + end.length());
			String temp2UP = temp2.toUpperCase();
			text = text.replace(temp2, temp2UP);
			indexStart = indexStart2;
			indexEnd = indexEnd2;
		}
		// Deletes start and end substrings, i.e. the substrings which separate the
		// reformatted text parts from the other parts of the text
		text = text.replaceAll(start.toUpperCase(), "");
		text = text.replaceAll(end.toUpperCase(), "");
		// Prints the reformatted text
		System.out.println(text);

	}

}
