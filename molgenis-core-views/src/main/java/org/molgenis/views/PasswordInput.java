package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for int values.
 */
public class PasswordInput extends HtmlInput<PasswordInput, String>
{

	public PasswordInput(String name)
	{
		super(name);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String css = isRequired() ? " required" : "";
		out.println(String.format("<input id=\"%s\" name=\"%s\" type=\"password\" placeholder=\"%s\" value=\"%s\" class=\"%s\"/>",
				getId(), getName(), getPlaceholder(), getValue(), css));
	}

}
