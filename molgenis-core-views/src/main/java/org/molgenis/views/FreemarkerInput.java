package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class FreemarkerInput extends HtmlInput<FreemarkerInput, String>
{


	public FreemarkerInput(String name)
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
