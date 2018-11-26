package reversedWordSequence;
import java.util.Arrays;
public class reversedWordSequence {
	/*
	 * This class implements a method called "reversedWS" which reverses the word
	 * order in a string. 
	 * Postcondition: The first word is the last and vice-versa,
	 * the next to the first is the next to the last and vice-versa, etc.
	 */
	public static void main(String[] args) {
		// Implementation example
		String text = "luminous beings are we";
		reversedWS(text);
	}

	public static void reversedWS(String text) {
		StringBuilder sb = new StringBuilder();
			for (int i = text.length() - 1; i>=0; i--) {
				sb.append(text.charAt(i));
			}
          String reversedText = sb.toString();
		System.out.println(reversedText);
		String[] wordArr = reversedText.split(" ");
		System.out.println(Arrays.toString(wordArr));
		String[]wordArrFinal = new String[wordArr.length];
		System.out.println(Arrays.toString(wordArrFinal));
		
		
		for (int i = 0; i < wordArr.length; i++) {
			StringBuilder sb1 = new StringBuilder();
			for(int j = wordArr[i].length() - 1; j>=0; j--) {
				sb1.append(wordArr[i].charAt(j));
			}
			wordArrFinal[i] = sb1.toString();
		}
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < wordArrFinal.length; i++) {
			sb2.append(wordArrFinal[i] + " ");
		}
		String reversedWords = sb2.toString();
		System.out.println(reversedWords);
	}

}
