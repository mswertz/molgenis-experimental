package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class OnoffInput extends HtmlInput<OnoffInput, String>
{


	public OnoffInput(String name)
	{
		super(name);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
			out.println("<input type=\"text\" name=\"" + this.getName()
					+ "\" value=\"" + getValue() + "\" placeholder=\""+getLabel()+"\"/>");
	}
}
