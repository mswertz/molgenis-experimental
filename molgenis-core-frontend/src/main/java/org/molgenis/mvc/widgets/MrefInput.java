package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class MrefInput extends HtmlInput<MrefInput, String>
{


	public MrefInput(String name)
	{
		super(name);
	}

	public MrefInput(String name, Class<?> klass)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
			out.println("<input type=\"text\" name=\"" + this.getName()
					+ "\" value=\"" + getValue() + "\" placeholder=\""+getLabel()+"\"/>");
	}
}
