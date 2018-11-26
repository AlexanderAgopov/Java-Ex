package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
public class CLOB {

	public static void main(String[] args) throws SQLException, IOException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");
		PreparedStatement ps = con
				.prepareStatement("update employees set resume_clob = ? where last_name = 'Draganov'");
		File file = new File("resume_clob.txt");
		FileInputStream fis = new FileInputStream(file);
		ps.setBinaryStream(1, fis);
		ps.executeUpdate();

		fis.close();
	}

}
