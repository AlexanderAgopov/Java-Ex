package com.jdbc;

import java.sql.*;

public class StoredProcedure4OUT {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");
		CallableStatement cs = conn.prepareCall("{call countEmployeesInDepartment(?,?)}");
		String department = "Legal";
		cs.setString(1, department);
		cs.registerOutParameter(2, Types.INTEGER);
		cs.execute();
		int count = cs.getInt(2);
		System.out.printf("There are %d employees in the %s department.", count, department);
	}

}
