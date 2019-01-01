package com.java;

public class ComparisonService {

	Calculator cal;

	public Calculator getCal() {
		return cal;
	}

	public void setCal(Calculator calc) {
		this.cal = calc;
	}

	public boolean compareTwoAdditions(double a, double b, double c, double d) {

		if (cal.add(a, b) >= cal.add(c, d)) {
			return true;
		} else {
			return false;
		}
	}

}
