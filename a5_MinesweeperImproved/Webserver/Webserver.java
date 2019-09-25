import java.io.*;
import java.net.*;

public class Webserver
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(8080);
			while(true)
			{
				Thread connection = new Thread(new ClientConnection(ss.accept()));
				connection.start();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}