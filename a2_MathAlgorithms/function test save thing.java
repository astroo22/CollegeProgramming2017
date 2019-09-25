//Jonathan Starkey

import java.util.*;
public class FunctionTest extends Function 
{
	public static final double EPSILON = 0.00000001;
	public static void main (String args[])
	{
		FunctionTest funTest = new FunctionTest();
		System.out.println(findRoot(3,4,EPSILON));
		
	}
	public double findRoot(double a, double b, double EPSILON)
	{
		double temp = (a + b)/ 2; 
		if (Math.abs(a - temp) < EPSILON)
		{
			return temp;
			
		}
		else if (evaluate(a) > 0 && evaluate(temp) > 0 || evaluate(a) < 0 && evaluate(temp) < 0) // could make an evaluation method for Math.sin? 
		{
			return findRoot(temp,b,EPSILON);
		}
		else 
		{
			return findRoot(b,temp,EPSILON);
		}
	}
	public double evaluate(double x)
	{
		return Math.sin(x);
	}
}






