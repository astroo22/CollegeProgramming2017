//Jonathan Starkey
import java.io.*;
import java.net.*;
import java.util.*;

public class River
{
	private double length;
	private double width;
	private String name;
	/**
	*Creates a basic river with placeholder values on sizes untill more info is given
	*@param name
	*/
	public River(String name)
	{
		this.name = name;
		this.width = 1;
		this.length = 1;
	}
	/**
	*Complete constructor for river
	*@param name
	*@param length
	*@param width
	*/
	public River(String name, double length, double width)
	{
		this.name = name;
		this.length = length;
		this.width = width;
	}
	/**
	*Sets length
	*@param length
	*/
	public void setLength(double length)
	{
		this.length = length;
		
	}
	/**
	*Sets width
	*@param width
	*/
	public void setWidth(double width)
	{
		this.width = width;
	}
	/**
	*gets length
	*@return length
	*/
	public double getLength()
	{
		return length;
	}
	/**
	*gets width
	*@return width
	*/
	public double getWidth()
	{
		return width;
	}
}