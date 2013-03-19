package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ButtonDropdown extends GuiElement<ButtonDropdown>
{
	String label;

	public ButtonDropdown()
	{
		super(randomId());
	}

	public ButtonDropdown(String id)
	{
		super(id);
	}

	public ButtonDropdown setLabel(String label)
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
		out.println("<div class=\"btn-group\"><a class=\"btn dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">"
				+ getLabel() + "<span class=\"caret\"></span></a>");
		
		// render items
		out.println("<ul class=\"dropdown-menu\" role=\"menu\">");
		this.renderItems(this.getChildren(), out);
		out.println("</ul></div>");
	}

	private void renderItems(List<GuiElement<?>> items, PrintWriter out) throws IOException
	{
		for (GuiElement<?> child : items)
		{
			if (child instanceof Button)
			{
				Button button = (Button) child;
				out.println("<li><a tabindex=\"-1\" onclick=\"" + button.getOnClick() + "\" href=\"#\">" + button.getLabel()
						+ "</a></li>");
			}
			else if (child instanceof ButtonDropdown)
			{

				ButtonDropdown dropdown = (ButtonDropdown) child;
				out.println("<li class=\"dropdown-submenu\"><a tabindex=\"-1\" href=\"#\">" + dropdown.getLabel()
						+ "</a><ul class=\"dropdown-menu\">");
				this.renderItems(child.getChildren(), out);
				out.println("</ul></li>");
			}
		}
	}
}
