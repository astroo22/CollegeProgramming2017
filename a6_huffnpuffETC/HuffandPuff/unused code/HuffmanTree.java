import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.*;


//import java.util.*;

public class HuffmanTree
{
	private int size = 0;
	private HuffmanNode base = new HuffmanNode();
	private PriorityQueue<HuffmanNode> daQue = new PriorityQueue();
	public ArrayList<String> thing1 = new ArrayList();
	public ArrayList<Character> values = new ArrayList();
	
	public HuffmanTree(int[] freq, char[] thingy)
	{
		this.size = freq.length;
		if(freq.length != thingy.length)
		{
			throw new UnsupportedOperationException("YEA ITS BROKEN TITS");
		}
		getMinOffer(freq,thingy);
		lifeTree();
		tree(this.base, "");
	}
	private void lifeTree()
	{
		while(daQue.size() >1)
		{
			HuffmanNode temp1L = daQue.poll();
			HuffmanNode temp1R = daQue.poll();
			HuffmanNode temp1P = new HuffmanNode(0,temp1L.n+temp1R.n,temp1L,temp1R,null);
			temp1L.parent = temp1P;
			temp1R.parent = temp1P;
			daQue.offer(temp1P);
			this.size++;
		}
		this.base = daQue.peek();// this grabs the remaining thing left over in the que and sets it to the root.
	}
	private void tree(HuffmanNode x, String s)
	{
		if(x.leftTree == null && x.rightTree == null)
		{
			char temp1;
			if(x.thing == 10)
			{
				temp1 = 'n';
			}
			if(x.thing == 32)
			{
				temp1 = ' ';
			}
			else
			{
				temp1 = (char)x.thing;
				this.values.add(temp1);
				this.thing1.add(s);
			}
		}
		s += "0";
		tree(x.leftTree, s);
		s = s.substring(0, s.length()-1); //reset to do right side
		s += "1";
		tree(x.rightTree, s);
	}
	public String encode(String s)
	{
		// to start need empty string 
		String empty = "";
		for(int i = 0; i<s.length(); i++)
		{
			for(int ii = 0; ii<values.size(); ii++)
			{
				if(values.get(ii) == s.charAt(i))
				{
					empty += thing1.get(i);
				}
			}
		}
		return empty;
	}
	public String decode(String thing)
	{
		//empty string again
		String empty = "";
		for(int i=0; i<thing.length(); i++)
		{
			if(!getish(thing.substring(0,i+1)).equals(""))
			{
				empty += getish(thing.substring(0,i+1));
				thing = thing.substring(i+1);
				i=0;
			}
		}
		return empty;
	}
	private String getish(String thing)
	{
		String temp = "";
		for(int i=0; i<thing1.size(); i++)
		{
			if(thing1.get(i).equals(thing))
			{
				temp = values.get(i).toString();
			}
		}
		return temp;
	}
	public void getMinOffer(int[] freq, char[] thingy)
	{
		while(freq.length >0)
		{
			int index=0;
			int min = freq[0];
			char thing= thingy[0];
			int[] n = new int[freq.length -1];
			char[] nn = new char[thingy.length -1];
			for(int i = 0; i< freq.length; i++)
			{
				if(freq[i] < min)
				{
					min = freq[i];
					thing = thingy[i];
					index = i;
				}
			}
			daQue.offer(new HuffmanNode(thingy[index], freq[index],null,null,null));
			for(int x = 0; x<freq.length; x++)
			{
				if(!(freq[x] == min))
				{
					n[x] = freq[x];
				}
				if(!(thingy[x] == thing))
				{
					nn[x] = nn[x];
				}
			}
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//Basic idea is create a tree and for each character found in the document of sorts find the binary code from the binary tree and put it into the encodings 
	//hashmap. then run through file and for each character pull the encodings out of the hashmap to create the encoded file. lit
	String line; 
	HashMap encodings;
	ArrayList<Character> chars;
	//originally had methods for this in Huff.java passing all of that over didn't work out very well as everything didn't seem to work as planned
	HashMap frequencies;
	BinaryTree binaryTree;
	public HuffmanTree(String line1)
	{
		//passing in line
		this.line = line1;
		//create a hashmap for all the encoded characters
		encodings = new HashMap();
		//ok now create an array list of different characters
		chars = new ArrayList<Character>();
		//creating a hashmap for how often a character shows up
		frequencies = new HashMap();
		//ok now add the frequencies to the hashmap
		frequencies = charFrequencies(line);
		// now that i have a thing of frequencies i should create a binary tree based on what is the smallest
		//so new method here 
		
		
	}
	public HashMap charFrequencies(String line)
	{
		HashMap temp = new HashMap();
		for(int i =0; i<line.length();i++)
		{
			//for hashmap use Character
			Character temp1 = new Character(line.charAt(i));
			int counter = 1;
			if(temp.containsKey(temp1))
			{
				counter = (((Integer)temp.get(temp1)).intValue()) +1;
			}
			//if character is not in list add it set counter to 1
			else
			{
				chars.add(temp1);
				temp.put(temp1, (Integer)counter);
			}
			
		}
		return temp;
	}
	public void createTree()
	{
		
	}
	
}*/