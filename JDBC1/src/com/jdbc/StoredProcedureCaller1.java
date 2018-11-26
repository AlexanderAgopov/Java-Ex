package com.jdbc;

import java.sql.*;

public class StoredProcedureCaller1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/sales";
		String user = "root";
		String pass = "antoniq";

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);
			CallableStatement cs = conn.prepareCall("{call getAllEmployees}");
			// cs.execute();
			rs = cs.executeQuery();
			display(rs);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	private static void display(ResultSet rs) throws SQLException {
		int id = 0;
		String lastName = "";
		String firstName = "";
		String email = "";
		String department = "";
		Double salary = 0.0;
		while (rs.next()) {
			id = rs.getInt("id");
			lastName = rs.getString("last_name");
			firstName = rs.getString("first_name");
			email = rs.getString("email");
			department = rs.getString("department");
			salary = rs.getDouble("salary");
			System.out.printf("%d %s %s %s %s %.2f", id, lastName, firstName, email, department, salary);
			System.out.println();
		}
	}

}
