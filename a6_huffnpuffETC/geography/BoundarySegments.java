//Jonathan Starkey
package geography;
import java.io.*;
import java.net.*;
import java.util.*;

public class BoundarySegments
{
	private double length;
	/**
	*So this will be the segements that are called in the other classes. The basic idea is this is all of the boundary lengths
	*and there will be another class that puts everything together based on the order of the segments in the array list based around the
	*anchor point in the center to create the map
	*@param length
	*/
	
	public BoundarySegments(double length)
	{
		this.length = length;
	}
	/**
	*gets the length
	*@return length
	*/
	public double getLength()
	{
		return length;
	}
	/**
	*sets the length
	*@param length
	*/
	public void setLength(double length)
	{
		this.length = length;
	}
	
}