package com.java;

public class CalcService {
	
	Calculator calc;
	
	
	
	public Calculator getCalc() {
		return calc;
	}



	public void setCalc(Calculator calc) {
		this.calc = calc;
	}



	public double addTwoNumbers(double x, double y) {
		return calc.add(x, y);
	}

}
