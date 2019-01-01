package com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.java.CalcService;
import com.java.Calculator;

public class CalcServiceTest {
	
	CalcService cs;

	@Before
	public void setUp() throws Exception {
		Calculator calc = Mockito.mock(Calculator.class);
		Mockito.when(calc.add(3, 3)).thenReturn(6.0);
		cs = new CalcService();
		cs.setCalc(calc);
	}

	@Test
	public void test() {
		Assert.assertEquals(6, cs.addTwoNumbers(3, 3), 0.1);
	}

}
