//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SierpinskiFrame extends JFrame
{
	public SierpinskiFrame()
	{
		// I think i should set a base width and height
		setTitle("Sierpinski");
		// Is there a problem with jframe and resolutions around 2k and 4k?
		// going to set width and height to 500 to start because im having some odd problems.
		// hold up forgot 2 add panel
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SierpinskiPanel panel = new SierpinskiPanel();
		Container c = getContentPane();
		c.add(panel);
		setVisible(true);
	}
	
}