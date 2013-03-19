package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;


public class H1 extends GuiElement<H1>
{
	private String contents;
	
	public H1(String contents)
	{
		super(randomId());
		this.contents = contents;
	}
	
	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<h1>"+contents+"</h1>");
		
	}

}
