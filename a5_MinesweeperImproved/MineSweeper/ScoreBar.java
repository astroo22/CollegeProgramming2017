//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScoreBar extends JPanel
{
	Logic logic;
	GameBoard gameBoard;
	private int bombs;
	private int flags;
	private JLabel bombsLeft;
	
	
	ScoreBar(Logic logic)
	{
		this.logic = logic;
		bombs = this.logic.bombTotal;
		flags = this.logic.flagsNum;
		setLayout(new GridLayout());
		//uhhhh same as panel now set the sizes
		setSize(getWidth(), 150); // so uses the width and is 150 pixels down like the width of the height
		bombsLeft = new JLabel("Bombs left: " + (bombs - flags)); // ok complicated need remaining bombs go through logic use the check function in gameBoard?
		// wait make the above just the base number minus number of flags.
		bombsLeft.setHorizontalAlignment(SwingConstants.CENTER);	//from list of java methods thing.
		//ok ~~~~~~~~
		
		
		
		add(bombsLeft);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		bombsLeft.setText("Bombs left: " + logic.bombsRemaining());
		repaint();
	}
}