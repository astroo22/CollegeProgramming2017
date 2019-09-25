//Jonathan Starkey

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class GameBoard implements Serializable
{
	// ok lets walk through this im going to need tiles bombs and creation of a grid
	// so lets start with creating a 2d array with tiles in it then we can use rng to create 
	// which ones have bombs n such etc etc start with tiles
	// lets make this a 10 by 10 game 
	// update ok this actually would be easier if i just created a tile class wouldn't it?
	// that way i could use simple methods to figure out if things are bombed covered flagged etc etc
	// ok so creating a tiles class ~~~~
	public int s;
	public int ss;
	Tiles[][] tiles1;//OK SO I HAD THESE IN CREATEGAME then copy and pasted
	//	but i didn't empty the [] when i did created so many compile errors.
	//MouseThing thing;
	public GameBoard(int SizeOfB,int NumOfBomb)
	{
		this.s = SizeOfB;
		this.ss = NumOfBomb;
		this.createGame();
		this.addBombs();
		
		//findTouchingBombs();
	}
	public void createGame()
	{
		
		tiles1 = new Tiles[s][s];
		for(int r = 0; r<tiles1.length; r++)
		{
			for(int c = 0; c<tiles1[r].length; c++)
			{
				tiles1[r][c] = new Tiles();
			}
		
		}
		
	}
	public boolean check()
	{
		int bombsFlagged = 0;
		int flagsUsed = 0;
		
		//for loops to count flags and if they have a bomb and flag
		// using x and y because i dont like confusion between variables
		for(int x=0; x<this.tiles1.length; x++)
		{
			for(int y=0; y < this.tiles1[x].length; y++)//x = row y = column
			{
				if(tiles1[x][y].hasFlag())
				{
					flagsUsed ++;
				}
				if(tiles1[x][y].hasBomb() && tiles1[x][y].hasFlag())
				{
					bombsFlagged ++;
				}
			}
		}
		if(bombsFlagged == s && flagsUsed == s)
		{
			System.out.println("welp i think you won? i mean you probs did but i did write this code so who knows?");
			
			return true;
			
		}
		else 
		{
			return false;
		}
	}
	public void setBomb(int r, int c)
	{
		tiles1[r][c].setBomb(true);
	}
	public Tiles getTile(int r, int c)
	{
		return tiles1[r][c];
	}
	public boolean hasBomb(int r, int c)
	{
		return tiles1[r][c].hasBomb();
	}
	public boolean hasFlag(int r, int c)
	{
		return tiles1[r][c].hasFlag();
	}
	public boolean hasCover(int r, int c)
	{
		return tiles1[r][c].hasCover();
	}
	public void removeCover(int r , int c)
	{
		tiles1[r][c].setCover(false);
	}
	public int getNumBombT(int r, int c)
	{
		//return findTouchingBombs(r,c);
		return tiles1[r][c].getBombsTouching();
	}
	public int getBomNum()
	{
		return ss;
	}

	
	public void setFlag(int r, int c)
	{
		if(tiles1[r][c].hasFlag())
		{
			tiles1[r][c].setFlag(false);
		}
		else
		{
			tiles1[r][c].setFlag(true);
		}
		
	}
	public void removeFlag(int r, int c)
	{
		tiles1[r][c].setFlag(false);
	}
	public void setCover(int r,int c)
	{
		tiles1[r][c].setCover(true);
	}
	public void gameBoardShow()
	{
		for(int i=0; i<s;i++)
		{
			for(int ii=0; ii<s;ii++)
			{
				removeCover(i,ii);
			}
		}
	}
	
	public void addBombs()
	{
		
		for(int i = 0; i< ss; i++)
		{
			// ok here comes RNG JESUS
			Random rand = new Random();
			//ok so i originally wrote this next part the same way i do in c++ but for some reason random is never found?
			//looked it up need to add nextInt for some reason 
			int row = rand.nextInt(s);
			int column = rand.nextInt(s);
			// so here we need this to not include things already bombed
			if(!tiles1[row][column].hasBomb())
			{
				setBomb(row, column);
			}
			else 
			{
				// could do this with a variable and just add one to bombs but i feel like that is excessive
				// so this should just make it reiterate 
				i--;
			}
		}
		findTouchingBombs();
	}
	// ok guna need to get tiles1 flags and cover and a set + remove flag and a set + remove cover uhhh yea
	// think thats it?
	
    //should i create a method to find the bombs touching each tile? or should i just create a massive loop? 
	// i think having this in a method will be benificial later on 
	public void findTouchingBombs()
	{
		int temp1r;
		int temp2c;
		for(int r = 0; r <s; r++)
		{
			for(int c = 0; c <s; c++) //ok these go through every tile... if it does find a bomb skip?
			{
				
				
				if(!hasBomb(r,c))// as long as it doesn't find a bomb it should go on
				{
					int bombCount = 0;
					/*
					if(r <1 )
					{
						temp1r =0;
					}
					else 
					{
						temp1r = r-1;
					}
					if(c<1)
					{
						temp2c = 0;
					}
					else
					{
						temp2c = c -1;
					}
					*/
					for(int i = r-1; i <=r +1; i++)// searching all adjacent tiles next to the non bombed tile
					{
						
						for(int erro = c-1; erro <= c +1; erro++)
						{
							
							if(i >= 0 && i < s && erro >=0 && erro < s)
							{
								if(hasBomb(i,erro))
								{
									bombCount ++;
									
								}
							}
						
						}
					}
				System.out.println("" + r + " " + c + " :" + bombCount);
				tiles1[r][c].setBombsTouching(bombCount);
				}
							
			}
		}
		
	}
	public void clearAround(int r, int c)
	{
		if(tiles1[r][c].getBombsTouching()==0)
		{
			for(int i = r-1; i <=r +1; i++)// searching all adjacent tiles next to the non bombed tile
			{
				for(int erro = c-1; erro <= c +1; erro++)
				{
					
					if(i >= 0 && i < s && erro >=0 && erro < s)
					{
						if(!tiles1[i][erro].hasBomb() && tiles1[i][erro].hasCover() && tiles1[i][erro].getBombsTouching()==0)
						{
							tiles1[i][erro].setCover(false);
							clearAround(i,erro);
						}
						else if(!tiles1[i][erro].hasBomb() && !tiles1[i][erro].hasFlag())
						{
							tiles1[i][erro].setCover(false);
						}
					}
				}
			}
		}
		//thing.fix();
	}
	
	
}