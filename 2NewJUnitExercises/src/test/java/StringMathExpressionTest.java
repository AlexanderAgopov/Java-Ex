/**
 * 
 */
package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.StringMathExpression;

/**
 * @author a
 *
 */
class StringMathExpressionTest {

	String add = "5 + 5";
	String subtract = "5 - 5";
	String multiply = "5 * 5";
	String divide = "5 / 5";
	String percent = "200 % 5";

	@Test
	void mathExpressionAdditionAsString_ReadItAndDoMath_ReturnCorrectResult() {
		assertEquals(10, StringMathExpression.doBasicMath(add));
	}

	@Test
	void mathExpressionSubtractionAsString_ReadItAndDoMath_ReturnCorrectResult() {
		assertEquals(0, StringMathExpression.doBasicMath(subtract));
	}

	@Test
	void mathExpressionMultiplicationAsString_ReadItAndDoMath_ReturnCorrectResult() {
		assertEquals(25, StringMathExpression.doBasicMath(multiply));
	}

	@Test
	void mathExpressionDivisionAsString_ReadItAndDoMath_ReturnCorrectResult() {
		assertEquals(1, StringMathExpression.doBasicMath(divide));
	}

	@Test
	void mathExpressionPercentageAsString_ReadItAndDoMath_ReturnCorrectResult() {
		assertEquals(10, StringMathExpression.doBasicMath(percent));
	}
	
	@Test
	void notMathExpression_ShouldThrowException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("Unknown operator!");	
		});
		assertEquals("Unknown operator!", exception.getMessage());		
	}

}
