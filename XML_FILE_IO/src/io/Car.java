package io;

public class Car {
	
	private String name;
	private int km;
	private boolean secondHand;
	
	public Car(String name, int km, boolean secondHand) {
		super();
		this.name = name;
		this.km = km;
		this.secondHand = secondHand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public boolean isSecondHand() {
		return secondHand;
	}

	public void setSecondHand(boolean secondHand) {
		this.secondHand = secondHand;
	}
	
	
	
	
	
	

}
