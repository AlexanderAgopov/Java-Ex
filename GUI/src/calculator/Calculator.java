/**
 * 
 */
package calculator;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


/**
 * The objects of class Calculator are user-friendly calculators which can
 * perform basic math functions such as increment, decrement, multiply, divide,
 * find square root, find logarithm and calculate factorial.
 * 
 * @author a
 *
 */
public class Calculator extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340732273401597053L;

	public Calculator() {
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
		expressionField = new JTextField(20);
		resultField = new JTextField(2);
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

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("EZ Calculator");

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
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		this.add(resultField, BorderLayout.NORTH);
		resultField.setVisible(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bSeven)
						.addComponent(bFour)
						.addComponent(bOne)
						.addComponent(bZero)
						.addComponent(expressionField)
						.addComponent(resultField))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bEight)
						.addComponent(bFive)
						.addComponent(bTwo)
						.addComponent(bDot))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bNine)
						.addComponent(bSix)
						.addComponent(bThree)
						.addComponent(bPercent))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bDivide)
						.addComponent(bMultiply)
						.addComponent(bIncrement)
						.addComponent(bDecrement))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bBackspace)
						.addComponent(bLogarithm)
						.addComponent(bPowerTwo)
						.addComponent(bEquals))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bCancel)
						.addComponent(bFactorial)
						.addComponent(bSquareRoot)));
		
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bSeven)
						.addComponent(bEight)
						.addComponent(bNine)
						.addComponent(bDivide)
						.addComponent(bBackspace)
						.addComponent(bCancel))
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bFour)
						.addComponent(bFive)
						.addComponent(bSix)
						.addComponent(bMultiply)
						.addComponent(bLogarithm)
						.addComponent(bFactorial))
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bOne)
						.addComponent(bTwo)
						.addComponent(bThree)
						.addComponent(bIncrement)
						.addComponent(bPowerTwo)
						.addComponent(bSquareRoot))
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bZero)
						.addComponent(bDot)
						.addComponent(bPercent)
						.addComponent(bDecrement)
						.addComponent(bEquals))
				.addComponent(expressionField)
				.addComponent(resultField));
		
		//Make all buttons same size
		layout.linkSize(bZero,bOne, bTwo,bThree,bFour,bFive,bSix,bSeven,bEight,bNine,bDot, 
			bEquals,bIncrement,bDecrement,bMultiply,bDivide,bPercent,bPowerTwo,bSquareRoot,
			bLogarithm,bFactorial,bBackspace,bCancel);

		/**
		 * layout.setHorizontalGroup( layout.createParallelGroup(Alignment.LEADING)
		 * .addGroup( layout.createSequentialGroup().addContainerGap()
		 * .addGroup(layout.createParallelGroup(Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup().addComponent(bSeven)
		 * .addPreferredGap(ComponentPlacement.RELATED).addComponent(bEight)
		 * .addPreferredGap(ComponentPlacement.RELATED).addComponent(bNine)
		 * .addGroup(layout.createSequentialGroup()).addComponent(bFour)
		 * .addPreferredGap(ComponentPlacement.RELATED).addComponent(bFive)
		 * .addPreferredGap(ComponentPlacement.RELATED).addComponent(bSix)))
		 * .addContainerGap(2, Short.MAX_VALUE)));
		 * 
		 * //layout.linkSize(SwingConstants.HORIZONTAL, bSeven, bFour);
		 * 
		 * layout.setVerticalGroup( layout.createParallelGroup(Alignment.LEADING)
		 * .addGroup( layout.createSequentialGroup().addContainerGap()
		 * .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(bSeven)
		 * .addComponent(bEight).addComponent(bNine))
		 * .addPreferredGap(ComponentPlacement.RELATED)
		 * .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(bFour)
		 * .addComponent(bFive).addComponent(bSix)) .addContainerGap(2,
		 * Short.MAX_VALUE)));
		 */
		pack();

	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		calc.setVisible(true);
		calc.initComponents();

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// new Calculator().setVisible(true);
		// }
		// });
	}

}
