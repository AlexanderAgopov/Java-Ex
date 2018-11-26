package com.jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class JDBCTest1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// Class.forName("com.mysql.jdbc.Driver");

		String dbUrl = "jdbc:mysql://localhost:3306/sales";
		String user = "root";
		String pass = "antoniq";

		Connection myconn = DriverManager.getConnection(dbUrl, user, pass);

		
		
		Statement stmnt = myconn.createStatement();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your query:");
		String query = input.nextLine();
		stmnt.execute(query);
		
		//String query = "delete from employees where last_name like '%spirido%';";
		//int rowsAffected = stmnt.executeUpdate(query);		
		//System.out.println("Rows afffected: " + rowsAffected);
		//System.out.println("Delete complete.");
		System.out.println();
		
		ResultSet rs = stmnt.executeQuery("select * from employees");

		
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			for (int i = 2; i < 5; i++) {
				System.out.print(" " + rs.getString(i));
			}

			System.out.println();

		}
		rs.first();

		
	
	}

}
