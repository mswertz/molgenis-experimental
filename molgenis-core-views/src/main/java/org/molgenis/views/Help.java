package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


public class Help extends Container<Help>
{
	public Help(View<?> ... elements)
	{
		super(elements);
	}
	
	public Help(String contents)
	{
		super(contents);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write("<span class=\"help-block\">"+getContents());
		this.renderChildren(out);
		out.write("</span>");
	}
}
