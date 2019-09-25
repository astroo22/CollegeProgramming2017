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
        try
        {
           int key = 0;
           Scanner keyScan = new Scanner(args[0]);
           
           Scanner scan = new Scanner(new File(args[1])); 
           if(!keyScan.hasNextInt())
           {
               System.out.println("Key must be an integer");
               System.exit(0);
           }
           else 
           {
               key = keyScan.nextInt();
           }
           while(scan.hasNextLine())
           {
               String line = scan.nextLine();
               String output = "";
               for(int i =0; i < line.length(); i++)
               {
                   char c = line.charAt(i);
                   //char outputChar;
                   if((int)c<32 || (int)c > 126)
                   {
                       output += c;
                   }
                   else 
                   {
                       output += (char)((int)c + key);
                   }
               }
               System.out.println(output);
               
               
               
           }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found");
            System.exit(0);
        }
    }
    
}