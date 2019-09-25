//Jonathan Starkey
package geography;
import java.io.*;
import java.net.*;
import java.util.*;

public class Cities implements GeographicMap
{
	private String name;
	private String capital;
	private ArrayList<BoundarySegments> boundaryList;
	//private ArrayList<Cities> citiesList;
	private Countries hostCountry;
	private State hostState;
	private int population;
	private ArrayList<River> cityRivers;
	/**
	*Base constructor
	*
	*@param name
	*@param population
	*/
	public Cities(String name, int population)
	{
		this.name = name;
		this.population = population;
	}
	/**
	*Constructor for cities object
	*
	*@param name
	*@param capital
	*@param boundaryList
	*@param citiesList
	*@param hostCountry
	*@param hostState
	*@param population
	*/
	public Cities(String name, String capital, ArrayList<BoundarySegments> boundaryList, Countries hostCountry, State hostState, int population, ArrayList<River> cityRivers)
	{
		this.name = name;
		this.capital = capital;
		this.boundaryList = boundaryList;
		this.hostCountry = hostCountry;
		this.hostState = hostState;
		this.population = population;
		this.cityRivers = cityRivers;
	}
	/**
	*Gets the name
	*@return name
	*/
	public String getName()
	{
		return name;
	}
	/**
	*Sets the name
	*@param name
	*/
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	*Gets the capital
	*@return capital
	*/
	public String getCapital()
	{
		return capital;
	}
	/**
	*Sets the capital
	*@param capital
	*/
	public void setCapital(String capital)
	{
		this.capital = capital;
	}
	/**
	*returns the area of the city
	*@return area
	*/
	public double area()
	{
		double area = 0;
		//calls city area here to calculate the area then returns it.
		return area;
	}
	/**
	*calculates the area of the city
	*@param boundaryList
	*/
	public double cityArea(ArrayList<BoundarySegments> boundaryList)
	{
		double area = 0;
		//decently difficult depending on how the list for the boundary segments are created
		//this one will most likely be easier than state/country. Could do a rough approximation and do the area of a circle that encompasses
		//the entire area of the city with a decent %error to make up for unused space. 
		//or as the previous comments mentioned split it into 4ths then do the area under a curve again to calculate the area.
		return area;
	}
	/**
	*Gets the city limits
	*@return boundaryList
	*/
	public ArrayList<BoundarySegments> getCitylimits()
	{
		return boundaryList;
	}
	/**
	*Sets the city limits
	*
	*@param boundaryList
	*/
	public void setCityLines(ArrayList<BoundarySegments> boundaryList)
	{
		this.boundaryList = boundaryList;
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
	*Gets the host State
	*@return hostState
	*/
	public State getHostState()
	{
		return hostState;
	}
	/**
	*Sets the host State
	*@param hostState
	*/
	public void setHostState(State hostState)
	{
		this.hostState = hostState;
	}
	/**
	*Gets the population
	*@return population
	*/
	public int getPopulation()
	{
		return population;
	}
	/**
	*Sets population
	*@param population
	*/
	public void setPopulation(int population)
	{
		//so this will most likely have to be given to us otherwise finding the area would be pretty difficult
		//we could mathmatically guess but in general population should be given
		this.population = population;
	}
	/**
	*Creates a triangle to find the distance between cities
	*@param city
	*@return distance
	*/
	public double distanceBetween(Cities city)
	{
		double distance =0;
		//here we would do something weird. If we have everybodys boundaries technically we could create a map using maybe a grid kind of function and coordinates
		//(but this would most likely require everything to have an anchor point that marks their location on a map and is contained in the boundarieslist info) then 
		//we will use trig to solve this. first we will have to set a point directly above or below one city that is horizontal to the other city
		//which will therefore create a triangle. then we can easily solve with a trig function using the distance between the point above or below and the city
		//and using the the distance between the horizontal point and the city. 
		//so here most likely would call a method from a class that forms a map of sorts.
		return distance;
	}
		/**
	*gets rivers
	*@return rivers
	*/
	public ArrayList<River> getRivers()
	{
		return cityRivers;
	}
	/**
	*sets rivers
	*@param rivers
	*/
	public void setRivers(ArrayList<River> cityRivers)
	{
		this.cityRivers = cityRivers;
	}
	/**
	*returns the neighbors of the city
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
	*returns borders of the city
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