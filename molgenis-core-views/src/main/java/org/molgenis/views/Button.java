package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Buttons to fire a MOLGENIS action.
 * 
 * TODO: also support other events such as hyperlinks, free javascript?
 */
public class Button extends FormElement<Button>
{
	public enum Style
	{
		DEFAULT, PRIMARY, INFO, SUCCESS, WARNING, DANGER, INVERSE, LINK
	};

	public enum Method
	{
		POST, GET, PUT, DELETE, CUSTOM
	};

	// public enum Size {LARGE, DEFAULT, SMALL, MINI};

	private Icon icon;
	private String text;
	private String onClick;
	private Style style = Style.DEFAULT;
	private String url;
	private Method method = Method.GET;

	public Button(String text)
	{
		super(randomId());
		this.text = text;
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
		switch(method)
		{
			case GET:
				return "location.href='"+getUrl()+"'";
			case POST:
				return "$(this).parents('form:first').attr('method','post');$(this).parents('form:first').attr('action','"+getUrl()+"');$(this).parents('form:first').submit()";
			default:
				break;

		}
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
		if (style != Style.DEFAULT) css += " btn-" + style.toString().toLowerCase();

		out.println("<button id=\"" + getId() + "\" class=\"" + css + "\" onclick=\"" + getOnClick() + "\">"
				+ getText() + "</button>");

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

	public String getUrl()
	{
		return url;
	}

	public Button setUrl(String url)
	{
		this.url = url;
		return this;
	}

	public Button post(String url)
	{
		this.setUrl(url);
		this.setMethod(Method.POST);
		return this;
	}

	public Method getMethod()
	{
		return method;
	}

	public void setMethod(Method rest)
	{
		this.method = rest;
	}
}
