package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.strategy.CreditCardStrategy;
import com.strategy.Item;
import com.strategy.PaypalStrategy;
import com.strategy.ShoppingCart;

class SuccessfulPaymentTest {

	private ShoppingCart cart;

	@BeforeEach
	void setUp() throws Exception {
		cart = new ShoppingCart();
		cart.addItem(new Item(123, 10));
		cart.addItem(new Item(101, 20));

	}

	@Test
	void testPaypalPayment() {
		Assert.assertEquals("30.0 paid via PayPal", cart.pay(new PaypalStrategy("assa@ssa.s", "123d")));
	}

	@Test
	void testCreditCardPayment() {
		Assert.assertEquals("30.0 paid with credit/debit card",
				cart.pay(new CreditCardStrategy("assa@ssa.s", "123d", "1", "v")));
	}

}
