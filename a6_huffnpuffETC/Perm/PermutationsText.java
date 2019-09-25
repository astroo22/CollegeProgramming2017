import java.util.*;

public class PermutationsTest
{
	public static void main(String[] args)
	{
		int numElements = Integer.parseInt(args[0]);
		ArrayList<Integer> list = new ArrayList<Integer>(numElements);
			for(int i= numElements -1; i>= 0; i--)
			{
				list.add(i);
			}
			Permutations<Integer> p = new Permutations<Integer>(list);
			while(p.hasNext())
			{
				System.out.println(p.next());
			}
	}
	
}