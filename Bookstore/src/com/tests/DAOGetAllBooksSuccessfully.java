package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.Book;
import com.dao.BookDAO;

class DAOGetAllBooksSuccessfully {
	
	BookDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new BookDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws SQLException {
		List<Book> booklist = dao.getAllBooks();
		assertEquals("2001: A Space Odyssey", booklist.get(0).getTitle());
		
	}

}
