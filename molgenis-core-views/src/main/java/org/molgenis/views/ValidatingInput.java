package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public abstract class ValidatingInput<T extends ValidatingInput<T,E>, E> extends HtmlInput<T, E>
{
	private String klazz = "";
	
	public ValidatingInput(String name, String validationKlazz)
	{
		super(name);
		this.klazz = validationKlazz;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String css = klazz;
		if (isRequired()) css += " required";
		out.println("<input id=\""+getId()+"\" class=\"" + css + "\" type=\"text\" name=\"" + this.getName() + "\" value=\"" + getValue() + "\" placeholder=\"" + getPlaceholder() + "\"/>");
	}
}
