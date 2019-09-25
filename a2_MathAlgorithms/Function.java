//Jonathan Starkey

import java.util.*;
/**
* basic class that holds everything together. Gives subclasses a way to find
*the root of a continuous function. 
*
*
*/

public abstract class Function
{
	/**
	* EPSILON is the amount of acceptable error as a constant
	*/
	public static final double EPSILON = 0.00000001;
    
	/**
	* An abstract method for subclasses used with findRoot
	*@param x the value that will be evaluated for the function
	*@return the value of the function at the value x
	*/
	
	public abstract double evaluate(double x);
	
	
	/**
	*this method is used to find the value of of the point between a and b where the function
	*is evaluated to find the 0 
	*
	*@param a the first number in the bound 
	*@param b the second number in the bound
	*@param EPSILON is the level of acceptable error
	*@return findRoot returns the root within the acceptable range
	*/
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
	public static void main(String args[])
	{
		SinFunc sin = new SinFunc();
		System.out.println(sin.findRoot(3,4,EPSILON));
		
		CosFunc cos = new CosFunc();
		System.out.println(cos.findRoot(1,3,EPSILON));
		
		int[] bruh = {-3,0,1};
		PolyFunc pFun1 = new PolyFunc(bruh);
		System.out.println(pFun1.findRoot(0, 50, EPSILON));
		
		
		int[] bruh1 = {-2,-1,1};
		PolyFunc pFun2 = new PolyFunc(bruh1);
		System.out.println(pFun2.findRoot(0,50, EPSILON));
	}
}