//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//ever growing list of imports 
//im used to putting the actionlistener stuff in one of the main files but 
//i saw something interesting while looking stuff up the other day
// and he put his handling in a file like this
// so heres my attempt at it

public class MouseThing extends MouseAdapter
{
	Logic logic;
	MineSweeperFrame mineSweeperFrame;
	MineSweeperPanel mineSweeperPanel;
	JButton[][] buttons;
	public MouseThing(Logic logic, JButton[][] buttons, MineSweeperFrame mineSweeperFrame, MineSweeperPanel mineSweeperPanel)
	{
		this.logic = logic;
		this.mineSweeperFrame = mineSweeperFrame;
		this.mineSweeperPanel = mineSweeperPanel;
		this.buttons = buttons;
	}
	//ok so copying some cough *alot* cough of the code from class here
	@Override
	public void MousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		JButton button = (JButton) e.getSource();
		
		
		//so pretty standard here if left mouse button need to click tile and find bombs nearby
		// if it doesn't find them then clear spaces nearby this is code that may or may not be used
		// depends if i can figure it out or not.
		//~~
		//~~CONTINUED HERE
		//~~
		// so heres where i was having my erros figuring which button to do the things to
		// heres my solution take the tooltiptext from MineSweeperPanel
		// so~
		/*
		String[] text = button.getToolTipText().split(", ");
		int r = Integer.parseInt(text[0]);
		int c = Integer.parseInt(text[1]);
		
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			
			if(logic.gameBoard.tiles1[r][c].getBombsTouching() == 0)
			{
				logic.clickedTile(r,c);
				logic.gameBoard.findTouchingBombs();
				
				
				// also might add something here if they lose? 
				
			}
			else
			{
				logic.clickedTile(r,c);
				logic.gameBoard.findTouchingBombs();
			}
		}
		//more class code stealing pretty basic if right click add flag
		else if(SwingUtilities.isRightMouseButton(e))
		{
			logic.addFlag(r,c);
			//might add something here if they win
		}
		mineSweeperPanel.repaint();
		*/
	}
}