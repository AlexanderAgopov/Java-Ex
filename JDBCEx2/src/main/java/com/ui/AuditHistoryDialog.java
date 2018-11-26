package com.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.core.AuditHistory;
import com.core.Employee;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AuditHistoryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel employeeLabel;

	public void populate(Employee tempEmployee, List<AuditHistory> auditHistoryList) {
		employeeLabel.setText(
				"Audit history for employee: " + tempEmployee.getFirstName() + " " + tempEmployee.getLastName());
		AuditHistoryTableModel model = new AuditHistoryTableModel(auditHistoryList);
		table.setModel(model);
	}

	/**
	 * Create the dialog.
	 */
	public AuditHistoryDialog() {
		setBounds(100, 100, 450, 300);
		setTitle("Audit history");
		setModalityType(AuditHistoryDialog.this.DEFAULT_MODALITY_TYPE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			employeeLabel = new JLabel("Audit history for employee");
			contentPanel.add(employeeLabel, BorderLayout.NORTH);
		}
		{
			table = new JTable();
			contentPanel.add(table, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
