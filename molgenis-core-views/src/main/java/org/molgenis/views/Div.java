package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


public class Div extends View<Div>
{
	public Div()
	{
		super(randomId());
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div>");
		for (View<?> i : this.getChildren())
		{
			i.render(out);
		}
		out.println("</div>");
	}

}
