//Jonathan Starkey
package geography;
import java.io.*;
import java.net.*;
import java.util.*;

public class State implements GeographicMap
{
	private String name;
	private String capital;
	private ArrayList<BoundarySegments> boundaryList;
	private ArrayList<Cities> citiesList;
	private Countries hostCountry;
	private ArrayList<River> stateRivers;
	/**
	*Base constructor
	*
	*@param name
	*/
	public State(String name)
	{
		this.name = name;
	}
	/**
	*Constructor for state
	*
	*@param name
	*@param capital
	*@param boundaryList
	*@param citiesList
	*@param hostCountry
	*/
	public State(String name, String capital, ArrayList<BoundarySegments> boundaryList, ArrayList<Cities> citiesList, Countries hostCountry,ArrayList<River> stateRivers)
	{
		this.name = name;
		this.boundaryList = boundaryList;
		this.citiesList = citiesList;
		this.hostCountry = hostCountry;
		this.stateRivers = stateRivers;
		
	}
	/**
	*returns the name of the state
	*@return name
	*/
	public String getName()
	{
		return name;
	}
	/**
	*Sets the name of the state
	*@param name
	*/
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	*Gets the state limits
	*@return boundaryList
	*/
	public ArrayList<BoundarySegments> getStateLines()
	{
		return boundaryList;
	}
	/**
	*Sets the state limits
	*
	*@param boundaryList
	*/
	public void setStateLines(ArrayList<BoundarySegments> boundaryList)
	{
		this.boundaryList = boundaryList;
	}
	/**
	*returns the name of the capital
	*@return capital
	*/
	public String getCap()
	{
		return capital;
	}
	/**
	*sets the name of the capital
	*@param cap
	*/
	public void setCap(String cap)
	{
		this.capital = cap;
	}
	
	/**
	*returns the area of the state
	*@return area
	*/
	public double area()
	{
		double area = 0;
		//calls stateArea here to calculate the area then returns it.
		return area;
	}
	/**
	*calculates the area of the state
	*@param boundaryList
	*/
	public double stateArea(ArrayList<BoundarySegments> boundaryList)
	{
		double area = 0;
		//decently difficult depending on how the list for the boundary segments are created
		//the states area will be calculated using derivatives and functions unless we can assume everything is a square
		//otherwise we would split the state most likely into forths then calculate based on the area under the curve
		//with a small % error. Not exact but most likely the most efficiant way without pulling the info off a database or something.
		return area;
	}
	/**
	*gets the cities in the State
	*
	*@param cities
	*/
	public ArrayList<Cities> getCities()
	{
		return citiesList;
	}
	/**
	*sets cities
	*@param citiesList
	*/
	public void setCities(ArrayList<Cities> citiesList)
	{
		this.citiesList = citiesList;
	}
	/**
	*Gets the host country
	*
	*@return hostCountry
	*/
	public Countries getHostCountry()
	{
		return hostCountry;
	}
	/**
	*sets the host country
	*@param hostCountry
	*/
	public void setHC(Countries hostCountry)
	{
		this.hostCountry = hostCountry;
		
	}
	/**
	*gets rivers
	*@return rivers
	*/
	public ArrayList<River> getRivers()
	{
		return stateRivers;
	}
	/**
	*sets rivers
	*@param rivers
	*/
	public void setRivers(ArrayList<River> stateRivers)
	{
		this.stateRivers = stateRivers;
	}
	/**
	*returns the neighbors of the state
	*@param name
	*@return 
	*/
	@Override
	public ArrayList<GeographicMap> neighbors(String name)
	{
		//checks if something is touching then returns a list of them if it is.
		return null;
	}
	/**
	*returns borders of the state
	*@param name
	*@return 
	*/
	@Override
	public ArrayList<GeographicMap> borderOf(String name)
	{
		//checks if the neighbors are touching elsewhere and if not returns them
		return null;
	}
	
}



/**
	*
	*
	*/