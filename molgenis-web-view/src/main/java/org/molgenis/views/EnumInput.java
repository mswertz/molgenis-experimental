package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class EnumInput extends HtmlInput<EnumInput, String>
{
	public EnumInput(String name)
	{
		super(name);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
			out.println("<textarea>"+this.getValue()+"</textarea>");
	}
}
