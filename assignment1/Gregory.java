//Jonathan Starkey

import java.util.*;

public class Gregory
{
	public static void main(String args[])
	{
		int n;
		n = Integer.parseInt(args[0]);
		double difference = (100 - ((series(n) / Math.PI) * 100));
		System.out.println("Pi according to the Gregory series: " + series(n));
		System.out.println("This differs from Java's value by " + difference + " percent.");
		
		
		
	}
	public static double series(int s)
		{
			double answer = 0;
			double return1;
			for(int i =1; i<=s; i++)
			{
				double temp1 = (Math.pow(-1, (i +1)))/ ((2*i)-1);
				answer += temp1;
			}
			return1 = answer*4;
			return return1;
		}
}