//Jonathan Starkey

import java.util.*;
public class Factorial 
{
	public static void main(String args[])
	{
		int temp1 = Integer.parseInt(args[0]);
		
		System.out.println(calculate(temp1));
	}
	public static long calculate(long n)
	{
		long temp = n;
		
		if( n<0 || n>20)
		{
			System.out.println("Number is not usable");
			
		}
		else if ((n >= 1) && (n<=20)) 
		{
			for (long i = n -1; i>0; i--)
			{
			
				temp =  temp *(i);
				
							
			}
			
		}
		else if(n == 0)
		{
			temp = 1;
			
		}
		return temp;
	}

}