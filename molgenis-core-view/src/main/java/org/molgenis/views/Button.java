package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

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
	private HashMap<String, Object> params = new HashMap<String, Object>();
	private Method method = Method.GET;
	private Boolean disabled = false;

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
		switch (method)
		{
			case GET:
				return "location.href='" + getUrl() + "'";
			case POST:
				return "$(this).parents('form:first').attr('method','post');$(this).parents('form:first').attr('action','"
						+ getUrl() + "');$(this).parents('form:first').submit()";
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

		switch (method)
		{
			case POST:
				out.println("<button id=\"" + getId() + "\" class=\"" + css + "\" onclick=\"" + getOnClick() + "\">"
						+ getText() + "</button>");
				break;
			case GET:
				if (disabled) css += " disabled";
				String url = getUrl();
				if (this.params.size() > 0)
				{
					String query = "";
					for (String key : this.params.keySet())
					{
						Object value = this.params.get(key);
						if (!(value instanceof String)) value = new ObjectMapper().writeValueAsString(value).replace(
								"\n", "");
						value = new StringEscapeUtils().escapeHtml(value.toString());
						query += "&"+key + "=" + value;
					}
					url += "?"+query.substring(1);
					Logger.getLogger(this.getClass()).info("value=" + url);
				}
				out.println("<a id=\"" + getId() + "\" class=\"" + css + "\" href=\"" + url + "\">" + getText()
						+ "</a>");
			default:
				break;
		}

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

	public Button disable()
	{
		this.disabled = true;
		return this;
	}

	public Button enable()
	{
		this.disabled = false;
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

	public Button url(String url)
	{
		this.url = url;
		return this;
	}

	public Button post(String url)
	{
		this.url(url);
		this.setMethod(Method.POST);
		return this;
	}
	
	public Button get(String url)
	{
		this.url(url);
		this.setMethod(Method.GET);
		return this;
	}

	public Button primary()
	{
		this.style = Style.PRIMARY;
		return this;
	}

	public Button danger()
	{
		this.style = Style.DANGER;
		return this;
	}

	public Button param(String name, Object value)
	{
		this.params.put(name, value);
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
