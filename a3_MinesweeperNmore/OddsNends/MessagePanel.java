//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MessagePanel extends JPanel
	{
		public static final int X_BOTTLE_TOP = 200;
		public static final int X2_BOTTLE_TOP = 300;
		public static final int Y_BOTTLE_TOP = 45;
		public static final int Y2_BOTTLE_TOP = 50;
		public static final int X_BOTTLE_LEFT_NECK =  200;
		public static final int Y_BOTTLE_LEFT_NECK = 50;
		public static final int X2_BOTTLE_LEFT_NECK = 200;
		public static final int Y2_BOTTLE_LEFT_NECK = 150;
		public static final int X_BOTTLE_RIGHT_NECK = 300;
		public static final int Y_BOTTLE_RIGHT_NECK = 50;
		public static final int X2_BOTTLE_RIGHT_NECK = 300;
		public static final int Y2_BOTTLE_RIGHT_NECK = 150;
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString("Message in a bottle", 200,300);
			g.drawLine(X_BOTTLE_LEFT_NECK, Y_BOTTLE_LEFT_NECK, X2_BOTTLE_LEFT_NECK, Y2_BOTTLE_RIGHT_NECK);
			g.drawLine(X_BOTTLE_RIGHT_NECK, Y_BOTTLE_RIGHT_NECK, X2_BOTTLE_RIGHT_NECK, Y2_BOTTLE_RIGHT_NECK);
			g.drawOval(X_BOTTLE_TOP, Y_BOTTLE_TOP, 100, 15);
			g.drawRoundRect(125,150,250,300,10,10);
		}
	}