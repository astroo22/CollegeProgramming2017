//Jonathan Starkey
import java.util.*;

public class Permutations<E>
{
	private List<E> list;
	private int length;
	private E start;
	private Permutations<E> part;
	private int index =0;
	
	public Permutations(List<E> list)
	{
		LinkedList<E> thing = new LinkedList<>(list); //is this correct?
		this.length = thing.size();
		if(length >0)
		{
			//ok first it says remove and remember the first element of the list
			this.start = thing.removeFirst();
			//ok so it says create and remember a new object based on whats left so
			this.part = new Permutations<>(thing); 
			//ok obtain and remember the first permutation or empty list ~
			//WAIT I UNDERSTAND whats going on now. ok so this is like multiple instances created with link lists so each permutation is an instance 
			//of a linked list that is a different order than all of the previous
			this.list = this.part.next();
			
		}
		else
		{
			this.start = null; // so i need to create a next method now i understand
		}
	}
	//found out there isn't a has next method
	public boolean hasNext()
	{
		if(length != 0 && index<length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public List<E> next()
	{
		//So this needs to be a specific order. started with !hasNext if statement at the bottom but these should be at the top
		//so if it returns then it doesn't create the linkedlist below even if theres nothing to create which was causing a nullpointer
		if(!hasNext())
		{
			return null;
		}
		if(list == null)
		{
			index ++;
			return Collections.singletonList(start); //found on oracle creates an immutable list containing only the specified object
		}
		LinkedList<E> thing2 = new LinkedList<>(list);
		thing2.add(index++,start);
		if(index == length && part.hasNext())
		{
			this.list = part.next();
			index = 0;
		}
		
		return thing2;
	}
//~~Code for testing given in class~~found my picture of it.
	//for testing doens't say to do anything like this so might comment it out.
	/*
	public static void main(String args[])
	{
		//public List<E> list1 = [0,1,2];
		
		
		//System.out.println("" + Permutations(list));
	} */
}