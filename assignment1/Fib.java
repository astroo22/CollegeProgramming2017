//Jonathan Starkey

import java.util.*;

public class Euler2
{
	public static void main(String args[])
	{
		int n=0;
		
		int n1=0;
		int n2=1;
		//int temp;
		
		
		
		for(int i = 2; i<4000000; i++)
		{
			int temp1=n1+n2;
			n1 = n2;
			n2 = temp1;
			
			//temp = (n1+n2);
			if(temp1%2 = 0)
			{
				n += temp;
			}
				
			
			
			
		}
		System.out.println(n);
	}
}