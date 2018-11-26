package com.jdbc;

import java.sql.*;

public class StoredProcedure2IParameters {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/sales";
		String user = "root";
		String pass = "antoniq";

		Connection conn = DriverManager.getConnection(url, user, pass);
		PreparedStatement ps = conn.prepareStatement("select * from employees");
		ResultSet rs = ps.executeQuery();
		System.out.println("Before:");
		while (rs.next()) {
			System.out.printf("%s, %f", rs.getString("last_name"), rs.getDouble("salary"));
			System.out.println();
		}
		System.out.println();
		System.out.println("After:");
			CallableStatement cs = conn.prepareCall("{call increaseSalariesForDepartment('Legal', 5000)}");

			cs.executeQuery();

			ps = conn.prepareStatement("select * from employees");
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.printf("%s, %f", rs.getString("last_name"), rs.getDouble("salary"));
				System.out.println();
			}
		
	}

}
