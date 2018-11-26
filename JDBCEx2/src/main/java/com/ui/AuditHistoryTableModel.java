package com.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.core.AuditHistory;

public class AuditHistoryTableModel extends AbstractTableModel {

	private static final int ID_COL = 0;
	private static final int USER_ID_COL = 1;
	private static final int EMPLOYEE_ID_COL = 2;
	private static final int ACTION_COL = 3;
	private static final int ACTION_DATE_TIME_COL = 4;
	private static final int USER_FIRST_NAME_COL = 5;
	private static final int USER_LAST_NAME_COL = 6;

	private String[] columnNames = { "ID", "User ID", "Employee ID", "Action", "Date/Time", "User First Name",
			"User LAst Name" };

	private List<AuditHistory> auditHistoryList;

	public AuditHistoryTableModel(List<AuditHistory> auditHistoryList) {
		this.auditHistoryList = auditHistoryList;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return auditHistoryList.size();
	}

	@Override
	public String getColumnName(int c) {
		return columnNames[c];
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		AuditHistory tempAuditHistory = auditHistoryList.get(row);

		switch (col) {
		case ID_COL:
			return tempAuditHistory.getId();
		case USER_ID_COL:
			return tempAuditHistory.getUserID();
		case EMPLOYEE_ID_COL:
			return tempAuditHistory.getEmployeeID();
		case ACTION_COL:
			return tempAuditHistory.getAction();
		case ACTION_DATE_TIME_COL:
			return tempAuditHistory.getActionDateTime();
		case USER_FIRST_NAME_COL:
			return tempAuditHistory.getUserFirstName();
		case USER_LAST_NAME_COL:
			return tempAuditHistory.getUserLastName();
		default:
			return tempAuditHistory.getUserLastName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
