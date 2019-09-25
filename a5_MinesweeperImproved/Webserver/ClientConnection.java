import java.io.*;
import java.net.*;
public class ClientConnection implements Runnable
{
	private Socket socket;
	public ClientConnection(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		
		String line ="";
		String notFound = "HTTP/1.1 404 Not Found\r\n\r\n";
		String internalError = "HTTP/1.1 500 Internal Server Error\r\n\r\n";
		File file;
		String response2 = "Content-type: text/html\r\n\r\n";
		String response3 = "Content-type: image/jpeg\r\n\r\n";
		boolean test = false;
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			line = in.readLine();
			while(line != null)
			{
				System.out.println(line);
				if(line.startsWith("GET"))
				{
					break;
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//get file name or return the index
		String fileName = "";
		String response1 ="";
		
		int temp1 = line.indexOf("GET") + 5;
		int temp2 = line.indexOf("HTTP"); 
		String temp3 = line.substring(temp1,temp2);
		temp3 = temp3.replaceAll("\\s","");
		System.out.println(temp3);
		
		if(temp3 == null|| temp3.equals("/")||temp3.equals("")|| temp3.equals("index.html")|| temp3.equals("/index.html"))
		{
			
			fileName = "index.html";
			response1 = "HTTP/1.1 200 ok\r\n";
		}
		else if(temp3.contains(".jpg")|| temp3.contains(".jpeg"))
		{
			test = true;
			fileName = temp3;
			response1 = "HTTP/1.1 200 ok\r\n";
		}
		else
		{
			//System.out.println("line53");
			response1 = "HTTP/1.1 200 ok\r\n";
			fileName = temp3;
		}
		if(temp3.contains("..") || temp3.contains("cd ..") || temp3.contains("cd") || temp3.contains("ls") || temp3.contains("copy") || temp3.contains("ctty")||temp3.contains("del") || temp3.contains("delete") || temp3.contains("dir") || temp3.contains("erase") || temp3.contains("echo") || temp3.contains("fdisk") || temp3.contains("find") || temp3.contains("fixboot") || temp3.contains("fixmbr") || temp3.contains("format") || temp3.contains("goto") || temp3.contains("ipconfig") || temp3.contains("keyb") || temp3.contains("listsvc") || temp3.contains("logoff") || temp3.contains("logon") || temp3.contains("md") || temp3.contains("move") || temp3.contains("msav")|| temp3.contains("nbtstat") || temp3.contains("nslookup") || temp3.contains("path") || temp3.contains("ping") || temp3.contains("popd") || temp3.contains("set") || temp3.contains("ren") || temp3.contains("rename") || temp3.contains("shutdown") || temp3.contains("telnet") || temp3.contains("tracert") || temp3.contains("unformat") || temp3.contains("xcopy"))
		{
			try
			{
				//System.out.println("line60");
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(response1);
				bw.flush();
				bw.write(response2);
				bw.flush();
				bw.write("BRUH wutchu think u doing??? go away!\r\n\r\n");
				bw.flush();
				bw.close();
			}
			catch(IOException e)
			{
				
				System.out.println("I hath made a mistake");
				//bw.write(internalError);
				//bw.flush();
			}
		}
		else
		{			
			try
			{
				//System.out.println("got here?");
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				file = new File(fileName);
				if(file.exists())
				{
					try
					{
						//System.out.println("line92");
						if(test==true)
						{
							/*
							ByteArrayOutputStream ba = new ByteArrayOutputStream();
							OutputStream os = socket.getOutputStream();
							BufferedImage image = ImageIO.read(new File("fileName"));
							ImageIO.write(image, "jpg", ba);
							byte[] thing = ByteBuffer.allocate(4).putInt(ba.size()).array();
							os.write(thing);
							os.write(ba.toByteArray());
							os.flush();
							test = false; */
							
							//System.out.println("did i get here?");
							bw.write(response1);
							bw.write(response3);
							bw.flush();
							FileInputStream fis = new FileInputStream(file);
							byte[] ii = new byte[(int)file.length()];
							fis.read(ii);
							//String temp8 = new String(ii, "UTF-8");
							OutputStream os = socket.getOutputStream();
							os.write(ii);
							os.flush();
							os.close();
							test = false;
							
							
						}
						else
						{
							
							//System.out.println("line81");
							bw.write(response1);
							bw.flush();
							bw.write(response2);
							bw.flush();
							//System.out.println("line84 did do this");
							FileInputStream fis = new FileInputStream(file);
							byte[] aa = new byte[(int)file.length()];
							fis.read(aa);
							//the below took a bit thought i could just make a string had to end up looking up on google what was wrong here and 
							// the best way 2 fix it. said to do that seemes to work as expected. 
							String temp = new String(aa, "UTF-8");
							
							bw.write(temp);
							bw.flush();
							bw.close();
						}
					}
					catch(Exception e)
					{
						System.out.println("things");
					}
					
				}
				else
				{
					//System.out.println("please get here");
					//this doesn't seem to do anything ?
					bw.write(response1);
					bw.flush();
					bw.write(response2);
					//fixed it
					bw.flush();
					bw.write(notFound);
					bw.flush();
					bw.close();
				}
			}
			catch(IOException e)
			{
				
				System.out.println("I hath made a mistake");
				//bw.write(internalError);
				//bw.flush();
			}
		}
		
	}
	private static Boolean isJPEG(File name) throws Exception
	{
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(name)));
		try//this part was trickey had to look some stuff up to get this
		{
			if(dis.readInt() == 0xffd8)//apparently all jpg images start with the same first two bites so you can abuse that here to check if its a jpg
			{
				//dis.close();
				return true;
			}
			else
			{
				//dis.close();
				return true;
			}
		}
		finally
		{
			dis.close();
		}
		/*
		catch(Exception|FileNotFoundException e)
		{
			System.out.println("broke 167");
		}
		/*
		catch(IOException e)
		{
			e.printStackTrace();
		}*/
		//return false;
	}
}