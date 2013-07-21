package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
	private String onClick;
	private Style style = Style.DEFAULT;
	private String url="";
	private HashMap<String, Object> params = new HashMap<String, Object>();
	private Method method = Method.GET;
	private Boolean disabled = false;
	private String target = null;

	public Button(String text)
	{
		super(randomId());
		this.label(text);
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
		//create onClick unless manually defined
		if(onClick!=null)return onClick;
				switch (method)
		{
			case GET:
				if(target!=null)
				{
					return "$('#"+target+"').load('"+getUrl()+"')";
				}
				return "location.href='" + getUrl() + "'";
			case POST:
				if(target!=null)
				{
					return "event.stopImmediatePropagation();var values = $('form:first').serialize();$.post('"+getUrl()+"', values).done(function(data){$('#"+getTarget()+"').html(data);}).fail(function() { $('#"+getTarget()+"').html('error');}); return false;";
				}
				return "$(this).parents('form:first').attr('method','post');$(this).parents('form:first').attr('action','"
						+ getUrl() + "');$(this).parents('form:first').submit()";
			default:
				//should never happen
				return "ERROR";

		}
	}

	public Button onClick(String onClick)
	{
		this.onClick = onClick;
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		this.renderTemplate(out, "<@button id=model.getId() label=model.getLabel() style=model.getStyle()?lower_case onclick=model.getOnClick()/>");

//		switch (method)
//		{
//			case POST:
//				out.println("<button id=\"" + getId() + "\" class=\"" + css + "\" onclick=\"" + getOnClick() + "\">"
//						+ getText() + "</button>");
//				break;
//			case GET:
//				if (disabled) css += " disabled";
//				String url = getUrl();
//				if (this.params.size() > 0)
//				{
//					String query = "";
//					for (String key : this.params.keySet())
//					{
//						Object value = this.params.get(key);
//						if (!(value instanceof String)) value = new ObjectMapper().writeValueAsString(value).replace(
//								"\n", "");
//						value = new StringEscapeUtils().escapeHtml(value.toString());
//						query += "&"+key + "=" + value;
//					}
//					url += "?"+query.substring(1);
//					Logger.getLogger(this.getClass()).info("value=" + url);
//				}
//				out.println("<a id=\"" + getId() + "\" class=\"" + css + "\" href=\"" + url + "\">" + getText()
//						+ "</a>");
//			default:
//				break;
//		}

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
	
	public Button target(String target)
	{
		this.target = target;
		return this;
	}
	
	public Button target(Div target)
	{
		return target(target);
	}

	public Style getStyle()
	{
		return style;
	}

	public Button style(Style style)
	{
		if(style == null) this.style = Style.DEFAULT;
		else this.style = style;
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
		this.method(Method.POST);
		return this;
	}
	
	public Button get(String url)
	{
		this.url(url);
		this.method(Method.GET);
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
	
	public boolean isDisabled()
	{
		return disabled;
	}

	public void method(Method rest)
	{
		this.method = rest;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}
}
