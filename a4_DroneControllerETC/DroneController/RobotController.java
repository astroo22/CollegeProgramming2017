
import java.io.*;
import java.net.InetAddress;
import java.net.*;
public class RobotController
{
	final String CONN = "lear.cs.okstate.edu";
	final int PORT = 9095;
	//need to add my writer up here i think? just create it
	PrintWriter writer;
	//ALSO HAVE TO HAVE MY SOCKET THING FUN FACT OF THE DAY
	Socket daSocket;
	String TAKEOFF_MSG = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
	String LAND = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
	
    String MOVEB = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":-0.25,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
    String MOVER = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0.75,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
    String MOVEL = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":-0.75,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
	//int something = 1;
	String MOVEF = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0.25,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
	String MOVED = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":-0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
	String MOVEU = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
	String TURNL = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0.25}}}";
	String TURNR = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":-0.25}}}";
	public RobotController()
	{
		try
		{
			daSocket = new Socket(CONN,PORT);
			System.out.println("daSocket was created");
			writer = new PrintWriter(daSocket.getOutputStream());
			System.out.println("Created da writer");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void takeOff()
	{
		writer.print(TAKEOFF_MSG);
		System.out.println("taking off");
		writer.flush();
		//return something;
	}
	public void land()
	{
		writer.print(LAND);
		System.out.println("landing");
		writer.flush();
	}
	public void moveForward()
	{
		System.out.println("forward");
		writer.print(MOVEF);
		writer.flush();
		//return something;
	}
	public void moveBack()
	{
		System.out.println("back");
		writer.print(MOVEB);
		writer.flush();
	}
	public void moveRight()
	{
		System.out.println("right");
		writer.print(MOVER);
		writer.flush();
	}
	public void moveLeft()
	{
		System.out.println("left");
		writer.print(MOVEL);
		writer.flush();
		
	}
	public void moveUp()
	{
		System.out.println("up");
		writer.print(MOVEU);
		writer.flush();
	}
	public void moveDown()
	{
		System.out.println("down");
		writer.print(MOVED);
		writer.flush();
	}
	public void turnLeft()
	{
		System.out.println("turning left");
		writer.print(TURNL);
		writer.flush();
	}
	public void turnRight()
	{
		System.out.println("turning right");
		writer.print(TURNR);
		writer.flush();
	}
	
}
