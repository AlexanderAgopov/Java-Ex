package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;

import com.factory.MiniWindow;
import com.factory.SuperWindow;
import com.factory.Window;
import com.factory.WindowFactory;
import com.factory.WindowType;

class WindowFactoryTest {

	@Test
	void test() {
		Window superWin2 = WindowFactory.getWindow(WindowType.SUPER_WINDOW, 5, "red");
		Window miniWin2 = WindowFactory.getWindow(WindowType.MINI_WINDOW, 2, "blue");
		
		assertTrue(superWin2 instanceof SuperWindow);
		assertTrue(miniWin2 instanceof MiniWindow);
	}

}
