package com.core;

import java.util.Date;

public class AuditHistory {

	private int id;
	private int userID;
	private int employeeID;
	private String action;
	private Date actionDateTime;
	private String userFirstName;
	private String userLastName;

	public AuditHistory(int id, int userID, int employeeID, String action, Date actionDateTime, String userFirstName,
			String userLastName) {
		super();
		this.id = id;
		this.userID = userID;
		this.employeeID = employeeID;
		this.action = action;
		this.actionDateTime = actionDateTime;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionDateTime() {
		return actionDateTime;
	}

	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return String.format(
				"Audit history [Edit ID = %d, conducted by userID=%d, first name = %s, last name = %s, action = %s, on employeeID = %s, time = %s]",
				this.id, this.userID, this.userFirstName, this.userLastName, this.action, this.employeeID,
				this.actionDateTime);
	}

}
