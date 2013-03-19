package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class TextInput extends HtmlInput<TextInput, String>
{
	public TextInput(String name)
	{
		super(name);
		this.add(new Css("/res/css/bootstrap-wysihtml5.css"));
		this.add(new Script("/res/js/wysihtml5-0.3.0.js"));
		this.add(new Script("/res/js/bootstrap-wysihtml5.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div class=\"well well-small\"><textarea id=\""+getId()+"\" class=\"textarea\">"+this.getValue()+"</textarea><script>$('#"+getId()+"').wysihtml5();</script></div>");
	}
}
