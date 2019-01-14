package com.factory;

public class MiniWindow extends Window {

	private int numberOfWings;
	private String color;

	public MiniWindow(int numberOfWings, String color) {
		this.numberOfWings = numberOfWings;
		this.color = color;
	}

	@Override
	public int getNumberOfWings() {
		// TODO Auto-generated method stub
		return this.numberOfWings;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public String toString() {
		return String.format("This is mini window with %d wings and %s color", this.numberOfWings, this.color);
	}

}
