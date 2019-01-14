package com.factory;

public class WindowClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Window superWindow = WindowFactory.getWindow(WindowType.SUPER_WINDOW, 8, "red");

		Window miniWindow = WindowFactory.getWindow(WindowType.MINI_WINDOW, 2, "brown");

		System.out.printf("%s%n%s", superWindow.toString(), miniWindow.toString());

	}

}
