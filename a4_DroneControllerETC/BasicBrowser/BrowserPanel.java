//Jonathan Starkey


import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.net.IDN;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrowserPanel extends JPanel 
{
	//Container c1;
	BrowserFrame browserFrame;
	JTextArea textC;
	JScrollPane scrollPane;
	Content content;
	public String line;
	public BrowserPanel()
	{
		//super();
		//browserFrame = browserFrame;
		//c1 = browserFrame.getContentPane();
		//c1.setLayout(new BorderLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		JTextField theURL = new JTextField("",70);
		JLabel urlStat = new JLabel(" ");
		textC = new JTextArea(5,30);
		textC.setEditable(false);
		textC.setLineWrap(true);
		textC.setText("Please enter a URL to start. You do not need to type in http://");
		JScrollPane scrollPane = new JScrollPane(textC, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension((screenSize.width/2) -20,(screenSize.height/2) -70));
		JScrollBar bar = scrollPane.getVerticalScrollBar();
		bar.setPreferredSize(new Dimension(40,0));
		ActionListener actionL1 = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				try
				{
					String text = theURL.getText();
					//InetAddress addr = InetAddress.getByName(text);
					//Socket s = new Socket(addr, 80);
					URL url = new URL("http://" + text);
					URLConnection connection = url.openConnection();
					//PrintWriter out = new PrintWriter(s.getOutputStream());
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuffer b = new StringBuffer();
					/*
					out.print("GET / HTTP/1.1\r\n");
					out.print("host: cs.okstate.edu\r\n\r\n");
					out.flush();
					*/
					while((line = in.readLine()) !=null)
					{
						
						b.append(line);
					}
					//System.out.println(b.toString());
					in.close();
					String temp = b.toString();
					content = new Content(temp);
					System.out.println("done");
					textC.setText(content.body);
					browserFrame.setTitle(content.title);
					//browserFrame.setTitle(content.title);
					//content = new Content(line);
					/*
					System.out.println("done1");
					
					System.out.println("done2");
					
					System.out.println("done3");
					
					System.out.println("done4");
					*/
					repaint();
					
					
				}
					
				catch (Exception ex)
				{
					textC.setText("Incorrect url format. You do not need to type in http://");
						 
				}
				
			}				
					
		};
		theURL.addActionListener(actionL1);
		//theURL.setVerticalAlignment(TOP);
		theURL.setBounds(0,700,50,100);
		add(theURL, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.SOUTH);
		//c1.add(theURL, BorderLayout.WEST);
		//browserFrame.setTitle(content.title);
		//textC.setText(content.body);
		
		
	}
	public void daFrame(BrowserFrame frame)
	{
		this.browserFrame = frame;
	}
	
}



/*
						for(int i=0; i<line.length();i++)
						{
							
							if(line.charAt(i) == '<')
							{
								
									/*
									String test = line.substring(i+1,i+5);
									String test2 = line.substring(i+1,i+3);
									//System.out.println(test);
									//System.out.println(test2);
									
									if(test.equals("title"))
									{
										System.out.println(test);
										line.replace("<title>","");
										line.replace("</title>","");
										title = line;
										System.out.println(title);
												
									}
								
								
							}
							
					String text = theURL.getText();
					//InetAddress addr = InetAddress.getByName(text);
					//Socket s = new Socket(addr, 80);
					URL url = new URL(http:\\text);
					URLConnection connection = url.openConnection();
					//PrintWriter out = new PrintWriter(s.getOutputStream());
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuffer b = new StringBuffer();
					/*
					out.print("GET / HTTP/1.1\r\n");
					out.print("host: cs.okstate.edu\r\n\r\n");
					out.flush();
					
					while((line = in.readLine()) !=null)
					{
						
						b.append(line);
					}
					
					in.close();
					String temp = b.toString();
					content = new Content(temp);
					System.out.println("done");*/