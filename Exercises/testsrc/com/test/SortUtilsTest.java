package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortUtilsTest {

	@Test
	public void testSort() {
		// GIVEN
		SortUtils utils = new SortUtilsImpl();
		int[] array = {1,2,3};
		// WHEN
		boolean result = utils.sort(array);
		// VERIFY
		assertTrue(result);
	}
	@Test(expected=NullPointerException.class)
	public void testInvalidInput() {
		// GIVEN
		SortUtils utils = new SortUtilsImpl();
		int[] array = null;
		// WHEN
		boolean result = utils.sort(array);
		// VERIFY
		fail();
	}
}
