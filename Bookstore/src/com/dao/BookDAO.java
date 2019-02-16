package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import com.core.Book;

public class BookDAO {

	private Connection connection;
	private String dburl;
	private String user;
	private String password;

	public BookDAO() throws FileNotFoundException, IOException, SQLException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("resources/db.properties"));
		this.dburl = properties.getProperty("dburl");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");
	}
	
	public BookDAO(String dburl, String user, String password) {
		this.dburl = dburl;
		this.user = user;
		this.password = password;
		
	}

	public void connect() throws SQLException {
		if (connection == null || connection.isClosed()) {
			this.connection = DriverManager.getConnection(dburl, user, password);
		}
	}

	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO books (title, author, price) VALUES (?,?,?)";
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());
		boolean rowInserted = statement.executeUpdate() > 0;
		close(this.connection, statement);
		return rowInserted;

	}

	public List<Book> getAllBooks() throws SQLException {
		List<Book> booklist = new ArrayList<Book>();
		String sql = "SELECT * FROM books";
		connect();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
			Book tempBook = new Book(id, title, author, price);
			booklist.add(tempBook);
		}
		close(this.connection, statement, resultSet);
		return booklist;
	}

	public boolean deleteBook(Book book) throws SQLException {
		String sql = "DELETE FROM books where book_id = ?";
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, book.getId());
		boolean rowDeleted = statement.executeUpdate() > 0;
		close(this.connection, statement);
		return rowDeleted;
	}

	public boolean updateBook(Book book) throws SQLException {
		String sql = "UPDATE books SET title = ?, author = ?, price = ? WHERE book_id = ?";
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(1, book.getAuthor());
		statement.setFloat(1, book.getPrice());
		statement.setInt(4, book.getId());
		boolean rowUpdated = statement.executeUpdate() > 0;
		close(this.connection, statement);
		return rowUpdated;
	}

	public Book getBook(int id) throws SQLException {
		Book book = null;
		String sql = "SELECT * FROM books WHERE book_id = ?";
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
			book = new Book(id, title, author, price);
		}
		close(this.connection, statement);
		return book;
	}

	private void close(Connection connection, Statement statement, ResultSet rs) throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (rs != null) {
			rs.close();
		}
	}

	private void close(Statement statement, ResultSet rs) throws SQLException {
		close(null, statement, rs);
	}

	private void close(Connection connection, Statement statement) throws SQLException {
		close(connection, statement, null);
	}

	private void close(Statement statement) throws SQLException {
		close(null, statement, null);
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		BookDAO dao = new BookDAO();
		List<Book> list = dao.getAllBooks();
		for(Book book : list) {
			System.out.println(book.getTitle());
		}
	}

}
