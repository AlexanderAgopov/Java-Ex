package com.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.core.User;
import com.dao.EmployeeDataAccessObject;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JComboBox userComboBox;
	private EmployeeDataAccessObject employeeDAO;

	/**
	 * Create the dialog.
	 */
	public UserLoginDialog() {
		setBounds(100, 100, 450, 300);
		setTitle("User login");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUser = new JLabel("User");
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
			gbc_lblUser.anchor = GridBagConstraints.EAST;
			gbc_lblUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblUser.gridx = 0;
			gbc_lblUser.gridy = 0;
			contentPanel.add(lblUser, gbc_lblUser);
		}
		{
			userComboBox = new JComboBox();
			GridBagConstraints gbc_userComboBox = new GridBagConstraints();
			gbc_userComboBox.insets = new Insets(0, 0, 5, 0);
			gbc_userComboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_userComboBox.gridx = 1;
			gbc_userComboBox.gridy = 0;
			contentPanel.add(userComboBox, gbc_userComboBox);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
			gbc_lblPassword.gridx = 0;
			gbc_lblPassword.gridy = 1;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 1;
			contentPanel.add(passwordField, gbc_passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (userComboBox.getSelectedIndex() < 0) {
							JOptionPane.showMessageDialog(UserLoginDialog.this, "Please select user name.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						User user = (User) userComboBox.getSelectedItem();
						int userID = user.getId();
						char[] password = passwordField.getPassword();
						String passwordText = new String(password);
						if (passwordText.equals(user.getPassword())) {
							setVisible(false);
							dispose();
							EmployeeSearchApp frame = new EmployeeSearchApp(userID, employeeDAO);
							frame.setVisible(true);
							frame.setLoggedInUserName(user.getFirstName(), user.getLastName());

						} else {
							JOptionPane.showMessageDialog(UserLoginDialog.this, "Wrong password! PLease try again.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				});
				okButton.setActionCommand("OK");
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

	public void populateUsers(List<User> users) {
		userComboBox.setModel(new DefaultComboBoxModel(users.toArray(new User[0])));
	}

	public void setEmployeeDAO(EmployeeDataAccessObject employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
