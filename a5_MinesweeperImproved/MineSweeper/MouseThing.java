//Jonathan Starkey

/*
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//ever growing list of imports 
//im used to putting the actionlistener stuff in one of the main files but 
//i saw something interesting while looking stuff up the other day
// and he put his handling in a file like this
// so heres my attempt at it

public class MouseThing extends MouseAdapter
{
	MineSweeperPanel mineSweeperPanel;
	public int r;
	public int c;
	public String text = "";
	private boolean bomb = false;
	private boolean flag = false;
	private boolean cover = true;
	private int bombNum = 0;
	private int totalBombs = 20;
	
	
	
	//GameBoard gameBoard;
	
	public void MouseHandler(int r, int c)
	{
		this.text = text;
		this.r = r;
		this.c = c;
		this.bomb = bomb;
		this.flag = flag;
		this.cover = cover;
		this.bombNum = getBombsTouching();
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(SwingUtilities.isRightMouseButton(e))
		{
			if(totalBombs == 0)
			{
				//winner
				;
			}
			else
			{
				
				mineSweeperPanel.addFlag(r,c);
				//add bomb check here;
			}
			
		}
		if(SwingUtilities.isLeftMouseButton(e))
		{
			if(cover = true)
			{
				if(bomb = true)
				{
					;
					//game over
				}
				else
				{
					
					cover = false;
				}
			}
			//logic.clickedTile(r,c);
			//repaint();
		}
	}
	public boolean hasBomb()
	{
		return bomb;
		
	}
	public boolean hasFlag()
	{
		return this.flag;
	}
	public boolean hasCover()
	{
		return this.cover;
	}
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	public void setBomb(boolean boom)
	{
		this.bomb = boom;
	}
	public void setCover(boolean covers)
	{
		this.cover = covers;
	}
	public int getBombsTouching()
	{
		return bombNum;
	}
	public void setBombsTouching(int bombNum)
	{
		this.bombNum = bombNum;
	}	
	
}*/