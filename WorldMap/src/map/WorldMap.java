package map;

import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class WorldMap implements MouseListener {

	JFrame frame;

	public WorldMap(JFrame frame) {
		super();
		this.frame = frame;
		this.frame.setResizable(false);
	}

	public void frameDo(BufferedImage image) {
		JPanel pane = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);
			};
		};

		frame.add(pane);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1440, 720);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {

		final BufferedImage image = ImageIO.read(new File("map.jpg"));
		JFrame frame = new JFrame();
		WorldMap wp = new WorldMap(frame);
		wp.frameDo(image);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		double x = 0;
		double y = 0;
		if (e.getY() < 360 && e.getX() < 720) {
			y = (360 - e.getY()) / 4;
			x = (720 - e.getX()) / 4;
			System.out.println("Latitude: " + y + " N " + "Longtitude: " + x + " W");
		}

		if (e.getY() > 360 && e.getX() > 720) {
			y = (e.getY() - 360) / 4;
			x = (e.getX() - 720) / 4;
			System.out.println("Latitude: " + y + " S " + "Longtitude: " + x + " E");
		}

		if (e.getY() < 360 && e.getX() > 720) {
			y = (360 - e.getY()) / 4;
			x = (e.getX() - 720) / 4;
			System.out.println("Latitude: " + y + " N " + "Longtitude: " + x + " E");
		}

		if (e.getY() > 360 && e.getX() < 720) {
			y = (e.getY() - 360) / 4;
			x = (720 - e.getX()) / 4;
			System.out.println("Latitude: " + y + " S " + "Longtitude: " + x + " W");
		}
	}

}
