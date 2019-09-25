//Jonathan Starkey
package geography;
import java.io.*;
import java.net.*;
import java.util.*;

public interface GeographicMap //pretty sure this should be an interface instead of a class?
{
	//private ArrayList<BoundarySegments> boundaryList;
	//public ArrayList<GeographicMap> mapParts;
	/**
	*should use the boundaries to create a map
	*@param boundaryList
	*/
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//public void createPart(ArrayList<BoundarySegments> boundaryList);
	//this will create a part of the map above by setting up the boundaries then using math to find the center and creates an
	//anchor point. the anchor point is then used by the map creater to place it on the map. All these parts will be added to a part list
	//have a decent idea on how to write this but not without trial and error. 	
	/**
	*This will use the parts created by the above method and add them together to create a map
	*
	*@param mapParts
	*/
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~public void createMap(ArrayList<GeographicMap> mapParts);~~~~~~~
	//this will create the map based on the parts created in the above method most likely using something along the lines of a grid set up
	//not entirely sure how to write this or implement it properly so commenting it out for now
	/**
	*This will get the neighbors of the area in question using the name of the country/state
	*@param name
	*/
	public ArrayList<GeographicMap> neighbors(String name);
	
		//will run a search of countries first based on name then States
		// once it finds a match it will take all of the states/countries touching and return them
		//not entirely sure how to write this. 
	/**
	*Same as the above except checks if they the places in question are touching elsewhere and excludes them
	*@param name
	*/
	public ArrayList<GeographicMap> borderOf(String name);
	//will do same as above except excludes things that are already touching elsewhere. 
}