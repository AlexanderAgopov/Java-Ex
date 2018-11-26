package map;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.font.TextAttribute;

public class Map extends JPanel implements MouseListener {


	final BufferedImage image; 
	Graphics g;
	JPanel panel = new JPanel();
    JFrame frame = new JFrame();
	PrintStream print;
    
    public Map() throws IOException { 
        addMouseListener(this);
        panel.addMouseListener(this);
        frame.addMouseListener(this);
       image = ImageIO.read(new File("map.jpg"));
        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		//System.out.print(x + " " + y);
		
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

}
