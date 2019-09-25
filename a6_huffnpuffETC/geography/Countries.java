//Jonathan Starkey
package geography;
import java.io.*;
import java.net.*;
import java.util.*;

public class Countries implements GeographicMap
{
	private String name;
	//private double area;
	private String capital; //might change this to city after i make the city class unsure tho.
	private ArrayList<BoundarySegments> boundaryList;
	private ArrayList<Cities> citiesList;
	private ArrayList<River> rivers;
	
	/**
	*Base constructor
	*
	* @param name
	*/
	public Countries(String name)
	{
		this.name = name;
	}
	/**
	*Constructor for Countries object
	*
	*@param name
	*@param capital
	*@param boundaryList
	*@param citiesList
	*@param rivers
	*/
	public Countries(String name, String capital, ArrayList<BoundarySegments> boundaryList, ArrayList<Cities> citiesList,ArrayList<River> rivers)
	{
		this.name = name;
		this.capital = capital;
		this.boundaryList = boundaryList;
		this.citiesList = citiesList;
		this.rivers = rivers;
	}
	/**
	*returns the name of the Country
	*@return name
	*/
	public String getName()
	{
		return name;
	}
	/**
	*Sets the name of the counrty
	*@param name
	*/
	public void setName(String name)
	{
		this.name = name;
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
	*returns the area of the country
	*@return area
	*/
	public double area()
	{
		double area =0;
		//calls countryarea to calculate the area then returns it.
		return area;
	}
	/**
	*calculates the area of the country
	*@param boundaryList
	*/
	public double countryArea(ArrayList<BoundarySegments> boundaryList)
	{
		double area = 0;
		//decently difficult depending on how the list for the boundary segments are created
		//the countries area will be calculated using derivatives and functions unless we can assume everything is a square
		//otherwise we would split the state most likely into forths then calculate based on the area under the curve
		//with a small % error
		return area;
	}
	/**
	*gets the cities in the country
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
	*gets rivers
	*@return rivers
	*/
	public ArrayList<River> getRivers()
	{
		return rivers;
	}
	/**
	*sets rivers
	*@param rivers
	*/
	public void setRivers(ArrayList<River> rivers)
	{
		this.rivers = rivers;
	}
	/**
	*returns the neighbors of the country
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
	*returns borders of the country
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