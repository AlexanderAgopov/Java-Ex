package com.factory;

public abstract class Window {

	public abstract int getNumberOfWings();

	public abstract String getColor();

	@Override
	public String toString() {
		return String.format("Window with %d wings and %s color", this.getNumberOfWings(), this.getColor());
	}

}
