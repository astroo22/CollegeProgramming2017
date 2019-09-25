//Jonathan Starkey

import java.util.*;

public class Euler2
{
	public static void main(String args[])
	{
		//ok -1833689714 is my answer but why? there are no negative numbers here....
		// tried for loop going to try boolean while loop now? maybe that will fix it?
		// i think I broke something when using the for loop result in a bad return
		int sum=0;
		int prev1=0;
		int prev2=1;
		int temp = 4000000;
		boolean max = false;
		
		
		while(!max)
		{
			int temp1 = prev1 + prev2;
			prev1 = prev2;
			prev2 = temp1;
			
			if(temp1>temp)
			{
				max = true;
				break;
			}
			if(temp1 % 2 == 0)
			{
				sum += temp1;
			}
			
				
		}
		System.out.println("" + sum);
	}
	
}