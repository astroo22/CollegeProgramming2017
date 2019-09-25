import java.util.*;
import java.io.*;

public class Puff {
  public static void main(String[] args) {
    try {
        String message = "";
        HuffPuff d = new HuffPuff();
        message = d.decode();
        try(PrintWriter writer = new PrintWriter("uncompressed.txt")) {
          writer.print(message);
        }
      }
    catch (Exception e) {
      System.out.println("File not found!");
      System.exit(-1);
    }
  }
}
