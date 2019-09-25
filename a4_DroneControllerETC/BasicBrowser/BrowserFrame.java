import java.util.*;
import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.net.IDN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrowserFrame extends JFrame
{
	Container c;
	BrowserPanel browserPanel;
	
	public BrowserFrame()
	{
		setTitle("Browser");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BrowserPanel browserPanel = new BrowserPanel();
		browserPanel.daFrame(this);
		c = getContentPane();
		//browserPanel = new BroswerPanel();
		//c.setLayout(new BorderLayout());
		//browserPanel.setFrame(this);
		
		//c.add(new JLabel("URL: "), BorderLayout.NORTH);
		c.add(browserPanel);
		//c.add(theURL, BorderLayout.CENTER);
		//c.add(urlStat, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
}