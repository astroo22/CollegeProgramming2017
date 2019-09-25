import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Robot
{
	//fun fact of the day these have to be static
	public static final String FORWARD = "w";
	public static final String BACK = "s";
	public static final String LEFT = "a";
	public static final String RIGHT = "d";
	public static final String TAKEOFF  = "z";
	public static final String LAND = "x";
	public static final String UP = "r";
	public static final String DOWN = "f";
	public static final String RLEFT = "q";
	public static final String RRIGHT = "e";
	public static void main(String[] args)
	{
		RobotController robotController;
		robotController = new RobotController();
		//~~~~~~~~~~~~~~~~~~~~~
		//ok so i thought about this i could do something with a mouse listener then make this an actual controller
		//however by making my last program more complicated than it should be (mineSweeper) it became the bane of my existance
		//So for now since there does not seem to be any extra credit or anything and im sure i will run into a multitude of problems
		// going to simply read input from command line to controll the drone using a switch statement
		//~~~~~~~~~~~~~~~~~~~~~
		System.out.println("To controll the robot you will use standard MMO keys for basic movement such as:");
		System.out.println("W,A,S,D for basic movement forward backward left right");
		System.out.println("Q,E for rotating the drone");
		System.out.println("R,F for going up and down");
		System.out.println("Z,X for taking off and landing");
		System.out.println("Keys are constant in that if you click something it will do that something and continue to do it");
		System.out.println("untill you tell it to do something else");
		robotController.takeOff();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext())
		{
			switch(scan.next())
			{
				case FORWARD:
					robotController.moveForward();
					break;
				case BACK:
					robotController.moveBack();
					break;
				case LEFT:
					robotController.moveLeft();
					break;
				case RIGHT:
					robotController.moveRight();
					break;
				case TAKEOFF:
					robotController.takeOff();
					break;
				case LAND:
					robotController.land();
					break;
				case UP:
					robotController.moveUp();
					break;
				case DOWN:
					robotController.moveDown();
					break;
				case RLEFT:
					robotController.turnLeft();
					break;
				case RRIGHT:
					robotController.turnRight();
					break;
				default:
					System.out.println("Please use your keyboard as if this were an mmo");
					break;
			}
		}
	}
}