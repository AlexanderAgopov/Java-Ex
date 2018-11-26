package io;

import java.util.ArrayList;

/**
 * @author a
 *
 */
public class Order {

	protected ArrayList<PVCWindow> orderList;
	protected double pricePerSqMGlass;
	protected double pricePerLMFrame;
	protected double totalSqMGlass;
	protected double totalLMFrame;
	protected double totalPriceGlass;
	protected double totalPriceFrame;
	protected double totalPriceOrder;
	protected String totalPriceString;
	
	

	public Order(ArrayList<PVCWindow> orderList, double pricePerSqMGlass, double pricePerLMFrame, double totalSqMGlass,
			double totalLMFrame, double totalPriceGlass, double totalPriceFrame, double totalPriceOrder,
			String totalPriceString) {
		super();
		this.orderList = orderList;
		this.pricePerSqMGlass = pricePerSqMGlass;
		this.pricePerLMFrame = pricePerLMFrame;
		this.totalSqMGlass = totalSqMGlass;
		this.totalLMFrame = totalLMFrame;
		this.totalPriceGlass = totalPriceGlass;
		this.totalPriceFrame = totalPriceFrame;
		this.totalPriceOrder = totalPriceOrder;
		this.totalPriceString = totalPriceString;
	}

	public Order() {
		super();
		this.orderList = orderList;
		this.pricePerSqMGlass = pricePerSqMGlass;
		this.pricePerLMFrame = pricePerLMFrame;
		this.totalSqMGlass = totalSqMGlass;
		this.totalLMFrame = totalLMFrame;
		this.totalPriceGlass = totalPriceGlass;
		this.totalPriceFrame = totalPriceFrame;
		this.totalPriceOrder = totalPriceOrder;
		this.totalPriceString = totalPriceString;
	}

	public String getTotalPriceString() {
		return totalPriceString;
	}

	public void setTotalPriceString(String totalPriceString) {
		this.totalPriceString = totalPriceString;
	}

	public ArrayList<PVCWindow> getOrderList() {

		if (orderList == null) {
			orderList = new ArrayList<PVCWindow>();
		}
		return orderList;
	}

	public void setOrderList(ArrayList<PVCWindow> order) {
		this.orderList = orderList;
	}

	public double getPricePerSqMGlass() {
		return pricePerSqMGlass;
	}

	public void setPricePerSqMGlass(double pricePerSqMGlass) {
		this.pricePerSqMGlass = pricePerSqMGlass;
	}

	public double getPricePerLMFrame() {
		return pricePerLMFrame;
	}

	public void setPricePerLMFrame(double pricePerLMFrame) {
		this.pricePerLMFrame = pricePerLMFrame;
	}

	public double getTotalSqMGlass() {
		return totalSqMGlass;
	}

	public void setTotalSqMGlass(double totalSqMGlass) {
		this.totalSqMGlass = totalSqMGlass;
	}

	public double getTotalLMFrame() {
		return totalLMFrame;
	}

	public void setTotalLMFrame(double totalLMFrame) {
		this.totalLMFrame = totalLMFrame;
	}

	public double getTotalPriceGlass() {
		return totalPriceGlass;
	}

	public void setTotalPriceGlass(double totalPriceGlass) {
		this.totalPriceGlass = totalPriceGlass;
	}

	public double getTotalPriceFrame() {
		return totalPriceFrame;
	}

	public void setTotalPriceFrame(double totalPriceFrame) {
		this.totalPriceFrame = totalPriceFrame;
	}

	public double getTotalPriceOrder() {
		return totalPriceOrder;
	}

	public void setTotalPriceOrder(double totalPriceOrder) {
		this.totalPriceOrder = totalPriceOrder;
	}

	/**
	 * Calculates the square meters of glass needed for the order fulfillment. In
	 * the for loop the square area of the specific window is divided by 10000
	 * because it is calculated in square centimeters by the method
	 * calculateSqCmGlass() but here it is needed in square meters.
	 * 
	 * @return the square meters of glass needed for the order fulfillment
	 */
	public double calculateTotalSqMGlass() {
		double totalSqM = 0;
		for (int i = 0; i < this.orderList.size(); i++) {
			totalSqM = totalSqM + this.orderList.get(i).calculateSqCmGlass() / 10000;
		}
		return totalSqM;
	}

	/**
	 * Calculates the linear meters of frame needed for the order fulfillment. In
	 * the for loop the total width of the frame of the specific window is divided
	 * by 100 because it is calculated in linear centimeters by the method
	 * calculateLCmFrame() but here it is needed in linear meters.
	 * 
	 * @return the linear meters of frame needed for the order fulfillment
	 */
	public double calculateTotalLMFrame() {
		double totalLM = 0;
		for (int i = 0; i < this.orderList.size(); i++) {
			totalLM = totalLM + this.orderList.get(i).calculateLCmFrame() / 100;
		}
		return totalLM;
	}

	/**
	 * Calculates the total price of the glass needed for the order fulfillment.
	 * 
	 * @return the total price of the glass needed for the order fulfillment
	 */
	public double calculateTotalPriceGlass() {
		return totalSqMGlass * pricePerSqMGlass;
	}

	/**
	 * Calculates the total price of the frame needed for the order fulfillment.
	 * 
	 * @return the total price of the frame needed for the order fulfillment
	 */
	public double calculateTotalPriceFrame() {
		return totalLMFrame * pricePerLMFrame;
	}

	/**
	 * Calculates the total price of the order.
	 * 
	 * @return the total price of the order.
	 */
	public double calculateTotalPriceOrder() {
		return totalSqMGlass * pricePerSqMGlass + totalLMFrame * pricePerLMFrame;
	}

}
