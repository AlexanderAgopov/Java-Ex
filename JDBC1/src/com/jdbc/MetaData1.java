package com.jdbc;

import java.sql.*;

public class MetaData1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "antoniq");
		DatabaseMetaData dbmd = conn.getMetaData();

		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		ResultSet rs = null;

		System.out.println("Product name: " + dbmd.getDatabaseProductName());
		System.out.println("Product version: " + dbmd.getDatabaseProductVersion());
		System.out.println();
		System.out.println("JDBC driver name: " + dbmd.getDriverName());
		System.out.println("JDBC driver version: " + dbmd.getDriverVersion());
		System.out.println();
		System.out.println("List of tables:");
		System.out.println();
		rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, types);

		while (rs.next()) {
			System.out.println(rs.getString("TABLE_NAME"));
		}

		System.out.println();
		System.out.println("List of all columns in 'employees' table:");
		ResultSet rs2 = dbmd.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
		while (rs.next()) {
			System.out.println(rs.getString("COLUMN_NAME"));
		}
		System.out.println();
		Statement s = conn.createStatement();
		rs2 = s.executeQuery("select last_name, first_name, email from employees");
		ResultSetMetaData rsmd = rs2.getMetaData();
		int columnCount = rsmd.getColumnCount();
		System.out.println("Column count: " + columnCount);
		System.out.println();
		for (int column = 1; column <= columnCount; column++) {
			System.out.printf("%s %s %b %b", rsmd.getColumnName(column), rsmd.getColumnType(column),
					rsmd.isNullable(column), rsmd.isAutoIncrement(column));
			System.out.println();
		}

	}

}
