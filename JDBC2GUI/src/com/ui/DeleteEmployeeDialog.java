package com.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.EmployeeDataAccessObject;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeleteEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private EmployeeDataAccessObject employeeDAO;
	private EmployeeSearchApp employeeSearchApp;
	private int id;

	/**
	 * Create the dialog.
	 */
	public DeleteEmployeeDialog(EmployeeDataAccessObject employeeDAO, EmployeeSearchApp employeeSearchApp, int id) {
		this.id = id;
		this.employeeDAO = employeeDAO;
		this.employeeSearchApp = employeeSearchApp;
		setTitle("Delete employee");
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblDeleteThisEmployee = new JLabel("Delete this employee?");
			contentPanel.add(lblDeleteThisEmployee);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						removeEmployee();
					}
				});
				okButton.setActionCommand("Delete");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void removeEmployee() {
		// TODO Auto-generated method stub
		try {
			System.out.println(DeleteEmployeeDialog.this.getId());
			employeeDAO.deleteEmployee(DeleteEmployeeDialog.this.getId());
			setVisible(false);
			dispose();
			employeeSearchApp.refreshEmployeesView();

			JOptionPane.showMessageDialog(employeeSearchApp, "Employee deleted successfully!", "Employee deleted",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(employeeSearchApp, "Error deleting employee " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
