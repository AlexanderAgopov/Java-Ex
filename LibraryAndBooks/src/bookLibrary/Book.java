package bookLibrary;

public class Book {

	private String title;
	private String author;
	private String publisher;
	private int releaseYear;
	private String isbn;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author, String publisher, int releaseYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void printBookInfo() {
		System.out.println("Author: " + getAuthor());
		System.out.println("Title: " + getTitle());

	}

}
