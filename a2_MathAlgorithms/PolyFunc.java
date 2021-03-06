//Jonathan Starkey

import java.util.*;
/**
 * This class evaluates and returns a polynomial. 
 * also gives the ability to manipulate polynomials.
*/
public class PolyFunc extends Function
{

		public int[] coefficients;
		/**
		* constructor for polynomial objects
		*
		* @param coefficients the coefficients of the array
		*/
		public PolyFunc(int[] coefficients)
		{
			this.coefficients = coefficients;
		}
		/**
		* returns the greatest power of the polynomial
		* @return this.coefficients.length -1
		*/
		public int degree()
		{
			return this.coefficients.length -1; //dont need to find this its simply # of the coefficients -1
		}
		
		/**
		* Method to print out the polynomial in a string
		*
		*@return sb.toString() This is the string builder that converts the polynomials to a string
		*/
		public String toString()
		{
			//ok think about this save it a bit for later ~~ found some code that can deal with polynomials called stringbuilder?
			//idea with string builder ~~
			StringBuilder sb = new StringBuilder();
			//need polySize method for iteration
			
			/*
			ok so a couple things i need to handle: 
			if the coefficient is 0 ~ if the coefficient is 1 (just make it so theres no 1)
			at i==0 there will be no X so make an else if and make sure to handle the negative
			at i==1 there wont be a power
			
			*/
			for(int i = this.polySize() - 1; i>=0; i--) // iterate backwords
			{
				if(i == this.polySize()-1)
				{
					sb.append(this.coefficients[i] + "x^" + i);//ok so append is basically something that allows string builder to handle any type data
					//so this is the first coefficient of the equation and i = the size so this should using the given test will be 2x^5 
					
				}// make else to handle everything else?
				//---------------------------
				//handle the above erronious stuff here
				else if (this.coefficients[i]==0)
				{
					continue;
				}
				else if (this.coefficients[i] ==1)
				{
					sb.append(" + x^" +i);
				}
				else if (i==0)
				{
					if (this.coefficients[i]>0)
					{
						sb.append(" + " + this.coefficients[i]);
					} // forgot originally need to handle the coefficient being 0
					else if(this.coefficients[i] == 0)
					{
						continue;//we have an else if above that does this same thing but because this is in an else if i dont think it gets triggered otherwise this would be useless
						
					}
					else 
					{
						sb.append(" " + this.coefficients[i]);
					}
					
				}
				else if (i==1)
				{
					if(this.coefficients[i]>0)
					{
						sb.append(" + " + this.coefficients[i] + "x");
					}
					else if (this.coefficients[i] == 0)
					{
						continue;
					}
					else 
					{
						sb.append(" " + this.coefficients[i] + "x");
					}
				}
				
				
				//---------------------------
				
				else
				{
					if(this.coefficients[i]>0) // as long as there is no 0 in the array this should trigger (edited: to not get negatives)
					{
						sb.append(" + " + this.coefficients[i] + "x^" + i);//this doesn't handle negative values make another else
					}
					else //to handle negative values
					{
						sb.append(" " + this.coefficients[i] + "x^" + i);
					}
				}
			}
			return sb.toString();
		}	
		/**
		* Method that returns the length of the array
		* @return this.coefficients.length this is the length of the array
		*/
		public int polySize()
		{
			return this.coefficients.length;
		}
		/**
		* Method used to add polynomials together 
		*
		* @param The polynomial added to the object
		* @return tempPoly is a new poly object that holds the result of the two added polynomials
		*
		*/
		
		public PolyFunc add(PolyFunc a)
		{ //couple things does this mean we could get arrays of varying sizes?
			//going to need to handle a couple different cases probably two main if statements with a large > small kind of set up and the inverse
			//then finally an else statement if the two sizes are equal.
			
			if(this.polySize() > a.polySize()) 
			{
				// create this inside the if statement to fix return problems
				int[] aPoly = new int[a.polySize()];//mixed up what i had to do depending on which poly was bigger so cut and pasted
				for(int i=0; i<a.polySize() -1; i++)
				{
					aPoly[i] = this.coefficients[i] + a.coefficients[i];
				}
				for(int i=a.polySize() -1; i < this.polySize(); i++)
				{
					aPoly[i] = this.coefficients[i];
				}
				PolyFunc tempPoly = new PolyFunc(aPoly);
				return tempPoly;
			}
			
			else if(this.polySize() < a.polySize())
			{
				int[] aPoly = new int[a.polySize()];
				//so this would be our given array while a would be the new one. Going to need to create a new array 
				// so going to need a loop to add everything 
				for(int i = 0; i<this.polySize() -1; i++)
				{
					aPoly[i] = this.coefficients[i] + a.coefficients[i]; //ok add all the coefficients together and add to new array
				}
				for (int i= this.polySize() -1; i<a.polySize(); i++) // this adds the excess coefficients on 
				{
					aPoly[i] = a.coefficients[i];
				}
				//create new poly because cant convert int to new poly
				PolyFunc tempPoly = new PolyFunc(aPoly);
				return tempPoly;
			}
			else //aight so this is if its the simple case and they are the same
			{
				int[] aPoly = new int[a.polySize()];
				for(int i = 0; i <= a.polySize() - 1; i++)
				{
					aPoly[i] = this.coefficients[i] + a.coefficients[i];
				}
				PolyFunc tempPoly = new PolyFunc(aPoly);
				return tempPoly;
			}
		}
		/**
		* Method used to evaluate a polynomial given a number
		*
		* @param x The variable used to input a given number	 
		* @return temp the result of the polynomial at a specific number
		*/
		public double evaluate(double x)
		{
			double temp = 0.0;
			for(int i = 0; i<this.polySize(); i++)
			{
				temp += coefficients[i] * Math.pow(x,i); // this replaces the x's with current i then adds it into the temp
			}
			return temp;
		}
		
		
		
	}
