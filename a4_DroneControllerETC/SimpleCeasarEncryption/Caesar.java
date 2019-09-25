import java.util.*;
import java.io.*;
/**
 *
 * @author astro
 */
public class Caesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        if(args.length == 2 || args.length == 1 || args.length == 3)
        {
            try
            {
               String output = "";

               int key = Integer.parseInt(args[0]);
               Scanner scan = new Scanner(new File(args[1])); 
               while(scan.hasNextLine())
               {
                    String line = scan.nextLine();
                    
                    for(int i =0; i < line.length(); i++)
                    {
                        char c = line.charAt(i);
                        //char outputChar;
                        int val;
                        if((int)c<32 || (int)c > 126)
                        {
                            output += c;
							//System.out.println("did a thing");
                        }
                        else 
                        {
                            val = ((int)c + key);
                             if((int)val>126)
                             {
                                 val = ((int)val - 95);
                             }
                             if((int)val<32)
                             {
                                 val = ((int)val +95);
                             }
                             output += (char)val;
							//System.out.println("added things");

                        }
						

                    }
					output += System.getProperty("line.separator");
					//System.out.println(output);
					//~~~~~~~~~~~~~~~~~WORK ON THIS TOMORROW
                   



               }
			   if(args.length == 3)
                   {
                       //String file = String.parse
					  // System.out.println(output);
					  //PrintStream out = new PrintStream(new FileOutputStream(args[2]));
					   
                       PrintWriter pw = new PrintWriter(args[2]);
					   
                       pw.println(output);
					   pw.close();
                   }
                   else
                   {
                    System.out.println(output);
                   }
            }
            catch(NumberFormatException|IOException ex)
            {
                System.out.println("File not found");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("!Usage! Please use the format: java Caesar key infile outfile");
        }
    }
}
