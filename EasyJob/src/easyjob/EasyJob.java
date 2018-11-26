package easyjob;

public class EasyJob {
	private String text;
	private String phrase;

	public EasyJob(String text, String phrase) {
		super();
		this.text = text;
		this.phrase = phrase;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	// This method returns the number of occurrences of a substring in a string
	public int countOccurrence(String text, String phrase) {
		int occurrences = 0;
		int index = text.indexOf(phrase);
		while (index != -1) {
			occurrences++;
			index = text.indexOf(phrase, (index + 1));
		}
		return occurrences;
	}

}
