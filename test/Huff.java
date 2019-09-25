import java.util.*;
import java.io.*;

public class Huff {
  public static String fileName;
  public static void main(String[] args) {
    System.out.println("I couldn't get the files to be recognized so in order to test my Huffman trees you will need to edit the tester.txt. \nThe changes will be saved to compressed.huff, etc.\nIt did work at some point but gives an ArrayIndexOutOfBoundsException...\n\n");
    fileName = "Text.txt";
      try{
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        String fileText = "";

        while (scanner.hasNextLine()) {
          fileText += scanner.nextLine() + "\n";
          }
        HuffPuff e = new HuffPuff();
        e.encode(fileText);
      }
      catch(Exception fnfe) {
        fnfe.printStackTrace(System.out);
        System.exit(-1);
      }
  }
}
