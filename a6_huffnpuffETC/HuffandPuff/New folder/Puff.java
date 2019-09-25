import java.util.*;
import java.io.*;

public class Puff 
{
	public static void main(String[] args)
	{
		try
		{
			
			String temp ="";
			Huffman hm = new Huffman();
			String temp2 = "" + args[0];
			temp = hm.decode(temp2);
			System.out.println("" + temp);
		}
		catch(IOException|ClassNotFoundException e)
		{
			e.printStackTrace(System.out);
		}
	}
}