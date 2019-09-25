//Jonathan Starkey

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tiles implements Serializable
{
	// continueing from the last page i need a method to figure out if its covered contains a bomb is flagged
	// and maybe if there are bombs around it? is this were i handle that? Lets put some psudo code in for now
	// and figure that out later so to start lets make it simple kind of like that final project for java last year
	//~~~~~~~~~~~~space for variables~~~~~~~~
	
	private boolean bomb = false;
	private boolean flag = false;
	private boolean cover = true;
	private int bombNum = 0;
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ok to start i should create tiles
	public Tiles()
	{
		//ok a tile could have a bomb be covered or be flagged so lets start the variables
		// for the above im going to need bool true false for bombed covered flagged
		// make everythign the standard untill told otherwise
		this.bomb = false;
		this.flag = false;
		this.cover = true;
		this.bombNum = bombNum;
		
	
		// would i put the number of bombs around here? hmmm i dont think so but i do need a variable for this
		
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
	public void setBombsTouching(int b)
	{
		this.bombNum = b;
	}
		
	

}