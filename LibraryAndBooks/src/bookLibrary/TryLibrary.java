package bookLibrary;

import java.util.*;

public class TryLibrary {

	public static void main(String[] args) {
		// Implementation example of the classes Book and Library
		Book dune = new Book("Dune", "Frank Herbert");
		Book idiot = new Book("Idiot", "Fyodor Dostoevsky");
		Book beadGame = new Book("Bead game", "Hermann Hesse");
		Book crimeAndPunishment = new Book("Crime and Punishment", "Fyodor Dostoevsky");

		ArrayList bookList = new ArrayList();

		Library librarySofia = new Library("Sofia Library", bookList);

		librarySofia.addBook(bookList, dune);
		librarySofia.addBook(bookList, idiot);
		librarySofia.addBook(bookList, beadGame);
		librarySofia.addBook(bookList, crimeAndPunishment);

		for (Object book : bookList.toArray()) {
			((Book) book).printBookInfo();
			System.out.println();
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the author's name:");
		String authorName = input.nextLine();

		System.out.println();
		System.out.println(librarySofia.searchBook(bookList, authorName));
		try {
			// This method prints the name of the next Book object stored in the ArrayList
			librarySofia.searchNextBook(bookList, authorName);
			input.close();

		} catch (NoSuchElementException e) {

		}
		System.out.println();
		System.out.println();
		// This method finds all books which is stored in the
		// library and is written by the author whose name is given to the method by the
		// user. The method prints the titles of the books.
		//librarySofia.searchBookAll(bookList, authorName);
		
	}

}
