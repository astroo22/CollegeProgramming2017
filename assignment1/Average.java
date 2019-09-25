//Jonathan Starkey

import java.util.*;

public class Average
{
	public static void main(String args[])
	{
		System.out.println("Please enter a series of numbers. Enter a negative number to quit.");
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		int linenumber = 0;
		double input;
		double temp = 0;
		double sum =0;
		double[] numbers = new double[100];
		while(scan.hasNextLine())
		{
			linenumber++;
			input = Double.parseDouble(scan.nextLine());
			if(input >0)
			{
				for(int ii = 0; ii<linenumber; ii++)
				{
					numbers[ii]=input;
				}
			}
			
			else if(input < 0)
			{
				for(int i =0; i<linenumber; i++)
				{
					temp += numbers[i];
					
				}
				sum = temp/(linenumber-1);
					
				break;
			}
			
			
		}
		
		
		
		System.out.println("You entered " + (linenumber-1) + " numbers averaging " + sum);
		
			
	}
}
	