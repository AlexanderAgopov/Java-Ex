package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.core.AuditHistory;
import com.core.Employee;
import com.core.User;
import com.dao.EmployeeDataAccessObject;

public class EmployeeSearchApp extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton buttonSearch;
	private JButton buttonAdd;
	private JButton buttonUpdate;
	private JButton buttonDelete;
	private JButton buttonViewHistory;
	private JScrollPane scrollPane;
	private JTable table;
	private EmployeeDataAccessObject employeeDAO;
	private int userID;
	private JLabel lblLoggedIn;
	private JLabel lblLoggedInUser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDataAccessObject employeeDAO = new EmployeeDataAccessObject();
					List<User> users = employeeDAO.getUsers();
					UserLoginDialog loginDialog = new UserLoginDialog();
					loginDialog.populateUsers(users);
					loginDialog.setEmployeeDAO(employeeDAO);
					loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					loginDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		);
	}

	public EmployeeSearchApp(int userID, EmployeeDataAccessObject theEmployeeDAO) {

		this.userID = userID;
		try {
			employeeDAO = theEmployeeDAO;
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("EmployeeSearchApp");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		lblLoggedIn = new JLabel("Logged in as:");
		panel.add(lblLoggedIn);
		lblLoggedInUser = new JLabel("New label");
		panel.add(lblLoggedInUser);

		JLabel enterLastNameLabel = new JLabel("Enter last name:");
		panel.add(enterLastNameLabel);

		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		lastNameTextField.setText("");
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					String lastName = lastNameTextField.getText();
					List<Employee> employees = null;
					if (lastName != "") {
						employees = employeeDAO.searchEmployees(lastName);
					} else {
						employeeDAO.getAllEmployees();
					}
					EmployeeTableModel model = new EmployeeTableModel(employees);
					table.setModel(model);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + ex, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		buttonAdd = new JButton("Add employee");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployeeDialog dialog = new AddEmployeeDialog(employeeDAO, EmployeeSearchApp.this);
				dialog.setVisible(true);
			}

		});

		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int id = (int) table.getValueAt(row, 0);
				String ln = (String) table.getValueAt(row, 1);
				String fn = (String) table.getValueAt(row, 2);
				String em = (String) table.getValueAt(row, 3);
				String dep = (String) table.getValueAt(row, 4);
				double sal = (double) table.getValueAt(row, 5);
				Employee tempEmployee = new Employee(id, ln, fn, em, dep, sal);
				AddEmployeeDialog dialog = new AddEmployeeDialog(employeeDAO, EmployeeSearchApp.this, tempEmployee,
						true);
				dialog.setVisible(true);
			}
		});

		buttonDelete = new JButton("Delete");
		buttonDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int id = (int) table.getValueAt(row, 0);

				DeleteEmployeeDialog dialog = new DeleteEmployeeDialog(employeeDAO, EmployeeSearchApp.this, id);
				System.out.println(dialog.getId());
				dialog.setVisible(true);
			}
		});

		buttonViewHistory = new JButton("View history");
		buttonViewHistory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();

				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int id = (int) table.getValueAt(row, 0);
				String ln = (String) table.getValueAt(row, 1);
				String fn = (String) table.getValueAt(row, 2);
				String em = (String) table.getValueAt(row, 3);
				String dep = (String) table.getValueAt(row, 4);
				double sal = (double) table.getValueAt(row, 5);
				Employee tempEmployee = new Employee(id, ln, fn, em, dep, sal);
				try {
					List<AuditHistory> auditHistoryList = employeeDAO.getAuditHistory(id);

					AuditHistoryDialog dialog = new AuditHistoryDialog();
					dialog.populate(tempEmployee, auditHistoryList);
					dialog.setVisible(true);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error retrieving audit history.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		panel.add(buttonSearch);
		panel.add(buttonAdd);
		panel.add(buttonDelete);
		panel.add(buttonUpdate);
		panel.add(buttonViewHistory);
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public int getUserID() {
		return userID;
	}

	public void refreshEmployeesView() throws SQLException {
		try {
			List<Employee> list = employeeDAO.getAllEmployees();
			EmployeeTableModel model = new EmployeeTableModel(list);
			table.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void setLoggedInUserName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		lblLoggedInUser.setText(firstName + " " + lastName);
	}

}
