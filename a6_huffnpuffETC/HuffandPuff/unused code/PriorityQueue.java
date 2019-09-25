//jonathan Starkey
/*
import java.util.*;
import java.io.*;

public class PriorityQueue<Ex> 
{
	
	//okay uhhhhh
	public class Ex
	{
		private int x;
		private Object thing; //?
		public Ex(int xx, Object thing1)
		{
			this.x = xx;
			this.thing = thing1;
		
		}
		public int getFreq()
		{
			return this.x;
		}
		public int getEl()
		{
			return this.element;
		}
	}
	public ArrayList<Ex> e;
	//maybe?
	public PriorityQueue()
	{
		this.e = new ArrayList<E
		//ok created an array list now im going to add a first thing that stays
		e.add(-1, null));
		
	}
	public void addIt(int numChar, Object thing)
	{
		int size = e.size();
		//ok so the que is based on the number of characters so i have to add the new thing in without messing up taht order
		// so i need to do a mini bubble sort i think?
		//ok like a linked list i think ~~~ using code written in my C++ class here mixed with a bubble sort
		int mid = size/2; // could create uneven here account for it
		//ok the last instance will be null so i can add one at the end the move it around
		e.add(null);// creates a object at the end of the que
		//ok now i need to think about this like the diagrams in notes from his explanation
		//so i need the mid area because that should be the max in the tree and the parent of everything. 
		Ex parent = (Ex)e.get(mid);  //so this is the second level parent 
		while(parent.getFreq() > numChar)
		{
			e.set(size, parent);
			size = mid; //ok think of this as if it was the binary tree ^
			mid = mid/2;
			parent =(Ex) e.get(mid);
			
		}
		e.set(size,new Ex(num, thing);
	}
	public Object getMin()
	{
		return((Ex)e.get(1)).getFreq();
	}
	public Object deleteMin()
	{
		//need to be able to get the element do this in Ex class
		Object min = ((Ex) e.get(1)).getEl();
		Ex lastE = (Ex)e.remove(e.size()-1);
		int temp = lastE.getFreq();
		int counter =1;
		int index = 2;
		while(index < e.size())
		{
			if(index +1< e.size() && ((Ex)e.get(index)).getFreq() > ((Ex)e.get(index+1)).getFreq())
			{
				marker++;
			}
			if(((Ex)e.get(index)).getFreq() >temp)
			{
				break;
			}
			e.set(counter,e.get(index));
			counter = index;
			
			
			
		}
	}

}*/