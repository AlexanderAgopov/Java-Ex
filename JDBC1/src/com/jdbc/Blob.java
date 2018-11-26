package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Blob {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");

		PreparedStatement ps = conn
				.prepareStatement("update employees set employee_resume = ? where last_name = 'Borisov'");
		File file = new File("resume1");
		FileInputStream fis = new FileInputStream(file);
		ps.setBinaryStream(1, fis);

		System.out.println("Reading file: " + file.getAbsolutePath());
		System.out.println("%sStoring resume in database: " + file);
		ps.executeUpdate();
		System.out.println("Completed successfully!");

		Statement s = conn.createStatement();
		ResultSet rs2 = s.executeQuery("select employee_resume from employees where last_name = 'Borisov'");
		File file2 = new File("resumeFromDB.txt");
		FileOutputStream fos = new FileOutputStream(file2);
		InputStream is = null;

		if (rs2.next()) {
			is = rs2.getBinaryStream("employee_resume");
			System.out.print("Reading resume from database");
			byte[] buffer = new byte[1024];
			while (is.read(buffer) > 0) {
				fos.write(buffer);
			}

			System.out.println("Saved to file: " + file2.getAbsolutePath());
			System.out.println("Completed successfully!");
		}

	}

}
