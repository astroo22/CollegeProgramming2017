//jonathan Starkey


/* ~~~~~~~~~~~~~~~~~~~~
At the start of this assignment I honestly didn't really have a very good grasp on what the differences in the sorting times were based 
on the time complexity things that were presented in class. The difference in run time between a O(n^2) sorting method vs a O(n Log n) 
sorting method is absolutely massive. I always knew the speed of an algorithm when it got to huge numbers like that would make a big difference,
but with only 100 million its already at such a huge time difference and im pretty sure a O(n Log n) sort is only one step above O(n^2);

~~~~~~~~~~~~~~~~~~~~~~~*/

import java.io.*;
import java.net.*;
import java.util.*;

public class Sorting
{
	public static int n = 1;
	public static boolean test = true;
	public static boolean test2 = true;
	public static long start2 = 0;
	public static void main(String args[])
	{	
		try
		{	
			
			
			while(true)
			{
				n *= 10;
				double[] x = new double[n];
				for(int r = 0; r<n; r++)
				{
					Random rr = new Random();
					double randomValue = 0.0 +(1.0 -0.0) *rr.nextDouble();
					
					x[r] = randomValue;
					
				}
				double[] other1 = x;
				if(test == true)
				{
					long start = System.currentTimeMillis();
					double[] xx = bubbles(x);
					long end = System.currentTimeMillis();
					if(test == true)
					{
						System.out.println("Bubble sort completed in: " + (end-start) + " Milliseconds.");
					}
				}
				
				if(test2 == true)
				{ 
					start2 = 0;
					start2 = System.currentTimeMillis();
					double[] other2 = mergen(other1);
					long end2 = System.currentTimeMillis();
					System.out.println("Merge sort completed in: " + (end2-start2) + " Milliseconds.");
				}
				
			}
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Java has run out of memory");
			System.out.println("Merge sort was still working at " + n + " values in under 20 seconds.");
			System.out.println("Now exiting the program...");
			System.exit(0);
			
		}
		
	}
	public static double[] bubbles(double[] x)
	{
		long otherThingy = System.currentTimeMillis();
		//boolean thingy = true;
		
		int temp2 = x.length;
		if(test == true)
		{
			for(int i=0; i<temp2; i++)
			{ 
				if(System.currentTimeMillis() - otherThingy < 20000)
				{
					for(int ii =0; ii< temp2-1;ii++)
					{
						if(x[ii] > x[ii+1])
						{
							double temp;
							
							temp = x[ii];
							x[ii] = x[ii+1];
							x[ii+1] = temp;
						}
						
					}
				}
				else
				{
					System.out.println("Bubble sort has taken longer than 20 seconds.");
					System.out.println("Bubble sort couldn't complete " + n + " values  in under 20 seconds.");
					//System.out.println("Now exiting the program...");
					test = false;
					break;
					//System.exit(0);
				}
			}
		}
		
		return x;
	}
	public static double[] mergen(double[] x)
	{
		
			if(System.currentTimeMillis() - start2 < 20000)
			{
				double[] xxx = null;
				
				if(x.length <=1)
				{
					//should this just be returned instead?
					return x;
				}
				int temp = (x.length)/2;
				double[] r = new double[temp];
				System.arraycopy(x, 0, r,0,temp);
				double[] l = new double[x.length - temp];
				System.arraycopy(x,temp,l,0,(x.length - temp));
				// uhhhhhhhhh two arrays left and right but these have to be divided till they are basically one?
				// im unsure how to do this
				// i could use a ton of weird for loops
				// wait i can use recursion into this method then create a new method that is part of this one that 
				// does the actual merge? orr uhhh sorting yassss
				r = mergen(r);
				l = mergen(l);
				//ok new method calling here~~~ this should most likely be another recursive method that takes
				// in both r and l and figures out which is bigger etc i think this will work?
				// uhhh next part i feel like this should be simple?
				// wait just make this also recursive
				//need an array for final tho~ shouldn't set a size could make a public variable outside of method and use above
				//counter but it would be better to just set it to null i think?
				xxx = mergen2(r,l);
				return xxx;
			}
			else
			{
				System.out.println("Merge sort has taken longer than 20 seconds.");
				System.out.println("Merge sort couldn't complete " + n + " values in under 20 seconds.");
				System.out.println("Now exiting the program...");
				System.exit(0);
			}
		
		return x;
	}
	public static double[] mergen2(double[] r, double[] l)
	{
		//start with a final array for everything to be put into 
		double[] fArray = new double[r.length + l.length];
		int counter =0;
		//but if they are different sizes ~~ or its 1 that needs to be handled in above
		//so ran into the issue of out of bounds because the length would reach the end on one then try to go up 
		//and find nothing. will try if statements
		//didn't work maybe could have gotten it to work but i think 
		// i figured out an easier way to do this...
		int rc = 0;
		int lc =0;
		for(int i= 0; i<fArray.length; i++)
		{
			// so if the left counter is greater than or equal to the left length or the right index is less than the right length AND 
			// the right[rc] is less than or equal to the left[lc] ~~~ ok that i think coveres all the if statements 
			if(lc >= l.length || (rc < r.length && r[rc] <= l[lc]))
			{
				//add the right side to array
				fArray[i] = r[rc];
				rc++;
			}
			else
			{
				fArray[i] = l[lc];
				lc++;
			}
		}
		/*
		for(int i =0; i < r.length;)
		{
			for(int ii=0; ii<l.length;)
			{
				if(r[i] > l[ii])
				{
					// ok i need a seperate counter for fArray 
					fArray[counter] = l[ii];
					counter++;
					ii++;
					/*
					if(ii == l.length)
					{
						if(l[ii]>r[i])
						{
							fArray[counter] = r[i];
							counter++;
							
							
						}
						if(l[ii]<r[i])
						{
							fArray[counter] = l[ii];
							counter++;
							for(int u = i; u<r.length; u++)
							{

							}
						}
					} 
				}
				else
				{
					fArray[counter] = r[i];
					counter++;
					i++;
					/*
					if(i == r.length)
					{
						
					} 
				}
			}
		} */
		
		return fArray;
	}
}