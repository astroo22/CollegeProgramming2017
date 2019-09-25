//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

	
	public class MessageFrame extends JFrame
	{
		public MessageFrame()
		{
			setTitle("Message in a Bottle");
			setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MessagePanel panel = new MessagePanel();
			add(panel);
			setVisible(true);
		}
		
	}
	
