//Jonathan Starkey

import java.util.*;
public class FunctionTest
{
	public static void main (String args[])
	{
		double epsilon = 0.00000001;
		System.out.println(findRoot(3,4,epsilon));
		
	}
	public static double findRoot(double a, double b, double epsilon)
	{
		double temp = (a + b)/ 2; 
		if (Math.abs(a - temp) < epsilon)
		{
			return temp;
			
		}
		else if (Math.sin(a) > 0 && Math.sin(temp) > 0 || Math.sin(a) < 0 && Math.sin(temp) < 0) // could make an evaluation method for Math.sin? 
		{
			return findRoot(temp,b,epsilon);
		}
		else 
		{
			return findRoot(b,temp,epsilon);
		}
	}
}






