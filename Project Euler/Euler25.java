//Jonathan Starkey

import java.util.*;
import java.math.BigInteger;

public class Euler25
{
	public static void main(String args[])
	{
		//int counter=0;
		//int prev1=0;
		//int prev2=1;
		//int limit = 1000;
		//BigInteger limit = (new BigInteger("10")).pow(999);
		BigInteger prev1 = BigInteger.valueOf(1);
		BigInteger prev2 = BigInteger.valueOf(2);
		BigInteger x = BigInteger.valueOf(0);
		BigInteger MAX = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		
		
		int i = 3; // lol this was so annoying
		for( i=3; prev2.compareTo(MAX)<0; i++)
		{
			x = prev1.add(prev2);
			prev1 = prev2;
			prev2 = x;
			
			
			
			
			
			
			
			/*if(i==0)
			{
				temp[i] = BigInteger.ZERO;
				
			}
			else if(i==1)
			{
				temp[i] = BigInteger.valueOf(1);
			}
			else
			{
					// had to look this up... such an odd way to add and BigInteger is a pain to deal with
				temp[i] = temp[i-1].add(temp[i-2]);
			}
			if(temp[i].length==1000)
			{
				counter =i;
				break;
			}
			*/
			/*
			int temp1 = prev1 + prev2;
			prev1 = prev2;
			prev2 = temp1;
			
			if(cout(prev1) ==1000)
			{
				max = true;
				break;
			}
			if(temp1 % 2 == 0)
			{
				sum += temp1;
			}*/
			
				
		}
		
		System.out.println(i);
	
	}
}