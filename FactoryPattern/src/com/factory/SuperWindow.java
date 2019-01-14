package com.factory;

public class SuperWindow extends Window {

	private int numberOfWings;
	private String color;
	
	public SuperWindow(int numberOfWings, String color) {
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
		return String.format("This is super window with %d wings and %s color", this.numberOfWings, this.color);
	}

}
