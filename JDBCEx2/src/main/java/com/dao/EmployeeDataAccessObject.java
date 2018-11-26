package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.core.AuditHistory;
import com.core.Employee;
import com.core.User;

import sun.security.pkcs11.Secmod.DbMode;

public class EmployeeDataAccessObject {

	private Connection connection;

	public EmployeeDataAccessObject() throws FileNotFoundException, IOException, SQLException {
		super();
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
		String dburl = properties.getProperty("dburl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		this.connection = DriverManager.getConnection(dburl, user, password);

		System.out.println("DB Connection successful to: " + dburl);
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> list = new ArrayList<>();

		Statement statement = null;
		ResultSet rs = null;

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from employees");

			while (rs.next()) {
				Employee tempEmployee = convertRowToEmployee(rs);
				list.add(tempEmployee);
			}
			return list;
		} finally {
			close(statement, rs);
		}

	}

	public List<Employee> searchEmployees(String lastName) throws SQLException {
		List<Employee> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			lastName += "%";
			statement = connection.prepareStatement("select * from employees where last_name like ?");
			statement.setString(1, lastName);
			rs = statement.executeQuery();

			while (rs.next()) {
				Employee tempEmployee = convertRowToEmployee(rs);
				list.add(tempEmployee);
			}
			return list;
		} finally {
			close(statement, rs);
		}

	}

	public List<User> getUsers() throws SQLException {
		List<User> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			statement = connection.prepareStatement("select * from users");
			rs = statement.executeQuery();

			while (rs.next()) {
				User tempUser = convertRowToUser(rs);
				list.add(tempUser);
			}
			return list;
		} finally {
			close(statement, rs);
		}
	}

	public void addEmployee(Employee newEmployee, int userID) throws SQLException {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"insert into employees(id, last_name, first_name, email, department, salary) values(0, ?, ?, ?, ?, ?)");
			statement.setString(1, newEmployee.getLastName());
			statement.setString(2, newEmployee.getFirstName());
			statement.setString(3, newEmployee.getEmail());
			statement.setString(4, newEmployee.getDepartment());
			statement.setDouble(5, newEmployee.getSalary());
			statement.executeUpdate();
			
			statement = connection.prepareStatement("insert into audit_history values(0, ?, ?, ?, ?)");
			statement.setInt(1, userID);
			statement.setInt(2, newEmployee.getId());
			statement.setString(3, "Update employee");
			statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			statement.executeUpdate();
		} finally {
			close(statement);
		}

	}

	public void updateEmployee(Employee employee, int userID) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(
					"update employees set last_name=?, first_name=?, email=?, department=?, salary=? where id=?");
			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getDepartment());
			statement.setDouble(5, employee.getSalary());
			statement.setInt(6, employee.getId());
			statement.executeUpdate();

			statement = connection.prepareStatement("insert into audit_history values(0, ?, ?, ?, ?)");
			statement.setInt(1, userID);
			statement.setInt(2, employee.getId());
			statement.setString(3, "Update employee");
			statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			statement.executeUpdate();
		} finally {
			close(statement);
		}
	}

	public void deleteEmployee(int id) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("delete from employees where id=?");
			statement.setInt(1, id);
			statement.execute();
		} finally {
			close(statement);
		}
	}

	private Employee convertRowToEmployee(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String lastName = rs.getString("last_name");
		String firstName = rs.getString("first_name");
		String email = rs.getString("email");
		String department = rs.getString("department");
		Double salary = rs.getDouble("salary");

		return new Employee(id, lastName, firstName, email, department, salary);
	}

	private User convertRowToUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String lastName = rs.getString("last_name");
		String firstName = rs.getString("first_name");
		String email = rs.getString("email");
		String password = rs.getString("password");

		return new User(id, lastName, firstName, email, password);
	}

	private static void close(Connection connection, Statement statement, ResultSet rs) throws SQLException {

		if (connection != null) {
			connection.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (rs != null) {
			rs.close();
		}

	}

	private void close(Statement statement, ResultSet rs) throws SQLException {
		close(null, statement, rs);
	}

	private void close(Statement statement) throws SQLException {
		close(null, statement, null);
	}

	public static void main(String[] args) throws Exception {

		EmployeeDataAccessObject dao = new EmployeeDataAccessObject();
		System.out.println(dao.searchEmployees("drag"));

		System.out.println(dao.getAllEmployees());
	}

	public List<AuditHistory> getAuditHistory(int employeeID) throws SQLException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.prepareStatement(
					"select history.id, history.user_id, history.employee_id, history.action, history.action_date_time, users.first_name, users.last_name from audit_history history, users users where history.user_id=users.id and history.employee_id="
							+ employeeID);
			List<AuditHistory> auditHistoryList = new ArrayList<AuditHistory>();
			rs = statement.executeQuery();
			while (rs.next()) {
				Timestamp timestamp = rs.getTimestamp("history.action_date_time");
				java.util.Date actionDateTime = new java.util.Date(timestamp.getTime());
				AuditHistory auditHistory = new AuditHistory(rs.getInt("history.id"), rs.getInt("history.user_id"),
						rs.getInt("history.employee_id"), rs.getString("history.action"), actionDateTime,
						rs.getString("users.first_name"), rs.getString("users.last_name"));
				auditHistoryList.add(auditHistory);
			}
			return auditHistoryList;
		} finally {
			close(statement, rs);
		}

	}

}
