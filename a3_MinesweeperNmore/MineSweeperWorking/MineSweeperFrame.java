//Jonathan Starkey


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MineSweeperFrame extends JFrame
{
	//Logic logic;
	GameBoard gameBoard;
	Container container;
	ScoreBar scoreBar;
	MineSweeperPanel mineSweeperPanel;
	Container c;
	Container c2;
	Logic logic;
	
	
	MineButton mineButton;
	public String sass ="";
	public String title ="";
	public static final int SAVE = 1;
	public static final int LOAD = 0;
	public static final int NEWGAME = 2;
	public static final int QUIT = 3;
	
	public MineSweeperFrame()
	{
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new BorderLayout());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		
        Image im = toolkit.getImage("flag.jpg");
        im = im.getScaledInstance(20, 20, 0);
        ImageIcon imageIcon = new ImageIcon(im);
		c.add(MenuBar(), BorderLayout.NORTH);
		newGame();
		
		
		
		
      
	}
	public void newGame()
	{
		setTitle("MineSweeper");
		Object[] temp2 = {"Normal","Less Normal", "Mo Scury", "Very Scury", "No im scurd"};
		int temp = JOptionPane.showOptionDialog(null, "Are you ready?", "Minsweeper", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, temp2, temp2[0]);
		if(temp == 0)
		{
			
			logic = new Logic(10,10);
			gameBoard = new GameBoard(10,10);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 1)
		{
			logic = new Logic(15,30);
			gameBoard = new GameBoard(15,30);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 2)
		{
			logic = new Logic(25,75);
			gameBoard = new GameBoard(25,75);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 3)
		{
			logic = new Logic(35,125);
			gameBoard = new GameBoard(35,125);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp ==4)
		{
			System.exit(0);
		}
	}
	public void newGame(String sass, String title)
	{
		
		String sassy = sass;
		String titles = title;
		Object[] temp2 = {"Normal","Less Normal", "Mo Scury", "Very Scury", "No im scurd"};
		int temp = JOptionPane.showOptionDialog(null, sassy, titles, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, temp2, temp2[0]);
		if(temp == 0)
		{
			System.out.println("did this");
		c2.remove(scoreBar);
		c2.remove(mineSweeperPanel);
		setVisible(false);
		System.out.println("did this");
			logic = new Logic(10,10);
			gameBoard = new GameBoard(10,10);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 1)
		{
			System.out.println("did this");
			c2.remove(scoreBar);
			c2.remove(mineSweeperPanel);
			setVisible(false);
			System.out.println("did this");
			logic = new Logic(15,30);
			gameBoard = new GameBoard(15,30);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 2)
		{
			System.out.println("did this");
			c2.remove(scoreBar);
			c2.remove(mineSweeperPanel);
			setVisible(false);
			System.out.println("did this");
			logic = new Logic(25,75);
			gameBoard = new GameBoard(25,75);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp == 3)
		{
			System.out.println("did this");
			c2.remove(scoreBar);
			c2.remove(mineSweeperPanel);
			setVisible(false);
			System.out.println("did this");
			logic = new Logic(35,125);
			gameBoard = new GameBoard(35,125);
			scoreBar = new ScoreBar(logic);
			//logic = new Logic();
			mineSweeperPanel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
			
			c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
			c2.setLayout(new BorderLayout());
			c2.add(scoreBar, BorderLayout.NORTH);
			c2.add(mineSweeperPanel, BorderLayout.CENTER);
			System.out.println("done");
			
			c.add(c2);
			setVisible(true);
			
		}
		if(temp ==4)
		{
			System.exit(0);
		}
	}
	public void gameOver(boolean result)
	{
		logic.loser = false;
		logic.winner = false;
		
		if(result==false)
		{
			
			title = "YOUR TERRIBLE!";
			sass = "What even are you doing, you should just quit";
			newGame(title,sass);
		}
		else if(result== true)
		{
			title = "Darn you beat me";
			sass = "This doesn't make you good. Wana play again?";
			newGame(title,sass);
		}
		else 
		{
			title = "New game?";
			sass = "Pick something!!!!";
			newGame(title,sass);
		}
		
		
	}
	public JMenuBar MenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fMenu = new JMenu("File");
		JMenuItem newGame1 = new JMenuItem("New Game");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem quit = new JMenuItem("Quit");
		newGame1.addActionListener(new Listener(NEWGAME));
		save.addActionListener(new Listener(SAVE));
		load.addActionListener(new Listener(LOAD));
		quit.addActionListener(new Listener(QUIT));
		fMenu.add(newGame1);
		fMenu.add(save);
		fMenu.add(load);
		fMenu.add(quit);
		menuBar.add(fMenu);
		return menuBar;
		
		
	}
	public class Listener implements ActionListener
	{
		int temp1;
		Listener(int temp1)
		{
			this.temp1 = temp1;
		}
		public void actionPerformed(ActionEvent e)
		{
			switch(temp1)
			{
				case NEWGAME:
				newGame("giving up hu","Yea you better start a new game");
				break;
				case SAVE:
				Options(SAVE);
				System.out.println("Attempting Save");
				break;
				case LOAD:
				Options(LOAD);
				System.out.println("Attempting load");
				break;
				case QUIT:
				System.exit(0);
				break;
				default:
				System.out.println("I shouldn't ever get here");
				break;
			}
		}
	}
	public void Options(int something)
	{
		if(something == SAVE)
		{
			String path = "";
			JFileChooser fc = new JFileChooser();
			int returnedThing = fc.showSaveDialog(null);
			if(returnedThing == JFileChooser.APPROVE_OPTION)
			{
				path = fc.getSelectedFile().getPath();
				logic.save(path);
				
				
			}
			else
			{
				System.out.println("something broke");
			}
			
		}
		else if(something == LOAD)
		{
			String path = "";
			JFileChooser fc = new JFileChooser();
			int returnedThing = fc.showOpenDialog(null);
			if(returnedThing == fc.APPROVE_OPTION)
			{
				path = fc.getSelectedFile().getPath();
				logic.load(path);
				
			}
			else
			{
				System.out.println("load broke");
			}
		}
	}
	
	
	/*
	 public void newGame()
	{
		c2.remove(scoreBar);
		c2.remove(mineSweeperPanel);
		logic = new Logic();
		gameBoard = new GameBoard();
		scoreBar = new ScoreBar(logic);
		//logic = new Logic();
		MineSweeperPanel panel = new MineSweeperPanel(logic,gameBoard,this, mineButton);
		
		c2 = new Container(); //found some example code on this on how to kind of add a scoreboard
		c2.setLayout(new BorderLayout());
		c2.add(scoreBar, BorderLayout.NORTH);
		c2.add(panel, BorderLayout.CENTER);
		System.out.println("done");
		c.add(c2);
		setVisible(true);
			
	}*/
}