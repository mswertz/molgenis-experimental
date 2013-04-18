package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Renders a switch.
 * 
 * Thanks to https://github.com/nostalgiaz/bootstrap-switch
 */
public class BoolInput extends HtmlInput<BoolInput, Boolean>
{
	public BoolInput(String name)
	{
		super(name);
		this.add(new Css("/res/css/bootstrap-switch.css"));
		this.add(new Script("/res/js/bootstrap-switch.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String checked = this.getObject() != null && this.getObject() ? "checked" : "";
		out.println(String.format("<div class=\"switch switch-small\"><input name=\"%s\" type=\"checkbox\" %s></div>", this.getName(), checked));
	}
}
