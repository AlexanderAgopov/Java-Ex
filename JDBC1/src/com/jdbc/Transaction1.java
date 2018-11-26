package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Transaction1 {

	private static void showSalaries(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select last_name, first_name, department, salary from employees");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.printf("%s %s %s %f", rs.getString("last_name"), rs.getString("first_name"),
					rs.getString("department"), rs.getDouble("salary"));
			System.out.println();
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");
		showSalaries(conn);
		conn.setAutoCommit(false);

		Statement s = conn.createStatement();
		s.executeUpdate("delete from employees where department = 'HR'");
		s.executeUpdate("update employees set salary = 35000 where department = 'Accounting'");

		Scanner input = new Scanner(System.in);
		System.out.println("Transaction steps are ready. Type 'c' to commit changes or any other key for rollback");
		String confirmation = input.nextLine();

		if (confirmation.equals("c")) {
			conn.commit();
			System.out.println("Transaction commited.");
		} else {
			conn.rollback();
			System.out.println("Transaction rolled back.");
		}

		showSalaries(conn);

	}

}
