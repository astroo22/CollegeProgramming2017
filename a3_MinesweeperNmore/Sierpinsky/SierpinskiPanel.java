//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SierpinskiPanel extends JPanel
{
	
	

	@Override
    public void paintComponent(Graphics g) 
	{
		// looks like im going to need another method to draw this instead of paint component
		
		/*int height = getHeight();
		int width = getWidth();
		int x0 = width/2;
		int y0 = 0;
		int x1 = width;
		int y1 = height;
		int x2 = 0;
		int y2 = height;
		g.drawLine(x0,y0,x1,y1);
		g.drawLine(x0,y0,x2,y2);
		g.drawLine(x1,y1,x2,y2);*/
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// should i create a level temp variable thing? how would i calculate this?
		int level;
		if (height < width)
		{
			level = height;
		}
		else 
		{
			level = width;
		}
		triangle(g,0,0,level);
	}
	public void triangle(Graphics g, int x, int y, int level)
	{
		if(level ==1) // code to account for 1 pixel wide thing
		{
				g.drawRect(x,y,1,1);
				
		}
		else //math section 
		{
			//ok need more descriptive names besides x0 y0 etc
			int x0 = x + (level/4);
			int y0 = y;
			int xLeftS= x;
			int yLeftS= y+(level/2);
			int xRightS = x+(level/2);
			int yRightS = y+(level/2);
			//ok recursive calling here 
			// this recalles itself so that it repaints it underpaint so call triangle in paint
			triangle(g, x0, y0, level/2);
			triangle(g, xLeftS, yLeftS,level/2);
			triangle(g, xRightS, yRightS, level/2);
		}
	
	}
		
	
}