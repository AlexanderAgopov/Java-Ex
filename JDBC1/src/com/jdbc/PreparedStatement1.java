package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement1 {

	private static void display(ResultSet rs) throws SQLException {
		int id = 0;
		String lastName = "";
		String firstName = "";
		String department = "";
		Double salary = 0.0;
		while (rs.next()) {
			id = rs.getInt("id");
			lastName = rs.getString("last_name");
			firstName = rs.getString("first_name");
			department = rs.getString("department");
			salary = rs.getDouble("salary");
			System.out.printf("%d %s %s %s %.2f", id, lastName, firstName, department, salary);
			System.out.println();
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/sales";
		String user = "root";
		String pass = "antoniq";

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			// 1. Get a connection to database
			conn = DriverManager.getConnection(url, user, pass);

			// 2. Prepare statement
			statement = conn.prepareStatement("select * from employees where salary>? and department=?");

			// 3. Set the parameters
			statement.setDouble(1, 24000);
			statement.setString(2, "Legal");

			// 4. Execute SQL query
			rs = statement.executeQuery();

			// 5. Display the result set
			display(rs);
			System.out.println();
			//6. Reuse the prepared statement
			statement.setDouble(1, 20000);
			statement.setString(2, "Accounting");
			rs = statement.executeQuery();
			display(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}

}
