package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class BoolInput extends HtmlInput<BoolInput, String>
{
	public BoolInput(String name)
	{
		super(name);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
			out.println("<textarea>"+this.getValue()+"</textarea>");
	}
}
