//Jonathan Starkey

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// logic for the game
public class Logic implements Serializable
{
	//ok couple things i think im going to need here 
	// by guestimation ima say two variables that state if they are a winner or loser
	// looked at the assignment thing again could also use a bombs remaining variable 
	// since this is the logic pretty sure i need to call my gameboard here
	// so
	boolean winner = false;
	boolean loser = false;
	int bombsRemaining = 0;
	GameBoard gameBoard;
	MineButton mineButton;
	MineSweeperFrame mineSweeperFrame;
	int flagsNum = 0;
	int bombTotal=0;
	
	//ok first lets create the board
	public Logic(int s,int ss)
	{
		this.gameBoard = createBoard(s,ss);
		this.bombTotal = ss;
	}
	public GameBoard createBoard(int s,int ss)
	{
		return new GameBoard(s,ss);
	}
	
	// need flag method
	public void addFlag(int r, int c)
	{
		
		gameBoard.setFlag(r,c);
		System.out.println("added flag");
		flagsNum ++;
		
		test();
		
	}
	public int bombsRemaining()
	{
		int bombsFlagged = 0;
		for(int row = 0; row < this.gameBoard.s; row++)
		{
			for(int column = 0; column < this.gameBoard.s; column++)
			{
				if(this.gameBoard.getTile(row,column).hasBomb() && this.gameBoard.getTile(row,column).hasFlag())
				{
					bombsFlagged++;
				}
			}
		}
		return bombsRemaining = gameBoard.ss - bombsFlagged;
	}
	
	public void clickedTile(int r, int c)
	{
		if(gameBoard.hasBomb(r,c) == true)
		{
			//mineSweeperFrame.gameOver(loser);
			System.out.println("Loser");
			loser = true;
			gameBoard.gameBoardShow();
			
		}
		else if(gameBoard.hasCover(r,c) == true)
		{
			this.gameBoard.removeCover(r,c);
			
			
			
		}
		
	}
	public void test()
	{
		bombsRemaining();
		this.winner = gameBoard.check();
		
	}
	public boolean lFlag(int r, int c)
	{
		if(gameBoard.hasFlag(r,c) == true)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	/*
	public Tiles[][] getTiles(int r, int c)
	{
		return tiles1;
		
	}
	*/
	/*
	public MineButton getTile(int r, int c)
	{
		return mineButton(r,c);
	}*/
	
	public int getStatus(int r, int c)
	{
		
		if(gameBoard.hasFlag(r,c) == true)
		{
			return 30;
		}
		else if(gameBoard.hasCover(r,c) == true)
		{
			return 60;
		}
		else if(gameBoard.hasBomb(r,c) == true)
		{
			return 90;
		}
		
		else if(gameBoard.getNumBombT(r,c)== 0)
		{
			 gameBoard.clearAround(r,c);
			 return gameBoard.getNumBombT(r,c);
		}
		else 
		{
			return gameBoard.getNumBombT(r,c);
		}
	}
	public void save(String path)
	{
		try
		{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(path)));
			os.writeObject(this);
			os.flush();
			os.close();
			
		}	
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void load(String path)
	{
		Logic temp1 = null;
		try
		{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File(path)));
			temp1 = (Logic)is.readObject();
			this.gameBoard = temp1.gameBoard;
			this.bombsRemaining = temp1.bombsRemaining;
		}
		catch(IOException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/*
	public void removeCover(int r, int c)
	{
		if(tiles1[r][c].hasBomb()== true)
		{
			
		}
		tiles1[r][c].setCover(false);
		
	}
	*/
	// thought there would be more stuff but only other thing i think i need is to find remaining bombs
	// you wanted it to be where you only really need to change one thing to get a different board size
	// so since this is rather far away from where that was specified uhhhh
	// something like gameBoard.tiles.length? and ill throw on a this in front if i have a compile error
	
	
	
}