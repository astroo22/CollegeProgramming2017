//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MineSweeperPanel extends JPanel
{
	
	//MouseThing buttonArray[][];
	//Button button;
	GameBoard gameBoard;
	Logic logic;
	MineSweeperFrame mineSweeperFrame;
	MineButton mineButton;
	//JButton buttons[][];
	public MineSweeperPanel(Logic logic, GameBoard gameBoard, MineSweeperFrame mineSweeperFrame, MineButton mineButton)
	{
		this.logic = logic;
		this.gameBoard = gameBoard;
		int size = gameBoard.s;
		//this.mineButton = mineButton;
		this.mineSweeperFrame = mineSweeperFrame;
		this.mineButton = mineButton;
		//this.Button = Button;
		//buttons = new MineButton[10][10];
		//boolean temp1= true;
		//int bombs =10;
		
		setLayout(new GridLayout(size,size));
		//theButtons = new mineButton();
		
			for(int i = 0; i < size; i++)
			{
				for(int ii = 0; ii < size; ii++)
				{
					int temp;
					MineButton thing  = new MineButton();
					thing.r = i;
					thing.c = ii;
					thing.logic = logic;
					/*
					if(gameBoard.hasBomb(i,ii))
					{
						System.out.println("bomb");
					}
					*/
					if(gameBoard.hasBomb(i,ii))
					{
						thing.bombNum = 0;
					}
					else
					{
						thing.bombNum = gameBoard.getNumBombT(i,ii);
					}
					
					System.out.println("r: "+ i + " c:" + ii + " bomb#: "+ gameBoard.getNumBombT(i,ii));
					thing.addMouseListener(new MouseThing(i,ii,logic));
					add(thing);
					//so pull in my buttons
					
					//buttonArray[i][ii].addMouseListener(new MouseThing());
					//buttonArray[i][ii].setText("" + logic.gameBoard.tiles1[i][ii].getBombsTouching());
					//add(buttons[i][ii]);
					
					//bombs --;
				}
			}
		 
	}
	public class MouseThing extends MouseAdapter
	{
		//GameBoard gameBoard;
		public int rr;
		public int cc;
		Logic logic;
		public MouseThing(int rr, int cc,Logic logic)
		{
			this.rr = rr;
			this.cc = cc;
			this.logic = logic;
		}
		public void mouseClicked(MouseEvent e)
		{
			
			if(e.getButton() == MouseEvent.BUTTON3)
			{
				logic.addFlag(rr,cc);
				if(logic.winner == true)
				{
					mineSweeperFrame.gameOver(true);
				}
				else if(logic.loser == true)
				{
					mineSweeperFrame.gameOver(false);
				}
				repaint();
			
				
				
			}
			if(SwingUtilities.isLeftMouseButton(e))
			{
				logic.clickedTile(rr,cc);
				repaint();
				if(logic.loser == true)
				{
					mineSweeperFrame.gameOver(false);
				}
				repaint();
				
			}
		}
		/*
		public void fix()
		{
			repaint();
		}*/
	}
}

/*
	public void addFlag(int r, int c)
	{
		if(buttonArray[r][c].getText().equals("F"))
		{
			buttonArray[r][c].setText("F");
		}
		else
		{
			buttonArray[r][c].setText("");
		}
	}
	public void addBombs()
	{
		
		for(int i = 0; i< 20; i++)
		{
			// ok here comes RNG JESUS
			Random rand = new Random();
			//ok so i originally wrote this next part the same way i do in c++ but for some reason random is never found?
			//looked it up need to add nextInt for some reason 
			int row = rand.nextInt(10);
			int column = rand.nextInt(10);
			// so here we need this to not include things already bombed
			if(!buttonArray[row][column].hasBomb())
			{
				buttonArray[row][column].setBomb(true);
			}
			else 
			{
				
				i--;
			}
		}
	}
	/*
	public buttonArray[][] getButton(int r, int c)
	{
		return buttonArray;
		
	}
	public JButton getBA(int r, int c)
	{
		return buttonArray[r][c];
	}
	
	public void setFlag(int r, int c)
	{
		buttonArray[r][c].setFlag(true);
	}
	public void removeFlag(int r, int c)
	{
		buttonArray[r][c].setFlag(false);
	}
	public void setCover(int r,int c)
	{
		buttonArray[r][c].setCover(true);
	}
	public void removeCover(int r, int c)
	{
		buttonArray[r][c].setCover(false);
	}
   
	public void findTouchingBombs()
	{
		
		for(int row = 0; row <10; row++)
		{
			for(int column = 0; column <10; column++) //ok these go through every tile... if it does find a bomb skip?
			{
				if(!buttonArray[row][column].hasBomb())// as long as it doesn't find a bomb it should go on
				{
					int bombCount = 0;
					for(int i = row -1; i <=row +1; i++)// searching all adjacent tiles next to the non bombed tile
					{
						for(int ii = column -1; ii <= column +1; column ++)
						{
							
							if(i >= 0 && i < 10 && ii >=0 && ii < 10)
							{
								if(buttonArray[i][ii].hasBomb())
								{
									bombCount ++;
								}
							}
						}
					}
				
				buttonArray[row][column].setBombsTouching(bombCount);
				}
				
			}
		}
	}	
	
		
	
}*/
	
		
	