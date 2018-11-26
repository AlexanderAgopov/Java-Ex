package com.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.core.*;

public class EmployeeTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private static final int ID_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int FIRST_NAME_C0L = 2;
	private static final int EMAIL_C0L = 3;
	private static final int DEPARTMENT_C0L = 4;
	private static final int SALARY_C0L = 5;

	private String[] columnNames = { "id", "Last Name", "First Name", "Email", "Department", "salary" };

	private List<Employee> employees;

	public EmployeeTableModel(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.employees.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Employee tempEmployee = employees.get(row);

		switch (col) {
		case ID_COL:
			return tempEmployee.getId();
		case LAST_NAME_COL:
			return tempEmployee.getLastName();
		case FIRST_NAME_C0L:
			return tempEmployee.getFirstName();
		case EMAIL_C0L:
			return tempEmployee.getEmail();
		case DEPARTMENT_C0L:
			return tempEmployee.getDepartment();
		case SALARY_C0L:
			return tempEmployee.getSalary();
		default:
			return tempEmployee.getLastName();
		}
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
