package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


public class Legend extends Container<Legend>
{
	public Legend(View<?> ... elements)
	{
		super(elements);
	}
	
	public Legend(String contents)
	{
		super(contents);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write("<legend>"+getContents());
		this.renderChildren(out);
		out.write("</legend>");
	}
}
