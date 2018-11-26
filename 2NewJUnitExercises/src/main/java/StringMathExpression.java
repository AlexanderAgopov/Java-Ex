 /**
 * 
 */
package main.java;

/**
 * @author a
 *
 */
public class StringMathExpression {

	/**
	 * The method doBasicMath(String expression) uses switch construction to define
	 * the math basic operations performed by the EZ Calculator. The calculation of
	 * percentage is also included.
	 * 
	 * @param expression - the math expression written in the expression field
	 * @return result of math function
	 */
	public static double doBasicMath(String expression) {
		double result = 0;
		if (expression.isEmpty() == true) {
			return result;
		} else {
			double firstValue = Double.parseDouble(expression.substring(0, expression.indexOf(" ")));
			double secondValue = Double.parseDouble(expression.substring(expression.lastIndexOf(" ")));
			String operator = expression.substring(expression.indexOf(" ") + 1, expression.lastIndexOf(" "));

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
				throw new IllegalArgumentException("Unknown operator" + operator);
			}
		}
	}

	public static void main(String[] args) {

	}

}
