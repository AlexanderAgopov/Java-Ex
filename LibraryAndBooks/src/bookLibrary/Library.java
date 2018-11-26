package bookLibrary;

import java.util.*;

public class Library {

	private String libraryName;

	private ArrayList<Book> bookList;

	public Library(String libraryName, ArrayList bookList) {
		this.libraryName = libraryName;
		this.bookList = bookList;
	}

	public void addBook(ArrayList bookList, Book book) {
		this.bookList.add(book);
	}

	public void deleteBook(ArrayList bookList, Book book) {
		bookList.remove(book);
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public void setBookList(ArrayList bookList) {
		this.bookList = bookList;
	}

	public String searchBook(ArrayList<Book> booklist, String search) {
		String bookTitle = null;
		for (Object book : bookList.toArray()) {
			if (((Book) book).getAuthor().equals(search)) {
				bookTitle = ((Book) book).getTitle();
				System.out.println("The first book in the library written by " + search + " is \"" + bookTitle + "\".");
				System.out.println();
				searchBookAll(booklist, search);
				break;
			}
		}

		if (bookTitle != null) {
			return " ";
		} else {

		}
		return "Sorry! The library does not contain any books written by that author. Please try with another author.";
	}

	// This method prints the titles of the books which are written by the author
	// whose
	// name is given to the method by the user
	public void searchBookAll(ArrayList<Book> booklist, String search) {
		System.out.printf("All books from %s:%n", search);
		for (Object book : bookList.toArray()) {
			if (((Book) book).getAuthor().equals(search)) {
				System.out.println(((Book) book).getTitle());
			}
		}

	}

	// This method prints the name of the author and the title of the book which is
	// next to the book written by the author whose name is given by the user in
	// relation to the method above.
	public void searchNextBook(ArrayList<Book> booklist, String search) {
		ListIterator<Book> litr = bookList.listIterator();
		while (litr.hasNext()) {
			if (litr.next().getAuthor().equals(search)) {
				System.out.printf("The next book in the library is \"%s\".", litr.next().getTitle());
			}
		}
	}
}
