package com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.java.Calculator;
import com.java.ComparisonService;

public class ComparisonServiceTestJUnit4 {
	
	ComparisonService cs;
	
	@Mock
	Calculator calc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(calc.add(3, 3)).thenReturn((double) 6);
		cs = new ComparisonService();
		cs.setCal(calc);
	}

	@Test
	public void testComparisonOfTwoAdditions() {
		Assert.assertTrue(cs.compareTwoAdditions(3, 3, 3, 3));
	}

}
