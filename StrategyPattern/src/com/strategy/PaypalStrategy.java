package com.strategy;

public class PaypalStrategy implements PaymentStrategy {

	private String email;
	private String password;

	public PaypalStrategy(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String pay(double amount) {
		// TODO Auto-generated method stub
		return amount + " paid via PayPal";
	}

}
