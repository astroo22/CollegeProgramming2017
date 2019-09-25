//Jonathan Starkey
/*

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// continuing after email
public class TheButtons extends MouseAdapter
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
	
	
	
	GameBoard gameBoard;
	
	public void theButtons(int r, int c)
	{
		this.text = text;
		this.r = r;
		this.c = c;
		this.bomb = gameBoard.tiles1[r][c].hasBomb();
		this.flag = gameBoard.tiles1[r][c].hasFlag();
		this.cover = gameBoard.tiles1[r][c].hasCover();
		this.bombNum = gameBoard.tiles1[r][c].getBombsTouching();
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
}
	
	

		
	
	/*
	
	public void paintCompoent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
	} 
}
	
	
	
	
	
	
	
	/*
	new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("button: " + i + ii +" pressed");
						repaint();
					}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public void doButton(int r, int c)
	{
		mineSweeperPanel.Button[r][c].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("button: " + r + c +" pressed");
				repaint();
			}
		});
		add(mineSweeperPanel.Button[r][c]);
	}
	
	
	public void MousePressed(MouseEvent e)
	{
		
		JButton Button = (JButton) e.getSource();
		if(gameBoard.tiles1[r][c].hasFlag())
		{
			mineSweeperPanel.Button[r][c].setText("F");
			repaint();
		}
		if(gameBoard.tiles1[r][c].hasCover())
		{
			mineSweeperPanel.Button[r][c].setBackground(Color.white);
			repaint();
		}
		else if(!gameBoard.tiles1[r][c].hasCover())
		{
			mineSweeperPanel.Button[r][c].setText("" +gameBoard.tiles1[r][c].getBombsTouching());
			repaint();
		}
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}

}*/