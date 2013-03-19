package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class XrefInput extends HtmlInput<XrefInput, String>
{


	public XrefInput(String name)
	{
		super(name);
	}

	public XrefInput(String name, String xrefEntityClassName) throws ClassNotFoundException
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
