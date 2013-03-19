package org.molgenis.mvc.widgets;

public class Css extends HtmlHeader
{
	public Css(String href)
	{
		super(href);
	}

	@Override
	public String toString()
	{
		return "<link href=\""+this.href+"\" rel=\"stylesheet\">";
	}

}
