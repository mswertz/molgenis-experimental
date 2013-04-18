package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 * 
 * Thanks to http://plugins.jquery.com/autosize/
 */
public class TextInput extends HtmlInput<TextInput, String>
{

	public TextInput(String name)
	{
		super(name);
		this.add(new Script("/res/js/jquery.autosize-min.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String required = isRequired() ? " required" : "";
		out.println(String.format(
				"<textarea class=\"input-xxlarge\" id=\"%s\" name=\"%s\" placeholder=\"%s\"%s>%s</textarea>", getId(),
				getName(), getPlaceholder(), required, getValue()));
		out.println(String.format("<script>$('#%s').autosize();</script>", getId()));
	}
}
