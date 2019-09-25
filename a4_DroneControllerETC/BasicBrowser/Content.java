//Jonathan Starkey


import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.net.IDN;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Content
{
	public String title = "untitled";
	public String body = "could not find body";
	public String code = "";
	public String temp3 = "";
	
	public Content(String code)
	{
		this.code = code;
		getTitle();
		getBody();
	}
	
	private void getTitle()
	{
		//System.out.println(code);
		//String temp1 = "untitled";
	
		try
		{
			System.out.println(code.indexOf("<title>"));
			System.out.println(code.indexOf("</title>"));
			String temp1 = code.substring(code.indexOf("<title>") +7, code.indexOf("</title>"));
			System.out.println(temp1);
			title = temp1;
		
		}
		catch(Exception e)
		{
			;//System.out.println("could not find Title");
		}
		
		
		/*
		String temp1 = "";
		Matcher matcher;
		//using matcher to figure out the title with the annoying syntax below
		matcher = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(code);
		try
		{
			while(matcher.find())
			{
				//while the matcher is running the first instance of the title is put into title
				temp1 = matcher.group(1);
			}
		}
		catch(IllegalStateException e)
		{
			e.printStackTrace();
		}
		//finally setting the title
		this.title = temp1;*/
		
	}
	private void getBody()
	{
		//String temp2 = "Could not find body";
		String tempi = "";
		
		try
		{
			System.out.println(code.indexOf("<body>"));
			System.out.println(code.indexOf("</body>"));
			String temp2 = code.substring(code.indexOf("<body>") + 6, code.indexOf("</body>"));
			System.out.println(temp2);
			temp3 = temp2;
			tempi = editBody(temp3).trim();
			//tempi = editBody2(tempi);
			body = tempi;
			
		}
		catch(Exception e)
		{
			;//System.out.println("could not find body");
		}
		
		
		
	}
	public static String editBody(String temp3)
	{
		int openPos = temp3.indexOf("<");
		int closePos = temp3.indexOf(">",openPos);
		if (openPos >= 0 && closePos >= 0)
		{
			String tempr = temp3.substring(0,openPos);
			tempr += temp3.substring(closePos+1,temp3.length());
			
			return editBody(tempr);
		}
		else
        return temp3;
	}
	public static String editBody2(String ff)
	{
		int openPos = ff.indexOf("<li");
		int closePos = ff.indexOf("</li>",openPos);
		if (openPos >=0 && closePos >=0)
		{
			String tempr = ff.substring(0,openPos);
			tempr += ff.substring(closePos+5,ff.length());
			return editBody2(tempr);
		}
		else
			return ff;
		
	}
		
	
}










/*
body.replaceAll("<[^>]*>","").trim();
		body.replaceAll("<select[^>]*>(.*?)</select>","").trim();
		//body.replaceAll("<li>(.*?)</li>","").trim();
		body.replaceAll("-[^>]*>","").trim();
		body.replaceAll("<script[^>]*>(.*?)</script>","").trim();
		body.replaceAll("&nbsp;", " ").trim();
		body.replaceAll(" +", "\n").trim();
		
		body.replaceAll("<input[^>]*>(.*?)</input>","").trim();
		//body.trim();
*/








