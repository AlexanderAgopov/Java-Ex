/**
 * 
 */
package calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 * @author a
 *
 */
public class EZCalculator extends JFrame {

	public EZCalculator() {
		initComponents();
	}

	// Class variables declaration
	private JTextField expressionField;
	private JTextField resultField;
	private JButton bZero;
	private JButton bOne;
	private JButton bTwo;
	private JButton bThree;
	private JButton bFour;
	private JButton bFive;
	private JButton bSix;
	private JButton bSeven;
	private JButton bEight;
	private JButton bNine;
	private JButton bDot;
	private JButton bOpenBracket;
	private JButton bCloseBracket;
	private JButton bEquals;
	private JButton bIncrement;
	private JButton bDecrement;
	private JButton bMultiply;
	private JButton bDivide;
	private JButton bPercent;
	private JButton bPowerTwo;
	private JButton bSquareRoot;
	private JButton bLogarithm;
	private JButton bFactorial;
	private JButton bBackspace;
	private JButton bCancel;

	private void initComponents() {
		// TODO Auto-generated method stub
		expressionField = new JTextField(30);
		resultField = new JTextField(30);
		bZero = new JButton("0");
		bOne = new JButton("1");
		bTwo = new JButton("2");
		bThree = new JButton("3");
		bFour = new JButton("4");
		bFive = new JButton("5");
		bSix = new JButton("6");
		bSeven = new JButton("7");
		bEight = new JButton("8");
		bNine = new JButton("9");
		bDot = new JButton(".");
		bOpenBracket = new JButton("(");
		bCloseBracket = new JButton(")");
		bEquals = new JButton("=");
		bIncrement = new JButton("+");
		bDecrement = new JButton("-");
		bMultiply = new JButton("*");
		bDivide = new JButton("/");
		bPercent = new JButton("%");
		bPowerTwo = new JButton("x*x");
		bSquareRoot = new JButton("sqrt");
		bLogarithm = new JButton("log");
		bFactorial = new JButton("n!");
		bBackspace = new JButton("<-");
		bCancel = new JButton("C");

		/**
		 * 
		 * bZero.addActionListener(new ActionListener() {
		 * 
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bZeroActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bOne.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bOneActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bTwo.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bTwoActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bThree.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bThreeActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bFour.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bFourActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bFive.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bFiveActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bSix.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bSixActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bSeven.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bSevenActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bEight.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bEightActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bNine.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bNineActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bDot.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bDotActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bOpenBracket.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bOpenBracketActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bCloseBracket.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bCloseBracketActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bEquals.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bEqualsActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bIncrement.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bIncrementActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bDecrement.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bDecrementActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bMultiply.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bMultiplyActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bDivide.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bDivideActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bPercent.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bPercentActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bPowerTwo.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bPowerTwoActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bSquareRoot.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bSquareRootActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bLogarithm.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bLogarithmActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bFactorial.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bFactorialActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bBackspace.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bBackspaceActionPerformed(e); }
		 * 
		 *           });
		 * 
		 *           bCancel.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 *           method stub bCancelActionPerformed(e); }
		 * 
		 *           });
		 * 
		 * 
		 */
		GridBagLayout grid = new GridBagLayout();
		getContentPane().setLayout(grid);
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		GridBagConstraints e = new GridBagConstraints();
		GridBagConstraints f = new GridBagConstraints();
		GridBagConstraints g = new GridBagConstraints();
		GridBagConstraints h = new GridBagConstraints();
		GridBagConstraints i = new GridBagConstraints();
		GridBagConstraints j = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // make this component tall
		// c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		getContentPane().add(expressionField, c);

		d.fill = GridBagConstraints.HORIZONTAL;
		d.ipady = 0; // make this component tall
		// c.weightx = 1.0;
		d.gridwidth = 3;
		d.gridx = 0;
		d.gridy = 1;
		getContentPane().add(resultField, d);

		e.fill = GridBagConstraints.HORIZONTAL;
		e.weightx = 0.5;
		e.gridx = 0;
		e.gridy = 2;
		getContentPane().add(bSeven, e);

		f.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 0.5;
		f.gridx = 1;
		f.gridy = 2;
		getContentPane().add(bEight, f);

		g.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 0.5;
		g.gridx = 3;
		g.gridy = 2;
		getContentPane().add(bNine, g);

		h.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 0.5;
		h.gridx = 4;
		h.gridy = 2;
		getContentPane().add(bDivide, h);

		i.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 0.5;
		i.gridx = 5;
		i.gridy = 2;
		getContentPane().add(bBackspace, i);

		j.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 0.5;
		j.gridx = 6;
		j.gridy = 2;
		getContentPane().add(bCancel, j);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("EZ Calculator");

		// Display the window
		pack();
		setVisible(true);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EZCalculator calc = new EZCalculator();
		calc.initComponents();

	}

}
