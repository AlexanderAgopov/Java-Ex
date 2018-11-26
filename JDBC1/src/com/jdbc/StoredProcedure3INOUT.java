package com.jdbc;

import java.sql.*;

public class StoredProcedure3INOUT {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");

		String departmentName = "Accounting";
		CallableStatement cs = conn.prepareCall("{call greetDepartment(?)}");
		cs.registerOutParameter(1, Types.VARCHAR);
		cs.setString(1, departmentName);
		System.out.println("Calling stored procedure greetdepartment('" + departmentName + "')");
		cs.execute();
		System.out.println("Finished calling stored procedure");
		String result = cs.getString(1);
		System.out.println("\nThe result is: " + result);
	}

}
