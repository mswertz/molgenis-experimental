package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Buttons to fire a MOLGENIS action.
 * 
 * TODO: also support other events such as hyperlinks, free javascript?
 */
public class Button extends FormElement<Button>
{
	public enum Style {DEFAULT, PRIMARY, INFO, SUCCESS, WARNING, DANGER, INVERSE, LINK};
	//public enum Size {LARGE, DEFAULT, SMALL, MINI};
	
	private Icon icon;
	private String action;
	private String text;
	private String onClick;
	private Style style = Style.DEFAULT;
	

	public Button(String id)
	{
		super(id);
	}

	public Button(String id, String label)
	{
		super(id);
		this.label(label);
	}

	public String getAction()
	{
		if (this.action == null) return this.getId();
		return action;
	}

	public Button setAction(String action)
	{
		this.action = action;

		return this;
	}

	public Icon getIcon()
	{
		return icon;
	}

	public Button setIcon(Icon icon)
	{
		this.icon = icon;
		return this;
	}

	public String getOnClick()
	{
		return onClick;
	}

	public Button setOnClick(String onClick)
	{
		this.onClick = onClick;

		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String css = "btn";
		if(style != Style.DEFAULT) css += " btn-"+style.toString().toLowerCase();
		out.println("<button id=\"" + getId() + "\" class=\""+css+"\" onclick=\"" + getOnClick() + "\">" + getText() + "</button>");
	}

	public String getText()
	{
		return text;
	}

	public Button text(String text)
	{
		this.text = text;
		return this;
	}

	public Style getStyle()
	{
		return style;
	}

	public Button style(Style style)
	{
		this.style = style;
		return this;
	}	
}
