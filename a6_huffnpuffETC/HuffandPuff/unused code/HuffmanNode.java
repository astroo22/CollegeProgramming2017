//Jonathan Starkey

import java.util.PriorityQueue;
import java.util.*;
import java.io.*;


public class Huffman
{
	
	public class HuffmanNode 
	{
		public char thing;
		public int freq;
		public HuffmanNode leftTree;
		public HuffmanNode rightTree;
		public HuffmanNode parent;
		public HuffmanNode()
		{
			
			parent = null;
			leftTree = null;
			rightTree= null;
		}
		public HuffmanNode(char thing1, int freq1,HuffmanNode leftTree1,HuffmanNode rightTree1,HuffmanNode parent1)
		{
			this.thing = thing1;
			this.freq = freq1;
			this.leftTree = leftTree1;
			this.rightTree = rightTree1;
			this.parent = parent1;
		}
	}
		
		public class compareTo implements Comparator<HuffmanNode>
		{
			public int compare(HuffmanNode one, HuffmanNode two)
			{
				return one.freq - two.freq;
			}
			
			
			
			/*HuffmanNode temp = (HuffmanNode)thing1;
			return n<temp.n ? -1: (n==temp.n ? 0 : 1);*/
		}
		
		//upon further review need below
		@Override
		public String toString() 
		{
			String temp = "";
			temp += this.thing;
			return temp;
		}
		//going to ttry a version where i do everything i did in the huffman tree below might be less confusing
		// awkward but i need to put everything into one class now though so i have to change the file name etc.
	
	public class bitthing
	{
		//might be moving the tree creation here
		public int danum;
	}
		//moving encode
		public void encoding(String line) throws FileNotFoundException,IOException
		{
			this.line = line;
			map<Character, Integer> freq = freqMap(line);
			HuffmanNode start = createHTree(freq);
			map<Character, String> newMap = codeMap(freq.keySet(), start);
			String result = encoded(newMap,line);
			save(start);
			saveResult(result);
		}
		public void saveResult(String result)
		{
			BitSet bits = new BitSet();
			try
			{
				ObjectOutputStream string = new ObjectOutputStream(new FileOutputStream("result.huff"));
				for(int i = 0; i<result.length();i++)
				{
					if(result.charAt(i) == '0')
					{
						bits.set(i,false);
						
					}
					else
					{
						bits.set(i,true);
					}
				}
				string.writeObject(bits);
			}
			catch(IOException|FileNotFoundException e)
			{
				System.out.println("Broke at saveResult");
			}
		}
		public void encode(HuffmanNode front, Map<Character, String> codeMap, String thing)
		{
			if(front.leftTree == null && front.rightTree == null)
			{
				codeMap.put(front.thing, thing);
			}
			encode(front.leftTree, codeMap, thing + '0');
			encode(front.rightTree, codeMap, thing + '1');
		}
		public String encoded(Map<Character, String> codeMap, String line)
		{
			String temp1 = "";
			for(int i = 0; i<line.length(); i++)
			{
				temp1 +=(codeMap.get(line.charAt(i)));
			}
			return temp1; //ok this should return the string full of everything needed
		}
		public Map<Character, String> createCM(Set<Character> freq, HuffmanNode front)
		{
			//creates a map of codes for each character. 
			Map<Character, String> codeMap = new HashMap<Character,String>();
			encode(front, codeMap, "");
			return codeMap;
		}
		public Map<Character,Integer> freqMap(String line)
		{
			//creates the map of frequencies for each character
			Map<Character,Integer> result = new HashMap<Character, Integer>();
			for(int i =0; i<line.length(); i++)
			{
				char current = line.charAt(i);
				if(result.containsKey(current))
				{
					int currentF = result.get(current);
					result.put(current,currentF++);
				}
				else
				{
					result.put(current,1);
				}
			}
			return result;
		}
		public HuffmanNode createHTree(Map<Character, Integer> map)
		{
			PriorityQueue<HuffmanNode> daQue = new PriorityQueue<HuffmanNode>(new compareTo());
			for(Map.Entry<Character, Integer> entry : map.entrySet()) //found this loop on Stack Overflow
			{
				daQue.add(new HuffmanNode(entry.getKey(), entry.getValue(), null,null));
				
			}
			while(daQue.size() >1)
			{
				HuffmanNode one = daQue.poll();
				HuffmanNode two = daQue.poll();
				daQue.offer(new HuffmanNode(0,one.freq + two.freq, one, two));
			}
			return daQue.remove();
		}
		public void save1(HuffmanNode front)//general idea from StackOverflow(code was not copied but general idea behind the logic was) 
		{
			//this could be thought of as the main method here. everything is created and passed on. 
			BitSet bits = new BitSet(); 
			try
			{
				ObjectOutputStream sTree = new ObjectOutputStream(new FileOutputStream("tree.huff"));
				ObjectOutputStream cFile = new ObjectOutputStream(new FileOutputStream("characters.huff")); //creating two files tree and characters
				// here cFile will be filled using my bitthing class and a method.
				//added public number danum to help with counting
				bitthing bt = new bitthing();
				//here we are going to use a different method to send out the characters from the nodes in order
				order(bits,bt,cFile,front);
				cFile.flush();
				cFile.close();
				bits.set(bt.danum,true);
				//bits from the second file is now added to the tree. 
				sTree.writeObject(bits);
				sTree.flush();
				sTree.close();
				
				
			}
			catch(IOException|FileNotFoundException e)
			{
				System.out.println("Broke at Save1");
			}
			
		}
		public void order(BitSet bits, bitthing bt, ObjectOutputStream cFile, HuffmanNode start)
		{
			//to account for the last instance
			if(head.leftChild == null && head.rightChild == null)
			{
				bits.set(bt.num++, false);
				cFile.writeChar(start.thing);
			}
			bits.set(bt.danum++, true);
			order(bits,bt,cFile,start.leftChild);
			bits.set(bt.danum++, true);
			order(bits, bt, cFile,start.rightChild);
			
		}
	
		
	}
	





