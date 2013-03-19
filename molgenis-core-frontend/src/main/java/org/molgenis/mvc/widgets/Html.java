package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;


public class Html extends GuiElement<Html>
{
	String contents;
	
	public Html(String contents)
	{
		super(randomId());
		
		this.contents = contents;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write(this.contents);

	}

}
