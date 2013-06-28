package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



public class ButtonGroup extends View<ButtonGroup>
{
	String label;

	public ButtonGroup()
	{
		super(randomId());
	}

	public ButtonGroup(String id)
	{
		super(id);
	}

	public ButtonGroup setLabel(String label)
	{
		this.label = label;

		return this;
	}

	public String getLabel()
	{
		if (label == null) return this.getId();
		return label;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		// render the button
		out.println("<div class=\"btn-group\">");
		
		// render items
		for(View<?> v: this.getChildren())
		{
			v.render(out);
		}
		out.println("</div>");
	}
}
