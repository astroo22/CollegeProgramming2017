import java.util.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Huff
{
	//HuffmanTree huffTree;
	//public static HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
	//public static Map<Character, Integer> sortedMap;
	public static void main(String args[])
	{
		//ArrayList<HuffmanNode> list = new ArrayList<HuffmanNode>();
		System.out.println("Will encode the file in the first argument");
		System.out.println("Notes: Couldn't figure out how to decode through only one file because i wasn't sure how i would split them apart");
		System.out.println("Cont: Encoding works and is sent out to Results.huff The decoding does work and is sent out to Decoded.txt.");
		System.out.println("Cont: To decode what you just encoded do Puff result.huff");
		System.out.println("Cont: To decode a random file~ this is probably not the program you are looking for");
		try
		{
			Scanner scan = new Scanner(new FileInputStream(args[0]));
			String line = "";
			//List<Character> thingy = new ArrayList<Character>();
			//List<Integer> freq = new ArrayList<Integer>();
			while(scan.hasNextLine())
			{
				line+=scan.nextLine() + "\n";
			}
			Huffman x = new Huffman();
			x.encoding(line);
			/*
			int index = 0;
			int counter = 0;
			int help = line.length();
			//boolean holyhell = false;
			for(int ii=0; ii<line.length(); ii++)
			{
				if(!(thingy.contains(line.charAt(ii))))
				{	
					for(int i =0; i<line.length(); i++)
					{
						if(thingy.contains(line.charAt(i)))
						{
							counter ++;
						}
						else
						{
							thingy.add(line.charAt(i));
						}
					}
					//counter =1;
					//index++;
				}	
			}
			char[] thingy1 = new char[thingy.size()];
			int[] freq = new int[thingy.size()];
			counter = 0;
			for(int i =0; i<thingy1.length; i++)
			{
				thingy1[i] = thingy.get(i);
			}
			boolean something1 = false;
			for(int ii=0; ii<thingy1.length; ii++)
			{
				if(something1)
				{
					freq[ii-1] = counter;
					counter =0;
					something1 =false;
				}
				for(int i=0; i<line.length(); i++)
				{
					if(thingy1[ii] ==  line.charAt(i))
					{
						counter ++;
						something1 = true;
					}
				}
			}
			System.out.println(Arrays.toString(thingy.toArray()));
			//System.out.println(Arrays.toString(freq.toArray()));
			for(int i=0; i<freq.length; i++)
			{
				System.out.print(" " + freq[i]);
			}
			//System.out.println(index);
			//freq1 = freq.toArray(freq1);
			//thingy1 = thingy.toArray(thingy1);
			HuffmanTree huffTree = new HuffmanTree(freq,thingy1);
			String something =  huffTree.encode(line);
			System.out.println(something);
			*/
		}
		catch(FileNotFoundException|ArrayIndexOutOfBoundsException e)
		{
			System.out.println("You need to input a file");
		}
		
	}
	/*
	public void buildTree(ArrayList<HuffmanNode> list)
	{
		PriorityQueue<HuffmanNode> que = new PriorityQueue<HuffmanNode>();
		for(int i=0; i<list.size(); i++)
		{
			que.add(list.get(i));
		}
		while(que.size() > 0)
		{
			System.out.println(que.remove().getString());
		}
	}
	public static int[] getFrequency(String line1)
	{
		
	}*/
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	Object[] a = characters.entrySet().toArray();
			Arrays.sort(a, new Comparator()
			{
				public int compare(Object o1, Object o2)
				{
					return((Map.Entry<Character, Integer>) o1).getValue()
					.compareTo(((Map.Entry<Character, Integer>) o2).getValue());
				}
			});
						
			
			//Map<Character, Integer> sortedMap = characters.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
			//LinkedHashMap<Character, Integer> sortedMap = sortHash(characters);
			String line2 = "";
			for(Object e : a)
			{
				line2 += (((Map.Entry<Character, Integer>) e).getKey() + ":" + ((Map.Entry<Character, Integer>) e).getValue()) + " ";
			}
			System.out.println(line2);
	
	public static Map<Character, Integer> something(HashMap<Character,Integer> characters)
	{
		
	}
	/*
	for(Object e : a)
			{
				sortedMap.put((((Map.Entry<Character, Integer>) e).getKey()), (((Map.Entry<Character, Integer>) e).getValue()));
			}
			System.out.println(Arrays.asList(sortedMap));
	public static LinkedHashMap<Character, Integer> sortHash(HashMap<Character,Integer> characters)
	{
		List<Character> mapKeys = new ArrayList<>(characters.keySet());
		List<Integer> mapValues = new ArrayList<>(characters.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);
		LinkedHashMap<Character, Integer> sorted = new LinkedHashMap<>();
		Iterator<Integer> valueIt = mapValues.Iterator();
		while(valueIt.hasNext())
		{
			String val = valueIt.next();
			Iterator<Character> keyIt = mapKeys.Iterator();
			while(keyIt.hasNext())
			{
				Integer key = keyIt.next();
				String temp1 = characters.get(key);
				String temp2 = val;
				if(temp1.equals(temp2))
				{
					keyIt.remove();
					sortedMap.put(key,val);
					break;
				}
			}
		}
		return sorted;
	}*/

/*
			Map<Character, Integer> sortedMap = characters.entrySet().stream()
		.sorted(Entry.comparingByValue())
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
		(e1,e2) -> e1, LinkedHashMap::new));*/