package ex;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class TabbedPanes extends JFrame implements ActionListener  
{
    static JTabbedPane tabs;
    JPanel pan1, pan2, pan3, pan4, pan5, pan6, pan7, pan8;
    JFrame frame;
    JScrollPane scroll1, scroll2, scroll3, scroll4, scroll5, scroll6, scroll7, scroll8;

    public void Tabs()
    {   
        tabs = new JTabbedPane();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));                                    
            JScrollPane scroll1 = new JScrollPane(pan1);                                           
                scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        pan2 = new JPanel();

        pan3 = new JPanel();

        pan4 = new JPanel();

        pan5 = new JPanel();

        pan6 = new JPanel();

        pan7 = new JPanel();

        pan8 = new JPanel();
            JScrollPane scroll8 = new JScrollPane(pan8);                                            
                scroll8.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroll8.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        Container pane = frame.getContentPane();
        pane.add(tabs);
            tabs.add("Mon", scroll1);
            tabs.add("Tue", pan2);
            tabs.add("Wed", pan3);
            tabs.add("Thu", pan4);
            tabs.add("Fri", pan5);
            tabs.add("Sat", pan6);
            tabs.add("Sun", pan7);
            tabs.add("Notes", scroll8);

            Dates datesObject = new Dates();
            datesObject.tabOnStartup("tabs");                                       

        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        TabbedPanes TrueTabs = new TabbedPanes();
        TrueTabs.Tabs();    
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
}