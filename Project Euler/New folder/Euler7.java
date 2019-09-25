//Jonathan Starkey

import java.util.*;
public class Euler7
{
	public static void main(String args[])
	{
		
		int numberOfPrimes = 1;
		long i = 2;
		while(numberOfPrimes <=10001)
		{
			if(prime(i))
			{
				i++;
				numberOfPrimes++;
			}
			else i++;
		}
		System.out.println(i-1);
	}
	public static boolean prime(long x)
		{
			if((x % 2 == 0)&&(x !=2))
			{
				return false;
			}
			for(long i = 3; i<=(x^(1/2)+1); i+=2)
			{
				if(x%i == 0)
				{
					return false;
				}
			}
			return true;
		}
}