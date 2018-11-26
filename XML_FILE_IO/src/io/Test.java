package io;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = new Order();

		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		for (PVCWindow w : order.getOrderList()) {
			w.setHeight(100);
			w.setWidth(200);
			w.setLCmFrame(w.calculateLCmFrame());
			w.setSqCmGlass(w.calculateSqCmGlass());
			w.setWindowFramePrice(234);
			w.setWindowGlassPrice(432);
			w.setWindowPrice(w.calculateWindowPrice(15, 20));
		}
		order.setPricePerLMFrame(34);
		order.setPricePerSqMGlass(23);
		order.setTotalLMFrame(order.calculateTotalLMFrame());
		order.setTotalPriceFrame(order.calculateTotalPriceFrame());
		order.setTotalSqMGlass(order.calculateTotalSqMGlass());
		order.setTotalPriceGlass(order.calculateTotalPriceGlass());
		order.setTotalPriceOrder(order.calculateTotalPriceOrder());

		order.setTotalPriceString("Big order");

		try {
			FileOutputStream fos = new FileOutputStream(new File("./order.xml"));
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(fos));
			e.writeObject(order);
			e.close();

			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
