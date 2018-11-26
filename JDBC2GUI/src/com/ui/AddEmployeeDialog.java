package com.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.core.Employee;
import com.dao.EmployeeDataAccessObject;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JTextField emailTextField;
	private JTextField departmentTextField;
	private JTextField salaryTextField;

	private EmployeeDataAccessObject employeeDAO;
	private EmployeeSearchApp employeeSearchApp;
	private Employee previousEmployee = null;
	private boolean updateMode = false;

	/**
	 * Create the dialog.
	 */

	public AddEmployeeDialog(EmployeeDataAccessObject employeeDAO, EmployeeSearchApp employeeSearchApp,
			Employee previousEmployee, boolean updateMode) {
		this(employeeDAO, employeeSearchApp);
		this.employeeDAO = employeeDAO;
		this.employeeSearchApp = employeeSearchApp;
		this.previousEmployee = previousEmployee;
		this.updateMode = updateMode;

		if (this.updateMode == true) {
			setTitle("Update employee");
			populateGUI(previousEmployee);
			lastNameTextField.setText(previousEmployee.getLastName());
			firstNameTextField.setText(previousEmployee.getFirstName());
			emailTextField.setText(previousEmployee.getEmail());
			departmentTextField.setText(previousEmployee.getDepartment());
			salaryTextField.setText(previousEmployee.getSalary().toString());
		}

	}

	private void populateGUI(Employee previousEmployee) {
		// TODO Auto-generated method stub
		lastNameTextField.setText(previousEmployee.getLastName());
		firstNameTextField.setText(previousEmployee.getFirstName());
		emailTextField.setText(previousEmployee.getEmail());
		departmentTextField.setText(previousEmployee.getDepartment());
		salaryTextField.setText(previousEmployee.getSalary().toString());
	}

	public AddEmployeeDialog(EmployeeDataAccessObject employeeDAO, EmployeeSearchApp employeeSearchApp) {
		this.employeeDAO = employeeDAO;
		this.employeeSearchApp = employeeSearchApp;

		setResizable(false);
		setBounds(100, 100, 450, 200);
		setTitle("Add employee");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblLastName = new JLabel("Last name");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.anchor = GridBagConstraints.EAST;
			gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_lblLastName.gridx = 0;
			gbc_lblLastName.gridy = 0;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			lastNameTextField = new JTextField();
			GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
			gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lastNameTextField.gridx = 1;
			gbc_lastNameTextField.gridy = 0;
			contentPanel.add(lastNameTextField, gbc_lastNameTextField);
			lastNameTextField.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("FIrst name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 1;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			firstNameTextField = new JTextField();
			GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
			gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstNameTextField.gridx = 1;
			gbc_firstNameTextField.gridy = 1;
			contentPanel.add(firstNameTextField, gbc_firstNameTextField);
			firstNameTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Email");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			emailTextField = new JTextField();
			emailTextField.setText("");
			GridBagConstraints gbc_emailTextField = new GridBagConstraints();
			gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
			gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailTextField.gridx = 1;
			gbc_emailTextField.gridy = 2;
			contentPanel.add(emailTextField, gbc_emailTextField);
			emailTextField.setColumns(10);
		}
		{
			JLabel lblDepartment = new JLabel("Department");
			GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
			gbc_lblDepartment.anchor = GridBagConstraints.EAST;
			gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_lblDepartment.gridx = 0;
			gbc_lblDepartment.gridy = 3;
			contentPanel.add(lblDepartment, gbc_lblDepartment);
		}
		{
			departmentTextField = new JTextField();
			departmentTextField.setText("");
			GridBagConstraints gbc_departmentTextField = new GridBagConstraints();
			gbc_departmentTextField.insets = new Insets(0, 0, 5, 0);
			gbc_departmentTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_departmentTextField.gridx = 1;
			gbc_departmentTextField.gridy = 3;
			contentPanel.add(departmentTextField, gbc_departmentTextField);
			departmentTextField.setColumns(10);
		}
		{
			JLabel lblSalary = new JLabel("Salary");
			GridBagConstraints gbc_lblSalary = new GridBagConstraints();
			gbc_lblSalary.anchor = GridBagConstraints.EAST;
			gbc_lblSalary.insets = new Insets(0, 0, 0, 5);
			gbc_lblSalary.gridx = 0;
			gbc_lblSalary.gridy = 4;
			contentPanel.add(lblSalary, gbc_lblSalary);
		}
		{
			salaryTextField = new JTextField();
			salaryTextField.setText("");
			GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
			gbc_salaryTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_salaryTextField.gridx = 1;
			gbc_salaryTextField.gridy = 4;
			contentPanel.add(salaryTextField, gbc_salaryTextField);
			salaryTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveEmployee();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	private void saveEmployee() {
		String lastName = lastNameTextField.getText();
		String firstName = firstNameTextField.getText();
		String email = emailTextField.getText();
		String department = departmentTextField.getText();
		double salary = Double.parseDouble(salaryTextField.getText());

		Employee tempEmployee = null;

		if (updateMode = true) {
			tempEmployee = previousEmployee;
			tempEmployee.setLastName(lastName);
			tempEmployee.setFirstName(firstName);
			tempEmployee.setEmail(email);
			tempEmployee.setDepartment(department);
			tempEmployee.setSalary(salary);
		} else {
			tempEmployee = new Employee(previousEmployee.getId(), lastName, firstName, email, department, salary);
		}

		try {
			if (updateMode == true) {
				employeeDAO.updateEmployee(tempEmployee, employeeSearchApp.getUserID());
			} else {
				employeeDAO.addEmployee(tempEmployee,employeeSearchApp.getUserID());
			}

			setVisible(false);
			dispose();

			employeeSearchApp.refreshEmployeesView();

			JOptionPane.showMessageDialog(employeeSearchApp, "Employee added successfully! ", "Employee added.",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			;
			JOptionPane.showMessageDialog(employeeSearchApp, "Error saving employee: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);

		}

	}

}
