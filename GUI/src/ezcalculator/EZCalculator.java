package ezcalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * The class EZCalculator generates a GUI presenting calculator which can perform the following math functions: 
 * 1) 
 * @author a
 *
 */
public class EZCalculator {

	private static String expression = "";
	private static String tempExpression = "";
	private static String result = "";
	private static double resultNumber = 0;

	/**
	 * Create and add all components to pane.
	 * 
	 * @param pane - the pane to be used
	 */
	public static void createAndAddComponentsToPane(Container pane) {

		pane.setLayout(new GridBagLayout());

		// Create Insets templates to be used for buttons on the left side, on the right
		// side, on the bottom and in the middle of the frame
		Insets insetsMiddle = new Insets(2, 2, 2, 2);
		Insets insetsLeft = new Insets(2, 4, 2, 2);
		Insets insetsRight = new Insets(2, 2, 2, 4);
		Insets insetsBottom = new Insets(2, 2, 4, 2);

		Font expressionFont = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		Font resultFont = new Font(Font.SANS_SERIF, Font.BOLD, 22);

		// Create text fields and position them on the top of the frame
		GridBagConstraints cF1 = new GridBagConstraints();
		JTextField expressionField = new JTextField();
		expressionField.setFont(expressionFont);
		expressionField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0') || (c > '9')) { // (c < '*') if we want to use '+', '-', '*' and '/'
					e.consume(); // ignore event
				}
				/**
				 * switch (c) { case '+': expression = expression + " + ";
				 * expressionField.setText(expression); break; case '-': expression = expression
				 * + " - "; expressionField.setText(expression); break; case '*': expression =
				 * expression + " * "; expressionField.setText(expression); break; case '/':
				 * expression = expression + " / "; expressionField.setText(expression); break;
				 * default: throw new RuntimeException("Unknown operator" + c);// catch this
				 * somewhere??? }
				 */
			}
		});
		cF1.fill = GridBagConstraints.HORIZONTAL;
		cF1.ipady = 20;
		cF1.weightx = 0.0;
		cF1.insets = new Insets(6, 4, 4, 2);
		cF1.gridwidth = 6;
		cF1.gridx = 0;
		cF1.gridy = 0;
		pane.add(expressionField, cF1);

		expressionField.setText(expression);

		GridBagConstraints cF2 = new GridBagConstraints();
		JTextField resultField = new JTextField();
		resultField.setFont(resultFont);
		resultField.setForeground(Color.red);
		resultField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				e.consume(); // ignore event
			}
		});
		cF2.fill = GridBagConstraints.HORIZONTAL;
		cF2.ipady = 20;
		cF2.weightx = 0.0;
		cF2.insets = new Insets(2, 4, 4, 2);
		cF2.gridwidth = 6;
		cF2.gridx = 0;
		cF2.gridy = 1;
		pane.add(resultField, cF2);

		// Create all buttons and position them in the frame
		GridBagConstraints cB7 = new GridBagConstraints();
		JButton b7 = new JButton("7");
		cB7.fill = GridBagConstraints.HORIZONTAL;
		cB7.ipadx = 10;
		cB7.ipady = 10;
		cB7.weightx = 0.5;
		cB7.insets = insetsLeft;
		cB7.gridx = 0;
		cB7.gridy = 2;
		pane.add(b7, cB7);

		GridBagConstraints cB8 = new GridBagConstraints();
		JButton b8 = new JButton("8");
		cB8.fill = GridBagConstraints.HORIZONTAL;
		cB8.ipadx = 10;
		cB8.ipady = 10;
		cB8.weightx = 0.5;
		cB8.insets = insetsMiddle;
		cB8.gridx = 1;
		cB8.gridy = 2;
		pane.add(b8, cB8);

		GridBagConstraints cB9 = new GridBagConstraints();
		JButton b9 = new JButton("9");
		cB9.fill = GridBagConstraints.HORIZONTAL;
		cB9.ipadx = 10;
		cB9.ipady = 10;
		cB9.weightx = 0.5;
		cB9.insets = insetsMiddle;
		cB9.gridx = 2;
		cB9.gridy = 2;
		pane.add(b9, cB9);

		GridBagConstraints cBDivide = new GridBagConstraints();
		JButton bDivide = new JButton("/");
		cBDivide.fill = GridBagConstraints.HORIZONTAL;
		cBDivide.ipadx = 15;
		cBDivide.ipady = 10;
		cBDivide.weightx = 0.5;
		cBDivide.insets = insetsMiddle;
		cBDivide.gridx = 3;
		cBDivide.gridy = 2;
		pane.add(bDivide, cBDivide);

		GridBagConstraints cBBackspace = new GridBagConstraints();
		JButton bBackspace = new JButton("\u2b05");
		cBBackspace.fill = GridBagConstraints.HORIZONTAL;
		cBBackspace.ipady = 10;
		cBBackspace.weightx = 0.5;
		cBBackspace.insets = insetsMiddle;
		cBBackspace.gridx = 4;
		cBBackspace.gridy = 2;
		pane.add(bBackspace, cBBackspace);

		GridBagConstraints cBCancel = new GridBagConstraints();
		JButton bCancel = new JButton("C");
		cBCancel.fill = GridBagConstraints.HORIZONTAL;
		cBCancel.ipadx = 10;
		cBCancel.ipady = 10;
		cBCancel.weightx = 0.5;
		cBCancel.insets = insetsRight;
		cBCancel.gridx = 5;
		cBCancel.gridy = 2;
		pane.add(bCancel, cBCancel);

		GridBagConstraints cB4 = new GridBagConstraints();
		JButton b4 = new JButton("4");
		cB4.fill = GridBagConstraints.HORIZONTAL;
		cB4.ipadx = 10;
		cB4.ipady = 10;
		cB4.weightx = 0.5;
		cB4.insets = insetsLeft;
		cB4.gridx = 0;
		cB4.gridy = 3;
		pane.add(b4, cB4);

		GridBagConstraints cB5 = new GridBagConstraints();
		JButton b5 = new JButton("5");
		cB5.fill = GridBagConstraints.HORIZONTAL;
		cB5.ipadx = 10;
		cB5.ipady = 10;
		cB5.weightx = 0.5;
		cB5.insets = insetsMiddle;
		cB5.gridx = 1;
		cB5.gridy = 3;
		pane.add(b5, cB5);

		GridBagConstraints cB6 = new GridBagConstraints();
		JButton b6 = new JButton("6");
		cB6.fill = GridBagConstraints.HORIZONTAL;
		cB6.ipadx = 10;
		cB6.ipady = 10;
		cB6.weightx = 0.5;
		cB6.insets = insetsMiddle;
		cB6.gridx = 2;
		cB6.gridy = 3;
		pane.add(b6, cB6);

		GridBagConstraints cBMultiply = new GridBagConstraints();
		JButton bMultiply = new JButton("*");
		cBMultiply.fill = GridBagConstraints.HORIZONTAL;
		cBMultiply.ipady = 10;
		cBMultiply.weightx = 0.5;
		cBMultiply.insets = insetsMiddle;
		cBMultiply.gridx = 3;
		cBMultiply.gridy = 3;
		pane.add(bMultiply, cBMultiply);

		GridBagConstraints cBFactorial = new GridBagConstraints();
		JButton bFactorial = new JButton("n!");
		cBFactorial.fill = GridBagConstraints.HORIZONTAL;
		cBFactorial.ipady = 10;
		cBFactorial.weightx = 0.5;
		cBFactorial.insets = insetsMiddle;
		cBFactorial.gridx = 4;
		cBFactorial.gridy = 3;
		pane.add(bFactorial, cBFactorial);

		GridBagConstraints cBLogarithm = new GridBagConstraints();
		JButton bLogarithm = new JButton("log");
		cBLogarithm.fill = GridBagConstraints.HORIZONTAL;
		cBLogarithm.ipady = 10;
		cBLogarithm.weightx = 0.5;
		cBLogarithm.insets = insetsRight;
		cBLogarithm.gridx = 5;
		cBLogarithm.gridy = 3;
		pane.add(bLogarithm, cBLogarithm);

		GridBagConstraints cB1 = new GridBagConstraints();
		JButton b1 = new JButton("1");
		cB1.fill = GridBagConstraints.HORIZONTAL;
		cB1.ipadx = 10;
		cB1.ipady = 10;
		cB1.weightx = 0.5;
		cB1.insets = insetsLeft;
		cB1.gridx = 0;
		cB1.gridy = 4;
		pane.add(b1, cB1);

		GridBagConstraints cB2 = new GridBagConstraints();
		JButton b2 = new JButton("2");
		cB2.fill = GridBagConstraints.HORIZONTAL;
		cB2.ipadx = 10;
		cB2.ipady = 10;
		cB2.weightx = 0.5;
		cB2.insets = insetsMiddle;
		cB2.gridx = 1;
		cB2.gridy = 4;
		pane.add(b2, cB2);

		GridBagConstraints cB3 = new GridBagConstraints();
		JButton b3 = new JButton("3");
		cB3.fill = GridBagConstraints.HORIZONTAL;
		cB3.ipadx = 10;
		cB3.ipady = 10;
		cB3.weightx = 0.5;
		cB3.insets = insetsMiddle;
		cB3.gridx = 2;
		cB3.gridy = 4;
		pane.add(b3, cB3);

		GridBagConstraints cBDecrement = new GridBagConstraints();
		JButton bDecrement = new JButton("-");
		cBDecrement.fill = GridBagConstraints.HORIZONTAL;
		cBDecrement.ipadx = 10;
		cBDecrement.ipady = 10;
		cBDecrement.weightx = 0.5;
		cBDecrement.insets = insetsMiddle;
		cBDecrement.gridx = 3;
		cBDecrement.gridy = 4;
		pane.add(bDecrement, cBDecrement);

		GridBagConstraints cBPowerTwo = new GridBagConstraints();
		JButton bPowerTwo = new JButton("x\u00B2");
		cBPowerTwo.fill = GridBagConstraints.HORIZONTAL;
		cBPowerTwo.ipady = 10;
		cBPowerTwo.weightx = 0.5;
		cBPowerTwo.insets = insetsMiddle;
		cBPowerTwo.gridx = 4;
		cBPowerTwo.gridy = 4;
		pane.add(bPowerTwo, cBPowerTwo);

		GridBagConstraints cBSquareRoot = new GridBagConstraints();
		JButton bSquareRoot = new JButton("\u221A");
		cBSquareRoot.fill = GridBagConstraints.HORIZONTAL;
		cBSquareRoot.ipady = 10;
		cBSquareRoot.weightx = 0.5;
		cBSquareRoot.insets = insetsRight;
		cBSquareRoot.gridx = 5;
		cBSquareRoot.gridy = 4;
		pane.add(bSquareRoot, cBSquareRoot);

		GridBagConstraints cB0 = new GridBagConstraints();
		JButton b0 = new JButton("0");
		cB0.fill = GridBagConstraints.HORIZONTAL;
		cB0.ipadx = 10;
		cB0.ipady = 10;
		cB0.weightx = 0.5;
		cB0.insets = new Insets(2, 4, 4, 2);
		cB0.gridx = 0;
		cB0.gridy = 5;
		pane.add(b0, cB0);

		GridBagConstraints cBDot = new GridBagConstraints();
		JButton bDot = new JButton(".");
		cBDot.fill = GridBagConstraints.HORIZONTAL;
		cBDot.ipadx = 10;
		cBDot.ipady = 10;
		cBDot.weightx = 0.5;
		cBDot.insets = insetsBottom;
		cBDot.gridx = 1;
		cBDot.gridy = 5;
		pane.add(bDot, cBDot);

		GridBagConstraints cBPercent = new GridBagConstraints();
		JButton bPercent = new JButton("%");
		cBPercent.fill = GridBagConstraints.HORIZONTAL;
		cBPercent.ipadx = 10;
		cBPercent.ipady = 10;
		cBPercent.weightx = 0.5;
		cBPercent.insets = insetsBottom;
		cBPercent.gridx = 2;
		cBPercent.gridy = 5;
		pane.add(bPercent, cBPercent);

		GridBagConstraints cBIncrement = new GridBagConstraints();
		JButton bIncrement = new JButton("+");
		cBIncrement.fill = GridBagConstraints.HORIZONTAL;
		cBIncrement.ipady = 10;
		cBIncrement.weightx = 0.5;
		cBIncrement.insets = insetsBottom;
		cBIncrement.gridx = 3;
		cBIncrement.gridy = 5;
		pane.add(bIncrement, cBIncrement);

		GridBagConstraints cBEquals = new GridBagConstraints();
		JButton bEquals = new JButton("=");
		cBEquals.fill = GridBagConstraints.HORIZONTAL;
		cBEquals.ipady = 10;
		cBEquals.weightx = 0.5;
		cBEquals.insets = new Insets(2, 2, 4, 4);
		cBEquals.gridwidth = 2;
		cBEquals.gridx = 4;
		cBEquals.gridy = 5;
		pane.add(bEquals, cBEquals);

		// Set button operations
		b0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "0";
				expressionField.setText(expression);
			}

		});

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "1";
				expressionField.setText(expression);
			}

		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "2";
				expressionField.setText(expression);
			}

		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "3";
				expressionField.setText(expression);
			}

		});

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "4";
				expressionField.setText(expression);
			}

		});

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "5";
				expressionField.setText(expression);
			}

		});

		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "6";
				expressionField.setText(expression);
			}

		});

		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "7";
				expressionField.setText(expression);
			}

		});

		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "8";
				expressionField.setText(expression);
			}

		});

		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + "9";
				expressionField.setText(expression);
			}

		});

		bDot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = expression + ".";
				expressionField.setText(expression);
			}

		});

		bIncrement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expressionField.getText().indexOf(" ") == -1) {
					if (expressionField.getText() == "") {
						// This block is performed if the calculator is empty.
						expression = " + ";
						expressionField.setText(expression);
						resultNumber = 0;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expressionField.getText();
						expression = expression + " + ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expressionField.getText();
						expression = expression + " + ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expressionField.getText().charAt(expressionField.getText().lastIndexOf(" ") - 1) == '+'
								|| expressionField.getText()
										.charAt(expressionField.getText().lastIndexOf(" ") - 1) == '-'
								|| expressionField.getText()
										.charAt(expressionField.getText().lastIndexOf(" ") - 1) == '*'
								|| expressionField.getText()
										.charAt(expressionField.getText().lastIndexOf(" ") - 1) == '/'
								|| expressionField.getText()
										.charAt(expressionField.getText().lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);
							expression = expressionField.getText();
							expression = expression + " + ";
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = expression + " + ";
							expressionField.setText(expression);
						}
					}

				}

			}

		});

		bDecrement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 0;
						expression = "-";
						expressionField.setText(expression);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " - ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}

				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " - ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = expression + " - ";
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = expression + " - ";
							expressionField.setText(expression);
						}
					}

				}
			}

		});

		bMultiply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						expression = " * ";
						expressionField.setText(expression);
						resultNumber = 0;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " * ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " * ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = expression + " * ";
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = expression + " * ";
							expressionField.setText(expression);
						}
					}

				}
			}

		});

		bDivide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						expression = " / ";
						expressionField.setText(expression);
						resultNumber = 0;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " / ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " / ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = expression + " / ";
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = expression + " / ";
							expressionField.setText(expression);
						}
					}

				}
			}

		});

		bPercent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						expression = " % ";
						expressionField.setText(expression);
						resultNumber = 0;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " % ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expression = expression + " % ";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = expression + " % ";
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = expression + " % ";
							expressionField.setText(expression);
						}
					}

				}
			}

		});

		bPowerTwo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 0;
						expression = "( 0 )\u00B2";
						expressionField.setText(expression);
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = expressionNumber * expressionNumber;
						expression = "( " + expression + " )\u00B2";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = expressionNumber * expressionNumber;
						expression = "( " + expression + " )\u00B2";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = "( " + expression + " )\u00B2";
							expressionField.setText(expression);
							resultNumber = resultNumber * resultNumber;
							result = Double.toString(resultNumber);
							resultField.setText(result);

						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = "( " + expression + " )\u00B2";
							expressionField.setText(expression);
							resultNumber = resultNumber * resultNumber;
							result = Double.toString(resultNumber);
							resultField.setText(result);
						}
					}

				}
			}

		});

		bSquareRoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 0;
						expression = "\u221A( 0 )";
						expressionField.setText(expression);
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = Math.sqrt(expressionNumber);
						expression = "\u221A( " + expression + " )";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = Math.sqrt(expressionNumber);
						expression = "\u221A( " + expression + " )";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = "\u221A( " + expression + " )";
							expressionField.setText(expression);
							resultNumber = Math.sqrt(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);

						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = "\u221A( " + expression + " )";
							expressionField.setText(expression);
							resultNumber = Math.sqrt(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);
						}
					}

				}

			}

		});

		bLogarithm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 0;
						expression = "log( 0 )";
						expressionField.setText(expression);
						resultNumber = Math.log(resultNumber);
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = Math.log(expressionNumber);
						expression = "log( " + expression + " )";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = Math.log(expressionNumber);
						expression = "log( " + expression + " )";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = "log( " + expression + " )";
							expressionField.setText(expression);
							resultNumber = Math.log(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);

						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = "log( " + expression + " )";
							expressionField.setText(expression);
							resultNumber = Math.log(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);
						}
					}

				}
			}

		});

		bFactorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 1;
						expression = "( 0 )!";
						expressionField.setText(expression);
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = factorial(expressionNumber);
						expression = "( " + expression + " )!";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					// This block is performed if multiple numbers are entered in the calculator.
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						expressionNumber = factorial(expressionNumber);
						expression = "( " + expression + " )!";
						expressionField.setText(expression);
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						if (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
								|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%') {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);

							expression = "( " + expression + " )!";
							expressionField.setText(expression);
							resultNumber = factorial(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);

						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							expression = "( " + expression + " )!";
							expressionField.setText(expression);
							resultNumber = factorial(resultNumber);
							result = Double.toString(resultNumber);
							resultField.setText(result);
						}
					}

				}
			}

		});

		bBackspace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (expression.charAt(expression.length() - 1) == ' ') {
					expression = "";
					expressionField.setText(expression);
					result = "";
					resultField.setText(result);
				} else {
					expression = expression.substring(0, expression.length() - 1);
					expressionField.setText(expression);
				}

			}
		});

		bCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				expression = "";
				expressionField.setText(expression);
				result = "";
				resultField.setText(result);
			}

		});

		bEquals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == "" && expression.indexOf(" ") == -1) {
					if (expression == "") {
						// This block is performed if the calculator is empty.
						resultNumber = 0;
						expression = "0";
						expressionField.setText(expression);
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if only one number is present in the expression field
						// of the calculator and
						// the 'equals' button is not used yet.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					}
				} else {
					if (Character.isDigit(expression.charAt(expression.length() - 1))
							&& expression.indexOf(" ") == -1) {
						// This block is performed when the 'equals' button is already used at least
						// once and
						// if only one number is present in the expression field
						// of the calculator.
						double expressionNumber = Double.parseDouble(expressionField.getText());
						resultNumber = expressionNumber;
						result = Double.toString(resultNumber);
						resultField.setText(result);
					} else {
						// This block is performed if multiple numbers are entered in the calculator.
						if (Character.isDigit(expression.charAt(expression.length() - 1))
								&& (expression.charAt(expression.lastIndexOf(" ") - 1) == '+'
										|| expression.charAt(expression.lastIndexOf(" ") - 1) == '-'
										|| expression.charAt(expression.lastIndexOf(" ") - 1) == '*'
										|| expression.charAt(expression.lastIndexOf(" ") - 1) == '/'
										|| expression.charAt(expression.lastIndexOf(" ") - 1) == '%')) {
							// This block is performed if the preceding operator is '+', '-', '*', '/' or
							// '%'.
							tempExpression = result + expressionField.getText()
									.substring(expressionField.getText().lastIndexOf(" ") - 2);
							resultNumber = doMath(tempExpression);
							result = Double.toString(resultNumber);
							resultField.setText(result);
							expression = result;
							expressionField.setText(expression);
						} else {
							// This block is performed if the preceding operator is different from '+', '-',
							// '*', '/' or '%'.
							result = Double.toString(resultNumber);
							resultField.setText(result);
							expression = result;
							expressionField.setText(expression);
						}
					}
				}
			}

		});

	}

	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("EZ Calculator");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		createAndAddComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * The method evaluate(String expression) uses switch construction to define all
	 * math functions which should be performed by the EZ Calculator.
	 * 
	 * @param expression - the math expression written in the expression field
	 * @return result of math function
	 */
	private static double doMath(String expression) {
		double result = 0;
		if (expression.isEmpty() == true) {
			return result;
		} else {
			double firstValue = resultNumber;
			double secondValue = Double.parseDouble(tempExpression.substring(tempExpression.lastIndexOf(" ")));
			String operator = tempExpression.substring(tempExpression.indexOf(" ") + 1,
					tempExpression.lastIndexOf(" "));

			switch (operator) {
			case "+":
				return firstValue + secondValue;
			case "-":
				return firstValue - secondValue;
			case "*":
				return firstValue * secondValue;
			case "/":
				return firstValue / secondValue;
			case "%":
				return (firstValue * secondValue) / 100;
			default:
				throw new RuntimeException("Unknown operator" + operator);// catch this somewhere???
			}
		}
	}

	/**
	 * The method factorial(double value) evaluates the factorial of the integer
	 * number closest to but less than the real number given to the method as a
	 * parameter.
	 * 
	 * @param value - variable of type double, real number
	 * @return the factorial of the integer number closest to but less than the real
	 *         number given to the method as a parameter.
	 */
	private static double factorial(double value) {
		long fact = 1L;
		int intValue = (int) value;
		for (int i = 1; i <= intValue; i++) {
			fact = fact * i;
		}
		return fact;
	}

	/**
	 * The method countSpaces(String expression) counts the occurrences of the
	 * single space character in a string.
	 * 
	 * @param expression - the string to be evaluated
	 * @return number of occurrences of the single space character in the string
	 */
	private static int countSpaces(String expression) {
		int count = 0;
		int index = expression.indexOf(" ");
		while (index != -1) {
			count++;
			index = expression.indexOf(" ", index + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
