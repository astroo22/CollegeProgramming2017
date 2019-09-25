//Jonathan Starkey

import java.util.*;

public class Euler6
{
	public static void main(String args[])
	{
		long sum =0;
		long sum2=0;
		long answer =0;
		for(int i=0;i<101;i++)
		{
			sum += i*i;
		}
		for(int ii=0; ii<101; ii++)
		{
			sum2 += ii;
		}
		answer = (sum2*sum2)-sum;
		System.out.println(answer);
	
	}
}