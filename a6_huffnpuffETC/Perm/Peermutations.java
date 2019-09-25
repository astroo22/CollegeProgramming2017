//Jonathan Starkey
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
			this.first = null; // so i need to create a next method now i understand
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
		LinkedList<E> thing2 = new LinkedList<>(list);
		thing2.add(index++,start);
		if(list == null)
		{
			index ++;
			return Collections.singletonList(start); //found on oracle creates an immutable list containing only the specified object
		}
		if(index == length && part.hasNext())
		{
			this.list = part.next();
			index = 0;
		}
		if(!hasNext())
		{
			return null;
		}
		return thing2;
	}
}