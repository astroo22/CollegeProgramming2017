//Jonathan Starkey

import java.util.*;
public class FibTest
{
	public static void main(String[] args)
	{
		int daNum = 40;
		
		long startTimerIter;
		long startTimerRecur;
		long endTimerIter;
		long endTimerRecur;
		long totalTimeI;
		long totalTimeR;
		long temp1I;
		long temp2R;
		
		if (fibIter(5) == 5)
		{
			System.out.println("fibIter passed for 5");
		}
		else 
		{
			System.out.println("fibIter did not pass for 5");
		}
		if(fibRecur(5) == 5)
		{
			System.out.println("fibrecur passed for 5");
		}
		else 
		{
			System.out.println("fibrecur did not pass for 5");
		}
		startTimerIter = System.currentTimeMillis();
		temp1I = fibIter(daNum);
		endTimerIter = System.currentTimeMillis();
		totalTimeI = endTimerIter - startTimerIter;
		
		startTimerRecur = System.currentTimeMillis();
		temp2R = fibRecur(daNum);
		endTimerRecur = System.currentTimeMillis();
		totalTimeR = endTimerRecur - startTimerRecur;
		
		System.out.println("Iter took: " + totalTimeI + " milliseconds to complete");
		System.out.println("Recur took: " + totalTimeR + " milliseconds to complete");
	
	}
	public static int fibIter(int n)
	{
		
		if(n == 0)
		{
			return 0;
		}
		if (n == 1)
		{
			return 1;
		}
		int result = 0;
		int secondToLast = 0;
		int lastNum = 1;
		
		for (int i = 2; i<= n; i++)
		{
			result = lastNum + secondToLast; // last + secondToLast
			secondToLast = lastNum; //secondtolast becomes equal to the last number
			lastNum = result; // set the last number equal to the result resets for next number 
			
		}
		return result;
	}
	public static int fibRecur(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else if( n==1 )
		{
			return 1;
		}
		else
		{
			return fibRecur(n-1) + fibRecur(n-2);
		}
	}
}