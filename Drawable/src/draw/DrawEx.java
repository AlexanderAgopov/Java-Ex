package draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.font.TextAttribute;

public class DrawEx extends JPanel {

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		for (int i = 1; i < 11; i++) {
			g.drawOval(i * 10, i * 10, i * 50, i * 50);
		}
		g.setColor(Color.green);
		for (int i = 2; i < 12; i++) {
			g.drawOval(i * 12, i * 12, i * 60, i * 60);

		}
		int x = 500;
		int y = 0;
		int width = 10;
		int heigth = 10;
		g.setColor(Color.BLUE);
		for (int i = 1; i < 10; i++) {
			g.drawOval(x, y, width, heigth);
			y += 12;
			x -= 10;
			width += i * 10;
			heigth += i * 10;
		}
		int x1 = 410;
		int y1 = 108;
		int width1 = 100;
		int heigth1 = 100;
		for (int i = 1; i < 10; i++) {
			g.drawOval(x1, y1, width1, heigth1);
			y1 += 12;
			x1 -= 10;
			width1 -= i * 10;
			heigth1 -= i * 10;
		}
		
		String text = "HELLO EVERYONE!!!";
				g.drawString(text, 500, 500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.getContentPane().add(new DrawEx());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);

	}

}
