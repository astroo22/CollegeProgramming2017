//Jonathan Starkey

//import java.util.PriorityQueue;
import java.util.*;
import java.io.*;


public class Huffman
{
	
	public static class HuffmanNode 
	{
		public char thing;
		public int freq;
		public HuffmanNode leftTree;
		public HuffmanNode rightTree;
		//public HuffmanNode parent;
		public HuffmanNode()
		{
			thing = '\0';
			//parent = null;
			leftTree = null;
			rightTree= null;
		}
		public HuffmanNode(char thing1, int freq1,HuffmanNode leftTree1,HuffmanNode rightTree1)
		{
			this.thing = thing1;
			this.freq = freq1;
			this.leftTree = leftTree1;
			this.rightTree = rightTree1;
			//this.parent = parent1;
		}
	}
		
		public static class compareTo implements Comparator<HuffmanNode>
		{
			public int compare(HuffmanNode one, HuffmanNode two)
			{
				return one.freq - two.freq;
			}
			
			
			
			/*HuffmanNode temp = (HuffmanNode)thing1;
			return n<temp.n ? -1: (n==temp.n ? 0 : 1);*/
		}
		
		//upon further review need below
		//~~~~~~~~~~~~
		//upong more review i do not need below
		/*
		@Override
		public String toString() 
		{
			String temp = "";
			temp += this.thing;
			return temp;
		}*/
		
		
		//going to ttry a version where i do everything i did in the huffman tree below might be less confusing
		// awkward but i need to put everything into one class now though so i have to change the file name etc.
	
	public class bitthing
	{
		//might be moving the tree creation here
		public int danum;
	}
		//moving encode
		public void encoding(String line) 
		{
			
			Map<Character, Integer> freq = freqMap(line);
			HuffmanNode start = createHTree(freq);
			Map<Character, String> newMap = createCM(freq.keySet(), start);
			String result = encoded(newMap,line);
			save1(start);
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
			catch(IOException e)
			{
				//System.out.println("Broke at saveResult");
				;
			}
		}
		public void encode(HuffmanNode front, Map<Character, String> codeMap, String thing1)
		{
			try
			{
				
				if(front.leftTree == null && front.rightTree == null)
				{
					codeMap.put(front.thing, thing1);
				}
				encode(front.leftTree, codeMap, thing1 + '0');
				encode(front.rightTree, codeMap, thing1 + '1');
			}
			catch(NullPointerException e)
			{
				;
				//System.out.println("Caught me a NULLPOINTER at encode 119");
			}
		}
		public static Queue<HuffmanNode> CreateQueue(Map <Character, Integer>map)
		{
			Queue<HuffmanNode> PriorityNodeQueue = new PriorityQueue<HuffmanNode>(11,new compareTo());
			for(Map.Entry<Character, Integer> entry : map.entrySet())
			{
				PriorityNodeQueue.add(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
			}
			return PriorityNodeQueue;
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
				if(!(result.containsKey(current)))
				{
					result.put(current,1);
					
				}
				else
				{
					int currentF = result.get(current);
					result.put(current,++currentF);
				}
			}
			return result;
		}
		public HuffmanNode createHTree(Map<Character, Integer> map)
		{
			Queue<HuffmanNode> NodeQueue = CreateQueue(map);
			/*
			for(Map.Entry<Character, Integer> entry : map.entrySet()) //found this loop on Stack Overflow
			{
				daQue.add(new HuffmanNode(entry.getKey(), entry.getValue(), null,null));
				
			}*/
			while(NodeQueue.size() >1)
			{
				HuffmanNode one = NodeQueue.remove();
				HuffmanNode two = NodeQueue.remove();
				NodeQueue.add(new HuffmanNode('0',one.freq + two.freq, one, two));
			}
			return NodeQueue.remove();
		}
		//Couldn't figure out how to code this into one file asked friend 
		//friend suggested this 3 file structure to complete assignment ~~ no code writen seen or copied from friend
	
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
			catch(IOException e)
			{
				System.out.println("Broke at Save1");
			}
			
		}
		public void order(BitSet bits, bitthing bt, ObjectOutputStream cFile, HuffmanNode start)
		{
			//to account for the last instance
			try
			{
				if(start.leftTree == null && start.rightTree == null)
				{
					bits.set(bt.danum++, false);
					cFile.writeChar(start.thing);
					return;
				}
				bits.set(bt.danum++, true);
				order(bits,bt,cFile, start.leftTree);
				bits.set(bt.danum++, true);
				order(bits, bt, cFile,start.rightTree);
			}
			catch(IOException|NullPointerException e)
			{
				;
				//System.out.println("died at order");
			}
				
		}
		// learned how to error handle more efficiantly in this section because of how some of the methods had to return
		// objects. 
		public String decode(String fileName) throws IOException, ClassNotFoundException
		{
			
			HuffmanNode front = getTree();
			String result = decodeMessage(front,fileName);
			return result;
		}
		public HuffmanNode getTree() throws IOException, FileNotFoundException, ClassNotFoundException
		{
			System.out.println("get here1?");
			try(ObjectInputStream treeStream = new ObjectInputStream(new FileInputStream("tree.huff")))
			{
				try(ObjectInputStream charStream = new ObjectInputStream(new FileInputStream("characters.huff")))
				{
					System.out.println("get here2?");
					BitSet bits = (BitSet)(treeStream.readObject());
					bitthing btt = new bitthing();
					return decodeOrder(bits, charStream, btt);
				}
				//decodeMessage(fileName);
				
			}
			/*
			catch(IOException|NullPointerException e)
			{
				System.out.println("died at getTree");
			}*/
			
		
		}
		public HuffmanNode decodeOrder(BitSet bits, ObjectInputStream characters, bitthing bt) throws IOException
		{
			
			//try
			//{
				
				// creating order of the things
				//System.out.println("get here3?");
				HuffmanNode temp = new HuffmanNode('\0',0,null,null);
				if(!(bits.get(bt.danum)))
				{
					
					//last case
					bt.danum++;
					temp.thing = characters.readChar();
					return temp;
				}
				bt.danum++;
				temp.leftTree = decodeOrder(bits, characters, bt);
				//System.out.println("get here5?");
				bt.danum++;
				temp.rightTree = decodeOrder(bits, characters, bt);
				
				return temp;
				
			//}
			//catch(IOException|NullPointerException e)
			//{
				//System.out.println("died at decodeOrder");
			//}
			
		}
		public String decodeMessage(HuffmanNode temp, String fileName) throws IOException, FileNotFoundException, ClassNotFoundException
		{
			//saw an example for reading in something similar on Stack overflow using the logic from that for the 
			//for loop and the while loop;
			
			try(ObjectInputStream tempSomething = new ObjectInputStream(new FileInputStream(fileName)))
			{
				System.out.println("get here4?");
				
				BitSet bits = (BitSet)(tempSomething.readObject());
				String omg = "";
				
				for(int i=0; i < bits.length() -1;)
				{
					//System.out.println("get here6?");
					HuffmanNode temp1 = temp;
					//System.out.println(sb.toString());
					//int counter = 0;
					while(temp.leftTree != null) 
					{
						//System.out.println("get here7?");
						System.out.println("get here? :" + i);
						System.out.println("" + bits.get(i));
						//System.out.println("c:" + temp1.thing + " R:" + temp1.rightTree + " L:" + temp1.leftTree);
						
						//also using a while loop because an if statement about the i could cause problems 
						// need the right side as well
						if(temp1.thing != '\0')
						{
							omg += temp1.thing;
							
							//counter =0;
							break;
						}
						else if(!bits.get(i))
						{
							temp1 = temp1.leftTree;
							//counter++;
						}
						else
						{
							temp1 = temp1.rightTree;
							//counter++;
						}
						i++;
						 // only want this to incriment based on the while loop 
						
					}
					
					
					
					
				}
				PrintWriter out = new PrintWriter("Decoded.txt");
				out.println(omg);
				out.close();
				return omg;
			}
			/*
			catch(IOException|NullPointerException e)
			{
				System.out.println("died at decodeMessage");
			}*/
			
		}
	
		
	}
	





