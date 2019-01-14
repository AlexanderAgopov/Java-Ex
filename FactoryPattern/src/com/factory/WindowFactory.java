package com.factory;

public class WindowFactory {

	public static Window getWindow(WindowType type, int numberOfWings, String color) {
		Window window;

		switch (type) {
		case SUPER_WINDOW:
			window = new SuperWindow(numberOfWings, color);
			break;
		case MINI_WINDOW:
			window = new MiniWindow(numberOfWings, color);
			break;
		default:
			window = null;
		}

		return window;
	}

}
