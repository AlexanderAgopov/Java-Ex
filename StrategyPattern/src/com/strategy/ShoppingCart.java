package com.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public double calculateTotal() {
		double total = 0;
		for (Item item : this.items) {
			total += item.getPrice();
		}
		return total;
	}

	public String pay(PaymentStrategy paymentMethod) {
		double amount = this.calculateTotal();
		return paymentMethod.pay(amount);
	}

}
