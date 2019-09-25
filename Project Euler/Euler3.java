//Jonathan Starkey
import java.math.*;
import java.util.*;


public class Euler3
{
	
	public static void main(String args[])
	{
			long THIS =600851475143L;
			  
		 long answer =0;
		//long THISBy4 = 150212868786L;
		for(int i = 2; i <= THIS; i++)
		{	
			if(THIS % i == 0)
			{
				System.out.println(i);
				THIS = THIS/i;
				answer = THIS / i;
				i= 2;
				
			}
			/*
			isPrime= true;
			while(isPrime== true)
			{
				
				for(int ii=2; 2*ii<i; ii++)
				{
					if(!(i%ii == 0))
					{
						isPrime = true;
						if(i*i == num)
						{
							answer = i;
							isPrime = false;
						}
					}
					else{
						isPrime = false;
					}
				
					
				}
				
				
				
			}*/
			
						
			
		}
		
		System.out.println(answer);
		
	
	}
	private static boolean isPrime(long n)
	{
		for(long num =2, max = 1 / 2; num < max; num++)
		{
			if(n % num ==0)
			{
				return false;
			}
		}
		return true;
	}
}	