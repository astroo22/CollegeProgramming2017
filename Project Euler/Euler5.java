//Jonathan Starkey

import java.util.*;

public class Euler5
{
	public static void main(String args[])
	{
		int answer = 21;
		
		
		while(true)
		{
			boolean something = true;
			for (int i =1; i<21; i++)
			{
				something = true;//attempt number 4. always get the command promp just running 
				//added above statement so that it resets itself on every iteration :l
				if(answer%i !=0)
				{
					something = false;
					break;
				}
							
			}
			if(something == true)
			{
				System.out.println(answer);
			}
			answer ++; // forgot the fricken iterator  this was the real problem omg
		}
		
		
		
		
		
			
			
			
		}
	
	}
