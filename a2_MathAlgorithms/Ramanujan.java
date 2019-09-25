//Jonathan Starkey

import java.util.*;

public class Ramanujan
{
	public static void main(String args[])
	{
		int n; 
		n = Integer.parseInt(args[0]);
		double difference = (100 - ((raman(n) / Math.PI) * 100));
		System.out.println("Pi from Raman series: " +raman(n));
		System.out.println("This differs from Javas value by " + difference + " percent.");
	
	}
	public static double raman(int m)
	{
		double temp1 = 0;
		double result = 0; 
		for (int i=0; i < m ; i++)
		{
			temp1 += ((Factorial.calculate(4*i))*(1103 + (26390 * i))) / (Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4*i))); // uhhh attempt 15? 
		}
		temp1 *= ((2 * Math.sqrt(2))/9801);
		result = 1/temp1;
		return result;
	}
}