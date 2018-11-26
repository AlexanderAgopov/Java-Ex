package io;

import io.Order;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class Decoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream("./order.xml")));
			Order decodedOrder = (Order) dec.readObject();
			dec.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
